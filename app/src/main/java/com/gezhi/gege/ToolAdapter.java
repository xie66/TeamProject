package com.gezhi.gege;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ToolAdapter extends RecyclerView.Adapter<ToolAdapter.ViewHolder> {
    Context mContent;
    List<Smalltools> msmalltools;
//    List<Text> mtext;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView toolimage;
        TextView toolname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            cardView = (CardView) itemView;
            toolimage = (ImageView) itemView.findViewById(R.id.tool_image);
            toolname = (TextView) itemView.findViewById(R.id.tool_name);
        }
    }

    ToolAdapter(List<Smalltools> smalltoolsList) {
        msmalltools = smalltoolsList;
//        mtext = text;

    }

    //     ToolAdapter1(List<Text> text) {
////        msmalltools = smalltoolsList;
//        mtext = text;
//
//    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContent = parent.getContext();
        View view = LayoutInflater.from(mContent).inflate(R.layout.toolitem_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
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
