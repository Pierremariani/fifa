package com.example.demo1;

public class Card {

    private String nom;
    private Rarete rare;
    private String url;

    private String poste;

    private String natio;

    private String club;

    public Card(String nom, Rarete rare, String url, String poste, String natio, String club) {
        this.nom = nom;
        this.rare = rare;
        this.url = url;
        this.poste = poste;
        this.natio = natio;
        this.club = club;
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

    public void setRare(Rarete rare) {
        this.rare = rare;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
