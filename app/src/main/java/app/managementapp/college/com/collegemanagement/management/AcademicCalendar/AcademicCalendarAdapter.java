/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.AcademicCalendar;

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
 * Created by yeshwanth on 8/27/2016.
 */
public class AcademicCalendarAdapter extends RecyclerView.Adapter<AcademicCalendarAdapter.ViewHolder> {


    Context ctx;
    List<AcademicCalendarItem> academicCalendarItem;

    public AcademicCalendarAdapter(Context ctx, List<AcademicCalendarItem> academicCalendarItem) {
        this.ctx = ctx;
        this.academicCalendarItem = academicCalendarItem;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.row_academic_calendar_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
//        viewHolder.toggle.setChecked(studentItem.getPresent());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AcademicCalendarItem academicCalendarItems = academicCalendarItem.get(position);

        Log.d("test", "onBindViewHolder: " + academicCalendarItems);
        setText(holder.startdate, academicCalendarItems.getStartDate());
        setText(holder.academicyear, String.valueOf(academicCalendarItems.getAcademicYear()));
        setText(holder.branch, academicCalendarItems.getBranch());
        setText(holder.branchid, String.valueOf(academicCalendarItems.getBranchID()));
        setText(holder.event, academicCalendarItems.getEvent());
        setText(holder.eventid, academicCalendarItems.getEventType());
        setText(holder.course, academicCalendarItems.getCourse());
        setText(holder.courseid, String.valueOf(academicCalendarItems.getCourseID()));
        setText(holder.sem, academicCalendarItems.getSem());
        setText(holder.enddate, academicCalendarItems.getEndDate());
//        holder.startdate.setText(academicCalendarItems.getStartDate());
//        holder.sem.setText(academicCalendarItems.getSem());
//        holder.eventid.setText(academicCalendarItems.getEventType());
//        holder.event.setText(academicCalendarItems.getEvent());
//        holder.enddate.setText(academicCalendarItems.getEndDate());
//        holder.courseid.setText(academicCalendarItems.getCourseID());
//        holder.course.setText(academicCalendarItems.getCourse());
//        holder.branchid.setText(academicCalendarItems.getBranchID());
//        holder.branch.setText(academicCalendarItems.getBranch());
//        holder.academicyear.setText(academicCalendarItems.getAcademicYear());
    }

    public void setText(TextView textView, String value) {
        if (textView != null && value != null) {
            textView.setText(value);
        } else {
            Log.d("test", "setText: isssu3e with ");
        }

    }

    @Override
    public int getItemCount() {
        return academicCalendarItem.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {//  implements View.OnClickListener {
        //        public MaterialRippleLayout studentCont;
//        //        public TextView studentId;
//        public TextView studentName;
//        public TextView studentRoll;
//        //        public ImageView present;
////        public ImageView abscent;
//        public ToggleButton toggle;
        public TextView academicyear;
        public TextView branch;
        public TextView branchid;
        public TextView course;
        public TextView courseid;
        public TextView event;
        public TextView eventid;
        public TextView startdate;
        public TextView sem;
        public TextView enddate;

        public ViewHolder(View itemView) {
            super(itemView);


            academicyear = (TextView) itemView.findViewById(R.id.textAcademicyear);
            branch = (TextView) itemView.findViewById(R.id.textBranch);
            branchid = (TextView) itemView.findViewById(R.id.textbranchid);
            course = (TextView) itemView.findViewById(R.id.textcourse);
            courseid = (TextView) itemView.findViewById(R.id.textcourseid);
            event = (TextView) itemView.findViewById(R.id.textevent);
            eventid = (TextView) itemView.findViewById(R.id.texteventtype);
            enddate = (TextView) itemView.findViewById(R.id.textenddate);
            startdate = (TextView) itemView.findViewById(R.id.textstartdate);
            sem = (TextView) itemView.findViewById(R.id.textsem);
        }

       /* @Override
        public void onClick(View v) {
            Log.d("yyyy", "onClick: clickeddd" );
            icon.setImageResource(R.drawable.ic_abscent);
        }*/
    }

}
