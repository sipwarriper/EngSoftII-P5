package com.company;

import java.util.Date;

public class OfertaFamiliaVIP extends Oferta{
    private Familia familia;

    public OfertaFamiliaVIP(AbstractProduct ap, Familia fam, int desc, Date inici, Date fi){
        prod=ap;
        familia=fam;
        descompte=desc;
        dataFi=fi;
        dataInici=inici;
    }

}
