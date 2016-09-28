/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.InvigilatorExamDuty;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import app.managementapp.college.com.collegemanagement.R;

public class InvigilatorExamDutyActivity extends AppCompatActivity {
    PopupWindow popupMessage;
    Button popupButton, insidePopupButton;
    DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    DateFormat keyFormatter = new SimpleDateFormat("dd-MMMM-yyyy");
    DatePicker fromDatePicker;
    DatePicker toDatePicker;
    TextView popupText;
    LinearLayout layoutOfPopup;
    LinearLayout layoutInnerOfPopup;
    FragmentManager fragmentManager;
    FrameLayout progressBarHolder;
    Calendar showingCalander = Calendar.getInstance(Locale.getDefault());
    View.OnClickListener onFilterclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("", "onClick: onFilterclickListener");
//                popupMessage.showAsDropDown(insidePopupButton, 0, 0);
            popupMessage.showAtLocation(insidePopupButton, Gravity.CENTER, 0, 0);
        }
    };
    View.OnClickListener onFilterbackclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("College profile", "onClick: onFilterbackTimeTableclickListener");
            onBackPressed();

        }
    };
    View.OnClickListener onFilterOkclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("", "onClick: onFilterOkclickListener");
            String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            if (popupMessage.isShowing()) {
                popupMessage.dismiss();
                try {
                    InvigilatorInfoListFragment fragment = InvigilatorInfoListFragment.newInstance(0, fromDatePicker.getDayOfMonth() + "-" + months[fromDatePicker.getMonth()] + "-" + fromDatePicker.getYear());
                    fragmentManager.beginTransaction().remove(fragmentManager.findFragmentById(R.id.fragment_container)).commit();
                    fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
                } catch (Exception e) {
                    Toast.makeText(InvigilatorExamDutyActivity.this, e.toString(), Toast.LENGTH_SHORT).show();

                }
            } else {
                Toast.makeText(InvigilatorExamDutyActivity.this, "From date cant exceed to date", Toast.LENGTH_SHORT).show();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invigilator_exam_duty);
        progressBarHolder = (FrameLayout) findViewById(R.id.progressBarHolder);
        progressBarHolder.setVisibility(View.VISIBLE);
        findViewById(R.id.backTimeTable).setOnClickListener(onFilterbackclickListener);
        fragmentManager = getSupportFragmentManager();
        InvigilatorInfoListFragment fragment = InvigilatorInfoListFragment.newInstance(0, "");
        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        progressBarHolder.setVisibility(View.GONE);
        ImageView filter = (ImageView) findViewById(R.id.filter);


        filter.setOnClickListener(onFilterclickListener);
        setupPopUp();
        insidePopupButton.setOnClickListener(onFilterOkclickListener);
    }

    private void setupPopUp() {

        popupText = new TextView(this);
        insidePopupButton = new Button(this);

        layoutOfPopup = new LinearLayout(this);
        layoutInnerOfPopup = new LinearLayout(this);
        insidePopupButton.setText("OK");
        insidePopupButton.setTextColor(Color.parseColor("#FFFFFF"));
        insidePopupButton.setBackgroundColor(Color.parseColor("#03A7E9"));
        popupText.setText("Month");
        popupText.setTextColor(Color.parseColor("#000000"));
        popupText.setTextSize(16);
        popupText.setPadding(0, 0, 0, 10);
        layoutOfPopup.setOrientation(LinearLayout.VERTICAL);
        fromDatePicker = new DatePicker(this);
        toDatePicker = new DatePicker(this);
        fromDatePicker.setCalendarViewShown(false);
        View dayId = fromDatePicker.findViewById(Resources.getSystem().getIdentifier("day", "id", "android"));
        if (dayId != null) dayId.setVisibility(View.GONE);
        toDatePicker.setCalendarViewShown(false);
        layoutOfPopup.addView(popupText);
        layoutOfPopup.addView(fromDatePicker);
//        layoutOfPopup.addView(toText);
        layoutOfPopup.addView(insidePopupButton);
        layoutOfPopup.setBackgroundColor(Color.parseColor("#ffffff"));
        layoutOfPopup.setPadding(40, 40, 40, 40);
        layoutOfPopup.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        layoutInnerOfPopup.setPadding(40, 40, 40, 40);
        layoutInnerOfPopup.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        layoutInnerOfPopup.setBackgroundColor(Color.parseColor("#80000000"));
        layoutInnerOfPopup.addView(layoutOfPopup);

        popupMessage = new PopupWindow(layoutInnerOfPopup, LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
        popupMessage.setContentView(layoutInnerOfPopup);
    }


    @Override
    public void onBackPressed() {
        Log.d("onBackPressed", "onBackPressed: ");
        if (popupMessage.isShowing()) {
            popupMessage.dismiss();
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (popupMessage != null && popupMessage.isShowing()) {
            popupMessage.dismiss();
        }
    }
}
