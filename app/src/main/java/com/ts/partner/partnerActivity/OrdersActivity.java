package com.ts.partner.partnerActivity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.ts.partner.R;
import com.ts.partner.databinding.OrderBinding;
import com.ts.partner.partnerAdapter.OrderFragmentPagerAdapter;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerFragment.AllOrdersFragment;
import com.ts.partner.partnerFragment.BeforeYestodayOrdersFragment;
import com.ts.partner.partnerFragment.TodayOrdersFragment;
import com.ts.partner.partnerFragment.YestodayOrdersFragment;

import java.util.ArrayList;
import java.util.List;
/*
展示所有订单的activity
 */
public class OrdersActivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    OrderBinding b;
    private Animation animation;
    private int currIndex = 0;
    private int bottomLineWidth;
    private int offset = 0;
    private int position_one;
    private int position_two;
    private int position_three;
    private ArrayList<Fragment> fragmentList;
    private Fragment allFormfragment, todayFragment, yesdayFragment, beforYesdayFragment;
    private List<TextView> textViews;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_orders);
        b = DataBindingUtil.setContentView(this, R.layout.activity_orders);
//        LoginBean bean = (LoginBean) getIntent().getSerializableExtra(LoginActivity.DATAS_KEY);
//        OrdersFactory factory = new OrdersFactory(bean);
//        List<LoginBean.DataBean.PartnerYesterdayOrderBean> datas = (List<LoginBean.DataBean.PartnerYesterdayOrderBean>) factory.getOrders(2);
//        toast(datas.get(0).getBelong_city());
        init();
    }

    private void init() {
        textViews = new ArrayList<>();
        textViews.add(b.myformTab1);
        textViews.add(b.myformTab2);
        textViews.add(b.myformTab3);
        textViews.add(b.myformTab4);
        b.ordersBack.setOnClickListener(this);
        b.ordersFenlei.setOnClickListener(this);
        b.myformTab1.setOnClickListener(new MyOnClickListener(0));
        b.myformTab2.setOnClickListener(new MyOnClickListener(1));
        b.myformTab3.setOnClickListener(new MyOnClickListener(2));
        b.myformTab4.setOnClickListener(new MyOnClickListener(3));

        initAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initWidth();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.orders_back:
                onBackPressed();
                break;
            case R.id.orders_fenlei:
                //判断是否下拉，然后做view的隐藏显示

                break;

        }

    }

    private void initWidth() {
        bottomLineWidth = b.orderColorline.getLayoutParams().width;
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        offset = 0+30;
        position_one = (int) (screenW / 4.0);
        position_two = position_one * 2;
        position_three = position_one * 3;
    }

    private void initAdapter() {
        fragmentList = new ArrayList<>();
        allFormfragment = new AllOrdersFragment();
        todayFragment = new TodayOrdersFragment();
        yesdayFragment = new YestodayOrdersFragment();
        beforYesdayFragment = new BeforeYestodayOrdersFragment();

        fragmentList.add(todayFragment);
        fragmentList.add(yesdayFragment);
        fragmentList.add(beforYesdayFragment);
        fragmentList.add(allFormfragment);
        b.orderViewpager.setCurrentItem(0);
        setTextColor(0);
        b.orderViewpager.setOffscreenPageLimit(4);
        b.orderViewpager.setAdapter(new OrderFragmentPagerAdapter(getSupportFragmentManager(), fragmentList));//解决fragment嵌套问题
        b.orderViewpager.addOnPageChangeListener(this);
    }

    private void setTextColor(int currIndex) {
        for (TextView ts : textViews) {
            ts.setTextColor(getResources().getColor(R.color.gray3));
        }
        textViews.get(currIndex).setTextColor(getResources().getColor(R.color.main_tixianbutton));

    }

    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            b.orderViewpager.setCurrentItem(index);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setTextColor(position);
        switch (position) {
            case 0:

                if (currIndex == 1) {
                    animation = new TranslateAnimation(position_one, 0, 0, 0);
                } else if (currIndex == 2) {
                    animation = new TranslateAnimation(position_two, 0, 0, 0);
                } else if (currIndex == 3) {
                    animation = new TranslateAnimation(position_three, 0, 0, 0);
                } else if (currIndex == 4) {
//                    animation = new TranslateAnimation(position_four, 0, 0, 0);
                }
                break;
            case 1:
                if (currIndex == 0) {
                    animation = new TranslateAnimation(offset, position_one, 0, 0);
                } else if (currIndex == 2) {
                    animation = new TranslateAnimation(position_two, position_one, 0, 0);
                } else if (currIndex == 3) {
                    animation = new TranslateAnimation(position_three, position_one, 0, 0);
                } else if (currIndex == 4) {
//                    animation = new TranslateAnimation(position_four, position_one, 0, 0);
                }
                break;
            case 2:
                if (currIndex == 0) {
                    animation = new TranslateAnimation(offset, position_two, 0, 0);
                } else if (currIndex == 1) {
                    animation = new TranslateAnimation(position_one, position_two, 0, 0);
                } else if (currIndex == 3) {
                    animation = new TranslateAnimation(position_three, position_two, 0, 0);
                } else if (currIndex == 4) {
//                    animation = new TranslateAnimation(position_four, position_two, 0, 0);
                }
                break;
            case 3:
                if (currIndex == 0) {
                    animation = new TranslateAnimation(offset, position_three, 0, 0);
                } else if (currIndex == 1) {
                    animation = new TranslateAnimation(position_one, position_three, 0, 0);
                } else if (currIndex == 2) {
                    animation = new TranslateAnimation(position_two, position_three, 0, 0);
                } else if (currIndex == 4) {
//                    animation = new TranslateAnimation(position_four, position_three, 0, 0);
                }
                break;

        }
        currIndex = position;
        animation.setFillAfter(true);
        animation.setDuration(100);
        b.orderColorline.startAnimation(animation);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        animation=null;
        fragmentList=null;
        textViews=null;
        b=null;
    }
}
