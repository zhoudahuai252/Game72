package com.myapp.game72.module.money.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.myapp.game72.R;
import com.myapp.game72.base.BaseFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends BaseFragment {


    private ViewPager viewPager;
    private String[] strUrl;
    private List<ImageView> imageList;

    @Override
    protected int setViewId() {
        return R.layout.fragment_image;
    }

    @Override
    protected void findViews(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.vp_image);
    }

    @Override
    protected void init() {
        String urls = getArguments().getString("urls");
        if (!TextUtils.isEmpty(urls)) {
            strUrl = urls.split(",");
            //准备足够的Imageview
            imageList = new ArrayList<>();
            for (int i = 0; i < strUrl.length; i++) {
                ImageView imageview = new ImageView(getActivity());
                imageview.setScaleType(ImageView.ScaleType.FIT_XY);
                Picasso.with(getActivity()).load(strUrl[i]).into(imageview);
                imageList.add(imageview);
            }

        }
    }

    @Override
    protected void initEvents() {
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(imageList.get(position));
                return imageList.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

        });
    }

    @Override
    protected void loadData() {

    }
}
