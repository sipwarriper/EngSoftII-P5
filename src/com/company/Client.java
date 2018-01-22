package com.company;

public class Client {
    private String nom;
    private int numTarg;
    private boolean anonim;
    private int punts;
    //private Historic;

    Client(){}

    Client(String nomclient, int numTargeta){
        nom=nomclient;
        numTarg=numTargeta;
    }

    public boolean esanonim(){
        return anonim;
    }

    public void afegirCompra(Carreto carr){

    }

    public int ConsultarPunts(){
        return punts;
    }
}
