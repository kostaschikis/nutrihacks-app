package com.example.nutrihacks_app;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.fragment.app.FragmentActivity;

public class ImageAdapter  extends BaseAdapter {


    private FragmentActivity mContext;

    public int[] imageArray = {
            R.drawable.b, R.drawable.g, R.drawable.h, R.drawable.image, R.drawable.l
    };

    public ImageAdapter(FragmentActivity mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {

        return imageArray.length;
    }

    @Override
    public Object getItem(int position) {

        return imageArray[position];
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(imageArray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(340, 350));
        return imageView;
    }
}

