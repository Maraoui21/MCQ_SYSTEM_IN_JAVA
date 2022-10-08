package app1;
import app1.Reponse;

import java.util.Arrays;

public class Question {
    String titre;
    String description;
    Reponse reps[];
    float score;
    public String toString(){
        String txt = this.titre +"\n"
//                "\n"+description+"\n"+
                ;
        for (Reponse val:reps) {
            txt+= " -> "+val.titre+"\n";
        }
        return txt;
    }
    Question(){}
    Question(String title,String details,Reponse arr[],float Quota) {
        this.titre = title;
//        this.description = details;
        this.reps = arr;
        this.score = Quota;
    }
}
