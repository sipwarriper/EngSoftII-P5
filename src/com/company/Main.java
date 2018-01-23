package com.company;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

public class Main {
    private Date avui;
    private ArrayList<Producte> productes;
    private ArrayList<Familia> families;
    private Botiga botiga;
    private Magatzem magatzem;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        int opcio=0;

        System.out.println("Benvingut a la màquina d'auto-servei de Serveis Digui i Tal");
        System.out.println("");

        while(opcio!=3){
            System.out.println("Tria una opcio:");
            System.out.println("1-Generar llistat inventari");
            System.out.println("2-Passar per caixa");
            System.out.println("3-Sortir");
            opcio=reader.nextInt();

            if(opcio==1){

            }
            else if(opcio==2){
                PassarPerCaixa();
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
    public static void creacioFamilies(){

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
                    String nomProducte = data[2].replaceAll("_", " ");
                    int EstocBotiga = Integer.parseInt(data[3]);
                    int EstocMagatzem = Integer.parseInt(data[4]);
                    double preu = (Integer.parseInt(data[4]))/100.0;
                    temp = new Producte(codiProducte,nomProducte, preu);
                }

            } catch (java.io.IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void cracioOfertes(){

    }
    public static void inicialitzarPrograma(){

    }
    public static void PassarPerCaixa(){
        Carreto carr=new Carreto();
        
    }
}
