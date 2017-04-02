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

import static com.ts.partner.R.id.waiterinfo_webparent;
//分享代理人名片的activity
public class ShareWaiterActivity extends BaseActivity implements View.OnClickListener {
    Button share;
    ImageButton back;
    LinearLayout webParent;
    WebView webView;
    ProgressBar bar;
    String waiterid;
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
        initWebview();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.waiterinfo_back:
                onBackPressed();
                break;
            case R.id.waiter_share:
                break;
        }
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
