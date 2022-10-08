package app1;

public class Reponse{
    String titre;
    boolean correct;
    Reponse(){}
    Reponse(String title,boolean isTrue){
        this.titre = title;
        this.correct = isTrue;
    }
    public String toString() {
        return this.titre+'\n';
    }
}
