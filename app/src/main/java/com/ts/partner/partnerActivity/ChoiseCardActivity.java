package com.ts.partner.partnerActivity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;

import com.ts.partner.R;
import com.ts.partner.databinding.ChoiseCardBinding;
import com.ts.partner.partnerAdapter.ChoiseCardLvAdapter;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBean.netBean.LoginBean;
import com.ts.partner.partnerUtils.SystemUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/*
选择银行卡界面
 */
public class ChoiseCardActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    ChoiseCardBinding b;
    LoginBean.DataBean datas = null;
    ChoiseCardLvAdapter adapter;
    private Intent intent;
    public static final int FROM_CHOISCARD = 11111;
    Handler handler = new Handler();
     SystemUtil su=new SystemUtil(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        b = DataBindingUtil.setContentView(this, R.layout.activity_choise_card);
        b.choisecardNewcard.setOnClickListener(this);
        b.choisecardReback.setOnClickListener(this);
        intent = getIntent();
        datas = (LoginBean.DataBean) intent.getSerializableExtra("datas");
        adapter = new ChoiseCardLvAdapter(this, datas.getPartner_bank_card());
        b.choisecardLb.setAdapter(adapter);
        b.choisecardLb.setOnItemClickListener(this);
        EventBus.getDefault().register(this);

    }

    Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(ChoiseCardActivity.this, AddcardStep1Activity.class);
            intent.putExtra("ids", FROM_CHOISCARD);
            startActivity(intent);
        }
    };
    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            finish();
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.choisecard_newcard:
                addcard();
                break;
            case R.id.choisecard_reback:
                onBackPressed();
                break;
        }
    }
    //刷新添加的银行卡
    @Subscribe
    public void onEventList(LoginBean datas) {
        adapter.setDatas(datas.getData().get(0).getPartner_bank_card());
        adapter.notifyDataSetChanged();
    }
    //添加银行卡
    private void addcard() {
        b.choisecardDuihao.setVisibility(View.VISIBLE);
        adapter.setPos(-1);
        su.saveModle1(1);
        handler.postDelayed(runnable1, 600);
    }


    //选择新的银行卡
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        adapter.setPos(position);
        b.choisecardDuihao.setVisibility(View.INVISIBLE);
        LoginBean.DataBean.PartnerBankCardBean choisedCard = datas.getPartner_bank_card().get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("datas1", choisedCard);
        intent.putExtras(bundle);
        setResult(DrawCashActivity.TOGETCARD, intent);
        handler.postDelayed(runnable2, 600);
    }


    @Override
    protected void onStop() {
        super.onStop();
        b.choisecardDuihao.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        handler.removeCallbacks(runnable1);
        handler.removeCallbacks(runnable2);
        datas=null;
        adapter=null;
        su=null;
        b=null;
    }
}
