package com.warriorsapp.imageslideshow;


/*
Adriano Alves
Jun 22 2017
Demo about pager view
 */

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity
{

    Toolbar toolbar;
    ViewPager viewPager;
    SlideShowAdaptor adaptor;
    CircleIndicator indicator;
    Handler handler;
    Runnable runnable;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.tollBarMain_id);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager)findViewById(R.id.viewPager_id);

        indicator = (CircleIndicator)findViewById(R.id.circleindicator_id);

        adaptor = new SlideShowAdaptor(this);

        viewPager.setAdapter(adaptor);
        indicator.setViewPager(viewPager);

    }

    // ***************** onResume ********************* //
    @Override
    protected void onResume()
    {
        super.onResume();
        addTimer();
    }

    // ***************** onPause ********************* //
    @Override
    protected void onPause()
    {
        super.onPause();
        // cancel the Timer
        timer.cancel();
        // free some memory
        handler = null;
        runnable = null;
        timer = null;
    }

    // **************** addTimer ********************* //
    private void addTimer()
    {
        // get the last position
        int lastPosition = adaptor.images.length - 1;
        // init the Handler
        handler = new Handler();
        // init the Runnable
        runnable = () -> {
            // get the current ViewPager position
            int currentPosition = viewPager.getCurrentItem();
            if(currentPosition == lastPosition) currentPosition = 0;
            else currentPosition++;
            viewPager.setCurrentItem(currentPosition,true);
        };

        timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                handler.post(runnable);
            }
        }, 4000, 4000);
    }
}
