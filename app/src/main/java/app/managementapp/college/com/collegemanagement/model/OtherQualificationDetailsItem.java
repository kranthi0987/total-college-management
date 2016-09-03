package app.managementapp.college.com.collegemanagement.model;

/**
 * Created by Sanjay on 8/31/2016.
 */
public class OtherQualificationDetailsItem {


    //    "Board": "C.B.S.E",
//            "College": "G.G.P.S",
//            "PCMPercent": 0,
//            "QualifyingCourse": "Intermidate",
//            "SSLCorSSCPercent": 0,
//            "TotalPercent": 88,
//            "USN": "107247"
    String Board;
    int PCMPercent;
    int TotalPercent;
    String College;
    int SSLCorSSCPercent;
    int QualifyingCourse;
    int USN;

    public OtherQualificationDetailsItem(
            String Board,
            int PCMPercent,
            int TotalPercent,
            String College,
            int SSLCorSSCPercent,
            int QualifyingCourse,
            int USN
    ) {

        this.Board = Board;
        this.PCMPercent = PCMPercent;
        this.TotalPercent = TotalPercent;
        this.College = College;
        this.SSLCorSSCPercent = SSLCorSSCPercent;
        this.QualifyingCourse = QualifyingCourse;
        this.USN = USN;

    }

    public String getBoard() {
        return Board;
    }

    public void setBoard(String board) {
        Board = board;
    }

    public int getPCMPercent() {
        return PCMPercent;
    }

    public void setPCMPercent(int PCMPercent) {
        this.PCMPercent = PCMPercent;
    }

    public int getTotalPercent() {
        return TotalPercent;
    }

    public void setTotalPercent(int totalPercent) {
        TotalPercent = totalPercent;
    }

    public String getCollege() {
        return College;
    }

    public void setCollege(String college) {
        College = college;
    }

    public int getSSLCorSSCPercent() {
        return SSLCorSSCPercent;
    }

    public void setSSLCorSSCPercent(int SSLCorSSCPercent) {
        this.SSLCorSSCPercent = SSLCorSSCPercent;
    }

    public int getQualifyingCourse() {
        return QualifyingCourse;
    }

    public void setQualifyingCourse(int qualifyingCourse) {
        QualifyingCourse = qualifyingCourse;
    }

    public int getUSN() {
        return USN;
    }

    public void setUSN(int USN) {
        this.USN = USN;
    }


}
