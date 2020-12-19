package com.gezhi.gege;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<Smalltools> smalltoolsList = new ArrayList<>();
    //1定义java对象
    ViewPager viewPager;
    RadioButton radioButtonone, radioButtontwo, radioButtonthree, radioButtonfour;
    RadioGroup radiogroup;

//    RecyclerView recyclerView;
//    LinearLayoutManager layoutManager;
//    DrawerLayout drawerLayout;
//    ToolAdapter toolAdapter;
    //创建4张卡片对应的对象
    Fragment homepagefragment, friendfragment, messagefragment, myfragment;

    //创建卡片数组
    private  List<Fragment> fragmentList = new ArrayList<>();

    //默认显示第一张卡片
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        绑定控件
        initView();
        //创建初始化数据方法
        initData();
        //处理滑屏事件
        initMove();
        //单击事件
        initOnclick();

    }

    private void initOnclick() {
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_one:
                        position = 0;
                        viewPager.setCurrentItem(position);
                        break;
                    case R.id.radio_two:
                        position = 1;
                        viewPager.setCurrentItem(position);
                        break;
                    case R.id.radio_three:
                        position = 2;
                        viewPager.setCurrentItem(position);
                        break;
                    case R.id.radio_four:
                        position = 3;
                        viewPager.setCurrentItem(position);
                        break;
                    default:
                        position = 0;
                        viewPager.setCurrentItem(position);
                        break;
                }
            }
        });
    }

    private void initMove() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((RadioButton) radiogroup.getChildAt(position)).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        radioButtonone = (RadioButton) findViewById(R.id.radio_one);
        radioButtontwo = (RadioButton) findViewById(R.id.radio_two);
        radioButtonthree = (RadioButton) findViewById(R.id.radio_three);
        radioButtonfour = (RadioButton) findViewById(R.id.radio_four);
        radiogroup = (RadioGroup) findViewById(R.id.radio_group);
    }

    private void initData() {
        //创建相应的卡片对象
        homepagefragment = new HomepageFragment();
        friendfragment = new FriendFragment();
        messagefragment = new MessageFragment();
        myfragment = new MyFragment();

        //将4个卡片对象放入到数组内
        fragmentList.add(homepagefragment);
        fragmentList.add(friendfragment);
        fragmentList.add(messagefragment);
        fragmentList.add(myfragment);

        //创建适配器对象
        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager(), fragmentList);
        //给ViewPager滑屏设置适配器
        viewPager.setAdapter(adapter);

        //默认显示第一张卡片
        ((RadioButton) radiogroup.getChildAt(position)).setChecked(true);

    }


}