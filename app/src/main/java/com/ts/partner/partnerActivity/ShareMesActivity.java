package com.ts.partner.partnerActivity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.ts.partner.R;
import com.ts.partner.databinding.ShareMsgBinding;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBase.BaseData;
import com.ts.partner.partnerBean.netBean.ShareMesBean;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class ShareMesActivity extends BaseActivity implements View.OnClickListener {
    ShareMsgBinding b;
    WebView webView;
    ShareMesBean.MsgBean datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    void init() {
        b = DataBindingUtil.setContentView(this, R.layout.activity_share_mes);
        b.shareReback.setOnClickListener(this);
        b.shareSharebt.setOnClickListener(this);
        datas = (ShareMesBean.MsgBean) getIntent().getSerializableExtra("sharedata");
        initWebview();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.share_reback:
                onBackPressed();
                break;
            case R.id.share_sharebt:
                share();
                break;
        }
    }

    void initWebview() {
        webView = new WebView(getApplication());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        webView.setLayoutParams(params);
        b.activityShareMsg.addView(webView);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.loadUrl(datas.getSpread_href());
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    // 网页加载完成
                     b.shareProgress.setVisibility(View.GONE);
                } else {
                    // 加载中
                b.shareProgress.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }

    //分享の微信 qq 以及微博
    void share() {
        OnekeyShare oks = new OnekeyShare();
        //分享到微博 微信也是这个
        oks.setImageUrl(datas.getSpread_pic());  //这个image 用户头像url
        oks.setText(datas.getSpread_title());
        //分享到qq
        oks.setTitle(datas.getSpread_title());
        oks.setTitleUrl(datas.getSpread_href());
        oks.setSite("企成成合伙人");
        oks.setSiteUrl(BaseData.BASEURL);//这个设置最好是域名的
        //分享到微信
        oks.setUrl(datas.getSpread_href());
        oks.setComment("");
        oks.show(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        b.activityShareMsg.removeView(webView);
        webView.stopLoading();
        webView.removeAllViews();
        webView.destroy();
        webView = null;
        datas=null;
        b=null;
    }
}
