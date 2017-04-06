package com.ts.partner.partnerActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.ts.partner.R;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBase.BaseData;

import cn.sharesdk.onekeyshare.OnekeyShare;

import static com.ts.partner.R.id.waiterinfo_webparent;
//分享代理人名片的activity
public class ShareWaiterActivity extends BaseActivity implements View.OnClickListener {
    Button share;
    ImageButton back;
    LinearLayout webParent;
    WebView webView;
    ProgressBar bar;
    String waiterid;
    String waiterPic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_waiter);
        init();
    }
    private  void init(){
        back= (ImageButton) this.findViewById(R.id.waiterinfo_back);
        share= (Button) findViewById(R.id.waiter_share);
        webParent= (LinearLayout) findViewById(waiterinfo_webparent);
        bar= (ProgressBar) findViewById(R.id.waiter_progressbar);
        back.setOnClickListener(this);
        share.setOnClickListener(this);
        waiterid=BaseData.DAILIRENFENXIANG+getIntent().getStringExtra("waiterid");
        waiterPic=BaseData.BASEPOSITON+getIntent().getStringExtra("waiterpic");
        initWebview();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.waiterinfo_back:
                onBackPressed();
                break;
            case R.id.waiter_share:
                shareWaiterMes();
                break;
        }
    }
 //点击按钮后分享关于代理人的链接
    private void shareWaiterMes() {
        OnekeyShare oks = new OnekeyShare();
        //分享到微博 微信也是这个
        oks.setImageUrl(waiterPic);  //这个image必须是
        oks.setText("企成成代理人助力企业发展");
        oks.setTitle("企成成商标注册");   //微信信息展示
//        oks.setTitleUrl();
        oks.setSite("企成成合伙人");
        oks.setSiteUrl(BaseData.BASEURL);//这个设置最好是域名的
        //分享到微信
        oks.setUrl(waiterid);
        oks.setComment("商标注册");
        oks.show(this);
    }


    void initWebview() {
        webView = new WebView(getApplication());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        webView.setLayoutParams(params);
       webParent.addView(webView);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.loadUrl(waiterid);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    // 网页加载完成
                  bar.setVisibility(View.GONE);
                } else {
                    // 加载中
                    bar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }

}
