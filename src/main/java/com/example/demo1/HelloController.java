package com.example.demo1;

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
    ArrayList<Card> listeCard = new ArrayList<>();

    @FXML
    ImageView CardonScreen,anim,backgroundopening,backgrounddraft,gkimage,dd,dcd,dcg,dg,mg,mc,md,ag,bu,ad,esteanimation,chat,show1,show2,show3,show4,show5,show6,show7,show8,show9,show10,show11;

    @FXML
    Button buttonopening,buttongk,buttondd,buttondcg,buttondcd,buttondg,buttonmg,buttonmc,buttonmd,buttonag,buttonbu,buttonad;

    @FXML
    TextField tfgk,tfdcd,tfdcg,tfdd,tfdg,tfmg,tfmc,tfmd,tfag,tfbu,tfad;

    @FXML
    ImageView currentpos;

    ArrayList<Card> listeEpic = new ArrayList<>();

    ArrayList<Card> listeCommun = new ArrayList<>();

    ArrayList<Card> listeRare = new ArrayList<>();

    ArrayList<Card> listeLegendaire = new ArrayList<>();

    ArrayList<Card> listeUltra = new ArrayList<>();

    ArrayList<Card> PlayerCard = new ArrayList<>();

    Card board[] = new Card[11];

    int numpos = 99;



    boolean getanim = false;

    boolean getanimultra = false;

    int nb = 0;

    int lastindex = 999;

    @FXML
    protected void onClickedButton() {
        boolean validate = false;
        Random random = new Random();
        int randomNumber;
        int r;
        randomNumber = random.nextInt(100) + 0;
        String result = getLuck(randomNumber);
            if (nb > 10) {
                changeGame();
            }
            else {
                if (result == "epique") {
                    r = random.nextInt(listeEpic.size()) + 0;
                    getanim = true;
                    getanimultra = false;
                    changeImageViewImg(CardonScreen, listeEpic.get(r).getUrl());
                    PlayerCard.add(listeEpic.get(r));
                } else if (result == "legendaire") {
                    r = random.nextInt(listeLegendaire.size()) + 0;
                    getanim = true;
                    getanimultra = false;
                    changeImageViewImg(CardonScreen, listeLegendaire.get(r).getUrl());
                    PlayerCard.add(listeLegendaire.get(r));
                } else if (result == "rare") {
                    r = random.nextInt(listeRare.size()) + 0;
                    getanim = false;
                    getanimultra = false;
                    changeImageViewImg(CardonScreen, listeRare.get(r).getUrl());
                    PlayerCard.add(listeRare.get(r));
                }
                else if (result == "ultra") {
                    r = random.nextInt(listeUltra.size()) + 0;
                    getanim = true;
                    getanimultra = true;
                    changeImageViewImg(CardonScreen, listeUltra.get(r).getUrl());
                    PlayerCard.add(listeUltra.get(r));
                }
                else {
                    r = random.nextInt(listeCommun.size()) + 0;
                    getanim = false;
                    getanimultra = false;
                    changeImageViewImg(CardonScreen, listeCommun.get(r).getUrl());
                    PlayerCard.add(listeCommun.get(r));
                }
                if (getanim) {
                    anim.setVisible(true);
                    System.out.println("on montre anim");
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
        System.out.println("image 9 cliquée");
        changeImageViewImg(currentpos, PlayerCard.get(8).getUrl());
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(8);
    }

    @FXML
    protected void show8clicked() {
        System.out.println("image 8 cliquée");
        changeImageViewImg(currentpos, PlayerCard.get(7).getUrl());
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(7);
    }

    @FXML
    protected void show7clicked() {
        System.out.println("image 7 cliquée");
        changeImageViewImg(currentpos, PlayerCard.get(6).getUrl());
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(6);
    }


    @FXML
    protected void show6clicked() {
        System.out.println("image 6 cliquée");
        changeImageViewImg(currentpos, PlayerCard.get(5).getUrl());
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(5);
    }


    @FXML
    protected void show5clicked() {
        System.out.println("image 5 cliquée");
        changeImageViewImg(currentpos, PlayerCard.get(4).getUrl());
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(4);
    }

    @FXML
    protected void show4clicked() {
        System.out.println("image 4 cliquée");
        changeImageViewImg(currentpos, PlayerCard.get(3).getUrl());
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(3);
    }


    @FXML
    protected void show11clicked() {
        System.out.println("image 11 cliquée");
        changeImageViewImg(currentpos, PlayerCard.get(10).getUrl());
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(10);
    }

    @FXML
    protected void show10clicked() {
        System.out.println("image 10 cliquée");
        changeImageViewImg(currentpos, PlayerCard.get(9).getUrl());
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(9);
    }

    @FXML
    protected void show3clicked() {
        System.out.println("image 3 cliquée");
        changeImageViewImg(currentpos, PlayerCard.get(2).getUrl());
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(2);
    }

    @FXML
    protected void show2clicked() {
        System.out.println("image 2 cliquée");
        changeImageViewImg(currentpos, PlayerCard.get(1).getUrl());
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(1);
    }

    @FXML
    protected void show1clicked() {
        System.out.println("image 1 cliquée");
        changeImageViewImg(currentpos, PlayerCard.get(0).getUrl());
        hideEveryImage();
        showButton();
        board[numpos] = PlayerCard.get(0);
    }



    @FXML
    protected void gkclicked() {
        //changeImageViewImg(gkimage,PlayerCard.get(Integer.parseInt(tfgk.getText())).getUrl());
        showEveryImage();
        buttongk.setVisible(false);
        tfgk.setVisible(false);
        gkimage.setVisible(true);
        currentpos = gkimage;
        hideButton();
        numpos = 0;
    }

    @FXML
    protected void dcdclicked() {
        showEveryImage();

        //changeImageViewImg(dcd,PlayerCard.get(Integer.parseInt(tfdcd.getText())).getUrl());
        buttondcd.setVisible(false);
        tfdcd.setVisible(false);
        dcd.setVisible(true);
        currentpos = dcd;
        hideButton();
        numpos = 3;

    }

    @FXML
    protected void mgclicked() {
        showEveryImage();
        currentpos = mg;
        //changeImageViewImg(mg,PlayerCard.get(Integer.parseInt(tfmg.getText())).getUrl());
        buttonmg.setVisible(false);
        tfmg.setVisible(false);
        mg.setVisible(true);
        hideButton();
        numpos = 5;

    }

    @FXML
    protected void mcclicked() {
        showEveryImage();
        currentpos = mc;
        //changeImageViewImg(mc,PlayerCard.get(Integer.parseInt(tfmc.getText())).getUrl());
        buttonmc.setVisible(false);
        tfmc.setVisible(false);
        mc.setVisible(true);
        hideButton();
        numpos = 6;

    }

    @FXML
    protected void mdclicked() {
        showEveryImage();
        currentpos = md;
        //changeImageViewImg(md,PlayerCard.get(Integer.parseInt(tfmd.getText())).getUrl());
        buttonmd.setVisible(false);
        tfmd.setVisible(false);
        md.setVisible(true);
        hideButton();
        numpos = 7;

    }

    @FXML
    protected void agclicked() {
        showEveryImage();
        currentpos = ag;
        //changeImageViewImg(ag,PlayerCard.get(Integer.parseInt(tfag.getText())).getUrl());
        buttonag.setVisible(false);
        tfag.setVisible(false);
        ag.setVisible(true);
        hideButton();
        numpos = 8;

    }

    @FXML
    protected void buclicked() {
        showEveryImage();
        currentpos = bu;
        //changeImageViewImg(bu,PlayerCard.get(Integer.parseInt(tfbu.getText())).getUrl());
        buttonbu.setVisible(false);
        tfbu.setVisible(false);
        bu.setVisible(true);
        hideButton();
        numpos = 9;

    }

    @FXML
    protected void adclicked() {
        showEveryImage();
        currentpos = ad;
        //changeImageViewImg(ad,PlayerCard.get(Integer.parseInt(tfad.getText())).getUrl());
        buttonad.setVisible(false);
        tfad.setVisible(false);
        ad.setVisible(true);
        hideButton();
        numpos = 10;

    }

    @FXML
    protected void dcgclicked() {
        showEveryImage();
        currentpos = dcg;
        //changeImageViewImg(dcg,PlayerCard.get(Integer.parseInt(tfdcg.getText())).getUrl());
        buttondcg.setVisible(false);
        tfdcg.setVisible(false);
        dcg.setVisible(true);
        hideButton();
        numpos = 2;

    }

    @FXML
    protected void dgclicked() {
        showEveryImage();
        currentpos = dg;
        //changeImageViewImg(dg,PlayerCard.get(Integer.parseInt(tfdg.getText())).getUrl());
        buttondg.setVisible(false);
        tfdg.setVisible(false);
        dg.setVisible(true);
        hideButton();
        numpos = 1;

    }

    @FXML
    protected void ddclicked() {
        showEveryImage();
        currentpos = dd;
        //changeImageViewImg(dd,PlayerCard.get(Integer.parseInt(tfdd.getText())).getUrl());
        buttondd.setVisible(false);
        tfdd.setVisible(false);
        dd.setVisible(true);
        hideButton();
        numpos = 4;

    }

    public int getCollectif() {
        return 0;
    }

    String getLuck(int randomNumber) {
        System.out.println(randomNumber);
        if (randomNumber < 46) {
            return "commun";
        }
        else if (randomNumber < 71) {
            return "rare";
        }
        else if (randomNumber < 91) {
            return "epique";
        }
        else if (randomNumber < 96){
            return "legendaire";
        }
        else {
            return "ultra";
        }
    }

    public void changeGame() {
        CardonScreen.setVisible(false);
        anim.setVisible(false);
        esteanimation.setVisible(false);
        chat.setVisible(false);
        backgroundopening.setVisible(false);
        backgrounddraft.setVisible(true);
        buttonopening.setVisible(false);
        /*
        tfgk.setVisible(true);
        tfdcd.setVisible(true);
        tfdd.setVisible(true);
        tfdcg.setVisible(true);
        tfdg.setVisible(true);
        tfad.setVisible(true);
        tfag.setVisible(true);
        tfbu.setVisible(true);
        tfmc.setVisible(true);
        tfmd.setVisible(true);
        tfmg.setVisible(true);

         */
        buttongk.setVisible(true);

        //showhand.setVisible(true);
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
        //changeImageViewImg(imgFond,"background.jpeg");
        Card Miniou = new Card("Miniou" , commun,"miniou.png","all","fr","real");
        Card Brahim = new Card("Brahim" ,rare,"brahim.png","ad","maroc","real");
        Card Justin = new Card("Huang", epique , "justin.png","bu","chine","real");
        Card Lorenz = new Card("Bretzel",legendaire,"bretzel.png","dc","gua","city");
        Card Laura = new Card("Madeleine",legendaire,"madeleine.png","gk","port","clev");
        Card batman = new Card("batman", commun,"batman.png","ag","fr","ac");
        Card pernet = new Card("Pernet",rare,"pernet.png","mc","br","ac");
        Card Vigiw = new Card("Vigiw",legendaire,"vigiw.png","all","fr","monaco");
        Card tonton = new Card("Tonton",legendaire,"tonton.png","dg","sen","united");
        Card thibault = new Card("Thibault", commun,"thibault.png","md","fr","barca");
        Card arthur = new Card("Arthur",commun,"arthur.png","dd","fr","psg");
        Card bryan = new Card("Bryan",commun,"bryan.png","all","congo","frank");
        Card haitem = new Card("Haitem",epique,"haitem.png","bu","fr","psg");
        Card thoury = new Card("Thoury",legendaire,"thoury.png","dc","fr","nantes");
        Card mariani = new Card("Mariani",legendaire,"mariani.png","all","ita","psg");
        Card mamadou = new Card("Mamadou",commun,"mamadou.png","mc","br","real");
        Card mohammed = new Card ("Mohammed",commun,"mohammed.png","dg","arg","ars");
        Card leutrim = new Card("Leutrim", legendaire,"leutrim.png","mc","alba","truk");
        Card ultraesteban = new Card("UltraEsteban",ultra,"ultraesteban.png","all","belge","real");
        Card ultravirgil = new Card("ultravirgil" , ultra,"ultravirgil.png","all","fr","ac");
        Card yousri = new Card("yousri",epique,"yousri.png","dg","japon","barca");
        Card wallace = new Card("wallace",ultra,"wallace.png","all","fr","new");
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