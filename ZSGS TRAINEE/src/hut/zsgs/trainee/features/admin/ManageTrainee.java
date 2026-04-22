package hut.zsgs.trainee.features.admin;

import hut.zsgs.trainee.dto.Trainee;
import hut.zsgs.trainee.resposity.ZsgsDB;

import java.util.Scanner;

public class ManageTrainee {
    public void start(){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("\n=== MANAGE TRAINEES ===");
            System.out.println("1. Add Trainee");
            System.out.println("2. View Trainees");
            System.out.println("3. Back");
            int ch=sc.nextInt(); sc.nextLine();
            switch(ch){
                case 1 -> add(sc);
                case 2 -> ZsgsDB.getInstance().getTrainees().forEach(System.out::println);
                case 3 -> {
                    return;
                }
            }
        }
    }

    private void add(Scanner sc){
        System.out.print("ZSGS ID: "); String id=sc.nextLine();
        System.out.print("Name: "); String n=sc.nextLine();
        System.out.print("DOB: "); String dob=sc.nextLine();
        System.out.print("Phone: "); String ph=sc.nextLine();
        System.out.print("ZSGS Mail: "); String zm=sc.nextLine();
        System.out.print("Personal Mail: "); String pm=sc.nextLine();
        System.out.print("Username: "); String u=sc.nextLine();
        System.out.print("Password: "); String p=sc.nextLine();

        ZsgsDB.getInstance().addTrainee(
                new Trainee(id,n,dob,ph,zm,pm,u,p)
        );
        System.out.println("Added!");
    }
}
