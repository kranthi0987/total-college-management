package app.managementapp.college.com.collegemanagement.model.Staff;

/**
 * Created by Sanjay on 9/2/2016.
 */
public class OtherStaffMovementRegisterItem {


//            "Date": "/Date(1433874600000+0530)/",
//            "Time": "10:04AM"

    String Date;
    String Time;

    public OtherStaffMovementRegisterItem(
            String Date,
            String Time

    ) {
        this.Date = Date;
        this.Time = Time;

    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
