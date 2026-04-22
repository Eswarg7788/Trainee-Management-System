package hut.zsgs.trainee.dto;

public class TraineeLog {

    private String traineeId;
    private String date;
    private String meeting;
    private String procrastination;
    private String status;
    private String reason;
    private int hackerrank, leetcode;

    public TraineeLog(String traineeId,String date,String meeting,String procrastination,
                      String status,String reason,int hr,int lc){
        this.traineeId=traineeId;
        this.date=date;
        this.meeting=meeting;
        this.procrastination=procrastination;
        this.status=status;
        this.reason=reason;
        this.hackerrank=hr;
        this.leetcode=lc;
    }

    public String getTraineeId(){
        return traineeId;
    }
    public int getHR(){
        return hackerrank;
    }
    public int getLC(){
        return leetcode;
    }

    // ⭐ YOU MUST ADD THESE GETTERS ⭐

    public String getDate() {
        return date;
    }

    public String getMorningMeeting() {
        return meeting;
    }

    public String getProcrastination() {
        return procrastination;
    }

    public String getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString(){
        return traineeId + " | " + date +
                " | Hackerrank:" + hackerrank +
                " | Leetcode:" + leetcode +
                " | " + status +
                " | " + reason;
    }
}
