package com.ts.partner.partnerFragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.PopupWindow;

import com.google.gson.Gson;
import com.ts.partner.BR;
import com.ts.partner.R;
import com.ts.partner.databinding.TuiguangBinding;
import com.ts.partner.partnerActivity.HomeActivity;
import com.ts.partner.partnerActivity.ShareMesActivity;
import com.ts.partner.partnerAdapter.simpleAdapter.ListAdapter;
import com.ts.partner.partnerBase.BaseData;
import com.ts.partner.partnerBase.BaseFragment;
import com.ts.partner.partnerBase.impl.OnShareMsgChangeListener;
import com.ts.partner.partnerBean.netBean.NetError;
import com.ts.partner.partnerBean.netBean.ShareMesBean;
import com.ts.partner.partnerUtils.NetUtils;

import org.xutils.common.Callback;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/2/25.
 * home 推广界面 显示文章列表
 */

public class TuiGuangFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {
    HomeActivity activity;
    TuiguangBinding b;
    private static ShareMesBean datas = new ShareMesBean();
    ListAdapter<ShareMesBean.MsgBean> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        b = DataBindingUtil.inflate(inflater, R.layout.fragment_tuiguang, container, false);
        init();
        initFresh();
        return b.getRoot();
    }

    private void init() {
        activity = (HomeActivity) getActivity();
//            View view = LayoutInflater.from(activity).inflate(R.layout.item_sharelv_headview, null);
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
//            b.tuiguangLv.addHeaderView(view);
        adapter = new ListAdapter<>(activity, datas.getMsg(), BR.msgbean, R.layout.item_share_lv);
        b.tuiguangLv.setAdapter(adapter);
        b.tuiguangLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(activity, ShareMesActivity.class);
                intent.putExtra("sharedata", datas.getMsg().get(position));
                startActivity(intent);
            }
        });
        b.tuiguangBianji.setOnClickListener(this);
        getShareMsg();
        b.tuiguangLv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                boolean enable = false;
                if (  b.tuiguangLv!= null &&   b.tuiguangLv.getChildCount() > 0) {
                    boolean firstItemVisible =   b.tuiguangLv.getFirstVisiblePosition() == 0;
                    boolean topOfFirstItemVisible =   b.tuiguangLv.getChildAt(0).getTop() == 0;
                    enable = firstItemVisible && topOfFirstItemVisible;
                }
               b.tuiguangRefresh.setEnabled(enable);
            }
        });

    }

    //设置刷新组建
    private void initFresh() {
        b.tuiguangRefresh.setOnRefreshListener(this);
        // 设置下拉圆圈上的颜色，蓝色、绿色、橙色、红色
        b.tuiguangRefresh.setColorSchemeResources(android.R.color.holo_blue_bright);
        b.tuiguangRefresh.setDistanceToTriggerSync(400);// 设置手指在屏幕下拉多少距离会触发下拉刷新
        b.tuiguangRefresh.setSize(SwipeRefreshLayout.DEFAULT); // 设置圆圈的大小

    }

    //刷新行为，向activity发送消息更新信息，然后通过回调将信息重新展示
//    @Override
//    public void onMsgChange(ShareMesBean datas) {
//        if (datas != null) {
//            adapter.setDatas(datas.getMsg());
//            b.tuiguangRefresh.setRefreshing(false);
//            toast(getString(R.string.gengxinchenggong)
//            );
//        } else {
//            b.tuiguangRefresh.setRefreshing(false);
//            toast(getString(R.string.failtorefresh));
//        }
//
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tuiguang_bianji:
//                getPopWindow();
                break;
        }
    }

    // 弹出投稿记录 和我要投稿的popuwindow
    PopupWindow mPopuwindow;

    private void initPopuwindow() {
        View popupView = getActivity().getLayoutInflater().inflate(R.layout.item_popu_tougao, null);
        Button tougao = (Button) popupView.findViewById(R.id.tuiguang_popu_tougao);
        Button jilu = (Button) popupView.findViewById(R.id.tuiguang_popu_jilu);
        tougao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        jilu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mPopuwindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopuwindow.setTouchable(true);
        mPopuwindow.setBackgroundDrawable(new BitmapDrawable());
        mPopuwindow.setOutsideTouchable(true);
        mPopuwindow.setFocusable(true);
        mPopuwindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    mPopuwindow.dismiss();
                    return true;
                }
                return false;
            }
        });

    }

    //对popuwindow 进行操作
    private void getPopWindow() {
        if (mPopuwindow == null) {
            initPopuwindow();
        }
        if (mPopuwindow.isShowing()) {
            mPopuwindow.dismiss();
        } else {

            mPopuwindow.showAsDropDown(b.tuiguangPos, -50, 0);
            mPopuwindow.update();
        }
    }

    //从服务器获取到分享的信息，然后传递到分享fragment

    Gson gson = new Gson();

    //刷新数据 刷新推广数据
    public void getShareMsg() {
        NetUtils.Get(BaseData.FENXIANG, new HashMap<String, String>(), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (result != null && !result.substring(0, 19).contains("Error")) {
                    datas = gson.fromJson(result, ShareMesBean.class);
                    adapter.setDatas(datas.getMsg());
                } else {
                    NetError error = gson.fromJson(result, NetError.class);
                    toast(error.getMsg());
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                b.tuiguangRefresh.setRefreshing(false);
            }
        });

    }

    //下拉刷新之后操作
    @Override
    public void onRefresh() {
        getShareMsg();
    }
}
