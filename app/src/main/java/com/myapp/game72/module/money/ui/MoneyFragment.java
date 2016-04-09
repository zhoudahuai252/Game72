package com.myapp.game72.module.money.ui;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.myapp.game72.R;
import com.myapp.game72.base.BaseFragment;
import com.myapp.game72.common.adapter.CommonAdapter;
import com.myapp.game72.common.adapter.ViewHolder;
import com.myapp.game72.module.money.bean.MoneyData;
import com.myapp.game72.module.money.dao.MoneyDao;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class MoneyFragment extends BaseFragment {

    private EditText editText;
    private PullToRefreshListView listView;
    private List<MoneyData.InfoEntity> moneyList;
    private CommonAdapter<MoneyData.InfoEntity> adapter;
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

                MoneyDao.getMoneyData(1 + "", new MoneyDao.MoneyCallback() {
                    @Override
                    public void callback(MoneyData moneyData) {
                        page = 1;
                        Log.d("MoneyFragment", moneyData.toString());
                        moneyList.clear();
                        moneyList.addAll(moneyData.getInfo());
                        Log.d("MoneyFragment", "--->" + moneyList.size());
                        adapter.notifyDataSetChanged();
                        refreshView.onRefreshComplete();
                    }
                });
            }

            @Override
            public void onPullUpToRefresh(final PullToRefreshBase<ListView> refreshView) {
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
                        moneyList.addAll(moneyData.getInfo());
                        adapter.notifyDataSetChanged();
                        refreshView.onRefreshComplete();
                    }
                });
            }
        });
       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //跳转到详细页
                Log.d("MoneyFragment", "setOnItemClickListener");
                Intent intent = new Intent(getActivity(), MoneyDetaiActivity.class);
                intent.putExtra("id", moneyList.get(position).getId());
                startActivity(intent);
            }
        });*/
    }

    @Override
    protected void loadData() {
        MoneyDao.getMoneyData(1 + "", new MoneyDao.MoneyCallback() {
            @Override
            public void callback(MoneyData moneyData) {
                Log.d("MoneyFragment", moneyData.toString());
                moneyList.addAll(moneyData.getInfo());
                Log.d("MoneyFragment", "--->" + moneyList.size());
                adapter.notifyDataSetChanged();
            }
        });

    }

    private class MyMoneyAdapter extends CommonAdapter<MoneyData.InfoEntity> {
        public MyMoneyAdapter(Context context, List<MoneyData.InfoEntity> mDatas, int itemLayoutId) {
            super(context, mDatas, itemLayoutId);
        }

        @Override
        public void convert(ViewHolder helper, int position, MoneyData.InfoEntity item) {
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
