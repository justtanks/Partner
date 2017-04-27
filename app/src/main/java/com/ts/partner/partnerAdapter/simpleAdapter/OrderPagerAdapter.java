package com.ts.partner.partnerAdapter.simpleAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ts.partner.partnerFragment.AllOrdersFragment;

import java.util.ArrayList;

/**订单详情界面viewpager的adapter
 *
 */

public class OrderPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<AllOrdersFragment> fragmentsList;

    public OrderPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public OrderPagerAdapter(FragmentManager fm, ArrayList<AllOrdersFragment> fragments) {
        super(fm);
        this.fragmentsList = fragments;
    }


    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    @Override
    public Fragment getItem(int arg0) {
        if (arg0 > fragmentsList.size()) {
            fragmentsList.add(null);
        }
        return fragmentsList.get(arg0);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

}
