package hut.zsgs.trainee.features.dashboard;

import hut.zsgs.trainee.dto.Trainee;
import hut.zsgs.trainee.features.trainee.TraineeAction;
import java.util.Scanner;
public class TraineeDashboard {
    Trainee t;
    public TraineeDashboard(Trainee t){ this.t=t; }

    public void start(){
        Scanner sc=new Scanner(System.in);
        TraineeAction a=new TraineeAction();

        while(true){
            System.out.println("\nWelcome "+t.getName()+" ("+t.getId()+")");
            System.out.println("1. Morning Meeting Notes");
            System.out.println("2. Daily Procrastination");
            System.out.println("3. Daily Task + HR/LC Count");
            System.out.println("4. Back");
            int c=sc.nextInt();
            switch(c){
                case 1 -> a.morningMeeting(t);
                case 2 -> a.procrastination(t);
                case 3 -> a.dailyTask(t);
                case 4 -> {
                    return;
                }
            }
        }
    }
}
