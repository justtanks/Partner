package com.ts.partner.partnerActivity;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.ts.partner.R;
import com.ts.partner.databinding.OrderBinding;
import com.ts.partner.partnerAdapter.OrderFragmentPagerAdapter;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBean.netBean.OrdersBean;
import com.ts.partner.partnerFragment.AllOrdersFragment;
import java.util.ArrayList;
import java.util.List;

/*
展示所有订单的activity
 */
public class OrdersActivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    OrderBinding b;
    private ArrayList<AllOrdersFragment> fragmentList;
    private List<TextView> textViews;
    private  List<Button> buttons;
    OrdersBean orders;
    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_orders);
        init();
    }
    private void init() {
        orders = (OrdersBean)getIntent().getSerializableExtra(LoginActivity.DATAS_KEY);
        b.ordersBack.setOnClickListener(this);
        b.ordersFenlei.setOnClickListener(this);
        initButton();
        initAdapter();
    }

    //动态添加新的按钮
    private void initButton(){
        textViews = new ArrayList<>();
        buttons=new ArrayList<>();
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT
                , ViewGroup.LayoutParams.MATCH_PARENT);
        for(OrdersBean.DataBean data:orders.getData()){
            Button button = new Button(getApplicationContext());
            ImageView image=new ImageView(getApplicationContext());
            button.setLayoutParams(params);
            button.setText(data.getCity_name());
            button.setGravity(Gravity.CENTER);
            button.setTextSize(12);
            button.setTextColor(getResources().getColor(R.color.gray3));
            button.setBackgroundColor(getResources().getColor(R.color.write));
            buttons.add(button);
            image.setLayoutParams(params);
            image.setImageDrawable(new BitmapDrawable());
            b.myformTabLayout.addView(button);
            b.myformTabLayout.addView(image);
        }
        for(int i=0;i<buttons.size();i++){
            final int finalI = i;
            buttons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    b.orderViewpager.setCurrentItem(finalI);
                    setTextColor(finalI);
                }
            });
        }
        setTextColor(0);
    }


    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable,10);
    }

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            changeData();
        }
    };
    //传递fragment数据
    private void changeData(){
        for(int i=0;i<fragmentList.size();i++){
            if(fragmentList.get(i)!=null){
                fragmentList.get(i).onOrderchange(orders.getData().get(i));
            }
        }
    }
    private void initAdapter() {
        fragmentList = new ArrayList<>();
         for(OrdersBean.DataBean data:orders.getData()){
             fragmentList.add(new AllOrdersFragment());
         }
        b.orderViewpager.setCurrentItem(0);
        b.orderViewpager.setOffscreenPageLimit(4);
        b.orderViewpager.setAdapter(new OrderFragmentPagerAdapter(getSupportFragmentManager(), fragmentList));
        b.orderViewpager.addOnPageChangeListener(this);
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
    private void setTextColor(int currIndex) {
        for (Button ts : buttons) {
            ts.setTextColor(getResources().getColor(R.color.gray3));
        }
        buttons.get(currIndex).setTextColor(getResources().getColor(R.color.main_tixianbutton));
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fragmentList = null;
        textViews = null;
        b = null;
    }
}
