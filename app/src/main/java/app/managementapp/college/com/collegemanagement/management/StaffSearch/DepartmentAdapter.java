package app.managementapp.college.com.collegemanagement.management.StaffSearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.Staff.Department.DataList;

/**
 * Created by Sri Harrsha on 01-Sep-16.
 * total
 */


public class DepartmentAdapter extends ArrayAdapter<DataList> {
    public static String deptId = "";
    List<DataList> departments;
    LayoutInflater inflater;


    public DepartmentAdapter(Context context, List<DataList> departments) {
        super(context, android.R.layout.simple_spinner_dropdown_item, departments);
        this.departments = departments;
    }


    @Override
    public int getCount() {
        try {
            return departments.size();
        } catch (NullPointerException nullexp) {
            return 0;
        }
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }


    // This funtion called for each row ( Called data.size() times )
    public View getCustomView(int position, View convertView, ViewGroup parent) {

        /********** Inflate spinner_rows.xml file for each row ( Defined below ) ************/
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.spinner_layout, parent, false);
        TextView label = (TextView) row.findViewById(R.id.text1);
        if (position == 0) {
            label.setText("Select Department");
            label.setTextSize(15);
        } else {
            label.setText(departments.get(position).getDrpName());
        }
        return row;
    }
}
