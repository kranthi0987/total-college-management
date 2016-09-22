/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.Absentees.AbsenteesList;

/**
 * Created by Sanjay on 9/21/2016.
 * total
 */

public class AbsenteesListItem {

    //            "Code": "CS001",
//            "GUID": "01B5A3AC-3274-44AF-A06F-03D085AB57F7",
//            "InTime": "",
//            "Name": "Dr. K.Ramesh",
//            "OutTime": ""
    String Code;
    String GUID;
    String InTime;
    String Name;
    String OutTime;


    public AbsenteesListItem(
            String Code,
            String GUID,
            String InTime,
            String Name,
            String OutTime

    ) {
        this.Code = Code;
        this.GUID = GUID;
        this.InTime = InTime;
        this.Name = Name;
        this.OutTime = OutTime;

    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getGUID() {
        return GUID;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public String getInTime() {
        return InTime;
    }

    public void setInTime(String inTime) {
        InTime = inTime;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOutTime() {
        return OutTime;
    }

    public void setOutTime(String outTime) {
        OutTime = outTime;
    }
}
