package com.company;

public class OfertaProducteVIP extends Oferta{
    private AbstractProduct prod;
    private int descompte;

    public OfertaProducteVIP(AbstractProduct ap, int desc){
        prod=ap;
        descompte=desc;
    }

    @Override
    public int ObtenirPreu() {
        return descompte*prod.ObtenirPreu();
    }
}
