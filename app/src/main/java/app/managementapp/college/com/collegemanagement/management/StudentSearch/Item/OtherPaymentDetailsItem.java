/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StudentSearch.Item;

/**
 * Created by new on 4/12/2016.
 */
public class OtherPaymentDetailsItem {


//    "BankName": null,
//    "FeeName": "TUTION FEE",
//    "PaidAmount": 108900.00,
//    "PaymentDate": "\/Date(1385577000000+0530)\/",
//    "PaymentModeWithDocNo": "Cash",
//    "Receipt": "2013\/10                       ",
//    "RefundAmount": 0.00,
//    "Sem": "Term I"

    String FeeName;
    String PaidAmount;
    String PaymentDate;
    String PaymentModeWithDocNo;
    String Receipt;
    String RefundAmount;
    String Sem;

    public OtherPaymentDetailsItem(
            String FeeName, String PaidAmount, String PaymentDate, String PaymentModeWithDocNo, String Receipt, String RefundAmount, String Sem) {

        this.FeeName = FeeName;
        this.PaidAmount = PaidAmount;
        this.PaymentDate = PaymentDate;
        this.PaymentModeWithDocNo = PaymentModeWithDocNo;
        this.Receipt = Receipt;
        this.RefundAmount = RefundAmount;
        this.Sem = Sem;
    }

    public String getFeeName() {
        return FeeName;
    }

    public void setFeeName(String feeName) {
        FeeName = feeName;
    }

    public String getSem() {
        return Sem;
    }

    public void setSem(String sem) {
        Sem = sem;
    }

    public String getRefundAmount() {

        return RefundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        RefundAmount = refundAmount;
    }

    public String getReceipt() {

        return Receipt;
    }

    public void setReceipt(String receipt) {
        Receipt = receipt;
    }

    public String getPaymentModeWithDocNo() {

        return PaymentModeWithDocNo;
    }

    public void setPaymentModeWithDocNo(String paymentModeWithDocNo) {
        PaymentModeWithDocNo = paymentModeWithDocNo;
    }

    public String getPaymentDate() {

        return PaymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        PaymentDate = paymentDate;
    }

    public String getPaidAmount() {

        return PaidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        PaidAmount = paidAmount;
    }
}
