package com.myapp.game72.module.money.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.myapp.game72.MyApplication;
import com.myapp.game72.R;
import com.myapp.game72.base.BaseFragment;
import com.myapp.game72.common.adapter.CommonAdapter;
import com.myapp.game72.common.adapter.ViewHolder;
import com.myapp.game72.common.constant.Constant;
import com.myapp.game72.module.money.bean.InfoEntity;
import com.myapp.game72.module.money.bean.MoneyData;
import com.myapp.game72.module.money.dao.MoneyDao;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class MoneyFragment extends BaseFragment {

    private EditText editText;
    private PullToRefreshListView listView;
    private List<InfoEntity> moneyList;
    private CommonAdapter<InfoEntity> adapter;
    private int page = 1;

    @Override
    protected int setViewId() {
        return R.layout.layout_money_fragment;
    }

    @Override
    protected void findViews(View view) {
        editText = (EditText) view.findViewById(R.id.etserach);
        listView = (PullToRefreshListView) view.findViewById(R.id.pulllistview);
    }

    @Override
    protected void init() {

        moneyList = new ArrayList<>();
        adapter = new MyMoneyAdapter(getActivity(), moneyList,
                R.layout.layout_item_list_money);

        listView.setMode(PullToRefreshBase.Mode.BOTH);
    }

    @Override
    protected void initEvents() {
        listView.setAdapter(adapter);
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(final PullToRefreshBase<ListView> refreshView) {
                boolean flag = Constant.checkNetworkAvailable(getActivity());
                if (!flag) {
                    refreshView.onRefreshComplete();
                    return;
                }
                MoneyDao.getMoneyData(1 + "", new MoneyDao.MoneyCallback() {
                    @Override
                    public void callback(MoneyData moneyData) {
                        page = 1;
                        Log.d("MoneyFragment", moneyData.toString());
                        moneyList.clear();
                        //把数据更新到数据库中
                        try {
                            MyApplication.dbUtils.saveAll(moneyData.getInfo());
                        } catch (DbException e) {
                            e.printStackTrace();
                        }
                        moneyList.addAll(moneyData.getInfo());
                        Log.d("MoneyFragment", "--->" + moneyList.size());
                        adapter.notifyDataSetChanged();
                        refreshView.onRefreshComplete();
                    }
                });
            }

            @Override
            public void onPullUpToRefresh(final PullToRefreshBase<ListView> refreshView) {
                boolean flag = Constant.checkNetworkAvailable(getActivity());
                if (!flag) {
                    refreshView.onRefreshComplete();
                    return;
                }
                MoneyDao.getMoneyData((page + 1) + "", new MoneyDao.MoneyCallback() {
                    @Override
                    public void callback(MoneyData moneyData) {

                        int size = moneyData.getInfo().size();
                        if (size == 0) {
                            Toast.makeText(getActivity(), "没有更多", Toast.LENGTH_SHORT).show();
                            refreshView.onRefreshComplete();
                            return;
                        }
                        page++;
                        Logger.d("--->" + size + "");
                        Logger.d("--->" + page + "");
                        //把数据更新到数据库中
                        try {
                            MyApplication.dbUtils.saveAll(moneyData.getInfo());
                        } catch (DbException e) {
                            e.printStackTrace();
                        }
                        moneyList.addAll(moneyData.getInfo());
                        adapter.notifyDataSetChanged();
                        refreshView.onRefreshComplete();
                    }
                });
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //跳转到详细页
                Log.d("MoneyFragment", "setOnItemClickListener" + "--->" + position);
                Intent intent = new Intent(getActivity(), MoneyDetaiActivity.class);
                String ids = moneyList.get(position - 1).getId();

                intent.putExtra("id", ids);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {
        boolean flag = Constant.checkNetworkAvailable(getActivity());
        if (flag) {
            MoneyDao.getMoneyData(1 + "", new MoneyDao.MoneyCallback() {
                @Override
                public void callback(MoneyData moneyData) {
                    Log.d("MoneyFragment", moneyData.toString());
                    //把数据更新到数据库中
                    try {
                        MyApplication.dbUtils.saveAll(moneyData.getInfo());
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                    moneyList.addAll(moneyData.getInfo());
                    Log.d("MoneyFragment", "--->" + moneyList.size());
                    adapter.notifyDataSetChanged();
                }
            });
        } else {
            //从数据库中加载
            try {
                List<InfoEntity> entities = MyApplication.dbUtils.findAll(InfoEntity.class);
                moneyList.addAll(entities);
                adapter.notifyDataSetChanged();
            } catch (DbException e) {
                e.printStackTrace();
            }
        }
        isUpdate();
        showDiag();

    }

    private void showDiag() {
        View view = View.inflate(getActivity(), R.layout.layout_diag_update, null);
        Button btnDown = (Button) view.findViewById(R.id.btn_down);
        Button btnCanle = (Button) view.findViewById(R.id.btn_cancel);
        final AlertDialog dialg = new AlertDialog.Builder(getActivity())
                .setView(view)
                .create();
        dialg.show();
        btnCanle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialg.dismiss();
            }
        });
        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //下载操作更新进度
            }
        });
    }

    private void isUpdate() {
        //判断是否有更新
        RequestParams params = new RequestParams();
        params.addBodyParameter("platform", "2");
        params.addBodyParameter("ver", "v1.0.0");
        MyApplication.mHttpUtils.send(HttpRequest.HttpMethod.POST,
                "http://zhushou.72g.com/app/common/upgrade/", params
                , new RequestCallBack<String>() {

                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        Log.d("myapp",responseInfo.toString());

                    }

                    @Override
                    public void onFailure(HttpException error, String msg) {
                        Logger.e(msg);
                    }
                });
    }

    private class MyMoneyAdapter extends CommonAdapter<InfoEntity> {
        public MyMoneyAdapter(Context context, List<InfoEntity> mDatas, int itemLayoutId) {
            super(context, mDatas, itemLayoutId);
        }

        @Override
        public void convert(ViewHolder helper, int position, InfoEntity item) {
            Log.e("print", "----->" + item.getName());
            helper.setText(R.id.tv_money_name, item.getName());
            helper.setText(R.id.tv_allprivce, item.getAll_prize() + "金币");
            helper.setText(R.id.tv_bootom, item.getCount_dl() + "人下载" + "  " + item.getSize());
            helper.setImageByUrl(R.id.iv_icon, item.getIcon(), getActivity());
            helper.setRatingbarPr0gess(R.id.rtbar_money,
                    5 * Float.parseFloat(item.getScore()) / 10);
        }
    }
}
