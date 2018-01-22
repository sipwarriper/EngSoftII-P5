package com.company;

public class OfertaFamilia extends Oferta{
    private AbstractProduct prod;
    private Familia familia;
    private int descompte;

    public OfertaFamilia(AbstractProduct ap, Familia fam, int desc){
        prod=ap;
        familia=fam;
        descompte=desc;
    }

    @Override
    public int ObtenirPreu() {
        return descompte*prod.ObtenirPreu();
    }
}
