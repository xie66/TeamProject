package com.gezhi.gege.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.gezhi.gege.MainActivity;
import com.gezhi.gege.R;


public class MainMapActivity extends AppCompatActivity implements View.OnClickListener {
    private AMap aMap;
    private MapView mapview;
    private TextView info;
    private FrameLayout b_1_1;
    private FrameLayout b_1_2;
    private FrameLayout b_1_3;
    private FrameLayout b_1_4;
    private TextView title;
    private TextView neirong;

    ImageView mapbackIv;

    //切换视图控件定义
    private TextView b_t_1;
    private TextView b_t_2;
    private TextView b_t_3;
    private TextView b_t_4;
    private TextView b_t_5;
    private LinearLayout blayout;

    private int types[] = new int[]{
            AMap.MAP_TYPE_NAVI,
            AMap.MAP_TYPE_NIGHT,
            AMap.MAP_TYPE_NORMAL,
            AMap.MAP_TYPE_SATELLITE
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapactivity_layout);

//        mMapview=(MapView)findViewById(R.id.mapview);//初始化控件
//        mMapview.onCreate(savedInstanceState);//此方法必须重写
//        if (aMap==null){
//            aMap=mMapview.getMap();//初始化地图控制器对象
        initView(savedInstanceState);
//        }
    }

    private void initView(Bundle save) {
        mapview = (MapView) findViewById(R.id.mapview);
        mapview.onCreate(save);
        if (aMap == null) {
            aMap = mapview.getMap();
        }
        info = (TextView) findViewById(R.id.info);
        b_1_1 = (FrameLayout) findViewById(R.id.b_1_1);
        b_1_2 = (FrameLayout) findViewById(R.id.b_1_2);
        b_1_2.setOnClickListener(this);
        b_1_3 = (FrameLayout) findViewById(R.id.b_1_3);
        b_1_3.setOnClickListener(this);
        b_1_4 = (FrameLayout) findViewById(R.id.b_1_4);


        mapbackIv = (ImageView) findViewById(R.id.map_back);
        mapbackIv.setOnClickListener(this);
        //切换视图的控件定义
        b_t_1 = (TextView) findViewById(R.id.b_t_1);
        b_t_1.setOnClickListener(this);
        b_t_2 = (TextView) findViewById(R.id.b_t_2);
        b_t_2.setOnClickListener(this);
        b_t_3 = (TextView) findViewById(R.id.b_t_3);
        b_t_3.setOnClickListener(this);
        b_t_4 = (TextView) findViewById(R.id.b_t_4);
        b_t_4.setOnClickListener(this);
        b_t_5 = (TextView) findViewById(R.id.b_t_5);
        b_t_5.setOnClickListener(this);
        blayout = (LinearLayout) findViewById(R.id.blayout);
        blayout.setOnClickListener(this);
        aMap.setInfoWindowAdapter(new AMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View view = View.inflate(MainMapActivity.this, R.layout.mapitem, null);
                title = (TextView) view.findViewById(R.id.biaoti);
                neirong = (TextView) view.findViewById(R.id.neirong);
                title.setText(marker.getTitle());
                neirong.setText(marker.getSnippet());
                return view;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.map_back:
                Intent intent = new Intent(MainMapActivity.this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.b_1_2:
                if (blayout.getVisibility() == View.GONE) {
                    blayout.setVisibility(View.VISIBLE);
                } else {
                    blayout.setVisibility(View.GONE);
                }
                break;
            case R.id.b_t_1:
                updataUi(0);
                info.setText("已经切换到导航视图");
                break;
            case R.id.b_t_2:
                updataUi(1);
                info.setText("已经切换到夜景视图");
                break;
            case R.id.b_t_3:
                updataUi(2);
                info.setText("已经切换到标准视图");
                break;
            case R.id.b_t_4:
                updataUi(3);
                info.setText("已经切换到卫星视图");
                break;
            case R.id.b_t_5:
                updataUi(4);
                info.setText("已经切换到交通视图");
                break;
            case R.id.b_1_3:
                if (aMap.getMapScreenMarkers().size() > 0) {
                    aMap.clear();
                    info.setText("小车地图信息");
                } else {
                    DrawMaker();
                    info.setText("1、2、3、4号小车地图标记已完成");
                }
        }
    }

    private void updataUi(int state) {
        if (state < 4) {
            aMap.setMapType(types[state]);
            aMap.setTrafficEnabled(false);
        } else {
            aMap.setTrafficEnabled(true);
        }
    }

    private void DrawMaker() {
        LatLng latLng1 = new LatLng(40.042737, 116.309884);
        aMap.addMarker(new MarkerOptions().position(latLng1).title("1号小车").snippet("联想大厦").icon(BitmapDescriptorFactory.fromResource(R.drawable.local1)));
        LatLng latLng2 = new LatLng(39.860512, 116.347593);
        aMap.addMarker(new MarkerOptions().position(latLng2).title("2号小车").snippet("西铁营桥").icon(BitmapDescriptorFactory.fromResource(R.drawable.local2)));
        LatLng latLng3 = new LatLng(39.802303, 116.209749);
        aMap.addMarker(new MarkerOptions().position(latLng3).title("3号小车").snippet("G107").icon(BitmapDescriptorFactory.fromResource(R.drawable.local3)));
        LatLng latLng4 = new LatLng(39.847603, 116.472871);
        aMap.addMarker(new MarkerOptions().position(latLng4).title("4号小车").snippet("G2路段").icon(BitmapDescriptorFactory.fromResource(R.drawable.local4)));
    }
}


