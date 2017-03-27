package com.ts.partner.partnerActivity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.ts.partner.R;
import com.ts.partner.databinding.FillMesBinding;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerUtils.StringUtils;

/*
完善个人信息的activity 增加银行卡时
 */
public class FillCardMsgActivity extends BaseActivity implements View.OnClickListener {
    FillMesBinding binding;
    String carnum=null;
    String carCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         init();
    }
    private void init(){
        binding= DataBindingUtil.setContentView(this,R.layout.activity_fill_card_msg);
        binding.fillcardMsgBac.setOnClickListener(this);
        binding.fillmsgNextstep.setOnClickListener(this);
        carnum=getIntent().getStringExtra("cardnum");
        carCity=getIntent().getStringExtra("cardcity");
        binding.fillcarmsgCardtype.setText(carCity);
        binding.fillcarmsgPhone.addTextChangedListener(new PhonetexWatcher());
        binding.fillmsgAgrees.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fillcardMsg_bac:
                onBackPressed();
                break;
            case R.id.fillmsg_nextstep:
             jumpTonext();
                break;
            case R.id.fillmsg_agrees:
                agree();
                break;
        }

    }

    private void agree() {
        Intent intent=new Intent(this,AgreeMentActivity.class);
        startActivity(intent);
    }

    private void jumpTonext(){
        String text=binding.fillcarmsgPhone.getText().toString();
        if(!StringUtils.isPhone(text)){
            toast("请输入正确手机号码");
            return;
        }
        Intent intent=new Intent(this,PhoneTestActivity.class);
        intent.putExtra("phone",text);
        intent.putExtra("cardcity",carCity);
        intent.putExtra("cardnum",carnum);
        startActivity(intent);
    }
    class PhonetexWatcher implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String text=binding.fillcarmsgPhone.getText().toString();
            if(null==text||"".equals(text)){
                binding.fillmsgNextstep.setBackgroundResource(R.mipmap.addcard_next_moren);
                binding.fillmsgNextstep.setEnabled(false);
            }else {
               binding.fillmsgNextstep.setBackgroundResource(R.drawable.selector_addcard_nextstep);
                binding.fillmsgNextstep.setEnabled(true);
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}
