package hut.zsgs.trainee.features.trainee;

import hut.zsgs.trainee.dto.*;
import hut.zsgs.trainee.resposity.ZsgsDB;

import java.time.LocalDate;
import java.util.Scanner;

public class TraineeAction {
    public void morningMeeting(Trainee t){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Morning Meeting Notes:");
        String txt=sc.nextLine();
        ZsgsDB.getInstance().addLog(new TraineeLog(t.getId(), LocalDate.now().toString(), txt,"-","-","-",0,0));
        System.out.println("Saved!");
    }

    public void procrastination(Trainee t){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Procrastination Notes:");
        String txt=sc.nextLine();
        ZsgsDB.getInstance().addLog(new TraineeLog(t.getId(), LocalDate.now().toString(), "-",
                txt,"-","-",0,0));
        System.out.println("Saved!");
    }

    public void dailyTask(Trainee t){
        Scanner sc=new Scanner(System.in);
        System.out.print("Completed? (yes/no): "); String s=sc.nextLine();
        System.out.print("HR solved: "); int hr=Integer.parseInt(sc.nextLine());
        System.out.print("LC solved: "); int lc=Integer.parseInt(sc.nextLine());
        System.out.print("Reason if not completed: "); String r=sc.nextLine();

        ZsgsDB.getInstance().addLog(new TraineeLog(t.getId(), LocalDate.now().toString(),
                "-","-",s,r,hr,lc));
        System.out.println("Saved!");
    }
}
