package com.bawei.lifeiyu1504d20170630.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.lifeiyu1504d20170630.R;
import com.bawei.lifeiyu1504d20170630.adapter.ViewPagerAdapter;
import com.bawei.lifeiyu1504d20170630.bean.HomeBean;
import com.bawei.lifeiyu1504d20170630.bean.MyBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * name ：李飞宇
 * Date: 2017/6/30
 * desc:
 */

public class Fragment_HomePage extends Fragment {
    private TabLayout tablayout;
    private ViewPager view_pager;
    private List<HomeBean.DataBean> Home_List = new ArrayList<>();
    private List<MyBean.DataBean> My_List = new ArrayList<>();
    private List<Fragment> Frag_List = new ArrayList<>();
    private HomeBean homeBean;
    private List<String> Str_List = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home_page, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addHttp();
    }

    private void addHttp() {
        RequestParams params = new RequestParams();
        String url = "http://lf.snssdk.com/neihan/service/tabs/?essence=1&iid=3216590132&device_id=32613520945&ac=wifi&channel=360&aid=7&app_name=joke_essay&version_code=612&version_name=6.1.2&device_platform=android&ssmix=a&device_type=sansung&device_brand=xiaomi&os_api=28&os_version=6.10.1&uuid=326135942187625&openudid=3dg6s95rhg2a3dg5&manifest_version_code=612&resolution=1450*2800&dpi=620&update_version_code=6120";
        params.setUri(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();

                HomeBean homeBean = gson.fromJson(result, HomeBean.class);
                List<HomeBean.DataBean> data = homeBean.getData();

                for (int i = 0; i < data.size(); i++) {
                    Home_List.addAll(data);
                    News_Fragment N_frag = new News_Fragment();
                    Frag_List.add(N_frag);
                }
                ViewPagerAdapter vpAdapter = new ViewPagerAdapter(getFragmentManager(), Home_List, Frag_List);
                view_pager.setAdapter(vpAdapter);
                tablayout.setupWithViewPager(view_pager);
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void initView(View view) {
        tablayout = (TabLayout) view.findViewById(R.id.tablayout);
        view_pager = (ViewPager) view.findViewById(R.id.view_pager);
    }
}
