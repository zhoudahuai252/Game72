package com.myapp.game72.module.me.ui;

import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.TextView;

import com.myapp.game72.R;
import com.myapp.game72.base.BaseFragment;
import com.myapp.game72.common.constant.Constant;
import com.myapp.game72.module.login.bean.LoginApiInfo;
import com.orhanobut.logger.Logger;
import com.se7en.utils.SystemUtil;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

public class MeFragment extends BaseFragment {

    private FloatingActionButton fab;
    private TextView tvNickName;

    @Override
    protected int setViewId() {
        return R.layout.layout_me_fragment;
    }

    @Override
    protected void findViews(View view) {
        fab = (FloatingActionButton) view.findViewById(R.id.fab_icon);
        tvNickName = (TextView) view.findViewById(R.id.tv_nickname);
    }

    @Override
    protected void init() {
        File file = new File(getActivity().getCacheDir(), Constant.LOGIN_CARE_NAME);
        LoginApiInfo info = null;
        try {
            info = (LoginApiInfo) SystemUtil.getSerializableObject(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (info != null) {
            Logger.d("!null");
            LoginApiInfo.InfoEntity infoEntity = info.getInfo();
            tvNickName.setText(infoEntity.getNickname());
            Picasso.with(getActivity()).load(infoEntity.getHpic()).into(fab);
        }
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void loadData() {

    }
}
