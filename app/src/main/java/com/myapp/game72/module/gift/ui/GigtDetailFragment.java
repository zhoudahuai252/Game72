package com.myapp.game72.module.gift.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.myapp.game72.R;
import com.myapp.game72.base.BaseFragment;
import com.myapp.game72.common.adapter.CommonAdapter;
import com.myapp.game72.common.adapter.ViewHolder;
import com.myapp.game72.module.gift.bean.GiftBean;
import com.myapp.game72.module.gift.dao.GiftDao;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GigtDetailFragment extends BaseFragment {
    private List<GiftBean.InfoEntity> giftData;
    private int iCurpage;
    private PullToRefreshListView lvDetail;
    private CommonAdapter<GiftBean.InfoEntity> adapter;

    @Override
    protected int setViewId() {
        return R.layout.fragment_gigt_detail;
    }

    @Override
    protected void findViews(View view) {
        lvDetail = (PullToRefreshListView) view.findViewById(R.id.lv_detail);
    }

    @Override
    protected void init() {
        giftData = new ArrayList<>();
        lvDetail.setMode(PullToRefreshBase.Mode.BOTH);
        adapter = new MyGiftAdapter(getActivity(),
                giftData, R.layout.layout_item_list_gift);
        lvDetail.setAdapter(adapter);
    }

    @Override
    protected void initEvents() {
        lvDetail.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                giftData.clear();
                iCurpage = 1;
                loadData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                iCurpage++;
                loadData();
            }
        });
    }

    @Override
    protected void loadData() {
        String type = getArguments().getString("type");
        GiftDao.getGiftData(iCurpage + "", type, new GiftDao.GiftCallBack() {
            @Override
            public void call(GiftBean giftBean) {
                List<GiftBean.InfoEntity> info = giftBean.getInfo();
                if (info.size() < 10) {//说明已经没有下一页
                    giftData.addAll(info);
                    lvDetail.onRefreshComplete();
                    adapter.notifyDataSetChanged();
                    lvDetail.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
                } else {
                    giftData.addAll(info);
                    lvDetail.onRefreshComplete();
                    adapter.notifyDataSetChanged();
                    lvDetail.setMode(PullToRefreshBase.Mode.BOTH);
                }
            }
        });
    }

    private class MyGiftAdapter extends CommonAdapter<GiftBean.InfoEntity> {
        public MyGiftAdapter(Context context, List<GiftBean.InfoEntity> mDatas, int itemLayoutId) {
            super(context, mDatas, itemLayoutId);
        }

        @Override
        public void convert(ViewHolder helper, int position, GiftBean.InfoEntity item) {
            helper.setText(R.id.tv_bootom, "剩余：" + item.getRemain());
            helper.setText(R.id.tv_gift_name, item.getName());
            helper.setText(R.id.tv_muchu, "价格：" + item.getConsume() + "U币");
            helper.setImageByUrl(R.id.iv_icon_gift, item.getIcon(), getActivity());
            helper.setOnclickLister(R.id.tv_btn, new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
