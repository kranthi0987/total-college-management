package app.managementapp.college.com.collegemanagement.model;

/**
 * Created by Sanjay on 8/31/2016.
 */
public class OtherAttendanceDetailsItem {
//    "Code": "FOUNDATIONS OF FINANCE",
//            "ID": 0,
//            "Name": "MA151",
//            "<DaysAttended>k__BackingField": "3",
//            "<Percentage>k__BackingField": 100,
//            "Held": 3,
//            "Sem": "Term II"


    String Code;
    int ID;
    String Name;
    //    String k__BackingField;
//    String k__BackingField;
    int Held;
    String Sem;

    public OtherAttendanceDetailsItem(
            String Code,
            int ID,
            String Name,
            int Held,
            String Sem
    ) {

        this.Code = Code;
        this.ID = ID;
        this.Name = Name;
        this.Held = Held;
        this.Sem = Sem;
    }

    public String getSem() {
        return Sem;
    }

    public void setSem(String sem) {
        Sem = sem;
    }

    public int getHeld() {

        return Held;
    }

    public void setHeld(int held) {
        Held = held;
    }

    public String getName() {

        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getID() {

        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCode() {

        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
}
