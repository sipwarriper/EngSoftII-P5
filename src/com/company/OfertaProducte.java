package com.company;

import java.util.Date;

public class OfertaProducte extends Oferta{
    private AbstractProduct prod;
    private int descompte;
    private Date dataInici,dataFi;

    public OfertaProducte(AbstractProduct ap, int desc, Date inici, Date fi){
        prod=ap;
        descompte=desc;
        dataFi=fi;
        dataInici=inici;
    }

    @Override
    public int ObtenirPreu() {
        return descompte*prod.ObtenirPreu();
    }

    public boolean esVigent(Date avui){ return (avui.before(dataFi) && avui.after(dataInici));  }
}
