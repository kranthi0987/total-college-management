/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StudentSearch.OtherDetails;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.managementapp.college.com.collegemanagement.management.StudentSearch.Item.OtherPaymentDetailsItem;
import app.managementapp.college.com.collegemanagement.model.util.Converter;

/**
 * Created by Sanjay on 8/30/2016.
 */
public class PaymentDetails extends AbstractOtherDetails {
    private static final String DEBUG_TAG = "paymentDetails";
    List<OtherPaymentDetailsItem> paymentDetailsList;

    public PaymentDetails() {
        super();
    }


    @Override
    public void init(String body) {
        try {
            JSONObject resultJSON = new JSONObject(body);
//            JSONObject getPaymentDetailsListResult = resultJSON.getJSONObject("DataList");
                    /*LinearLayout linearLayout = (LinearLayout) findViewById(R.id.studentCont);
                    LayoutInflater inflater = LayoutInflater.from(mContext);*/

            Log.d("resultJSON ", body + "");
            if (resultJSON.getInt("ServiceResult") == 0) {

                List<OtherPaymentDetailsItem> paymentDetailList = paymentDetailsList(resultJSON.getJSONArray("DataList"));


//    "BankName": null,
//    "FeeName": "TUTION FEE",
//    "PaidAmount": 108900.00,
//    "PaymentDate": "\/Date(1385577000000+0530)\/",
//    "PaymentModeWithDocNo": "Cash",
//    "Receipt": "2013\/10                       ",
//    "RefundAmount": 0.00,
//    "Sem": "Term I"

                Log.d(DEBUG_TAG, "init: paymentDetailList size " + paymentDetailList.size());
                for (int i = 1; i < paymentDetailList.size(); i++) {
                    OtherPaymentDetailsItem item = paymentDetailList.get(i);

                    keys.add("FeeName");
                    keys.add("PaidAmount");
                    keys.add("PaymentDate");
                    keys.add("PaymentModeWithDocNo");
                    keys.add("Receipt");
                    keys.add("RefundAmount");
                    keys.add("Sem");

                    values.add(item.getFeeName());
                    values.add(item.getPaidAmount());
                    values.add(item.getPaymentDate());
                    values.add(item.getPaymentModeWithDocNo());
                    values.add(item.getReceipt());
                    values.add(item.getRefundAmount());
                    values.add(item.getSem());
                    Log.d(DEBUG_TAG, "init: doing here");
                }

            } else {

            }
        } catch (Exception t) {
            Log.e("JSON error", t + "");
        }
//        list kiterate chesi {
//            keys.add("");
//            values.add("");
//
//        }


    }


    private List<OtherPaymentDetailsItem> paymentDetailsList(JSONArray body) {
        List<OtherPaymentDetailsItem> data = new ArrayList<>();
        for (int i = 0, size = body.length(); i < size; i++) {
            try {
                JSONObject objectInArray = body.getJSONObject(i);
                OtherPaymentDetailsItem paymentDetailsItem = new OtherPaymentDetailsItem
                        (
                                objectInArray.getString("FeeName"),
                                objectInArray.getString("PaidAmount"),
                                Converter.retroDateConvert(objectInArray.getString("PaymentDate")),
                                objectInArray.getString("PaymentModeWithDocNo"),
                                objectInArray.getString("Receipt"),
                                objectInArray.getString("RefundAmount"),
                                objectInArray.getString("Sem")
                        );
                data.add(paymentDetailsItem);
            } catch (Exception e) {
                Log.e(DEBUG_TAG, "getFeeSummaryList: " + e.getMessage());
            }
        }
        return data;
    }

    public String getURL(String id) {
        return "/ManagementService.svc/GetFeePaymentDetails?StudentID=10";
    }

}
