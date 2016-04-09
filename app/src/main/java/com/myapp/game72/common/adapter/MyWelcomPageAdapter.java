package com.myapp.game72.common.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class MyWelcomPageAdapter extends PagerAdapter {
    List<ImageView> imageViewsList;

    public MyWelcomPageAdapter(List<ImageView> listData) {
        this.imageViewsList = listData;
    }

    @Override
    public int getCount() {
        return imageViewsList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imageViewsList.get(position));
        return imageViewsList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
