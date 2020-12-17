package com.gezhi.gege;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.gezhi.gege.news.MainNewsActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HomepageFragment extends Fragment implements View.OnClickListener {

    private static final int TAKE_PHOTO = 1;
    List<Smalltools> smalltoolsList = new ArrayList<>();

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    DrawerLayout drawerLayout;
    ToolAdapter toolAdapter;
    ImageView toolimage, phoneimage;


    @SuppressLint("ResourceAsColor")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//newsimage.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//        ComponentName comp = new ComponentName("com.gezhi.gege.HomepageFragment","com.gezhi.gege.news.MainNewsActivity");
//        Intent intent=new Intent();
//        intent.setComponent(comp);
//        intent.setAction("android.intent.action.VIEW");
//        startActivity(intent);
//    }
//});

        initTools();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepagefragment_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        toolimage = (ImageView) view.findViewById(R.id.home_image);
        toolimage.setOnClickListener(this);
        phoneimage = (ImageView) view.findViewById(R.id.phone_img);
        phoneimage.setOnClickListener(this);


        return view;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onStart() {
        super.onStart();
        GridLayoutManager layoutManager = new GridLayoutManager(this.getActivity(), 4);
        recyclerView.setLayoutManager(layoutManager);
        toolAdapter = new ToolAdapter(smalltoolsList);
        recyclerView.setAdapter(toolAdapter);
    }

    private void initTools() {
        Smalltools smalltools1 = new Smalltools("新闻", R.drawable.news_icon, 1);
        Smalltools smalltools2 = new Smalltools("阅读", R.drawable.readlogo, 2);
        Smalltools smalltools3 = new Smalltools("计算器", R.drawable.calc_icon, 3);
        Smalltools smalltools4 = new Smalltools("闹钟", R.drawable.clock_icon, 4);
        Smalltools smalltools5 = new Smalltools("计步器", R.drawable.jbq, 5);
        Smalltools smalltools6 = new Smalltools("表白墙", R.drawable.bp_icon, 6);
        Smalltools smalltools7 = new Smalltools("表白墙", R.drawable.bp_icon, 6);
        Smalltools smalltools8 = new Smalltools("表白墙", R.drawable.bp_icon, 6);
        Smalltools smalltools9 = new Smalltools("表白墙", R.drawable.bp_icon, 6);
        Smalltools smalltools10 = new Smalltools("表白墙", R.drawable.bp_icon, 6);
        Smalltools smalltools11 = new Smalltools("表白墙", R.drawable.bp_icon, 6);
        Smalltools smalltools12 = new Smalltools("表白墙", R.drawable.bp_icon, 6);
        Smalltools smalltools13 = new Smalltools("表白墙", R.drawable.bp_icon, 6);
        Smalltools smalltools14 = new Smalltools("表白墙", R.drawable.bp_icon, 6);

        smalltoolsList.add(smalltools1);
        smalltoolsList.add(smalltools2);
        smalltoolsList.add(smalltools3);
        smalltoolsList.add(smalltools4);
        smalltoolsList.add(smalltools5);
        smalltoolsList.add(smalltools6);
        smalltoolsList.add(smalltools7);
        smalltoolsList.add(smalltools8);
        smalltoolsList.add(smalltools9);
        smalltoolsList.add(smalltools10);
        smalltoolsList.add(smalltools11);
        smalltoolsList.add(smalltools12);
        smalltoolsList.add(smalltools13);
        smalltoolsList.add(smalltools14);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.phone_img:
                Intent intent1 = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent1, TAKE_PHOTO);
                break;
            case R.id.home_image:
                Intent intent = new Intent(getActivity(), MainNewsActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
