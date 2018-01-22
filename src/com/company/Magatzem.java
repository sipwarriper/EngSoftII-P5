package com.company;
import java.util.*;

public class Magatzem {
    private String ciutat;
    private String provincia;
    private String adreca;
    private int CP;

    Map<Integer, Estoc> estoc;
    //ArrayList<Estoc> estoc;

    public Magatzem(String ciutat, String provincia, String adreca, int CP, ArrayList<Estoc> est) {
        this.ciutat = ciutat;
        this.provincia = provincia;
        this.adreca = adreca;
        this.CP = CP;
        estoc=est;
    }

    public void AfegirEstocMagatzem(Producte prod, int quant){

    }

    public void TreureEstocMagatzem(Producte prod, int quant){

    }

    public void ModificarEstocMagatzem(Producte prod, int diff){

    }

    public Estoc ConsultarEstocMagatzem(Producte prod){
        Estoc res=null;
        res=estoc.get(prod.getCodiProducte());
        return res;
    }

}
