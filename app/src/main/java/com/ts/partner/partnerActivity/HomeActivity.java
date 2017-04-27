package com.ts.partner.partnerActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.Toast;

import com.ts.partner.R;
import com.ts.partner.partnerAdapter.OrderFragmentPagerAdapter;
import com.ts.partner.partnerBase.BaseActivity;

import com.ts.partner.partnerBase.impl.OnDatasChangeListener;

import com.ts.partner.partnerBean.netBean.LoginDataBean;

import com.ts.partner.partnerFragment.HomeFragmnent;
import com.ts.partner.partnerFragment.MineFragment;
import com.ts.partner.partnerFragment.TuiGuangFragment;
import com.ts.partner.partnerService.UpdateService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import java.util.List;

public class HomeActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    //记录登录时间
    private long currentTime;
    private BottomNavigationView tab;
    public static final String MAIN_KEY = "1";
    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    HomeFragmnent homeFragmnent = new HomeFragmnent();
    TuiGuangFragment tuiGuangFragment = new TuiGuangFragment();
    MineFragment mineFragment = new MineFragment();
    MenuItem prevMenuItem;
    //从loginactivity 获取的数据
    private LoginDataBean datas;
    // 记录回调对象
    private List<OnDatasChangeListener> lis = new ArrayList<>();
    //返回分享信息fragment的信息回调
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initData();
        EventBus.getDefault().register(this);
    }
    //获取到从登录界面传过来的值
    public LoginDataBean getDatas() {
        return datas;
    }

    private void initData() {
        datas = (LoginDataBean) getIntent().getSerializableExtra(LoginActivity.DATAS_KEY);
    }

    //初始化view 将fragment展示出来
    private void initView() {
        tab = (BottomNavigationView) this.findViewById(R.id.first_tab);
        viewPager = (ViewPager) this.findViewById(R.id.first_pager);
        initAdapter();
        tab.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //添加工具界面的点击事件
        currentTime = System.currentTimeMillis();
        getFresh();
    }

    private void initAdapter() {
        fragmentList.add(homeFragmnent);
        fragmentList.add(tuiGuangFragment);
        fragmentList.add(mineFragment);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new OrderFragmentPagerAdapter(getSupportFragmentManager(), fragmentList));//解决fragment嵌套问题
        viewPager.addOnPageChangeListener(this);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.action_qiangdan:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.action_me:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }

    };

    @Override
    public void onBackPressed() {
        long time = System.currentTimeMillis();
        if (time - currentTime > 3000) {
            Toast.makeText(this, R.string.home_backpress, Toast.LENGTH_SHORT).show();
            currentTime = time;
            return;
        }
        this.setResult(LoginActivity.HOMEBACKCODE);
        super.onBackPressed();
    }

    @Subscribe
    public void onEvent(LoginDataBean datas) {
        //提现之后刷新数据，直接重新设置数据
        this.datas = datas;
        for (OnDatasChangeListener li : lis) {
            if (li != null) {
                li.onDatasChange(datas);
            }
        }
    }

    @Subscribe
    public void onEvent(String datas) {
        if (datas.equals("guanbizhujiemian")) {
            this.finish();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    //显示是否具有新版本并进行更新
    private void getFresh() {
        if (getIntent().getIntExtra("isfresh", 0) == 1) {
            showUpdataDialog();
        }
    }

    //将所有的注册监听保存起来  有时间做出一个反射版本，保存方法
    public void setOndatasChangeListener(OnDatasChangeListener li) {
        lis.add(li);
    }

    //弹出对话框
    private void showUpdataDialog() {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("已经有新版本");
        builder.setMessage("是否进行更新？").
                setCancelable(false).setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent service = new Intent(HomeActivity.this, UpdateService.class);
                startService(service);
                dialog.cancel();
            }
        }).setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (prevMenuItem != null) {
            prevMenuItem.setChecked(false);
        } else {
            tab.getMenu().getItem(0).setChecked(false);
        }
        tab.getMenu().getItem(position).setChecked(true);
        prevMenuItem = tab.getMenu().getItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
