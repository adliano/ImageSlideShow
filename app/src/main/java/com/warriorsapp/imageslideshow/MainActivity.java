package com.warriorsapp.imageslideshow;


/*
Adriano Alves
Jun 22 2017
Demo about pager view
 */

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity
{

    Toolbar toolbar;
    ViewPager viewPager;
    SlideShowAdaptor adaptor;
    CircleIndicator indicator;

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
}
