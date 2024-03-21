package com.example.demo1;

public class Card {

    private String nom;
    private String Rarete;
    private String url;

    public Card(String nom, String rarete, String url) {
        this.nom = nom;
        Rarete = rarete;
        this.url = url;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRarete() {
        return Rarete;
    }

    public void setRarete(String rarete) {
        Rarete = rarete;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
