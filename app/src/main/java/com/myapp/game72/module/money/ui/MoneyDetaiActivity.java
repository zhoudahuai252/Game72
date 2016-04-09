package com.myapp.game72.module.money.ui;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.myapp.game72.R;
import com.myapp.game72.base.BaseActivity;
import com.myapp.game72.module.money.bean.MoneyDetailBean;
import com.myapp.game72.module.money.dao.MoneyDao;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MoneyDetaiActivity extends BaseActivity {

    private ImageView mImageView;
    private int mGameId;
    private String[] strImageUrls;
    private String snapshot;
    private ImageFragment imageFragment;
    private ContenerFragment contenerFragment;

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
        mGameId = intent.getIntExtra("id", 0);
        imageFragment = new ImageFragment();
        contenerFragment = new ContenerFragment();
        mImageView.setEnabled(false);
    }

    @Override
    protected void initEvents() {
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击显示图片界面Fragment
                FragmentTransaction transaction = getSupportFragmentManager()
                        .beginTransaction();
                transaction.hide(contenerFragment);
                transaction.show(imageFragment);
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
                        }
                    }
                });
    }
}
