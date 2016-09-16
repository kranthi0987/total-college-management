package app.managementapp.college.com.collegemanagement.management.CollegeProfile.DepartmentList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.CollegeProfile.Department;

public class DepartmentRecyclerViewAdapter extends RecyclerView.Adapter<DepartmentRecyclerViewAdapter.ViewHolder> {

    private final List<Department> mValues;

    public DepartmentRecyclerViewAdapter(List<Department> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_department_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mDepartmentName.setText(mValues.get(position).getDepartmentName());
        holder.mHodName.setText(mValues.get(position).getDepartmentHODID());
        holder.mHodPhone.setText(mValues.get(position).getHODPhone());
        holder.mHodQualification.setText(mValues.get(position).getQualification());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mDepartmentName;
        public final TextView mHodName;
        public final TextView mHodPhone;
        public final TextView mHodQualification;

        public Department mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mDepartmentName = (TextView) view.findViewById(R.id.dept_name);
            mHodName = (TextView) view.findViewById(R.id.hod_name);
            mHodPhone = (TextView) view.findViewById(R.id.hod_number);
            mHodQualification = (TextView) view.findViewById(R.id.hod_qualification);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mDepartmentName.getText() + "'";
        }
    }
}
