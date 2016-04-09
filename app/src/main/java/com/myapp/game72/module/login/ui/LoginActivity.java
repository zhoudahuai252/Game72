package com.myapp.game72.module.login.ui;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.myapp.game72.MainActivity;
import com.myapp.game72.R;
import com.myapp.game72.base.BaseActivity;
import com.myapp.game72.common.constant.Constant;
import com.myapp.game72.module.login.bean.LoginApiInfo;
import com.myapp.game72.module.login.dao.LoginDao;
import com.se7en.utils.SystemUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class LoginActivity extends BaseActivity {


    private Toolbar toolbar;
    private Button btnLogin;
    private ProgressBar progressBar;

    @Override
    protected int setViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void findViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnLogin = (Button) findViewById(R.id.btn_login);
        progressBar = (ProgressBar) findViewById(R.id.progbar);
    }

    @Override
    protected void init() {
        //toolbar.setSubtitle("");
        toolbar.setTitle(" ");

        //String strTitle = (String) toolbar.getTitle();
        setSupportActionBar(toolbar);


    }

    @Override
    protected void initEvents() {

        RxView.clicks(btnLogin)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        btnLogin.setEnabled(false);
                        progressBar.setVisibility(View.VISIBLE);
                        //应该进行网络任务
                        Log.d("LoginActivity", Thread.currentThread().getName());
                        LoginDao.getRetrofit()
                                .getGiftData("13970239406", "YWExMTIyMzM=")
                                .subscribeOn(Schedulers.newThread())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Action1<LoginApiInfo>() {
                                    @Override
                                    public void call(LoginApiInfo loginApiInfo) {
                                        if (loginApiInfo.getInfo() != null) {
                                            loginSucess(loginApiInfo);
                                        } else {
                                            progressBar.setVisibility(View.GONE);
                                            btnLogin.setEnabled(true);
                                            Toast.makeText(LoginActivity.this, "登陆失败，网络错误", Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                }, new Action1<Throwable>() {
                                    @Override
                                    public void call(Throwable throwable) {
                                        progressBar.setVisibility(View.GONE);
                                        btnLogin.setEnabled(true);
                                        //登陆失败，吐一个思
                                        Toast.makeText(LoginActivity.this, throwable.toString(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                });
    }

    private void loginSucess(LoginApiInfo loginApiInfo) {
        //登陆成功，跳转界面
        SystemUtil.setSharedString(Constant.IS_LOGIN, "true");
        Intent intent = new Intent(LoginActivity.this, MainActivity
                .class);
        try {
            SystemUtil.setSerializableObject(new File(getCacheDir
                            (), Constant.LOGIN_CARE_NAME),
                    loginApiInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        progressBar.setVisibility(View.GONE);
        startActivity(intent);
        finish();
    }

    @Override
    protected void loadData() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.add(1, 1, 1, "注册");

        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 1) {
            //跳转注册页面
        }
        return super.onOptionsItemSelected(item);
    }
}
