/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.ExamResult;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.ExamResult.DataList;
import app.managementapp.college.com.collegemanagement.management.ExamResult.ExamResultListFragment.OnListFragmentInteractionListener;

public class ExamSearchListRecyclerViewAdapter extends RecyclerView.Adapter<ExamSearchListRecyclerViewAdapter.ViewHolder> {
    private final OnListFragmentInteractionListener mListener;
    protected List<app.managementapp.college.com.collegemanagement.api.ExamResult.DataList> mValues = Collections.emptyList();

    public ExamSearchListRecyclerViewAdapter(List<app.managementapp.college.com.collegemanagement.api.ExamResult.DataList> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_exam_result_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.FullName.setText(mValues.get(position).getFullName());
        holder.Code.setText(mValues.get(position).getCode());
        holder.Branch.setText(mValues.get(position).getBranch());
        holder.SGPA.setText(Integer.toString(mValues.get(position).getSGPA()));
        holder.Sem.setText(mValues.get(position).getSem());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        try {
            return mValues.size();
        } catch (NullPointerException e) {
            return 0;
        }

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView FullName;
        public final TextView Code;
        public TextView Branch;
        public TextView SGPA;
        public TextView Sem;

        public DataList mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            FullName = (TextView) view.findViewById(R.id.fullname);
            Code = (TextView) view.findViewById(R.id.code);
            Sem = (TextView) view.findViewById(R.id.sem);
            SGPA = (TextView) view.findViewById(R.id.sgpa);
            Branch = (TextView) view.findViewById(R.id.branch);
        }

        @Override
        public String toString() {
            return super.toString();// + " " + mContentView.getText() + "'";
        }
    }
}
