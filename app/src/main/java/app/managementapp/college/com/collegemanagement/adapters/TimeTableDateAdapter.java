package app.managementapp.college.com.collegemanagement.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.Date;

import app.managementapp.college.com.collegemanagement.R;

public class TimeTableDateAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final Date[] date;

    public TimeTableDateAdapter(Activity context, Date[] date) {
        super(context, R.layout.row_time_table_date_item);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.date = date;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.row_time_table_date_item, null, true);

       /* TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        extratxt.setText("Description "+itemname[position]);
        */
        return rowView;

    }

    ;
}