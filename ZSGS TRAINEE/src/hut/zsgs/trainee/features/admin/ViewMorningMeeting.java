package hut.zsgs.trainee.features.admin;

import hut.zsgs.trainee.dto.Trainee;
import hut.zsgs.trainee.dto.TraineeLog;
import hut.zsgs.trainee.resposity.ZsgsDB;

public class ViewMorningMeeting {

    public void show() {

        System.out.println("\n=== MORNING MEETING NOTES ===");

        boolean found = false;

        for (TraineeLog log : ZsgsDB.getInstance().getLogs()) {

            if (!log.getMorningMeeting().equals("-")) {

                // Get trainee name using traineeId
                Trainee trainee = ZsgsDB.getInstance()
                        .getTrainees()
                        .stream()
                        .filter(t -> t.getId().equals(log.getTraineeId()))
                        .findFirst()
                        .orElse(null);

                String name = (trainee != null) ? trainee.getName() : "Unknown";

                System.out.println("Trainee: " + name + " (" + log.getTraineeId() + ")");
                System.out.println("Date: " + log.getDate());
                System.out.println("Meeting Notes: " + log.getMorningMeeting());
                System.out.println("----------------------------------");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No morning meeting notes yet.");
        }
    }
}
