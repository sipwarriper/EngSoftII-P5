package com.company;
import java.lang.reflect.Array;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.io.*;

public class Main {
    private static Date avui;
    private static Map<Integer,Producte> productes = new HashMap<>();
    private static Map<Integer,Familia> families = new HashMap<>();
    private static Botiga botiga;
    private static Magatzem magatzem;

    public static void main(String[] args) {

        inicialitzarPrograma();
        creacioFamilies();
        creacioProductes();
        creacioOfertes();

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        int opcio=0;

        System.out.println("Benvingut a la màquina d'auto-servei de Serveis Digui i Tal");

        while(opcio!=3){
            System.out.println("");
            System.out.println("Tria una opcio:");
            System.out.println("1-Generar llistat inventari");
            System.out.println("2-Passar per caixa");
            System.out.println("3-Sortir");
            opcio=reader.nextInt();

            if(opcio==1) {
                generarInventari();
            }
            else if(opcio==2){
                Carreto carr=new Carreto(avui,botiga);
                PassarPerCaixa(carr,reader,avui,productes);
            }
            else if(opcio==3){
                System.out.println("Adeu");
            }
            else{
                System.out.println("Opcio invalida");
            }
        }
        reader.close();
    }

    public static void PassarPerCaixa(Carreto carr, Scanner reader, Date data, Map<Integer,Producte> productes){
        int idproducte;
        Oferta oferta, ofertavip, ofertafamilia, ofertafamiliavip, milloroferta;
        ArrayList<Oferta> ofertes;
        int descompte, descomptevip, descomptefamilia, descomptefamiliavip, temp;
        double preu;
        Producte prod;
        Familia fam;

        do{
            System.out.print("Entra l'id del producte o -1 per acabar: ");
            idproducte=reader.nextInt();

            ofertes=new ArrayList<>();
            descomptefamilia=descomptefamiliavip=0;
            ofertafamilia=ofertafamiliavip=null;
            prod=productes.get(idproducte);
            if(prod==null){if(idproducte!=-1)System.out.println("Producte invalid");}
            else{
                preu=prod.ObtenirPreu();
                oferta=prod.BuscarOfertaVigent(data);
                ofertavip=prod.BuscarOfertaVigentVIP(data);
                fam=prod.ObtenirFamilia();
                if(fam!=null){
                    ofertafamilia=fam.BuscarOfertaVigent(data);
                    ofertafamiliavip=fam.BuscarOfertaVigentVIP(data);
                }
                ofertes.add(oferta);
                ofertes.add(ofertavip);
                ofertes.add(ofertafamilia);
                ofertes.add(ofertafamiliavip);
                milloroferta=BuscarMillorOferta(ofertes);
                carr.AfegirProducte(prod,milloroferta);
            }
        }while(idproducte!=-1);

        System.out.println("");
        System.out.println("Ticket:");
        System.out.println("Producte quantitat preu");
        System.out.println("");
        carr.Mostrar();
    }

    private static Oferta BuscarMillorOferta(ArrayList<Oferta> ofertes){
        int millordescompte=0;
        Oferta millor=null;
        for(Oferta o : ofertes)
            if(o!=null && o.getDescompte()>millordescompte){
                millordescompte=o.getDescompte();
                millor=o;
            }
        return millor;
    }

