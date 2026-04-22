package hut.zsgs.trainee.features.dashboard;

import hut.zsgs.trainee.features.admin.*;
import java.util.Scanner;

public class AdminDashboard {


    public void start(){

        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("\n=== ADMIN DASHBOARD ===");
            System.out.println("1. Manage Trainees");
            System.out.println("2. View Problem Summary");
            System.out.println("3. View Full Logs");
            System.out.println("4. Trainee Ranking");
            System.out.println("5. View Morning Meeting Notes");
            System.out.println("6. View Procrastination Notes");
            System.out.println("7. Back");
            System.out.println("=== Choose Your Option ===");
            int ch=sc.nextInt();
            switch(ch){
                case 1 -> new ManageTrainee().start();
                case 2 -> new ProblemSummary().show();
                case 3 -> new ViewLogs().show();
                case 4 -> new TraineeRanking().show();
                case 5 -> new ViewMorningMeeting().show();
                case 6 -> new ViewProcrastination().show();
                case 7 -> {
                    return;
                }
            }
        }
    }
}
