package com.company;

import java.util.*;

public class Carreto {
    private Date datacompra;
    private Botiga botiga;
    //private Magatzem magatzem;
    private Map<Integer, LiniaCarreto> liniacarreto=new TreeMap<>();

    public Carreto(Date data, Botiga b/*, Magatzem m*/){
        datacompra=data;
        botiga=b;
        //magatzem=m;
    }

    public void AfegirProducte(Producte prod, Oferta of){
        LiniaCarreto lc=liniacarreto.get(prod.getCodiProducte());
        if(lc==null){
            liniacarreto.put(prod.getCodiProducte(),new LiniaCarreto(this,prod,of));
            lc=liniacarreto.get(prod.getCodiProducte());
        }
        lc.AfegirQuantitat(1);
        botiga.TreureEstocBotiga(prod,1);
    }

    public void EliminarProducte(Producte prod){}

   public double ObtenirPreuTotal(){
        double res=0;
        for(LiniaCarreto lc : liniacarreto.values())
            res+=1;
        return res;
   }

   public void Mostrar(){
        for(LiniaCarreto lc : liniacarreto.values())
            lc.Mostrar();
   }

}
