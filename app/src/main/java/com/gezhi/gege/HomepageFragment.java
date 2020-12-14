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

import java.util.ArrayList;
import java.util.List;

public class HomepageFragment extends Fragment {

    List<Smalltools> smalltoolsList = new ArrayList<>();

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    DrawerLayout drawerLayout;
    ToolAdapter toolAdapter;
    ImageView newsimage;

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
        newsimage = (ImageView) view.findViewById(R.id.tool_image);
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
//        Text text = new Text("快乐屋");
//        Smalltools apple = new Smalltools("陕西红富士", R.drawable.home_cc
//        );
//        smalltoolsList.add(apple);

        Smalltools smalltools1 = new Smalltools("新闻", R.drawable.apple);
        Smalltools smalltools2 = new Smalltools("阅读", R.drawable.home_cc);
        Smalltools smalltools3 = new Smalltools("新闻", R.drawable.apple);
        Smalltools smalltools4 = new Smalltools("阅读", R.drawable.home_cc);
        // Smalltools smalltools = {smalltools1, smalltools2, smalltools3, smalltools4};
//        smalltoolsList.clear();

//        Random random = new Random();
//        int index = random.nextInt(smalltools.length);

        smalltoolsList.add(smalltools1);
        smalltoolsList.add(smalltools2);
        smalltoolsList.add(smalltools3);
        smalltoolsList.add(smalltools4);
    }



}
