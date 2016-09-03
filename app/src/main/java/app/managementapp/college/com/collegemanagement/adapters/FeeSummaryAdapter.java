package app.managementapp.college.com.collegemanagement.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;

import java.util.List;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.management.FeeSummary.FeeSummary;
import app.managementapp.college.com.collegemanagement.model.FeeSummaryItem;

/**
 * Created by yeshwanth on 8/27/2016.
 */
public class FeeSummaryAdapter extends RecyclerView.Adapter<FeeSummaryAdapter.ViewHolder> {


    Context ctx;
    List<FeeSummaryItem> feeSummaryItem;

    public FeeSummaryAdapter(Context ctx, List<FeeSummaryItem> feeSummaryItem) {
        this.ctx = ctx;
        this.feeSummaryItem = feeSummaryItem;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.row_fee_summary_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
//        viewHolder.toggle.setChecked(studentItem.getPresent());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FeeSummaryItem item = feeSummaryItem.get(position);
        holder.Heading.setText(item.getItemType());
        holder.feePaidContent.setText(item.getFeePaid());
        holder.feeDueContent.setText(item.getFeeDue());
        holder.feeDemandContent.setText(item.getFeeDemand());
        holder.studentCont.setOnClickListener(new FeeSummaryOnClickListener(position));
    }

    @Override
    public int getItemCount() {
        return feeSummaryItem.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {//  implements View.OnClickListener {
        public MaterialRippleLayout studentCont;
        public TextView Heading;
        public TextView feePaidContent;
        public TextView feeDueContent;
        public TextView feeDemandContent;

        public ViewHolder(View itemView) {
            super(itemView);

            studentCont = (MaterialRippleLayout) itemView.findViewById(R.id.lyt_parent);
            Heading = (TextView) itemView.findViewById(R.id.Heading);
            feePaidContent = (TextView) itemView.findViewById(R.id.feePaidContent);
            feeDueContent = (TextView) itemView.findViewById(R.id.feeDueContent);
            feeDemandContent = (TextView) itemView.findViewById(R.id.feeDemandContent);

        }

       /* @Override
        public void onClick(View v) {
            Log.d("yyyy", "onClick: clickeddd" );
            icon.setImageResource(R.drawable.ic_abscent);
        }*/
    }


    public class FeeSummaryOnClickListener implements View.OnClickListener {
        public static final String DEBUG_TAG = "TimeTable";
        private FeeSummaryItem studentItem;
        private int position;

        public FeeSummaryOnClickListener(int position) {
            this.studentItem = feeSummaryItem.get(position);
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            Log.d(DEBUG_TAG, "onClick: FeeSummaryOnClickListener ");
            ((FeeSummary) ctx).levelIds.add(studentItem.getItemTypeID());
            ((FeeSummary) ctx).level += 1;
            ((FeeSummary) ctx).makeNetworkCall();
        }
    }

    ;

}
