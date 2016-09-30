/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StudentExternalMarks.summary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import app.managementapp.college.com.collegemanagement.R;


public class CollegeRecyclerViewAdapter extends RecyclerView.Adapter<CollegeRecyclerViewAdapter.ViewHolder> {

    private final CollegeListFragment.OnListFragmentInteractionListener mListener;
    public List<app.managementapp.college.com.collegemanagement.api.StudentExternalExam.DataList> mValues = Collections.emptyList();

    public CollegeRecyclerViewAdapter(List<app.managementapp.college.com.collegemanagement.api.StudentExternalExam.DataList> items, CollegeListFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_int_ext_mark_summary_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).getCategoryName());
        holder.Pass.setText(Integer.toString(mValues.get(position).getPass()));
        holder.Fail.setText(Integer.toString(mValues.get(position).getFail()));

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
        } catch (Exception e) {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public TextView Pass;
        public TextView Fail;
        public app.managementapp.college.com.collegemanagement.api.StudentExternalExam.DataList mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
            Pass = (TextView) view.findViewById(R.id.pass);
            Fail = (TextView) view.findViewById(R.id.fail);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
