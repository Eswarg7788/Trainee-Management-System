package hut.zsgs.trainee.features.admin;

import hut.zsgs.trainee.dto.TraineeLog;
import hut.zsgs.trainee.resposity.ZsgsDB;

import java.util.*;

public class ProblemSummary {
    public void show(){
        List<TraineeLog> logs=ZsgsDB.getInstance().getLogs();
        Map<String,int[]> map=new HashMap<>();

        for(TraineeLog l:logs){
            map.putIfAbsent(l.getTraineeId(),new int[]{0,0});
            map.get(l.getTraineeId())[0]+=l.getHR();
            map.get(l.getTraineeId())[1]+=l.getLC();
        }

        System.out.println("\n=== PROBLEM SUMMARY ===");
        map.forEach((id,a)->{
            System.out.println(id+" | HR:"+a[0]+" | LC:"+a[1]+" | Total:"+(a[0]+a[1]));
        });
    }
}
