package com.company;

public class Estoc {
    private int quant;

    private Producte prod;

    public Estoc(int quant, Producte prod) {
        this.quant = quant;
        this.prod = prod;
    }

    public void AfegirEstoc(int i){
        quant+=i;
    }

    public void AssignarEstoc(int i){
        quant=i;
    }

    public int Quantitat(){
        return quant;
    }
}
