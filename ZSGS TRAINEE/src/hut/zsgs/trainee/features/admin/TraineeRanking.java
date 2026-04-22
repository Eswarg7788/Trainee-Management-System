package hut.zsgs.trainee.features.admin;

import hut.zsgs.trainee.dto.Trainee;
import hut.zsgs.trainee.resposity.ZsgsDB;

import java.util.*;

public class TraineeRanking {
    public void show(){
        List<Trainee> list=new ArrayList<>(ZsgsDB.getInstance().getTrainees());
        list.sort((a,b)->b.getTotalSolved()-a.getTotalSolved());

        System.out.println("\n=== TRAINEE RANKING ===");
        int r=1;
        for(Trainee t:list){
            System.out.println(r++ + ". " + t.getName() + " | Total Solved: " + t.getTotalSolved());
        }
    }
}
