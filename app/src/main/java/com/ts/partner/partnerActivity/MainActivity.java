//package com.ts.partner.partnerActivity;
//
//import android.content.Intent;
//import android.databinding.DataBindingUtil;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Toast;
//
//import com.ts.partner.R;
//import com.ts.partner.databinding.MainBinding;
//import com.ts.partner.partnerBase.BaseActivity;
//import com.ts.partner.partnerBean.BendingBean.DatasInMain;
//import com.ts.partner.partnerBean.BendingBean.ShowMsgInMineBean;
//import com.ts.partner.partnerBean.netBean.LoginBean;
//
//import org.greenrobot.eventbus.EventBus;
//import org.greenrobot.eventbus.Subscribe;
//
///*
//展示 首页
// */
//public class MainActivity extends BaseActivity implements View.OnClickListener {
//    private MainBinding b;
//    LoginBean logindatas;
//    public static final String MAIN_KEY = "1";
//    LoginBean.DataBean datas;
//    DatasInMain maida;
//    private long currentTime;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        b = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        EventBus.getDefault().register(this);
//        init();
//    }
//
//    private void init() {
//        b.mainMy.setOnClickListener(this);
//        b.mainDingdanmingxi.setOnClickListener(this);
//        b.mainTixian.setOnClickListener(this);
//        logindatas = (LoginBean) getIntent().getSerializableExtra(LoginActivity.DATAS_KEY);
//        datas = logindatas.getData().get(0);
//        maida = new DatasInMain(datas);
//        b.setDatas(maida);
//        currentTime=System.currentTimeMillis();
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.main_my:
//                jumpToMine();
//                break;
//            case R.id.main_dingdanmingxi:
//                justToOrders();
//                break;
//            case R.id.main_tixian:
//                jumpToMyCard();
//                break;
//
//        }
//    }
//
//    //跳转到我的界面
//    private void jumpToMine() {
//        Intent intent = new Intent(this, MineActivity.class);
//        intent.putExtra(MAIN_KEY, new ShowMsgInMineBean(datas));
//        startActivity(intent);
//    }
//
//    //跳转到提现界面
//    private void jumpToMyCard() {
//        //判断是否有银行卡 没有就先添加银行卡
//        if(datas.getPartner_bank_card().size()==0){
//            toast("请先添加银行卡");
//            Intent intent=new Intent(this,CardActivity.class);
//            startActivity(intent);
//            return;
//        }
//        Intent intent = new Intent(this, DrawCashActivity.class);
//        intent.putExtra("datas",datas);
//        startActivity(intent);
//    }
//
//    private void justToOrders() {
//        Intent intent = new Intent(this, OrdersActivity.class);
//        intent.putExtra(LoginActivity.DATAS_KEY, logindatas);
//        startActivity(intent);
//    }
//
//    @Subscribe
//    public void onEvent(LoginBean.DataBean datas) {
//        //提现之后刷新数据，直接重新设置数据
//        this.datas = datas;
//        maida = new DatasInMain(datas);
//        b.setDatas(maida);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        EventBus.getDefault().unregister(this);
//    }
//
//    @Override
//    public void onBackPressed() {
//        long time=System.currentTimeMillis();
//        if(time-currentTime>3000){
//            Toast.makeText(this, R.string.home_backpress, Toast.LENGTH_SHORT).show();
//            currentTime=time;
//            return;
//        }
//        super.onBackPressed();
//    }
//
//}
