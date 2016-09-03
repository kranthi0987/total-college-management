package app.managementapp.college.com.collegemanagement.model;

/**
 * Created by Sanjay on 28/08/2016.
 */
public class AcademicCalendarItem {
    //Data Variables

    /**
     * "AccademicYear": 2013,
     * "Branch": null,
     * "BranchID": 0,
     * "Course": "Post Graduate Diploma in Management",
     * "CourseID": 41,
     * "EndDate": "/Date(1431023400000+0530)/",
     * "Event": "Anual Day",
     * "EventType": "Cultural Event",
     * "Sem": "Term I",
     * "StartDate": "/Date(1430418600000+0530)/"
     */

    Integer AcademicYear;
    String Branch;
    Integer BranchID;
    String Course;
    Integer CourseID;
    String EndDate;
    String Event;
    String EventType;
    String Sem;
    String StartDate;

    public AcademicCalendarItem(Integer AcademicYear,
                                String Branch,
                                Integer BranchID,
                                String Course,
                                Integer CourseID,
                                String EndDate,
                                String Event,
                                String EventType,
                                String Sem,
                                String StartDate) {
        this.AcademicYear = AcademicYear;
        this.Branch = Branch;
        this.BranchID = BranchID;
        this.Course = Course;
        this.CourseID = CourseID;
        this.EndDate = EndDate;
        this.Event = Event;
        this.EventType = EventType;
        this.Sem = Sem;
        this.StartDate = StartDate;


    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getSem() {

        return Sem;
    }

    public void setSem(String sem) {
        Sem = sem;
    }

    public String getEventType() {

        return EventType;
    }

    public void setEventType(String eventType) {
        EventType = eventType;
    }

    public String getEvent() {

        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public Integer getCourseID() {

        return CourseID;
    }

    public void setCourseID(Integer courseID) {
        CourseID = courseID;
    }

    public String getEndDate() {

        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getCourse() {

        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public Integer getBranchID() {

        return BranchID;
    }

    public void setBranchID(Integer branchID) {
        BranchID = branchID;
    }

    public String getBranch() {

        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public Integer getAcademicYear() {

        return AcademicYear;
    }

    public void setAcademicYear(Integer academicYear) {
        AcademicYear = academicYear;
    }
}