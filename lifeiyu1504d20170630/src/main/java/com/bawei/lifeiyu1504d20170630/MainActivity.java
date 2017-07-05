package com.bawei.lifeiyu1504d20170630;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bawei.lifeiyu1504d20170630.fragment.Fragment_Discover;
import com.bawei.lifeiyu1504d20170630.fragment.Fragment_Duan_Youxiu;
import com.bawei.lifeiyu1504d20170630.fragment.Fragment_HomePage;
import com.bawei.lifeiyu1504d20170630.fragment.Fragment_My;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fragment;
    private RadioGroup radio;
    private FragmentTransaction transaction;
    private Fragment_HomePage homePage;
    private Fragment_Duan_Youxiu duan_youxiu;
    private Fragment_Discover discover;
    private Fragment_My my;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addFragment();
        RadioButionClick();
    }

    //RadioButton的点击事件
    private void RadioButionClick() {
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.RB_Home_Page:
                        Log.e("-------->","frag_home_page");
                        FragmentManager home_page = getSupportFragmentManager();
                        FragmentTransaction tran1 = home_page.beginTransaction();
                        tran1.replace(R.id.fragment, homePage);
                        tran1.commit();

                        break;
                    case R.id.RB_DuanYouXi:
                        Log.e("-------->","frag_duanyouxiu");
                        FragmentManager duanyouxiu = getSupportFragmentManager();
                        FragmentTransaction tran2 = duanyouxiu.beginTransaction();
                        tran2.add(R.id.fragment, duan_youxiu);
                        tran2.commit();

                        break;
                    case R.id.RB_Discover:
                        Log.e("-------->","frag_discover");
                        FragmentManager discover_first = getSupportFragmentManager();
                        FragmentTransaction tran3 = discover_first.beginTransaction();
                        tran3.add(R.id.fragment, discover);
                        tran3.commit();

                        break;
                    case R.id.RB_My:
                        Log.e("-------->","frag_my");
                        FragmentManager my_first = getSupportFragmentManager();
                        FragmentTransaction tran4 = my_first.beginTransaction();
                        tran4.add(R.id.fragment, my);
                        tran4.commit();
                        break;
                }
            }
        });
    }

    private void addFragment() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        homePage = new Fragment_HomePage();
        duan_youxiu = new Fragment_Duan_Youxiu();
        discover = new Fragment_Discover();
        my = new Fragment_My();
        transaction.add(R.id.fragment, homePage);
        transaction.commit();
    }

    private void initView() {
        fragment = (FrameLayout) findViewById(R.id.fragment);
        radio = (RadioGroup) findViewById(R.id.radio_group);
    }
}
