package com.ts.partner.partnerActivity;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ts.partner.R;
import com.ts.partner.databinding.ActivityWaiterListBinding;
import com.ts.partner.partnerAdapter.OrderFragmentPagerAdapter;
import com.ts.partner.partnerAdapter.WaiterListPagerAdapter;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBean.netBean.WaitersBean;
import com.ts.partner.partnerFragment.AllOrdersFragment;
import com.ts.partner.partnerFragment.ChengDanFragment;
import com.ts.partner.partnerFragment.HaopingFragment;
import com.ts.partner.partnerFragment.ZhongHeFragment;

import java.util.ArrayList;
import java.util.List;

public class WaiterListActivity extends BaseActivity implements View.OnClickListener ,ViewPager.OnPageChangeListener
{
   ActivityWaiterListBinding b;
    private ArrayList<Fragment> fragmentList;
    private Fragment zongHefragment,  haoPingFragment, chengDanYesdayFragment;
    private List<Button> bts;
    WaitersBean datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b= DataBindingUtil.setContentView(this,R.layout.activity_waiter_list);
        init();
    }
    private void init(){
        b.waiterBack.setOnClickListener(this);
        bts = new ArrayList<>();
        bts.add(b.waitersTab1);
        bts.add(b.waitersTab2);
        bts.add(b.waitersTab3);
        b.waitersTab1.setOnClickListener(this);
        b.waitersTab2.setOnClickListener(this);
        b.waitersTab3.setOnClickListener(this);
        datas= (WaitersBean) getIntent().getSerializableExtra("waiters");
        initAdapter();
    }
    public WaitersBean getDatas(){
        return datas;
    }
    private void initAdapter() {
        fragmentList = new ArrayList<>();
        zongHefragment = new ZhongHeFragment();
        haoPingFragment = new HaopingFragment();
        chengDanYesdayFragment = new ChengDanFragment();
        fragmentList.add(zongHefragment);
        fragmentList.add(haoPingFragment);
        fragmentList.add(chengDanYesdayFragment);
        b.waitersViewpager.setCurrentItem(0);
        b.waitersViewpager.setOffscreenPageLimit(4);
        b.waitersViewpager.setAdapter(new WaiterListPagerAdapter(getSupportFragmentManager(), fragmentList));//解决fragment嵌套问题
        b.waitersViewpager.addOnPageChangeListener(this);
        setTextColor(0);
    }
    //设置文本颜色
    private void setTextColor(int currIndex) {
        for (Button ts : bts) {
            ts.setTextColor(getResources().getColor(R.color.gray3));
        }
        bts.get(currIndex).setTextColor(getResources().getColor(R.color.main_tixianbutton));

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.waiter_back:
                onBackPressed();
                break;
            case R.id.waiters_tab1:
                b.waitersViewpager.setCurrentItem(0);
                break;
            case R.id.waiters_tab2:
                b.waitersViewpager.setCurrentItem(1);
                break;
            case R.id.waiters_tab3:
                b.waitersViewpager.setCurrentItem(2);
                break;
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setTextColor(position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
