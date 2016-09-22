/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.Absentees;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.management.Absentees.AbsenteesList.AbsenteesList;

/**
 * Created by yeshwanth on 8/29/2016.
 */
public class AbsenteesAdapter extends RecyclerView.Adapter<AbsenteesAdapter.ViewHolder> {


    Context ctx;
    List<AbsenteesItem> absenteesItems;

    public AbsenteesAdapter(Context ctx, List<AbsenteesItem> absenteesItems) {
        this.ctx = ctx;
        this.absenteesItems = absenteesItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.row_absentees_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AbsenteesItem absenteesItem = absenteesItems.get(position);
        Log.d("test", "onBindViewHolder: " + absenteesItems);
        setText(holder.Absentees, absenteesItem.getAbsentees());
        setText(holder.Active, absenteesItem.getActive());
        setText(holder.Category, absenteesItem.getCategory());
        setText(holder.CategoryID, absenteesItem.getCategoryID());
        setText(holder.CurrentLevel, absenteesItem.getCurrentLevel());
        setText(holder.IsChildAvailable, absenteesItem.getIsChildAvailable());
        setText(holder.OnLeave, absenteesItem.getOnLeave());
        setText(holder.Present, absenteesItem.getPresent());
    }

    public void setText(TextView textView, String value) {
        if (textView != null && value != null) {
            textView.setText(value);
        } else {
            Log.d("test", "setText: isssu3e with ");
            Log.d("ddd", "getItemCount: " + getItemCount());
        }

    }

    @Override
    public int getItemCount() {

        return absenteesItems.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Absentees;
        public TextView Active;
        public TextView Category;
        public TextView CategoryID;
        public TextView CurrentLevel;
        public TextView IsChildAvailable;
        public TextView OnLeave;
        public TextView Present;


        public LinearLayout button;
        public LinearLayout button1;

        public ViewHolder(View itemView) {
            super(itemView);
            Absentees = (TextView) itemView.findViewById(R.id.absenteescount);
            Active = (TextView) itemView.findViewById(R.id.textBranch);
            Category = (TextView) itemView.findViewById(R.id.category);
            CategoryID = (TextView) itemView.findViewById(R.id.textcourse);
            CurrentLevel = (TextView) itemView.findViewById(R.id.textcourseid);
            IsChildAvailable = (TextView) itemView.findViewById(R.id.textevent);
            OnLeave = (TextView) itemView.findViewById(R.id.texteventtype);
            Present = (TextView) itemView.findViewById(R.id.presentcount);
            button = (LinearLayout) itemView.findViewById(R.id.present);


            button1 = (LinearLayout) itemView.findViewById(R.id.absent);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ctx, AbsenteesList.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ctx.startActivity(intent);

                }
            });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ctx, AbsenteesList.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ctx.startActivity(intent);
                }
            });
        }

    }


}