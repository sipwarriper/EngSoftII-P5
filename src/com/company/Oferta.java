package com.company;

import java.util.Date;

public abstract class Oferta extends AbstractProduct{
    protected AbstractProduct prod;
    protected int descompte;
    protected Date dataInici,dataFi;

    public int getDescompte() {
        return descompte;
    }

    public double ObtenirPreu() {
        return (descompte/100.0)*prod.ObtenirPreu();
    }

    public boolean esVigent(Date avui){ return (avui.before(dataFi) && avui.after(dataInici));  }
}
