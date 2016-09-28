/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.InvigilatorExamDuty;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.InvigilatorExamDuty.DataList;

public class InvigilatorInfoListRecyclerViewAdapter extends RecyclerView.Adapter<InvigilatorInfoListRecyclerViewAdapter.ViewHolder> {


    public List<DataList> mValues;


    public InvigilatorInfoListRecyclerViewAdapter(List<DataList> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_invigilator_info_card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.examName.setText(mValues.get(position).getExamName());
        holder.examSession.setText(mValues.get(position).getExamSession());
        holder.staffName.setText(mValues.get(position).getStaffName());
        holder.roomNo.setText(mValues.get(position).getRoomNo());
        holder.subjectName.setText(mValues.get(position).getSubjects());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        private final TextView examName;
        private final TextView examSession;
        private final TextView staffName;
        private final TextView roomNo;
        private final TextView subjectName;
        public DataList mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            examName = (TextView) view.findViewById(R.id.examname);
            examSession = (TextView) view.findViewById(R.id.examsession);
            staffName = (TextView) view.findViewById(R.id.staffname);
            roomNo = (TextView) view.findViewById(R.id.roomno);
            subjectName = (TextView) view.findViewById(R.id.subjectname);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + examName.getText() + "'";
        }
    }
}
