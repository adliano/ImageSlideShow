package com.warriorsapp.imageslideshow;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

/**
 * Created by Adliano on 6/25/17.
 * Adptor used for slideshow
 */

public class SlideShowAdaptor extends PagerAdapter
{
    // private to make sure that this context will be used only in this adaptor
    private Context context;
    private LayoutInflater inflater;
    static final String IMAGE_POSITION_TAG = "com.warriorsapp.imageslideshow.POS_TAG";

    // Array with all images
    // declared public to access it from anywhere on the project
    public int[] images = {R.drawable.angrybirds,
            R.drawable.asphalt8,
            R.drawable.clashofclans,
            R.drawable.cuttherope,
            R.drawable.fruitninja,
            R.drawable.pou,
            R.drawable.talkingtom,
            R.drawable.wheresmywhater,
            R.drawable.worms3,
            R.drawable.android,
            R.drawable.dwnld,
            R.drawable.tf2,
            R.drawable.emc,
            R.drawable.lambo,
            R.drawable.sunset};

    // ************** Constructor ************** //
    public SlideShowAdaptor(Context context)
    {
        this.context = context;
    }

    // *************** getCount ***************//
    @Override
    public int getCount()
    {
        return images.length;
    }

    // ***************** isViewFromObject **************** //
    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return (view == (LinearLayout)object);
    }

    // ******************** instantiateItem ****************** //
    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        //instantiate the inflater
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View tempView = inflater.inflate(R.layout.slide_show_layout,container,false);
        // instantiate the ImageView and set image to it
        ImageView imageView = (ImageView)tempView.findViewById(R.id.imageView_id);

        //imageView.setImageResource(images[position]); to slow and heavy use Glide or picasso

        Glide.with(context).load(images[position]).into(imageView);

        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(context,ImageActivity.class);
            intent.putExtra(IMAGE_POSITION_TAG,position);
            context.startActivity(intent);
        });

        container.addView(tempView);

        return tempView;
    }

    // ********************** destroyItem ************************ //
    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        container.removeView((LinearLayout)object);
    }
}
