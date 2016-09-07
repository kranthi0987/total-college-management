package app.managementapp.college.com.collegemanagement.management.staffsearch.OtherDetails;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sanjay on 9/2/2016.
 */
public class StaffAbstractOtherDetails implements Parcelable {
    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Creator<StaffAbstractOtherDetails> CREATOR = new Creator<StaffAbstractOtherDetails>() {
        public StaffAbstractOtherDetails createFromParcel(Parcel in) {
            return new StaffAbstractOtherDetails();
        }

        public StaffAbstractOtherDetails[] newArray(int size) {
            return new StaffAbstractOtherDetails[size];
        }
    };
    public List<String> keys = new ArrayList<String>();
    public List<String> values = new ArrayList<String>();
    private int mData;

    // example constructor that takes a Parcel and gives you an object populated with it's values
    StaffAbstractOtherDetails() {
//        mData = in.readInt();
    }

    public String getURL(String id) {
        return "";
    }

    public List<String> getKeys() {
        return keys;
    }

    public List<String> getValues() {
        return values;
    }

    public void init(String body) {
        Log.d("000", "init: old method");
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

}
