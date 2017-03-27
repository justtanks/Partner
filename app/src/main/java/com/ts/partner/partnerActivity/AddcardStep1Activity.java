package com.ts.partner.partnerActivity;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.parser.BindingExpressionParser;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.ts.partner.R;

import com.ts.partner.databinding.AddcardBinding;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerUtils.BankUtil;

import java.util.HashMap;
import java.util.Map;

import kotlin.collections.IndexingIterable;

/*
   添加银行卡第一步的activity
 */
public class AddcardStep1Activity extends BaseActivity implements View.OnClickListener {
    AddcardBinding b;
    Map<String, Boolean> isEnable = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_addcard_step1);
        init();
    }


    private void init() {
        b.addcardNextstep.setOnClickListener(this);
        b.step1Back.setOnClickListener(this);
        b.step1Back2.setOnClickListener(this);
        b.addcardStep1Help.setOnClickListener(this);
        b.addcarStep1Name.addTextChangedListener(new NameWatcher());
        b.addcardStep1Cardnum.addTextChangedListener(new NumberWatcher());
        isEnable.put("name", false);
        isEnable.put("cardnum", false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addcard_nextstep:
                jumpToFillcardMsg();
                break;
            case R.id.step1_back:
            case R.id.step1_back2:
                onBackPressed();
                break;
            case R.id.addcard_step1_help:
                break;
        }
    }
    private void jumpToFillcardMsg(){
        String carnum=b.addcardStep1Cardnum.getText().toString();
        String cardCity= BankUtil.getNameOfBank(carnum);
        if("-1".equals(cardCity)){
            toast("请输入正确的卡号");
            return;
        }
        Intent intent = new Intent(this, FillCardMsgActivity.class);
        intent.putExtra("cardnum",carnum);
        intent.putExtra("cardcity",cardCity);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        int from=getIntent().getIntExtra("ids",-1);
        if(from==ChoiseCardActivity.FROM_CHOISCARD){
            finish();
        }else {
            Intent intent = new Intent(this, CardActivity.class);
            startActivity(intent);
        }

    }
   //判断是否都填写完毕 然后设置下一步按钮的背景
    private void judge() {
        if (isEnable.get("name") && isEnable.get("cardnum")) {
            b.addcardNextstep.setBackgroundResource(R.drawable.selector_addcard_nextstep);
            b.addcardNextstep.setEnabled(true);
        } else {
            b.addcardNextstep.setBackgroundResource(R.mipmap.addcard_next_moren);
            b.addcardNextstep.setEnabled(false);
        }

    }

    class NameWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String text = b.addcarStep1Name.getText().toString();
            if (null != text && !"".equals(text)) {
                isEnable.put("name", true);
            } else {
                isEnable.put("name", false);
            }
            judge();
        }
    }

    class NumberWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String text = b.addcardStep1Cardnum.getText().toString();
            if (null != text && !"".equals(text)) {
                isEnable.put("cardnum", true);
            } else {
                isEnable.put("cardnum", false);
            }
            judge();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        b=null;
        isEnable=null;
    }
}
