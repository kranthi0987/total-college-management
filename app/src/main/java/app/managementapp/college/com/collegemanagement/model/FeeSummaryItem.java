package app.managementapp.college.com.collegemanagement.model;

/**
 * Created by yeshwanth on 8/27/2016.
 */
public class FeeSummaryItem {
    Integer CurrentLevel;
    String FeeDemand;
    String FeeDue;
    String FeePaid;
    String ItemType;
    String ItemTypeID;
    Integer isChildAvailable;

    public FeeSummaryItem(Integer CurrentLevel, String FeeDemand, String FeeDue, String FeePaid,
                          String ItemType, String ItemTypeID, Integer isChildAvailable) {
        this.CurrentLevel = CurrentLevel;
        this.FeeDemand = FeeDemand;
        this.FeeDue = FeeDue;
        this.FeePaid = FeePaid;
        this.ItemType = ItemType;
        this.ItemTypeID = ItemTypeID;
        this.isChildAvailable = isChildAvailable;

    }

    public Integer getCurrentLevel() {
        return CurrentLevel;
    }

    public void setCurrentLevel(Integer currentLevel) {
        CurrentLevel = currentLevel;
    }

    public String getFeeDemand() {
        return FeeDemand;
    }

    public void setFeeDemand(String feeDemand) {
        FeeDemand = feeDemand;
    }

    public String getFeeDue() {
        return FeeDue;
    }

    public void setFeeDue(String feeDue) {
        FeeDue = feeDue;
    }

    public String getFeePaid() {
        return FeePaid;
    }

    public void setFeePaid(String feePaid) {
        FeePaid = feePaid;
    }

    public String getItemType() {
        return ItemType;
    }

    public void setItemType(String itemType) {
        ItemType = itemType;
    }

    public Integer getIsChildAvailable() {
        return isChildAvailable;
    }

    public void setIsChildAvailable(Integer isChildAvailable) {
        this.isChildAvailable = isChildAvailable;
    }

    public String getItemTypeID() {
        return ItemTypeID;
    }

    public void setItemTypeID(String itemTypeID) {
        ItemTypeID = itemTypeID;
    }
}
