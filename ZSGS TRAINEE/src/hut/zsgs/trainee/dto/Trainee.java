package hut.zsgs.trainee.dto;

public class Trainee{

    private String id, name, dob, phone, zsgsMail, personalMail, username, password;
    private int totalSolved = 0;

    public Trainee(String id, String name, String dob, String phone,
                   String zm, String pm, String u, String p){

        this.id = id;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.zsgsMail = zm;
        this.personalMail = pm;
        this.username = u;
        this.password = p;
    }

    // --------- GETTERS ---------

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDob(){
        return dob;
    }
    public String getPhone(){
        return phone;
    }
    public String getZsgsMail(){
        return zsgsMail;
    }
    public String getPersonalMail(){
        return personalMail;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public int getTotalSolved() {
        return totalSolved;
    }
    // --------- UPDATE SOLVED ---------
    public void addSolved(int val) {
        totalSolved += val;
    }
    @Override
    public String toString() {
        return id + " | " + name + " | Solved: " + totalSolved;
    }
}
