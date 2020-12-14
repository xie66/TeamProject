package com.gezhi.gege;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MyFragmentAdapter extends FragmentPagerAdapter {


    //定义一个卡片数组
    private List<Fragment> fragmentList2;

    public MyFragmentAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList2) {
        super(fm);
        this.fragmentList2 = fragmentList2;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList2.get(position);  //返回positio位置上的卡片
    }

    @Override
    public int getCount() {
        return fragmentList2.size();  //返回卡片数组中的卡片数量
    }
}
