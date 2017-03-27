package com.ts.partner.partnerActivity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ts.partner.R;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBase.BaseData;
import com.ts.partner.partnerBase.impl.OnDatasChangeListener;
import com.ts.partner.partnerBase.impl.OnShareMsgChangeListener;
import com.ts.partner.partnerBean.netBean.LoginBean;
import com.ts.partner.partnerBean.netBean.ShareMesBean;
import com.ts.partner.partnerFragment.HomeFragmnent;
import com.ts.partner.partnerFragment.MineFragment;
import com.ts.partner.partnerFragment.TuiGuangFragment;
import com.ts.partner.partnerUtils.NetUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeActivity extends BaseActivity {
    //记录登录时间
    private long currentTime;

    private static FragmentTabHost mTabHost;
    public static final String MAIN_KEY = "1";
    private Class mFragmentArray[] = {HomeFragmnent.class, TuiGuangFragment.class, MineFragment.class
    };
    private int mImageArray[] = {R.drawable.tab_partner, R.drawable.tab_tuiguang, R.drawable.tab_mine};
    private String textArray[] = {"合伙人", "我要推广", "我的"};
    private LayoutInflater mInflater;
    //从loginactivity 获取的数据
    private LoginBean datas;
    // 记录回调对象
    private List<OnDatasChangeListener> lis = new ArrayList<>();
    //返回分享信息fragment的信息回调
    private OnShareMsgChangeListener shareListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initData();
        EventBus.getDefault().register(this);
        getShareMsg();
    }

    //获取到从登录界面传过来的值
    public LoginBean getDatas() {
        return datas;
    }

    private void initData() {
        datas = (LoginBean) getIntent().getSerializableExtra(LoginActivity.DATAS_KEY);
    }

    //将所有的注册监听保存起来  有时间做出一个反射版本，保存方法
    public void setOndatasChangeListener(OnDatasChangeListener li) {

        lis.add(li);
    }

    //设置分享信息的回调，如果分享信息还有其他的界面，将其扩展为list
    public void setOnShareMsgChangeListenr(OnShareMsgChangeListener listenr) {
        this.shareListner = listenr;
    }

    //初始化view 将fragment展示出来
    private void initView() {

        mTabHost = (FragmentTabHost) findViewById(R.id.home_tab);
        mInflater = LayoutInflater.from(this);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.home_content);
        mTabHost.getTabWidget().setDividerDrawable(R.color.write);//去掉tabhost的分割线
        int count = mFragmentArray.length;
        for (int i = 0; i < count; i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(textArray[i]).setIndicator(getTabItemView(i));
            mTabHost.addTab(tabSpec, mFragmentArray[i], null);
        }
        updateTab(mTabHost);
        mTabHost.setOnTabChangedListener(tabChangeListener);
        //添加工具界面的点击事件
        currentTime = System.currentTimeMillis();
    }

    private TabHost.OnTabChangeListener tabChangeListener = new TabHost.OnTabChangeListener() {
        @Override
        public void onTabChanged(String s) {
            updateTab(mTabHost);
        }
    };

    //          更新tab键文字
    private void updateTab(FragmentTabHost mTabHost) {
        for (int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++) {
            View view = mTabHost.getTabWidget().getChildAt(i);
            TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(R.id.textview);
            if (mTabHost.getCurrentTab() == i) {//选中
                tv.setTextColor(this.getResources().getColorStateList(
                        R.color.yellow_ffdcoo));

            } else {//不选中
                tv.setTextColor(this.getResources().getColorStateList(
                        R.color.gray3));
            }
        }
    }

    //      为tab键设置图片和文字
    private View getTabItemView(int index) {
        View view = mInflater.inflate(R.layout.tab_item_view, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview_1);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        imageView.setImageResource(mImageArray[index]);
        textView.setText(textArray[index]);
        return view;
    }

    @Override
    public void onBackPressed() {
        long time = System.currentTimeMillis();
        if (time - currentTime > 3000) {
            Toast.makeText(this, R.string.home_backpress, Toast.LENGTH_SHORT).show();
            currentTime = time;
            return;
        }
        super.onBackPressed();
    }

    @Subscribe
    public void onEvent(LoginBean datas) {
        //提现之后刷新数据，直接重新设置数据
        this.datas = datas;
        for (OnDatasChangeListener li : lis) {
            if(li!=null){
                li.onDatasChange(datas);
            }
        }
    }

    public ShareMesBean getShareDatas() {
        return sharebean;
    }

    //从服务器获取到分享的信息，然后传递到分享fragment
    ShareMesBean sharebean = new ShareMesBean();
    Gson gson = new Gson();
  //刷新数据
    public void getShareMsg() {
        NetUtils.Get(BaseData.FENXIANG, new HashMap<String, String>(), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (result != null && !result.substring(0, 19).contains("Error")) {
                    sharebean = gson.fromJson(result, ShareMesBean.class);
                    if (shareListner != null) {
                        shareListner.onMsgChange(sharebean);
                    }
                } else {
                    toast(getString(R.string.net_error));
                    shareListner.onMsgChange(null);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                shareListner.onMsgChange(null);
            }

            @Override
            public void onCancelled(CancelledException cex) {
                shareListner.onMsgChange(null);
            }

            @Override
            public void onFinished() {

            }
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        //当activity退出栈后，activity对象会被回收，其中所含有的东西也会被回收
        gson=null;
        mTabHost=null;
        mFragmentArray=null;
        mImageArray=null;
        mInflater=null;
        sharebean=null;
        shareListner=null;
        lis=null;
    }
}
