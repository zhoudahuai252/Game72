package com.myapp.game72.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myapp.game72.R;

/**
 * 自定义底部菜单
 */
public class BottomMenu extends LinearLayout {

    private ImageView mimageview;
    private TextView mTextview;
    public boolean isSelect = false;
    private int resid_nomal;
    private int resid_sel;
    private int width;
    private int heigth;

    public BottomMenu(Context context) {
        super(context);
        initView(context, null, 0);
    }

    public BottomMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs, 0);
    }

    public BottomMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.layout_bootommenu, this, true);
        findViews();
        //得到XML自定义的属性值
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.bottommenu);
        String text = typedArray.getString(R.styleable.bottommenu_text);//得到设置的字符串
        //得到没有点击的资源ID
        resid_nomal = typedArray.getResourceId(R.styleable.bottommenu_nomalpic, -1);
        //得到点击后资源ID
        resid_sel = typedArray.getResourceId(R.styleable.bottommenu_selpic, -1);
        mimageview.setImageResource(resid_nomal);
        mTextview.setText(text);
    }

    public void setSelect(boolean isSelect) {
        Log.d("print", "setSelect");
        //改变状态时,有动画
        boolean lastState = this.isSelect;
        this.isSelect = isSelect;
        if (lastState != this.isSelect) {
            onStateChange();
        }
    }

    /**
     * 查找自定义控件子控件
     */
    private void findViews() {
        mimageview = (ImageView) findViewById(R.id.ivbmpic);
        mTextview = (TextView) findViewById(R.id.tvbm);
    }

    private void onStateChange() {
        Log.d("print", "onStateChange");
        if (isSelect) {
            onSelect();
        } else {
            onUnSelect();
        }
    }

    /**
     * 点击菜单,切换图片
     */
    public void onSelect() {
        if (isSelect) {
            return;
        }
        //切换图片.并且隐藏文字
        mimageview.setImageResource(resid_sel);
        mTextview.setVisibility(GONE);
        this.measure(0, 0);
        width = getMeasuredWidth();
        heigth = getMeasuredHeight();
        //放大自己
        ScaleAnimation animation = new ScaleAnimation(1, 1.5f, 1, 1.5f, width / 2, heigth / 2);
        //把图片放大到1.5
        animation.setFillAfter(true);//停留再最后一针
        animation.setDuration(500);
        mimageview.startAnimation(animation);

    }

    public void onUnSelect() {
        //缩小自己动画
        //放大自己
        Log.d("print", "onUnSelect");
        ScaleAnimation animation = new ScaleAnimation(1.5f, 1, 1.5f, 1, width / 2, heigth / 2);//把图片缩小

        animation.setDuration(500);
        animation.setFillAfter(true);//停留再最后一针
        mimageview.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mimageview.setImageResource(resid_nomal);
                mTextview.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

}
