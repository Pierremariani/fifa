package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    ArrayList<Card> listeCard = new ArrayList<>();

    @FXML
    ImageView CardonScreen,anim;

    boolean getanim = false;

    int lastindex = 999;

    @FXML
    protected void onClickedButton() {
        boolean validate = false;
        Random random = new Random();
        int randomNumber;
        do {
            randomNumber = random.nextInt(listeCard.size()) + 0;
            if (listeCard.get(randomNumber).getRarete() == "epique") {
                if (getLuckEpique()) {
                    validate = true;
                    getanim = false;
                }
            }
            else if (listeCard.get(randomNumber).getRarete() == "legendaire") {
                if (getLucklegendaire()) {
                    validate = true;
                    getanim = true;
                }
            }
            else {
                validate = true;
                getanim = false;
            }
        } while (!validate && randomNumber == lastindex) ;
            if (getanim) {
                anim.setVisible(true);
                System.out.println("on montre anim");
            }
            else {
                anim.setVisible(false);
                System.out.println("pas d'anim");
            }
            System.out.println("Vous avez obtenu : " + listeCard.get(randomNumber).getNom());
            changeImageViewImg(CardonScreen, listeCard.get(randomNumber).getUrl());
            lastindex = randomNumber;
    }

    boolean getLuckEpique() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        if (randomNumber > 50) {
            return false;
        }
        return true;
    }

    boolean getLucklegendaire() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        if (randomNumber > 33) {
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //changeImageViewImg(imgFond,"background.jpeg");
        Card Miniou = new Card("Miniou" , "commun","miniou.png");
        Card Brahim = new Card("Brahim" ,"rare","brahim.png");
        Card Justin = new Card("Huang", "epique" , "justin.png");
        Card Lorenz = new Card("Bretzel","legendaire","bretzel.png");
        Card Laura = new Card("Madeleine","legendaire","madeleine.png");
        Card batman = new Card("batman", "commun","batman.png");
        Card pernet = new Card("Pernet","rare","pernet.png");
        Card Vigiw = new Card("Vigiw","legendaire","vigiw.png");
        Card tonton = new Card("Tonton","legendaire","tonton.png");
        Card thibault = new Card("Thibault", "commun","thibault.png");
        Card arthur = new Card("Arthur","commun","arthur.png");
        Card bryan = new Card("Bryan","commun","bryan.png");
        Card haitem = new Card("Haitem","epique","haitem.png");
        Card thoury = new Card("Thoury","legendaire","thoury.png");
        Card mariani = new Card("Mariani","legendaire","mariani.png");
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