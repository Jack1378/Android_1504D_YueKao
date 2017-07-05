package com.bawei.lifeiyu1504d20170630.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bawei.lifeiyu1504d20170630.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * name ：李飞宇
 * Date: 2017/6/30
 * desc:ViewPager的适配器
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<HomeBean.DataBean> Home_List = new ArrayList<>();
    private List<Fragment> Frag_List = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm, List<HomeBean.DataBean> Home_List, List<Fragment> Frag_List) {
        super(fm);
        this.Home_List = Home_List;
        this.Frag_List = Frag_List;
    }

    @Override
    public Fragment getItem(int position) {
        return Frag_List.get(position);
    }

    @Override
    public int getCount() {
        return Frag_List.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Home_List.get(position).getName();
    }
}
