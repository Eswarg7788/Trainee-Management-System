package hut.zsgs.trainee.features.admin;

import hut.zsgs.trainee.dto.TraineeLog;
import hut.zsgs.trainee.resposity.ZsgsDB;
public class ViewProcrastination {
    public void show() {
        System.out.println("\n=== PROCRASTINATION NOTES ===");

        boolean found = false;

        for (TraineeLog log : ZsgsDB.getInstance().getLogs()) {
            if (!log.getProcrastination().equals("-")) {
                System.out.println("Trainee: " + log.getTraineeId());
                System.out.println("Date: " + log.getDate());
                System.out.println("Procrastination: " + log.getProcrastination());
                System.out.println("----------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No procrastination notes yet.");
        }
    }
}
