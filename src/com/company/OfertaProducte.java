package com.company;

import java.util.Date;

public class OfertaProducte extends Oferta{

    public OfertaProducte(AbstractProduct ap, int desc, Date inici, Date fi){
        prod=ap;
        descompte=desc;
        dataFi=fi;
        dataInici=inici;
    }

}
