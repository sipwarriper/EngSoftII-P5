package com.company;

public class OfertaProducte extends Oferta{
    private AbstractProduct prod;
    private int descompte;

    public OfertaProducte(AbstractProduct ap, int desc){
        prod=ap;
        descompte=desc;
    }

    @Override
    public int ObtenirPreu() {
        return descompte*prod.ObtenirPreu();
    }
}
