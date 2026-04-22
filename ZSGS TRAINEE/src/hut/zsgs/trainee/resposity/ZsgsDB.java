package hut.zsgs.trainee.resposity;

import hut.zsgs.trainee.dto.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ZsgsDB{ 
    private static ZsgsDB instance;
    private Connection conn;

    private ZsgsDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/zsgs_tracker",
                    "root",
                    "root"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ZsgsDB getInstance() {
        if (instance == null)
            instance = new ZsgsDB();
        return instance;
    }

    // ---------------- ADD TRAINEE ----------------
    public void addTrainee(Trainee t) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO trainees VALUES (?,?,?,?,?,?,?,?,?)"
            );
            ps.setString(1, t.getId());
            ps.setString(2, t.getName());
            ps.setString(3, t.getDob());
            ps.setString(4, t.getPhone());
            ps.setString(5, t.getZsgsMail());
            ps.setString(6, t.getPersonalMail());
            ps.setString(7, t.getUsername());
            ps.setString(8, t.getPassword());
            ps.setInt(9, t.getTotalSolved());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------- ADD LOG ----------------
    public void addLog(TraineeLog l) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO logs (trainee_id,date,meeting,procrastination,status,reason,hr,lc) VALUES (?,?,?,?,?,?,?,?)"
            );
            ps.setString(1, l.getTraineeId());
            ps.setString(2, l.getDate());
            ps.setString(3, l.getMorningMeeting());
            ps.setString(4, l.getProcrastination());
            ps.setString(5, l.getStatus());
            ps.setString(6, l.getReason());
            ps.setInt(7, l.getHR());
            ps.setInt(8, l.getLC());
            ps.executeUpdate();

            // Update total solved
            PreparedStatement update = conn.prepareStatement(
                    "UPDATE trainees SET total_solved = total_solved + ? WHERE id=?"
            );
            update.setInt(1, l.getHR() + l.getLC());
            update.setString(2, l.getTraineeId());
            update.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------- GET TRAINEES ----------------
    public List<Trainee> getTrainees() {
        List<Trainee> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM trainees");

            while (rs.next()) {
                Trainee t = new Trainee(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("dob"),
                        rs.getString("phone"),
                        rs.getString("zsgs_mail"),
                        rs.getString("personal_mail"),
                        rs.getString("username"),
                        rs.getString("password")
                );
                t.addSolved(rs.getInt("total_solved"));
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ---------------- FIND LOGIN ----------------
    public Trainee findByUsername(String u) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM trainees WHERE username=?");
            ps.setString(1, u);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Trainee t = new Trainee(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("dob"),
                        rs.getString("phone"),
                        rs.getString("zsgs_mail"),
                        rs.getString("personal_mail"),
                        rs.getString("username"),
                        rs.getString("password")
                );
                t.addSolved(rs.getInt("total_solved"));
                return t;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // ---------------- GET LOGS ----------------
    public List<TraineeLog> getLogs() {
        List<TraineeLog> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM logs");

            while (rs.next()) {
                list.add(new TraineeLog(
                        rs.getString("trainee_id"),
                        rs.getString("date"),
                        rs.getString("meeting"),
                        rs.getString("procrastination"),
                        rs.getString("status"),
                        rs.getString("reason"),
                        rs.getInt("hr"),
                        rs.getInt("lc")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
