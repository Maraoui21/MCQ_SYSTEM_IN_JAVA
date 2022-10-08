package app1;
import app1.*;
import java.util.Scanner;
public class Application {
    static Scanner scan = new Scanner(System.in);
    static void Menu(){
        System.out.println("=========================================");
        System.out.println("1-Repondre a un questionnaire par defaut.");
        System.out.println("2-Creer un nouveau questionnaire.");
        System.out.println("=========================================");
    }
    static Questionnaire DefaultQcmContent(){
        // qts1
        Reponse ResQ1[] = new Reponse[3];
        ResQ1[0] = new Reponse("1) rabat",true);
        ResQ1[1] = new Reponse("2) agadir",false);
        ResQ1[2] = new Reponse("3) casablanca",false);
        // qts2
        Reponse ResQ2[] = new Reponse[3];
        ResQ2[0] = new Reponse("1) 5",false);
        ResQ2[1] = new Reponse("2) 7",false);
        ResQ2[2] = new Reponse("3) 2",true);
        // qts3
        Reponse ResQ3[] = new Reponse[3];
        ResQ3[0] = new Reponse("1) 25M",false);
        ResQ3[1] = new Reponse("2) 7M",false);
        ResQ3[2] = new Reponse("3) 40M",true);
        // qts4
        Reponse ResQ4[] = new Reponse[3];
        ResQ4[0] = new Reponse("1) oriente objet",false);
        ResQ4[1] = new Reponse("2) structee",true);
        ResQ4[2] = new Reponse("3) les deux",false);
        // qts5
        Reponse ResQ5[] = new Reponse[3];
        ResQ5[0] = new Reponse("1) Maroc",false);
        ResQ5[1] = new Reponse("2) Algerie",true);
        ResQ5[2] = new Reponse("3) tunsie",false);

        Question Qst[] = new Question[5];
        Qst[0] = new Question("capitale de maroc ?","none",ResQ1,10);
        Qst[1] = new Question("Resultat de 1+1 ?","none",ResQ2,20);
        Qst[2] = new Question("le nombre des habitants de maroc ?","none",ResQ3,30);
        Qst[3] = new Question("c est un langage...","none",ResQ4,15);
        Qst[4] = new Question("le grande pays de l'afrique ?","none",ResQ5,25);

        Questionnaire Questionnaire1 = new Questionnaire("qst1",Qst);
        return  Questionnaire1;
    }
    static Questionnaire NewQcm(String QcmTitle){
        Question arr[]= new Question[2];
        for(int i=0;i<2;i++){
            System.out.println("Entrer la question "+(i+1)+":");
            String QuestionTitle = scan.nextLine();
            System.out.println("Entrer le score de la question:");
            float ScoreNum = scan.nextFloat();
            scan.nextLine();
            arr[i] = new Question();
            arr[i].titre = QuestionTitle;
            arr[i].score = ScoreNum;
            arr[i].reps = new Reponse[3];
            for(int j=0;j<3;j++){
                System.out.println("Reponse "+(j+1)+":");
                boolean isValid = true;
                String qtRep = scan.nextLine();
                System.out.println("cette reponse est correct ? (1-oui/0-non)");
                while(isValid){
                    String InputStr = scan.nextLine();
                    try {
                        int num = Integer.parseInt(InputStr);
                        Boolean isTrue=(num!=0);
                        arr[i].reps[j] = new Reponse((j+1)+") "+qtRep,isTrue);
                        isValid = false;
                    }catch(NumberFormatException e){
                        System.out.println("choisir 1 pour oui et 0 pour non !!!!");
                    }
                }


            }
        }
        Questionnaire toReturn = new Questionnaire(QcmTitle,arr);
        return toReturn;
    }
    static void ResponseToQcm(Questionnaire QCM){
        float score=0;
        for(int i=0;i<QCM.qts.length;i++){
            System.out.println(QCM.qts[i]);
            System.out.println("Votre Reponse?");
            int rep =scan.nextInt();
            if(rep>3 || rep<1){
                System.out.println("votre reponse est incorrect saisir le num de reponse");
                i--;
            }else{
                if(QCM.qts[i].reps[rep-1].correct==true){
                    score+=QCM.qts[i].score;
                }
            }
        }
        System.out.println("================================");
        System.out.println("Votre score final est --> "+score+"%");
        System.out.println("================================");
    }
    public static void main(String[] args) {
        int left=1;
        while (left==1) {
            Menu();
            System.out.println("Enter votre choix");
            int choix = scan.nextInt();
            Questionnaire CreatedQcm;
            switch (choix) {
                case 1:
                    ResponseToQcm(DefaultQcmContent());
                    break;
                case 2:
                    System.out.println("ENTRER LE TITRE DE QCM");
                    String title = scan.nextLine();
                    scan.nextLine();
                    CreatedQcm = NewQcm(title);
                    System.out.println("Tu veux repondre a ce Questionnaire ?(1-oui/0-Non)");
                    boolean canRep = (scan.nextInt() != 0);
                    if (canRep) {
                        ResponseToQcm(CreatedQcm);
                    } else {
                        System.out.println("Au Revoir");
                    }
                    ;
                    break;
                default:
                    System.out.println("something wrong bro");
                    break;
            }
            System.out.println("repeter?(1-oui/0-non)");
            left = scan.nextInt();
        }
    }
}




