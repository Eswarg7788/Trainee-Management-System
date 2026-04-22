package hut.zsgs.trainee.features.login;

import hut.zsgs.trainee.features.dashboard.*;
import hut.zsgs.trainee.resposity.ZsgsDB;
import hut.zsgs.trainee.dto.Trainee;

import java.util.Scanner;

public class Login {
    public void start(){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("\n=== ZSGS LOGIN ===");
            System.out.println("1. Admin");
            System.out.println("2. Trainee");
            System.out.println("3. Exit");
            System.out.println("=== Choose Your Option ===");
            int ch=sc.nextInt(); sc.nextLine();
            switch(ch){
                case 1 -> admin(sc);
                case 2 -> trainee(sc);
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid");
            }
        }
    }

    private void admin(Scanner sc){
        System.out.print("Admin User: "); String u=sc.nextLine();
        System.out.print("Password: "); String p=sc.nextLine();
        if(u.equals("admin")&&p.equals("admin")) new AdminDashboard().start();
        else System.out.println("Invalid Admin");
    }

    private void trainee(Scanner sc){
        System.out.print("Username: "); String u=sc.nextLine();
        System.out.print("Password: "); String p=sc.nextLine();
        Trainee t=ZsgsDB.getInstance().findByUsername(u);
        if(t!=null && t.getPassword().equals(p)) new TraineeDashboard(t).start();
        else System.out.println("Invalid trainee login");
    }
}

