package com.example.demo1;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    Label collectif,note,openinglabel;

    @FXML
    ArrayList<Card> listeCard = new ArrayList<>();

    @FXML
    ImageView CardonScreen,anim,backgroundopening,backgrounddraft,gkimage,dd,dcd,dcg,dg,mg,mc,md,ag,bu,ad,esteanimation,chat,show1,show2,show3,show4,show5,show6,show7,show8,show9,show10,show11,loading,packfiesta;

    @FXML
    Button nextbutton,buttongk,buttondd,buttondcg,buttondcd,buttondg,buttonmg,buttonmc,buttonmd,buttonag,buttonbu,buttonad,buttonsimulation;

    @FXML
    ImageView currentpos,goldpack;

    ArrayList<Card> listeEpic = new ArrayList<>();

    ArrayList<Card> listeCommun = new ArrayList<>();

    ArrayList<Card> listeRare = new ArrayList<>();

    ArrayList<Card> listeLegendaire = new ArrayList<>();

    ArrayList<Card> listeUltra = new ArrayList<>();

    ArrayList<Card> PlayerCard = new ArrayList<>();

    ArrayList<String> QuartEquipe = new ArrayList<>();
    ArrayList<String> DemiEquipe = new ArrayList<>();

    ArrayList<String> FinalEquipe = new ArrayList<>();



    Card board[] = new Card[11];

    int numpos = 99;

    boolean fiesta = false;



    boolean getanim = false;

    boolean getanimultra = false;

    int nb = 0;

    int lastindex = 999;

    @FXML
    protected void simulationclicked() {
        int scoremoi = 0;
        int scoreennemi = 0;
        Random random = new Random();
        int randomNumber = random.nextInt(QuartEquipe.size());
        System.out.println("L'équipe que nous aller affronter en Quart de Final sera : "+QuartEquipe.get(randomNumber));
        int random10min = random.nextInt(2);
        int random10Def;
        if (random10min == 1) {
            random10min = random.nextInt(10)+1;
            System.out.println("Offensive de : "+PlayerCard.get(random10min).getNom());
            if (getNote() + getCollectif() > 155) {
                scoremoi++;
                System.out.println("BUT !!");
            }
            else {
                System.out.println("ballon contrer");
            }
        }
        else {
            System.out.println("Offensive ennemie");
            random10Def = random.nextInt(3);
            if (random10Def == 1) {
                System.out.println("But Ennemi");
                scoreennemi++;
            }
            else {
                int rand10minGK = random.nextInt(2);
                if (rand10minGK == 1) {
                    System.out.println("arret de "+board[0].getNom());
                }
                else {
                    int randDefenseur = random.nextInt(4);
                    System.out.println("Ballon défendu par "+board[randDefenseur]);
                }
            }
        }
    }

    @FXML
    protected void onnextclicked() {
        tirage();
    }
    @FXML
    protected void ongoldpackclicked() {
        hideoppening();
        tirage();
    }

    public boolean StartGame() {
        boolean oui = true;
        for (int i = 0 ; i < board.length; i++) {
            if (board[i] == null) {
                oui = false;
            }
        }
        if (oui) {
            buttonsimulation.setVisible(true);
        }
        return oui;
    }

    @FXML
    protected void packfiestaclicked() {
        fiesta = true;
        hideoppening();
        tirage();
    }

    protected void hideoppening() {
        openinglabel.setVisible(false);
        goldpack.setVisible(false);
        packfiesta.setVisible(false);
        CardonScreen.setVisible(true);
        nextbutton.setVisible(true);
    }

    @FXML
    protected void tirage() {
        boolean validate = false;
        Random random = new Random();
        int randomNumber;
        int r = 0;
        randomNumber = random.nextInt(100) + 0;
        String result = getLuck(randomNumber);
            if (nb > 10) {
                changeGame();
            }
            else {
                if (result == "epique" && !listeEpic.isEmpty()) {
                    r = random.nextInt(listeEpic.size()) + 0;
                    getanim = true;
                    getanimultra = false;
                    changeImageViewImg(CardonScreen, listeEpic.get(r).getUrl());
                    PlayerCard.add(listeEpic.get(r));
                    listeEpic.remove(listeEpic.get(r));
                } else if (result == "legendaire" && !listeLegendaire.isEmpty()) {
                    r = random.nextInt(listeLegendaire.size()) + 0;
                    getanim = true;
                    getanimultra = false;
                    changeImageViewImg(CardonScreen, listeLegendaire.get(r).getUrl());
                    PlayerCard.add(listeLegendaire.get(r));
                    listeLegendaire.remove(listeLegendaire.get(r));
                } else if (result == "rare" && !listeRare.isEmpty()) {
                    r = random.nextInt(listeRare.size()) + 0;
                    getanim = false;
                    getanimultra = false;
                    changeImageViewImg(CardonScreen, listeRare.get(r).getUrl());
                    PlayerCard.add(listeRare.get(r));
                    listeRare.remove(listeRare.get(r));
                }
                else if (result == "ultra" && !listeUltra.isEmpty()) {
                    r = random.nextInt(listeUltra.size()) + 0;
                    getanim = true;
                    getanimultra = true;
                    changeImageViewImg(CardonScreen, listeUltra.get(r).getUrl());
                    PlayerCard.add(listeUltra.get(r));
                    listeUltra.remove(listeUltra.get(r));
                }
                else {
                    boolean yes = true;
                    while(yes) {
                        r = random.nextInt(listeCommun.size()) + 0;
                        if (listeCommun.get(r).getUrl() != null) {
                            yes = false;
                        }
                    }
                    getanim = false;
                    getanimultra = false;
                    changeImageViewImg(CardonScreen, listeCommun.get(r).getUrl());
                    PlayerCard.add(listeCommun.get(r));
                    listeCommun.remove(listeCommun.get(r));
                }
                if (getanim) {
                    anim.setVisible(true);
                } else {
                    anim.setVisible(false);
                }
                if (getanimultra) {
                    esteanimation.setVisible(true);
                    chat.setVisible(true);
                }
                else {
                    esteanimation.setVisible(false);
                    chat.setVisible(false);
                }
                lastindex = r;
                nb++;
            }
    }

    @FXML
    protected void showEveryImage() {
        show1.setVisible(true);
        show2.setVisible(true);
        show3.setVisible(true);
        show4.setVisible(true);
        show5.setVisible(true);
        show6.setVisible(true);
        show7.setVisible(true);
        show8.setVisible(true);
        show9.setVisible(true);
        show10.setVisible(true);
        show11.setVisible(true);
        changeImageViewImg(show1,PlayerCard.get(0).getUrl());
        changeImageViewImg(show2,PlayerCard.get(1).getUrl());
        changeImageViewImg(show3,PlayerCard.get(2).getUrl());
        changeImageViewImg(show4,PlayerCard.get(3).getUrl());
        changeImageViewImg(show5,PlayerCard.get(4).getUrl());
        changeImageViewImg(show6,PlayerCard.get(5).getUrl());
        changeImageViewImg(show7,PlayerCard.get(6).getUrl());
        changeImageViewImg(show8,PlayerCard.get(7).getUrl());
        changeImageViewImg(show9,PlayerCard.get(8).getUrl());
        changeImageViewImg(show10,PlayerCard.get(9).getUrl());
        changeImageViewImg(show11,PlayerCard.get(10).getUrl());
    }

    @FXML
    protected void hideEveryImage() {
        show1.setVisible(false);
        show2.setVisible(false);
        show3.setVisible(false);
        show4.setVisible(false);
        show5.setVisible(false);
        show6.setVisible(false);
        show7.setVisible(false);
        show8.setVisible(false);
        show9.setVisible(false);
        show10.setVisible(false);
        show11.setVisible(false);
    }

    @FXML
    protected void show9clicked() {
        if (PlayerCard.get(8).isOnboard()) {
            if (PlayerCard.get(8).getPos() != currentpos) {
                PlayerCard.get(8).getPos().setVisible(false);
                changeImageViewImg(PlayerCard.get(8).getPos(),"loading.png");
                PlayerCard.get(8).getPos().setVisible(false);            }
        }
        changeImageViewImg(currentpos, PlayerCard.get(8).getUrl());
        currentpos.setVisible(true);
        PlayerCard.get(8).setOnboard(true);
            PlayerCard.get(8).setPos(currentpos);
            hideEveryImage();
            showButton();
            board[numpos] = PlayerCard.get(8);
            collectif.setText("Collectif : "+getCollectif());
            note.setText("Note générale : "+getNote());
            StartGame();
    }

    @FXML
    protected void show8clicked() {
        if (PlayerCard.get(7).isOnboard()) {
            if (PlayerCard.get(7).getPos() != currentpos) {
                PlayerCard.get(7).getPos().setVisible(false);
            }
        }
        changeImageViewImg(currentpos, PlayerCard.get(7).getUrl());
        currentpos.setVisible(true);
        PlayerCard.get(7).setOnboard(true);
        PlayerCard.get(7).setPos(currentpos);
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(7);
        collectif.setText("Collectif : "+getCollectif());
        note.setText("Note générale : "+getNote());
        StartGame();
    }

    @FXML
    protected void show7clicked() {
        if (PlayerCard.get(6).isOnboard()) {
            if (PlayerCard.get(6).getPos() != currentpos) {
                PlayerCard.get(6).getPos().setVisible(false);
            }
        }
        changeImageViewImg(currentpos, PlayerCard.get(6).getUrl());
        currentpos.setVisible(true);
        PlayerCard.get(6).setOnboard(true);
        PlayerCard.get(6).setPos(currentpos);
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(6);
        collectif.setText("Collectif : "+getCollectif());
        note.setText("Note générale : "+getNote());
        StartGame();
    }


    @FXML
    protected void show6clicked() {
        if (PlayerCard.get(5).isOnboard()) {
            if (PlayerCard.get(5).getPos() != currentpos) {
                PlayerCard.get(5).getPos().setVisible(false);
            }
        }
        changeImageViewImg(currentpos, PlayerCard.get(5).getUrl());
        currentpos.setVisible(true);
        PlayerCard.get(5).setOnboard(true);
        PlayerCard.get(5).setPos(currentpos);
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(5);
        collectif.setText("Collectif : "+getCollectif());
        note.setText("Note générale : "+getNote());
        StartGame();
    }


    @FXML
    protected void show5clicked() {
        if (PlayerCard.get(4).isOnboard()) {
            if (PlayerCard.get(4).getPos() != currentpos) {
                PlayerCard.get(4).getPos().setVisible(false);
            }
        }
        changeImageViewImg(currentpos, PlayerCard.get(4).getUrl());
        currentpos.setVisible(true);
        PlayerCard.get(4).setOnboard(true);
        PlayerCard.get(4).setPos(currentpos);
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(4);
        collectif.setText("Collectif : "+getCollectif());
        note.setText("Note générale : "+getNote());
        StartGame();
    }

    @FXML
    protected void show4clicked() {
        if (PlayerCard.get(3).isOnboard()) {
            if (PlayerCard.get(3).getPos() != currentpos) {
                PlayerCard.get(3).getPos().setVisible(false);
            }
        }
        changeImageViewImg(currentpos, PlayerCard.get(3).getUrl());
        currentpos.setVisible(true);
        PlayerCard.get(3).setOnboard(true);
        PlayerCard.get(3).setPos(currentpos);
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(3);
        collectif.setText("Collectif : "+getCollectif());
        note.setText("Note générale : "+getNote());
        StartGame();
    }

    @FXML
    protected void show11clicked() {
        if (PlayerCard.get(10).isOnboard()) {
            if (PlayerCard.get(10).getPos() != currentpos) {
                PlayerCard.get(10).getPos().setVisible(false);
            }
        }
        changeImageViewImg(currentpos, PlayerCard.get(10).getUrl());
        currentpos.setVisible(true);
        PlayerCard.get(10).setOnboard(true);
        PlayerCard.get(10).setPos(currentpos);
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(10);
        collectif.setText("Collectif : "+getCollectif());
        note.setText("Note générale : "+getNote());
        StartGame();
    }

    @FXML
    protected void show10clicked() {
        if (PlayerCard.get(9).isOnboard()) {
            if (PlayerCard.get(9).getPos() != currentpos) {
                PlayerCard.get(9).getPos().setVisible(false);
            }
        }
        changeImageViewImg(currentpos, PlayerCard.get(9).getUrl());
        currentpos.setVisible(true);
        PlayerCard.get(9).setOnboard(true);
        PlayerCard.get(9).setPos(currentpos);
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(9);
        collectif.setText("Collectif : "+getCollectif());
        note.setText("Note générale : "+getNote());
        StartGame();
    }

    @FXML
    protected void show3clicked() {
        if (PlayerCard.get(2).isOnboard()) {
            if (PlayerCard.get(2).getPos() != currentpos) {
                PlayerCard.get(2).getPos().setVisible(false);
            }
        }
        changeImageViewImg(currentpos, PlayerCard.get(2).getUrl());
        currentpos.setVisible(true);
        PlayerCard.get(2).setOnboard(true);
        PlayerCard.get(2).setPos(currentpos);
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(2);
        collectif.setText("Collectif : "+getCollectif());
        note.setText("Note générale : "+getNote());
        StartGame();
    }

    @FXML
    protected void show2clicked() {
        if (PlayerCard.get(1).isOnboard()) {
            if (PlayerCard.get(1).getPos() != currentpos) {
                PlayerCard.get(1).getPos().setVisible(false);
            }
        }
        changeImageViewImg(currentpos, PlayerCard.get(1).getUrl());
        currentpos.setVisible(true);
        PlayerCard.get(1).setOnboard(true);
        PlayerCard.get(1).setPos(currentpos);
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(1);
        collectif.setText("Collectif : "+getCollectif());
        note.setText("Note générale : "+getNote());
        StartGame();
    }

    @FXML
    protected void show1clicked() {
        if (PlayerCard.get(0).isOnboard()) {
            if (PlayerCard.get(0).getPos() != currentpos) {
                PlayerCard.get(0).getPos().setVisible(false);
            }
        }
        changeImageViewImg(currentpos, PlayerCard.get(0).getUrl());
        currentpos.setVisible(true);
        PlayerCard.get(0).setOnboard(true);
        PlayerCard.get(0).setPos(currentpos);
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(0);
        collectif.setText("Collectif : "+getCollectif());
        note.setText("Note générale : "+getNote());
        StartGame();
    }

    public int isOnCase(int i) {
        if (board[i] != null) {
            for (int j = 0 ; j < PlayerCard.size(); j++) {
                 if (PlayerCard.get(j).getNom() == board[i].getNom()) {
                     return j;
                 }
            }
        }
        return 99;
    }

    public String showBoard() {
        String s="";
        for (int i = 0 ; i < board.length; i++) {
            if (board[i] == null ) {
                s+= " null ";
            }
            else {
                s+= board[i].getNom()+" ";
            }
        }
        return s;
    }

    public void verifydoublon(int d ) {
        for (int i = 0 ; i < board.length;i++) {
            if (board[i] != null && d != i ) {
                if (board[i].getNom().equals(board[d].getNom())) {
                    board[d] = null;
                    System.out.println("doublon supprimé");
                    System.out.println(board[i]);
                }
            }
        }
        System.out.println(showBoard());
    }

    @FXML
    protected void gkclicked() {
        showEveryImage();
        buttongk.setVisible(false);
        currentpos = gkimage;
        hideButton();
        numpos = 0;
        collectif.setText("Collectif : "+getCollectif());
    }

    protected void testOnCase(int i) {
        if (isOnCase(i) != 99) {
            PlayerCard.get(isOnCase(i)).getPos().setVisible(false);
            PlayerCard.get(isOnCase(i)).setOnboard(false);
            PlayerCard.get(isOnCase(i)).setPos(null);
        }
        verifydoublon(i);
    }

    @FXML
    protected void dcdclicked() {
        showEveryImage();
        buttondcd.setVisible(false);
        currentpos = dcd;
        hideButton();
        numpos = 3;
        collectif.setText("Collectif : "+getCollectif());
    }

    @FXML
    protected void mgclicked() {
        showEveryImage();
        currentpos = mg;
        buttonmg.setVisible(false);
        hideButton();
        numpos = 5;
        collectif.setText("Collectif : "+getCollectif());
    }

    @FXML
    protected void mcclicked() {
        showEveryImage();
        currentpos = mc;
        buttonmc.setVisible(false);
        hideButton();
        numpos = 6;
        collectif.setText("Collectif : "+getCollectif());
    }

    @FXML
    protected void mdclicked() {
        showEveryImage();
        currentpos = md;
        buttonmd.setVisible(false);
        hideButton();
        numpos = 7;
        collectif.setText("Collectif : "+getCollectif());
    }

    @FXML
    protected void agclicked() {
        showEveryImage();
        currentpos = ag;
        buttonag.setVisible(false);
        hideButton();
        numpos = 8;
        collectif.setText("Collectif : "+getCollectif());
    }

    @FXML
    protected void buclicked() {
        showEveryImage();
        currentpos = bu;
        buttonbu.setVisible(false);
        hideButton();
        numpos = 9;
        collectif.setText("Collectif : "+getCollectif());
    }

    @FXML
    protected void adclicked() {
        showEveryImage();
        currentpos = ad;
        buttonad.setVisible(false);
        hideButton();
        numpos = 10;
        collectif.setText("Collectif : "+getCollectif());
    }

    @FXML
    protected void dcgclicked() {
        showEveryImage();
        currentpos = dcg;
        buttondcg.setVisible(false);
        hideButton();
        numpos = 2;
        collectif.setText("Collectif : "+getCollectif());
    }

    @FXML
    protected void dgclicked() {
        showEveryImage();
        currentpos = dg;
        buttondg.setVisible(false);
        hideButton();
        numpos = 1;
        collectif.setText("Collectif : "+getCollectif());
    }

    @FXML
    protected void ddclicked() {
        showEveryImage();
        currentpos = dd;
        buttondd.setVisible(false);
        hideButton();
        numpos = 4;
    }

    public int getCollectif() {
        int total = 0;
        for (int i = 0 ; i < board.length;i++) {
            if (i != 0) {
                if (board[i] != null && board[i-1] != null) {
                    if (board[i - 1].getNatio() == board[i].getNatio()) {
                        total += 5;
                    }
                    if (board[i - 1].getClub() == board[i].getClub()) {
                        total += 10;
                    }
                }
            }
            if (board[i] != null) {
                if (board[i].getPoste() == i || board[i].getPoste() == 99) {
                    total += 5;
                }
                if (board[i].getPoste() == 2 && i == 3) {
                    total+=5;
                }
            }
        }
        if (total > 100) {
            return 100;
        }
        else {
            return total;
        }
    }

    public int getNote() {
        double total = 0;
        int nb=0;
        for (int i = 0; i < board.length; i++) {
            if (board[i] != null) {
                total += board[i].getNote();
                nb++;
            }
        }
        return (int)total/nb;
    }

    String getLuck(int randomNumber) {
        if (!fiesta) {
            if (randomNumber < 46) {
                return "commun";
            } else if (randomNumber < 71) {
                return "rare";
            } else if (randomNumber < 91) {
                return "epique";
            } else if (randomNumber < 96) {
                return "legendaire";
            } else {
                return "ultra";
            }
        }
        else {
            if (randomNumber < 26) {
                return "commun";
            } else if (randomNumber < 41) {
                return "rare";
            } else if (randomNumber < 61) {
                return "epique";
            } else if (randomNumber < 86) {
                return "legendaire";
            } else {
                return "ultra";
            }
        }
    }

    public void changeGame() {
        CardonScreen.setVisible(false);
        anim.setVisible(false);
        esteanimation.setVisible(false);
        chat.setVisible(false);
        backgroundopening.setVisible(false);
        backgrounddraft.setVisible(true);
        goldpack.setVisible(false);
        nextbutton.setVisible(false);
        buttongk.setVisible(true);
        buttondcd.setVisible(true);
        buttondcg.setVisible(true);
        buttondd.setVisible(true);
        buttondg.setVisible(true);
        packfiesta.setVisible(false);
        buttonad.setVisible(true);
        buttonag.setVisible(true);
        buttonbu.setVisible(true);
        buttonmc.setVisible(true);
        buttonmd.setVisible(true);
        buttonmg.setVisible(true);
        collectif.setVisible(true);
        note.setVisible(true);
        showCard();
    }

    @FXML
    public void hideButton() {
        buttondcd.setVisible(false);
        buttondcg.setVisible(false);
        buttondd.setVisible(false);
        buttondg.setVisible(false);
        buttonad.setVisible(false);
        buttonag.setVisible(false);
        buttonbu.setVisible(false);
        buttonmc.setVisible(false);
        buttonmd.setVisible(false);
        buttonmg.setVisible(false);
        buttongk.setVisible(false);
    }

    public void showButton() {
        buttondcd.setVisible(true);
        buttondcg.setVisible(true);
        buttondd.setVisible(true);
        buttondg.setVisible(true);
        buttonad.setVisible(true);
        buttonag.setVisible(true);
        buttonbu.setVisible(true);
        buttonmc.setVisible(true);
        buttonmd.setVisible(true);
        buttonmg.setVisible(true);
        buttongk.setVisible(true);
    }

    public void showCard() {
        String s="";
        for (int i = 0 ; i < PlayerCard.size();i++) {
            s+=PlayerCard.get(i).getNom()+" "+i+" ";
            System.out.println(i+" "+PlayerCard.get(i).getNom());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Rarete commun = new Rarete(45,"commun");
        Rarete rare = new Rarete(25,"rare");
        Rarete epique = new Rarete(20,"epique");
        Rarete legendaire = new Rarete(10,"legendaire");
        Rarete ultra = new Rarete(4,"ultra");
        Card Miniou = new Card("Miniou" , commun,"miniou.png",99,"fr","real",80);
        Card Brahim = new Card("Brahim" ,rare,"brahim.png",10,"maroc","real",85);
        Card Justin = new Card("Huang", epique , "justin.png",9,"chine","real",88);
        Card Lorenz = new Card("Bretzel",legendaire,"bretzel.png",2,"gua","city",94);
        Card Laura = new Card("Madeleine",legendaire,"madeleine.png",0,"port","clev",91);
        Card batman = new Card("batman", commun,"batman.png",8,"fr","ac",86);
        Card pernet = new Card("Pernet",rare,"pernet.png",6,"br","ac",87);
        Card Vigiw = new Card("Vigiw",legendaire,"vigiw.png",99,"fr","monaco",96);
        Card tonton = new Card("Tonton",legendaire,"tonton.png",1,"sen","united",92);
        Card thibault = new Card("Thibault", commun,"thibault.png",7,"fr","barca",81);
        Card arthur = new Card("Arthur",commun,"arthur.png",4,"fr","psg",84);
        Card bryan = new Card("Bryan",commun,"bryan.png",99,"congo","frank",75);
        Card haitem = new Card("Haitem",epique,"haitem.png",9,"fr","psg",89);
        Card thoury = new Card("Thoury",legendaire,"thoury.png",2,"fr","nantes",99);
        Card mariani = new Card("Mariani",legendaire,"mariani.png",99,"ita","psg",97);
        Card mamadou = new Card("Mamadou",commun,"mamadou.png",6,"br","real",81);
        Card mohammed = new Card ("Mohammed",commun,"mohammed.png",1,"arg","ars",83);
        Card leutrim = new Card("Leutrim", legendaire,"leutrim.png",6,"alba","truk",90);
        Card ultraesteban = new Card("UltraEsteban",ultra,"ultraesteban.png",99,"belge","real",93);
        Card ultravirgil = new Card("ultravirgil" , ultra,"ultravirgil.png",99,"fr","ac",98);
        Card yousri = new Card("yousri",epique,"yousri.png",1,"japon","barca",89);
        Card wallace = new Card("wallace",ultra,"wallace.png",99,"fr","new",90);
        Card fares = new Card("fares",ultra,"fares.png",6,"alge","ajax",92);
        Card val = new Card("Val",epique,"val.png",0,"ita","ac",88);
        Card tomleg = new Card("tomleg",legendaire,"tomleg.png",99,"anglais","united",95);
        Card haitemleg = new Card("haitemleg",legendaire,"haitemleg.png",99,"fr","psg",94);
        Card alex = new Card("alex",commun,"alex.png",4,"port","porto",82);
        Card yannis = new Card("yannis",epique,"Yannis.png",7,"fr","psg",90);
        listeEpic.add(yannis);
        listeCommun.add(alex);
        listeLegendaire.add(haitemleg);
        listeLegendaire.add(tomleg);
        listeEpic.add(val);
        listeUltra.add(fares);
        listeUltra.add(wallace);
        listeEpic.add(yousri);
        listeUltra.add(ultraesteban);
        listeUltra.add(ultravirgil);
        listeEpic.add(Justin);
        listeEpic.add(haitem);
        listeLegendaire.add(leutrim);
        listeLegendaire.add(Lorenz);
        listeLegendaire.add(Laura);
        listeLegendaire.add(Vigiw);
        listeLegendaire.add(tonton);
        listeLegendaire.add(thoury);
        listeLegendaire.add(mariani);
        listeCommun.add(mamadou);
        listeCommun.add(mohammed);
        listeCommun.add(Miniou);
        listeCommun.add(batman);
        listeCommun.add(thibault);
        listeCommun.add(arthur);
        listeCommun.add(bryan);
        listeRare.add(Brahim);
        listeRare.add(pernet);
        listeCard.add(Miniou);
        listeCard.add(Brahim);
        listeCard.add(Justin);
        listeCard.add(Lorenz);
        listeCard.add(Laura);
        listeCard.add(batman);
        listeCard.add(pernet);
        listeCard.add(Vigiw);
        listeCard.add(tonton);
        listeCard.add(thibault);
        listeCard.add(arthur);
        listeCard.add(bryan);
        listeCard.add(haitem);
        listeCard.add(thoury);
        listeCard.add(mariani);
        QuartEquipe.add("Milan AC");
        QuartEquipe.add("Dortmund");
        QuartEquipe.add("Arsenal");
        QuartEquipe.add("Seville");
        DemiEquipe.add("Chelsea");
        DemiEquipe.add("Atletico Madrid");
        DemiEquipe.add("Juventus");
        DemiEquipe.add("Leipzig");
        FinalEquipe.add("Paris");
        FinalEquipe.add("Manchester City");
        FinalEquipe.add("Real Madrid");
        FinalEquipe.add("Bayern Munich");
    }

    public void changeImageViewImg(ImageView imgView, String linkImage){
        imgView.setImage(
                new Image(
                        getClass().getResource(
                                "/images/"+linkImage
                        ).toExternalForm()
                )
        );
    }
}