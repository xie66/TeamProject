package com.gezhi.gege;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gezhi.gege.map.MainMapActivity;
import com.gezhi.gege.news.MainNewsActivity;
import com.gezhi.gege.stepcount.StepcounterActivity;

import java.util.List;

public class ToolAdapter extends RecyclerView.Adapter<ToolAdapter.ViewHolder> {
    Context mContent;
    List<Smalltools> msmalltools;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView toolimage;
        TextView toolname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            toolimage = (ImageView) itemView.findViewById(R.id.tool_image);
            toolname = (TextView) itemView.findViewById(R.id.tool_name);
        }
    }

    ToolAdapter(List<Smalltools> smalltoolsList) {
        msmalltools = smalltoolsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContent = parent.getContext();
        View view = LayoutInflater.from(mContent).inflate(R.layout.toolitem_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.toolimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.toolname.getText().equals("新闻")) {
                    Intent intent = new Intent(mContent, MainNewsActivity.class);
                    mContent.startActivity(intent);
                    Log.d("news-TAG", "onClick: 新闻");
//                    Toast.makeText(mContent, "新闻", Toast.LENGTH_SHORT).show();
                } else if (holder.toolname.getText().equals("地图")) {
                    Intent intent = new Intent(mContent, MainMapActivity.class);
                    mContent.startActivity(intent);
                    Log.d("map-TAG", "onClick: 地图");
//                    Toast.makeText(mContent, "地图", Toast.LENGTH_SHORT).show();
                } else if (holder.toolname.getText().equals("计步器")) {
                    Intent intent = new Intent(mContent, StepcounterActivity.class);
                    mContent.startActivity(intent);
                    Log.d("map-TAG", "onClick: 计步器");
//                    Toast.makeText(mContent, "计步器", Toast.LENGTH_SHORT).show();
                } else if (holder.toolname.getText().equals("计算器")) {
                    Toast.makeText(mContent, "计算器", Toast.LENGTH_SHORT).show();
                } else if (holder.toolname.getText().equals("表白墙")) {
                    Toast.makeText(mContent, "表白墙", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Smalltools smalltools = msmalltools.get(position);
        holder.toolimage.setImageResource(smalltools.getImageId());
        holder.toolname.setText(smalltools.getName());
        Glide.with(mContent).load(smalltools.getImageId()).into(holder.toolimage);
    }

    @Override
    public int getItemCount() {
        return msmalltools.size();
    }
}
