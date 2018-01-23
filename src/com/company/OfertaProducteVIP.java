package com.company;
import java.util.Date;

public class OfertaProducteVIP extends Oferta{

    public OfertaProducteVIP(AbstractProduct ap, int desc, Date inici, Date fi){
        prod=ap;
        descompte=desc;
        dataFi=fi;
        dataInici=inici;
    }

}
