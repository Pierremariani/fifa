package com.example.demo1;

public class Rarete {
    int pourcentage;
    String type;

    public Rarete(int pourcentage, String type) {
        this.pourcentage = pourcentage;
        this.type = type;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
