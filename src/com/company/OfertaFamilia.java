package com.company;

import java.util.Date;

public class OfertaFamilia extends Oferta{
    private AbstractProduct prod;
    private Familia familia;
    private int descompte;
    private Date dataInici,dataFi;


    public OfertaFamilia(AbstractProduct ap, Familia fam, int desc, Date inici, Date fi){
        prod=ap;
        familia=fam;
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
