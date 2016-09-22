/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.Absentees.AbsenteesList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.managementapp.college.com.collegemanagement.R;

/**
 * Created by Sanjay on 9/21/2016.
 * total
 */

public class AbsenteesListAdapter extends RecyclerView.Adapter<AbsenteesListAdapter.ViewHolder> {


    Context ctx;
    List<AbsenteesListItem> absenteesListItems;

    public AbsenteesListAdapter(Context ctx, List<AbsenteesListItem> absenteesListItems) {
        this.ctx = ctx;
        this.absenteesListItems = absenteesListItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.row_absenteeslist_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AbsenteesListItem absenteesListItem = absenteesListItems.get(position);

        Log.d("test", "onBindViewHolder: " + absenteesListItems);
        setText(holder.Code, absenteesListItem.getCode());
        setText(holder.GUID, absenteesListItem.getGUID());
        setText(holder.InTime, absenteesListItem.getInTime());
        setText(holder.Name, absenteesListItem.getName());
        setText(holder.OutTime, absenteesListItem.getOutTime());
    }

    public void setText(TextView textView, String value) {
        if (textView != null && value != null) {
            textView.setText(value);
        } else {
            Log.d("ddd", "getItemCount: " + getItemCount());
        }

    }

    @Override
    public int getItemCount() {

        return absenteesListItems.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Code;
        public TextView GUID;
        public TextView InTime;
        public TextView Name;
        public TextView OutTime;

        public ViewHolder(View itemView) {
            super(itemView);
            Code = (TextView) itemView.findViewById(R.id.code);
            GUID = (TextView) itemView.findViewById(R.id.textBranch);
            InTime = (TextView) itemView.findViewById(R.id.intime);
            Name = (TextView) itemView.findViewById(R.id.name);
            OutTime = (TextView) itemView.findViewById(R.id.outtime);
        }

    }


}
