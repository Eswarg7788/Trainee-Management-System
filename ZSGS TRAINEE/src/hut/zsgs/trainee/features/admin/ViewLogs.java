package hut.zsgs.trainee.features.admin;

import hut.zsgs.trainee.resposity.ZsgsDB;

public class ViewLogs {
    public void show(){
        System.out.println("\n=== FULL LOGS ===");
        ZsgsDB.getInstance().getLogs().forEach(System.out::println);
    }
}
