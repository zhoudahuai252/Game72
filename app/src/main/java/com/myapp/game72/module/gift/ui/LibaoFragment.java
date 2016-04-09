package com.myapp.game72.module.gift.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.myapp.game72.R;
import com.myapp.game72.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class LibaoFragment extends BaseFragment {
    ViewPager mViewpager;
    RadioGroup mRgoup;
    List<Fragment> arrFragment;

    @Override
    protected int setViewId() {
        return R.layout.layout_libao_fragment;
    }

    @Override
    protected void findViews(View view) {
        mViewpager = (ViewPager) view.findViewById(R.id.vpdetail);
        mRgoup = (RadioGroup) view.findViewById(R.id.rg_chose);
        mRgoup.check(R.id.rb_xin);
    }

    @Override
    protected void init() {
        arrFragment = new ArrayList<>();
        //最新页面fragment
        GigtDetailFragment gigtDetailFragmentNew = new GigtDetailFragment();
        Bundle bundleNew = new Bundle();
        bundleNew.putString("type", "1");
        gigtDetailFragmentNew.setArguments(bundleNew);
        arrFragment.add(gigtDetailFragmentNew);

        //最热页面fragment
        GigtDetailFragment gigtDetailFragmentHot = new GigtDetailFragment();
        Bundle bundleHot = new Bundle();
        bundleHot.putString("type", "2");
        gigtDetailFragmentHot.setArguments(bundleHot);
        arrFragment.add(gigtDetailFragmentHot);

        mViewpager.setAdapter(new FragmentPagerAdapter(this.getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return arrFragment.get(position);
            }

            @Override
            public int getCount() {
                return arrFragment.size();
            }
        });
    }

    @Override
    protected void initEvents() {
        mRgoup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_xin:
                        mViewpager.setCurrentItem(0);
                        break;
                    case R.id.rb_ri:
                        mViewpager.setCurrentItem(1);
                        break;
                    default:
                        break;
                }
            }
        });
        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                RadioButton rb = (RadioButton) mRgoup.getChildAt(position);
                rb.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void loadData() {

    }
}
