package com.warriorsapp.imageslideshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageActivity extends AppCompatActivity
{
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        int pos = getIntent().getIntExtra(SlideShowAdaptor.IMAGE_POSITION_TAG,0);

        imageView = (ImageView)findViewById(R.id.imageActivity_imageView_id);
        Glide.with(this).load(new SlideShowAdaptor(this).images[pos]).into(imageView);
    }
}
