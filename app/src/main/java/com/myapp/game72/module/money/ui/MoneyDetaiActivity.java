package com.myapp.game72.module.money.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.myapp.game72.R;
import com.myapp.game72.base.BaseActivity;
import com.myapp.game72.module.money.bean.MoneyDetailBean;
import com.myapp.game72.module.money.dao.ActivityCallback;
import com.myapp.game72.module.money.dao.MoneyDao;
import com.squareup.picasso.Picasso;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MoneyDetaiActivity extends BaseActivity implements ActivityCallback {

    private ImageView mImageView;
    private String mGameId;
    private String[] strImageUrls;
    private String snapshot;
    private ImageFragment imageFragment;
    private ContenerFragment contenerFragment;
    private FragmentManager fragmentManager;

    @Override
    protected int setViewId() {
        return R.layout.activity_money_detai;
    }

    @Override
    protected void findViews() {
        mImageView = (ImageView) findViewById(R.id.iv_top);
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        mGameId = intent.getStringExtra("id");
        imageFragment = new ImageFragment();
        contenerFragment = new ContenerFragment();
        mImageView.setEnabled(false);
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void initEvents() {
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击显示图片界面Fragment
                FragmentTransaction transaction = fragmentManager
                        .beginTransaction();
                transaction.replace(R.id.fl_contener, imageFragment);
                transaction.hide(contenerFragment);
                transaction.show(imageFragment);
                transaction.commit();
            }
        });
    }

    @Override
    protected void loadData() {
        //  获得数据
        MoneyDao.getRefoit()
                .getDetailData(mGameId + "")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MoneyDetailBean>() {
                    @Override
                    public void call(MoneyDetailBean moneyDetailBean) {
                        if (moneyDetailBean.getInfo() != null) {
                            //数据请求成功
                            snapshot = moneyDetailBean.getInfo().getSnapshot();
                            strImageUrls = snapshot.split(",");
                            Bundle bundle = new Bundle();
                            bundle.putCharSequence("urls", snapshot);
                            imageFragment.setArguments(bundle);
                            mImageView.setEnabled(true);
                            //默认显示第一张图片
                            Picasso.with(MoneyDetaiActivity.this).load(strImageUrls[0]).into(mImageView);
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.d("MoneyDetaiActivity", throwable.toString());
                    }
                });
    }

    @Override
    public void callback(int postion) {
        //当回调时隐藏图片的界面
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(imageFragment);
        transaction.commit();
        Picasso.with(this).load(strImageUrls[postion]).into(mImageView);
    }
}
