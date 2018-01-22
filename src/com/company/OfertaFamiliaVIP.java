package com.company;

public class OfertaFamiliaVIP extends Oferta{
    private AbstractProduct prod;
    private Familia familia;
    private int descompte;

    public OfertaFamiliaVIP(AbstractProduct ap, Familia fam, int desc){
        prod=ap;
        familia=fam;
        descompte=desc;
    }

    @Override
    public int ObtenirPreu() {
        return descompte*prod.ObtenirPreu();
    }
}
