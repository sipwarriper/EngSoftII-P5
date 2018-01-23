package com.company;

import java.util.Date;

public class OfertaFamilia extends Oferta{
    private Familia familia;

    public OfertaFamilia(AbstractProduct ap, Familia fam, int desc, Date inici, Date fi){
        prod=ap;
        familia=fam;
        descompte=desc;
        dataFi=fi;
        dataInici=inici;
    }

}
