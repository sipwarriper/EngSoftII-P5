package com.company;

public class Producte extends AbstractProduct {
    private int codiProducte;
    private String nomProducte;
    private int preuProducte;

    private Familia familia;

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

    public Oferta BuscarOfertaVigent(){

    }
}
