package com.company;

public class LiniaCarreto {
    private Producte prod;
    private int quantitat;
    private Oferta oferta;
    private Carreto carr;

    public LiniaCarreto(Carreto c, Producte p, Oferta o){
        carr=c;
        prod=p;
        oferta=o;
        quantitat=0;
    }

    public void AfegirQuantitat(int q){
        quantitat+=q;
    }

    public double ObtenirPreu(){
        double of=1;
        if(oferta!=null)of=oferta.ObtenirPreu();
        return of*quantitat;
    }

    public void Mostrar(){
        System.out.println(prod.getNomProducte()+" "+quantitat+" "+ObtenirPreu());
    }

}
