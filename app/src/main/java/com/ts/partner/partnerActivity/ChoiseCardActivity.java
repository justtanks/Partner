package com.ts.partner.partnerActivity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;

import com.ts.partner.R;
import com.ts.partner.databinding.ChoiseCardBinding;
import com.ts.partner.partnerAdapter.ChoiseCardLvAdapter;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBean.netBean.CardBean;
import com.ts.partner.partnerUtils.SystemUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/*
选择银行卡界面
 */
public class ChoiseCardActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    ChoiseCardBinding b;
    CardBean datas = null;
    ChoiseCardLvAdapter adapter;
    public static final int FROM_CHOISCARD = 11111;
    Intent fromDrawCashIntent;  //从提现界面传过来的intent
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
        b.choisecardLb.setOnItemClickListener(this);
        fromDrawCashIntent=getIntent();
    }
    @Override
    protected void onStart() {
        super.onStart();
        datas = (CardBean) getIntent().getSerializableExtra("datas");
        adapter = new ChoiseCardLvAdapter(this, datas.getData());
        b.choisecardLb.setAdapter(adapter);
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
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
//    //刷新添加的银行卡
//    @Subscribe
//    public void onEventList(CardBean datas) {
//        this.datas=datas;
//        adapter.setDatas(datas.getData());
//        adapter.notifyDataSetChanged();
//    }
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
        CardBean.DataBean choisedCard = datas.getData().get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("datas1", choisedCard);
        fromDrawCashIntent.putExtras(bundle);
        setResult(DrawCashActivity.TOGETCARD, fromDrawCashIntent);
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
//        EventBus.getDefault().unregister(this);
        handler.removeCallbacks(runnable1);
        handler.removeCallbacks(runnable2);
        datas=null;
        adapter=null;
        su=null;
        b=null;
    }
}
