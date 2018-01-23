package com.company;

import java.util.HashMap;
import java.util.Map;

public class Magatzem {
    private String ciutat;
    private String provincia;
    private String adreca;
    private int CP;

    private HashMap<Integer, Estoc> estoc = new HashMap<>();

    public Magatzem(String ciutat, String provincia, String adreca, int CP) {
        this.ciutat = ciutat;
        this.provincia = provincia;
        this.adreca = adreca;
        this.CP = CP;
    }

    public void AfegirEstocMagatzem(Producte prod, int quant){
        Estoc e=estoc.get(prod.getCodiProducte());
        if(e==null)e=InicialitzarEstoc(prod,quant);
        e.AfegirEstoc(quant);
    }

    public void TreureEstocMagatzem(Producte prod, int quant){
        AfegirEstocMagatzem(prod,-quant);
    }

    public void ModificarEstocMagatzem(Producte prod, int quant){
        Estoc e=estoc.get(prod.getCodiProducte());
        if(e==null)e=InicialitzarEstoc(prod,quant);
        e.AssignarEstoc(quant);
    }

    public Estoc ConsultarEstocMagatzem(Producte prod){
        Estoc e=estoc.get(prod.getCodiProducte());
        if(e==null)e=InicialitzarEstoc(prod,0);
        return e;
    }

    private Estoc InicialitzarEstoc(Producte prod, int quant){
        Estoc e = new Estoc(quant,prod);
        estoc.put(prod.getCodiProducte(),e);
        //Afegir estoc a llista de Producte?
        return e;
    }
}
