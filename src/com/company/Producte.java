package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;

public class Producte extends AbstractProduct {
    private int codiProducte;
    private String nomProducte;
    private double preuProducte;
    private Familia familia;
    private ArrayList<OfertaProducte> ofertes = new ArrayList<>();
    private ArrayList<OfertaProducteVIP> ofertesVIP = new ArrayList<>();

    Producte(int codi, String nom, double preu, Familia fam){
        codiProducte=codi;
        nomProducte=nom;
        preuProducte=preu;
        familia = fam;
    }

    public Familia ObtenirFamilia(){
        return familia;
    }

    @Override
    public double ObtenirPreu() {
        return preuProducte;
    }

    public void afegirOferta(OfertaProducte o){
        ofertes.add(o);
    }

    public void afegirOfertaVIP(OfertaProducteVIP o){
        ofertesVIP.add(o);
    }

    public int getCodiProducte() {
        return codiProducte;
    }

    public String getNomProducte(){ return nomProducte; }

    // Pre: cert
    //Post: retorna la oferta vigent, si no nhi ha retorna null.
    public OfertaProducte BuscarOfertaVigent(Date avui){
        ListIterator<OfertaProducte> it = ofertes.listIterator();
        boolean trobat = false;
        OfertaProducte temp = null;
        while (it.hasNext() && !trobat){
            temp = it.next();
            trobat = temp.esVigent(avui);
        }
        return temp;
    }

    public OfertaProducteVIP BuscarOfertaVigentVIP(Date avui){
        ListIterator<OfertaProducteVIP> it = ofertesVIP.listIterator();
        boolean trobat = false;
        OfertaProducteVIP temp = null;
        while (it.hasNext() && !trobat){
            temp = it.next();
            trobat = temp.esVigent(avui);
        }
        return temp;
    }
}
