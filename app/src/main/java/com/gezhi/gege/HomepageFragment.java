package com.gezhi.gege;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gezhi.gege.news.MainNewsActivity;

import java.util.ArrayList;
import java.util.List;

public class HomepageFragment extends Fragment implements View.OnClickListener {

    List<Smalltools> smalltoolsList = new ArrayList<>();

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    DrawerLayout drawerLayout;
    ToolAdapter toolAdapter;
    ImageView toolimage;

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
//        newsimage.setOnClickListener(this);
//        ToolAdapter toolAdapter = new ToolAdapter(smalltoolsList);
//        layoutManager = new LinearLayoutManager(this.getActivity());
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(layoutManager);
//        ToolAdapter toolAdapter1 = new ToolAdapter(textList);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        GridLayoutManager layoutManager = new GridLayoutManager(this.getActivity(), 4);
        recyclerView.setLayoutManager(layoutManager);
        toolAdapter = new ToolAdapter(smalltoolsList);
        recyclerView.setAdapter(toolAdapter);
    }

    private void initTools() {
        Smalltools smalltools1 = new Smalltools("新闻", R.drawable.news_icon,1);
        Smalltools smalltools2 = new Smalltools("阅读", R.drawable.readlogo,2);
        Smalltools smalltools3 = new Smalltools("计算器", R.drawable.calc_icon,3);
        Smalltools smalltools4 = new Smalltools("闹钟", R.drawable.clock_icon,4);
        Smalltools smalltools5 = new Smalltools("计步器", R.drawable.jbq,5);
        Smalltools smalltools6 = new Smalltools("表白墙", R.drawable.bp_icon,6);
        // Smalltools smalltools = {smalltools1, smalltools2, smalltools3, smalltools4};
//        smalltoolsList.clear();

//        Random random = new Random();
//        int index = random.nextInt(smalltools.length);
        smalltoolsList.add(smalltools1);
        smalltoolsList.add(smalltools2);
        smalltoolsList.add(smalltools3);
        smalltoolsList.add(smalltools4);
        smalltoolsList.add(smalltools5);
        smalltoolsList.add(smalltools6);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_image:
                Intent intent = new Intent(getActivity(), MainNewsActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
