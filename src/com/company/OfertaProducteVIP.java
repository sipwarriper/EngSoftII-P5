package com.company;
import java.util.Date;

public class OfertaProducteVIP extends Oferta{
    private AbstractProduct prod;
    private int descompte;
    private Date dataInici,dataFi;

    public OfertaProducteVIP(AbstractProduct ap, int desc, Date inici, Date fi){
        prod=ap;
        descompte=desc;
        dataFi=fi;
        dataInici=inici;
    }

    @Override
    public double ObtenirPreu() {
        return (descompte/100.0)*prod.ObtenirPreu();
    }
    @Override
    public boolean esVigent(Date avui){ return (avui.before(dataFi) && avui.after(dataInici));  }
}
