package com.company;

import java.util.Date;

public abstract class Oferta extends AbstractProduct{
    public boolean esVigent(Date avui) {
        return false;
    }
}