    public static void creacioFamilies(){
        String Linia;
        Familia temp;

        BufferedReader sFamilia = null;
        try {
            sFamilia = new BufferedReader(new FileReader("families.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (sFamilia != null){
            try{
                Linia = sFamilia.readLine();
                while (Linia!=null){
                    String [] data = Linia.split(" ");
                    int codi = Integer.parseInt(data[0]);
                    String nom = data[1].replaceAll("_", " ");
                    temp = new Familia(codi, nom);
                    families.put(codi, temp);
                    Linia = sFamilia.readLine();
                }
            } catch (java.io.IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void creacioProductes() {
        String Linia;
        Producte temp;

        BufferedReader sProductes = null;
        try {
            sProductes = new BufferedReader(new FileReader("productes.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (sProductes != null){
            try{
                Linia = sProductes.readLine();
                while (Linia!=null){
                    String [] data = Linia.split(" ");
                    int codiProducte = Integer.parseInt(data[0]);
                    int codiFamilia = Integer.parseInt(data[1]);
                    Familia ftemp = families.get(codiFamilia);
                    String nomProducte = data[2].replaceAll("_", " ");
                    int EstocBotiga = Integer.parseInt(data[3]);
                    int EstocMagatzem = Integer.parseInt(data[4]);
                    double preu = (Integer.parseInt(data[5]))/100.0;
                    temp = new Producte(codiProducte,nomProducte, preu, ftemp);
                    productes.put(codiProducte,temp);
                    botiga.AfegirEstocBotiga(temp,EstocBotiga);
                    magatzem.AfegirEstocMagatzem(temp,EstocMagatzem);
                    Linia = sProductes.readLine();
                }
            } catch (java.io.IOException e){
                e.printStackTrace();
            }
        }
    }

    public static Date convertirAData(String a){
        String [] data = a.split("-");
        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int any = Integer.parseInt(data[2]);
        LocalDate localDate = LocalDate.of(any,mes,dia);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return date;
    }

    public static void creacioOfertes(){
        String Linia;
        Familia temp;

        BufferedReader sOfertes = null;
        try {
            sOfertes = new BufferedReader(new FileReader("ofertes.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (sOfertes != null){
            try{
                Linia = sOfertes.readLine();
                while (Linia!=null){
                    String [] data = Linia.split(" ");
                    int tipus = Integer.parseInt(data[0]);
                    int ref = Integer.parseInt(data[1]);
                    Date inici = convertirAData(data[2]);
                    Date fi = convertirAData(data[3]);
                    int desc = Integer.parseInt(data[1]);
                    if (tipus == 1 || tipus == 3){//ofertes i ofertesVIP de producte
                        Producte p = productes.get(ref);
                        if (tipus==1) p.afegirOferta(new OfertaProducte(p,desc,inici, fi));
                        else  p.afegirOfertaVIP(new OfertaProducteVIP(p,desc,inici, fi));
                    }
                    else if (tipus == 0|| tipus == 2){//ofertes i ofertes VIP de familia
                        Familia f = families.get(ref);
                        if (tipus==0) f.afegirOferta(new OfertaFamilia(null,f,desc,inici,fi));
                        else  f.afegirOfertaVIP(new OfertaFamiliaVIP(null,f,desc,inici,fi));
                    }
                    Linia = sOfertes.readLine();
                }
            } catch (java.io.IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void inicialitzarPrograma(){
        String Linia;
        Magatzem mtemp;

        BufferedReader sAltres = null;
        try {
            sAltres = new BufferedReader(new FileReader("altres.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (sAltres != null){
            try{
                Linia = sAltres.readLine();
                String []data = Linia .split(" ");
                botiga = new Botiga(data[0].replaceAll("_"," "),data[1].replaceAll("_"," "),data[2].replaceAll("_"," "), Integer.parseInt(data[3]));
                Linia = sAltres.readLine();
                data = Linia .split(" ");
                magatzem = new Magatzem(data[0].replaceAll("_"," "),data[1].replaceAll("_"," "),data[2].replaceAll("_"," "), Integer.parseInt(data[3]));
                Linia = sAltres.readLine();
                avui = convertirAData(Linia);
            } catch (java.io.IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void generarInventari(){
        System.out.println(String.format("%-10s %-50s %15s %20s" , "Codi", "Article", "Botiga", "Magatzem"));
        for (Producte temp : productes.values()){
            int EstocBotiga=botiga.ConsultarEstocBotiga(temp);
            int EstocMagatzem=magatzem.ConsultarEstocMagatzem(temp);
            System.out.println(String.format("%-10d %-56s %9d %9s %9d %9s" , temp.getCodiProducte(), temp.getNomProducte(), EstocBotiga, "_____", EstocMagatzem, "_____"));
        }
    }
}
