package com.ts.partner.partnerActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ts.partner.R;
import com.ts.partner.databinding.CardBinding;
import com.ts.partner.partnerAdapter.CardListviewAdatper;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBase.BaseData;
import com.ts.partner.partnerBean.netBean.CardBean;
import com.ts.partner.partnerBean.netBean.DeleteCardSuccess;
import com.ts.partner.partnerBean.netBean.IsHadPasswordBean;
import com.ts.partner.partnerBean.netBean.NetError;
import com.ts.partner.partnerUtils.NetUtils;
import com.ts.partner.partnerUtils.SystemUtil;
import com.ts.partner.partnerViews.PwdEditText;

import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.Map;

public class CardActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener, SwipeRefreshLayout.OnRefreshListener {
    /*
    我的银行卡界面
     */
    private CardBinding bingding;
    CardBean carddata = new CardBean();
    CardListviewAdatper adatper;
    SystemUtil su = new SystemUtil(this);
    AlertDialog.Builder builder;
    ProgressDialog progressDialog;
    PopupWindow mPopuwindow; // 输入密码的弹出框
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        builder = new AlertDialog.Builder(this);
        bingding = DataBindingUtil.setContentView(this, R.layout.activity_card);
        bingding.cardAddnewcard.setOnClickListener(this);
        bingding.cardBacktext.setOnClickListener(this);
        bingding.cardLv.setOnItemLongClickListener(this);
        adatper = new CardListviewAdatper(this, carddata.getData());
        bingding.cardLv.setAdapter(adatper);
        setCircle();
    }

    private void setCircle() {
        bingding.cardFresh.setOnRefreshListener(this);
        bingding.cardFresh.setColorSchemeResources(android.R.color.holo_blue_bright);
        bingding.cardFresh.setDistanceToTriggerSync(300);
        bingding.cardFresh.setSize(SwipeRefreshLayout.DEFAULT);
        bingding.cardLv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                boolean enable = false;
                if (bingding.cardLv != null && bingding.cardLv.getChildCount() > 0) {
                    boolean firstItemVisible = bingding.cardLv.getFirstVisiblePosition() == 0;
                    boolean topOfFirstItemVisible = bingding.cardLv.getChildAt(0).getTop() == 0;
                    enable = firstItemVisible && topOfFirstItemVisible;
                }
                bingding.cardFresh.setEnabled(enable);
            }
        });
    }

    @Override
    public void onRefresh() {
        getCardOnNET();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getCardOnNET();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card_backtext:
                onBackPressed();
                break;
            case R.id.card_addnewcard:
                addCard();
                break;
        }
    }

    //添加银行卡
    private void addCard() {
        su.saveModle1(2);
        Map<String, Object> params = new HashMap<>();
        params.put("partner_id", su.showUid() + "");
        NetUtils.Post(BaseData.ISHADPASS, params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                IsHadPasswordBean bean = gson.fromJson(result, IsHadPasswordBean.class);
                if (bean.getData() == 1) {
                    //已经设置密码
                    Intent intent = new Intent(CardActivity.this, AddcardStep1Activity.class);
                    startActivity(intent);
                } else if (bean.getData() == 2) {
                    //未设置密码
                    Intent intent = new Intent(CardActivity.this, AddpassWordActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                toast(getResources().getString(R.string.net_error));
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        su = null;
        adatper = null;
        carddata = null;
        bingding = null;
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        popDialog(position);
        return true;
    }

    private void popDialog(final int position) {
        builder.setTitle("确定移除银行卡吗？");
        builder.setCancelable(false).setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showPassword(carddata.getData().get(position).getCard_num());
                dialog.cancel();
            }
        }).setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    //显示输入密码的弹出框 然后访问网络重新刷新数据
    private void showPassword(final String cardnum) {
        View popupView = getLayoutInflater().inflate(R.layout.dialog_shanka_password, null);
        PwdEditText password = (PwdEditText) popupView.findViewById(R.id.dialog_tixian_pet_pwd);
        RelativeLayout relBack = (RelativeLayout) popupView.findViewById(R.id.dialog_relaBack);
        mPopuwindow = new PopupWindow(popupView, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT, true);
        mPopuwindow.setTouchable(true);
        mPopuwindow.setOutsideTouchable(true);
        ColorDrawable dw = new ColorDrawable(0x00000000);
        mPopuwindow.setBackgroundDrawable(dw);
        relBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopuwindow.dismiss();
            }
        });

        password.setOnInputFinishListener(new PwdEditText.OnInputFinishListener() {
            @Override
            public void onInputFinish(String password) {
                changeCardforNet(cardnum, password);
                mPopuwindow.dismiss();
            }
        });
        mPopuwindow.showAtLocation(bingding.cardBack, Gravity.CENTER, 0, 0);
    }

    //请求网络进行删除操作
    private void changeCardforNet(String cardnum, String password) {
        progressDialog = ProgressDialog.show(this, "", "正在执行删除操作");
        progressDialog.show();
        Map<String, Object> param = new HashMap<>();
        param.put("partner_id", su.showUid());
        param.put("card_num", cardnum);
        param.put("password", password);
        NetUtils.Post(BaseData.DELETECARD, param, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (result.substring(0, 18).contains("Error")) {
                    NetError error = gson.fromJson(result, NetError.class);
                    toast(error.getMsg());
                } else {
                    DeleteCardSuccess sumsg = gson.fromJson(result, DeleteCardSuccess.class);
                    toast(sumsg.getMsg());
                    getCardOnNET();
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
                progressDialog.dismiss();
            }
        });
    }
    //从新请求网络加载银行卡数据  adapter重新加载数据


    private void getCardOnNET() {
        bingding.cardFresh.setRefreshing(true);
        Map<String, Object> param = new HashMap<>();
        param.put("partner_id", su.showUid());
        NetUtils.Post(BaseData.GETCARDS, param, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (result.substring(0, 18).contains("Error")) {
                    NetError error = gson.fromJson(result, NetError.class);
                    if (error.getMsg().equals("0")) {
                        //没有银行卡
                        toast("您还没有银行卡");
                    } else if (error.getMsg().equals("1")) {
                        Toast.makeText(CardActivity.this, "您还没有进行认证，无法获取银行卡信息", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    carddata = gson.fromJson(result, CardBean.class);
                    adatper.setDatas(carddata.getData());
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                toast("获取失败请重试");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                bingding.cardFresh.setRefreshing(false);
            }
        });

    }
}
