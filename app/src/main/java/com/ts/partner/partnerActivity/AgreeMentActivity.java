package com.ts.partner.partnerActivity;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.ts.partner.R;
import com.ts.partner.databinding.AgreementBinding;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBase.BaseData;
//合作协议的activity
public class AgreeMentActivity extends BaseActivity implements View.OnClickListener{
    AgreementBinding b;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_agree_ment);
        b= DataBindingUtil.setContentView(this,R.layout.activity_agree_ment);
        b.agreeReback.setOnClickListener(this);
        initWebview();
    }
    void  initWebview(){
        webView = new WebView(getApplication());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        webView.setLayoutParams(params);
        b.activityAgreeMent.addView(webView);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(false);
        webView.loadUrl(BaseData.XIEYI);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.agree_reback:
                onBackPressed();
                break;
        }
    }
    protected void onDestroy() {
        super.onDestroy();
        b.activityAgreeMent.removeView(webView);
        webView.stopLoading();
        webView.removeAllViews();
        webView.destroy();
        webView = null;
        b=null;
    }

}
