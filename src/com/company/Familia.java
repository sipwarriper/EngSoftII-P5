package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;

public class Familia {
    private int familia;
    private String nomfamilia;
    private ArrayList<OfertaFamilia> ofertes = new ArrayList<>();
    private ArrayList<OfertaFamiliaVIP> ofertesVIP = new ArrayList<>();

    Familia(int codi, String nom){
        familia = codi;
        nomfamilia=nom;
    }
    public void afegirOferta(OfertaFamilia o){
        ofertes.add(o);
    }
    public void afegirOfertaVIP(OfertaFamiliaVIP o){
        ofertesVIP.add(o);
    }


    // Pre: cert
    //Post: retorna la oferta vigent, si no nhi ha retorna null.
    public OfertaFamilia BuscarOfertaVigent(Date avui){
        ListIterator<OfertaFamilia> it = ofertes.listIterator();
        boolean trobat = false;
        OfertaFamilia temp = null;
        while (it.hasNext() && !trobat){
            temp = it.next();
            trobat = temp.esVigent(avui);
        }
        return temp;
    }

    public OfertaFamiliaVIP BuscarOfertaVigentVIP(Date avui){
        ListIterator<OfertaFamiliaVIP> it = ofertesVIP.listIterator();
        boolean trobat = false;
        OfertaFamiliaVIP temp = null;
        while (it.hasNext() && !trobat){
            temp = it.next();
            trobat = temp.esVigent(avui);
        }
        return temp;
    }

}
