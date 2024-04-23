package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Card {

    private String nom;
    private Rarete rare;
    private String url;

    private int poste;

    private String natio;
    @FXML
    ImageView pos;

    private String club;

    boolean onboard = false;

    int note;

    public Card(String nom, Rarete rare, String url, int poste, String natio, String club,int note) {
        this.nom = nom;
        this.rare = rare;
        this.url = url;
        this.poste = poste;
        this.natio = natio;
        this.club = club;
        this.note = note;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Rarete getRare() {
        return rare;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setRare(Rarete rare) {
        this.rare = rare;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPoste() {
        return poste;
    }

    public void setPoste(int poste) {
        this.poste = poste;
    }

    public String getNatio() {
        return natio;
    }

    public void setNatio(String natio) {
        this.natio = natio;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public boolean isOnboard() {
        return onboard;
    }

    public void setOnboard(boolean onboard) {
        this.onboard = onboard;
    }

    public ImageView getPos() {
        return pos;
    }

    public void setPos(ImageView pos) {
        this.pos = pos;
    }
}
