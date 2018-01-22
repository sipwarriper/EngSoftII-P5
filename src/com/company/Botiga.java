package com.company;
import java.nio.channels.InterruptedByTimeoutException;
import java.util.*;

public class Botiga {
    private String ciutat;
    private String provincia;
    private String adreca;
    private int CP;

    private Map<Integer, Estoc> estoc;

    public Botiga(String ciutat, String provincia, String adreca, int CP) {
        this.ciutat = ciutat;
        this.provincia = provincia;
        this.adreca = adreca;
        this.CP = CP;
    }

    public void AfegirEstocBotiga(Producte prod, int quant){
        Estoc e=estoc.get(prod.getCodiProducte());
        if(e==null)e=InicialitzarEstoc(prod,quant);
        e.AfegirEstoc(quant);
    }

    public void TreureEstocBotiga(Producte prod, int quant){
        AfegirEstocBotiga(prod,-quant);
    }

    public void ModificarEstocBotiga(Producte prod, int quant){
        Estoc e=estoc.get(prod.getCodiProducte());
        if(e==null)e=InicialitzarEstoc(prod,quant);
        e.AssignarEstoc(quant);
    }

    public Estoc ConsultarEstocBotiga(Producte prod){
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
