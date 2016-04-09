package com.myapp.game72;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.myapp.game72.base.BaseActivity;
import com.myapp.game72.common.adapter.MyWelcomPageAdapter;
import com.myapp.game72.common.constant.Constant;
import com.myapp.game72.module.login.ui.LoginActivity;
import com.se7en.utils.SystemUtil;

import java.util.ArrayList;
import java.util.List;

public class WelcomActivity extends BaseActivity {


    private ViewPager mviewPager;
    private List<ImageView> mlistData;
    private PagerAdapter madapter;
    private Button mbtn_start;
    private int iCurversion;
    private int iLastversion;
    private ImageView ivtext;
    private ImageView ivPiclogo;

    @Override
    protected int setViewId() {
        Log.d("print", "setViewId");
        return R.layout.activity_welcom;
    }

    @Override
    protected void findViews() {
        Log.d("print", "findViews");
        mviewPager = (ViewPager) findViewById(R.id.page_welcom);
        mbtn_start = (Button) findViewById(R.id.btn_start);
        ivtext = (ImageView) findViewById(R.id.ivtext);
        ivPiclogo = (ImageView) findViewById(R.id.ivpiclog);
    }

    @Override
    protected void init() {
        iCurversion = SystemUtil.getSystemVersionCode();
        iLastversion = SystemUtil.getSharedInt(Constant.VERSION_STRING, -1);
        if (iLastversion == -1 || iCurversion > iLastversion) {
            mlistData = new ArrayList<>();
            //把引导图片放入数组
            addImageView(R.mipmap.bg_guide_01);
            addImageView(R.mipmap.bg_guide_02);
            addImageView(R.mipmap.bg_guide_03);
            addImageView(R.mipmap.bg_guide_04);
            Log.d("print", "mlistData.size():" + mlistData.size());

            madapter = new MyWelcomPageAdapter(mlistData);
            mviewPager.setAdapter(madapter);
        } else {
            //显示动画
            showTextAnimation();

        }

    }

    /**
     * 显示文字动画
     */
    protected void showTextAnimation() {
        ivtext.setVisibility(View.VISIBLE);
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation
                .RELATIVE_TO_PARENT,
                -1,
                Animation.RELATIVE_TO_PARENT,
                0,
                Animation.RELATIVE_TO_PARENT,
                0,
                Animation.RELATIVE_TO_PARENT,
                0);
        translateAnimation.setDuration(2000);
        //回弹一下
        translateAnimation.setInterpolator(new OvershootInterpolator());
        ivtext.startAnimation(translateAnimation);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                showPiclogoAnim();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    /**
     * 显示图片loggo动画
     */
    private void showPiclogoAnim() {
        ivPiclogo.setVisibility(View.VISIBLE);
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation
                .RELATIVE_TO_PARENT,
                0,
                Animation.RELATIVE_TO_PARENT,
                0,
                Animation.RELATIVE_TO_PARENT,
                -1,
                Animation.RELATIVE_TO_PARENT,
                0);
        translateAnimation.setDuration(2000);
        //回弹多下
        translateAnimation.setInterpolator(new BounceInterpolator());
        ivPiclogo.startAnimation(translateAnimation);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                isLoginToNextAty();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    protected void addImageView(int id) {
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(id);
        mlistData.add(imageView);
    }

    @Override
    protected void initEvents() {
        mbtn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SystemUtil.setSharedInt(Constant.VERSION_STRING, iCurversion);
                isLoginToNextAty();

            }
        });
        mviewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == mlistData.size() - 1) {
                    mbtn_start.setVisibility(View.VISIBLE);
                } else {
                    mbtn_start.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void isLoginToNextAty() {
        //判断是否登陆
        String isLogin = SystemUtil.getSharedString(Constant.IS_LOGIN, "false");
        if (TextUtils.isEmpty(isLogin) || isLogin.equals("false")) {
            //没有登陆跳转登陆界面
            startActivity(new Intent(WelcomActivity.this, LoginActivity.class));
            finish();
        } else {
            //登陆跳转主界面
            Intent intent = new Intent(WelcomActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void loadData() {

    }
}
