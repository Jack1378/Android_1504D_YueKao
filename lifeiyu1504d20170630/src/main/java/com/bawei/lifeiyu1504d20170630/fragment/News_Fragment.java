package com.bawei.lifeiyu1504d20170630.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bawei.lifeiyu1504d20170630.R;
import com.bawei.lifeiyu1504d20170630.adapter.FragmentAdapter;
import com.bawei.lifeiyu1504d20170630.bean.MyBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * name ：李飞宇
 * Date: 2017/6/30
 * desc:
 */

public class News_Fragment extends Fragment {
    private ListView list_view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grag_home_listview, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addHttp();
    }

    private void initView(View view) {
        list_view = (ListView) view.findViewById(R.id.list_view);
    }

    private void addHttp() {
        RequestParams params = new RequestParams();
//        String url = "http://lf.snssdk.com/neihan/service/tabs/?essence=1&iid=3216590132&device_id=32613520945&ac=wifi&channel=360&aid=7&app_name=joke_essay&version_code=612&version_name=6.1.2&device_platform=android&ssmix=a&device_type=sansung&device_brand=xiaomi&os_api=28&os_version=6.10.1&uuid=326135942187625&openudid=3dg6s95rhg2a3dg5&manifest_version_code=612&resolution=1450*2800&dpi=620&update_version_code=6120";

        String url = "http://api.expoon.com/AppNews/getNewsList/type/1/p/1";
        params.setUri(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            public void onSuccess(String result) {
                Gson gson = new Gson();
                MyBean myBean = gson.fromJson(result, MyBean.class);
                List<MyBean.DataBean> data = myBean.getData();
                FragmentAdapter fragmentAdapter = new FragmentAdapter(getActivity(), data);
                list_view.setAdapter(fragmentAdapter);
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


}
