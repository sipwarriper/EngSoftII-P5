package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;

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
    public double ObtenirPreu() {
        return 0;
    }

    public void afegirOferta(Oferta o){
        ofertes.add(o);
    }

    // Pre: cert
    //Post: retorna la oferta vigent, si no nhi ha retorna null.
    public Oferta BuscarOfertaVigent(Date avui){
        ListIterator<Oferta> it = ofertes.listIterator();
        boolean trobat = false;
        Oferta temp = null;
        while (it.hasNext() && !trobat){
            temp = it.next();
            trobat = temp.esVigent(avui);
        }
        return temp;
    }
}
