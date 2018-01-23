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
        return oferta.ObtenirPreu()*quantitat;
    }

    public void Mostrar(){
        System.out.println(prod.getNomProducte()+" "+quantitat+" "+ObtenirPreu());
    }
    //public int obtenirQuantitat(Producte prod){}

    //public Oferta obtenirOferta(Producte prod){} //retorna int o oferta?
}
