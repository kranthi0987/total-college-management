/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.Absentees;

/**
 * Created by Sanjay on 9/21/2016.
 * total
 */

public class AbsenteesItem {
//data variables
//
//    {
//        "DataList": [
//        {
//            "Absentees": 0,
//                "Active": 1,
//                "Category": "Dept of Mathematics",
//                "CategoryID": "10",
//                "CurrentLevel": 2,
//                "IsChildAvailable": false,
//                "OnLeave": 0,
//                "Present": 0
//        }
//        ],
//        "ErrorMessage": null,
//            "ExtendedToken": "xxx",
//            "ServiceResult": 0
//    }

    String Absentees;
    String Active;
    String Category;
    String CategoryID;
    String CurrentLevel;
    String IsChildAvailable;
    String OnLeave;
    String Present;

    public AbsenteesItem(
            String Absentees,
            String Active,
            String Category,
            String CategoryID,
            String CurrentLevel,
            String IsChildAvailable,
            String OnLeave,
            String Present
    ) {
        this.Absentees = Absentees;
        this.Active = Active;
        this.Category = Category;
        this.CategoryID = CategoryID;
        this.CurrentLevel = CurrentLevel;
        this.IsChildAvailable = IsChildAvailable;
        this.OnLeave = OnLeave;
        this.Present = Present;


    }

    public String getAbsentees() {
        return Absentees;
    }

    public void setAbsentees(String absentees) {
        Absentees = absentees;
    }

    public String getActive() {
        return Active;
    }

    public void setActive(String active) {
        Active = active;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public String getCurrentLevel() {
        return CurrentLevel;
    }

    public void setCurrentLevel(String currentLevel) {
        CurrentLevel = currentLevel;
    }

    public String getIsChildAvailable() {
        return IsChildAvailable;
    }

    public void setIsChildAvailable(String isChildAvailable) {
        IsChildAvailable = isChildAvailable;
    }

    public String getOnLeave() {
        return OnLeave;
    }

    public void setOnLeave(String onLeave) {
        OnLeave = onLeave;
    }

    public String getPresent() {
        return Present;
    }

    public void setPresent(String present) {
        Present = present;
    }

}
