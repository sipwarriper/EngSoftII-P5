package com.company;

import java.util.ArrayList;

public class Producte extends AbstractProduct {
    private int codiProducte;
    private String nomProducte;
    private int preuProducte;
    private Familia familia;
    private ArrayList<Oferta> ofertes;

    Producte(int codi, String nom, int preu){
        codiProducte=codi;
        nomProducte=nom;
        preuProducte=preu;
    }

    public Familia ObtenirFamilia(){
        return familia;
    }

    @Override
    public int ObtenirPreu() {
        return 0;
    }

    public void afegirOferta(Oferta o){
        ofertes.add(o);
    }

    public Oferta BuscarOfertaVigent(){

    }

    public int getCodiProducte() {
        return codiProducte;
    }
}
