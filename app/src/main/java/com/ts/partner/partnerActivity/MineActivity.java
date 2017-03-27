//package com.ts.partner.partnerActivity;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.databinding.DataBindingUtil;
//import android.os.Bundle;
//import android.view.View;
//
//import com.ts.partner.R;
//import com.ts.partner.databinding.MineBinding;
//import com.ts.partner.partnerBase.BaseActivity;
//import com.ts.partner.partnerBean.BendingBean.ShowMsgInMineBean;
//import com.ts.partner.partnerBean.netBean.LoginBean;
//
//import org.greenrobot.eventbus.EventBus;
//import org.greenrobot.eventbus.Subscribe;
//
//import java.util.List;
//
///*
//我的界面的activity
// */
//public class MineActivity extends BaseActivity implements View.OnClickListener {
//    MineBinding bingding;
//    ShowMsgInMineBean data;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_mine);
//        bingding = DataBindingUtil.setContentView(this, R.layout.activity_mine);
//        bingding.mineBack.setOnClickListener(this);
//        bingding.mineSetting.setOnClickListener(this);
//        bingding.mineMycard.setOnClickListener(this);
//        data= (ShowMsgInMineBean) getIntent().getSerializableExtra(HomeActivity.MAIN_KEY);
//        bingding.setMinedatas(data);
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.mine_back:
//                onBackPressed();
//                break;
//            case R.id.mine_mycard:
//                Intent intent = new Intent(this, CardActivity.class);
//                intent.putExtra(HomeActivity.MAIN_KEY,data);
//                startActivity(intent);
//                break;
//            case R.id.mine_setting:
//                break;
//        }
//    }
//    @Subscribe
//    public void onEvent(LoginBean.DataBean datas) {
//        loge("changedata");
//       data=new ShowMsgInMineBean(datas);
//        bingding.setMinedatas(data);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        EventBus.getDefault().unregister(this);
//    }
//}
