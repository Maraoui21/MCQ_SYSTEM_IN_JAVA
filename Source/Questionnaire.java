package app1;
import app1.Question;

public class Questionnaire {
    protected String titre;
    protected Question qts[];
    Questionnaire(String title,Question tab[]){
        this.titre = title;
        this.qts = tab;
    }
    public String toString(){
        String txt ="";
        for(Question val:qts){
            txt += val.toString();
            txt+="\n";
        }
        return txt;
    }
}
