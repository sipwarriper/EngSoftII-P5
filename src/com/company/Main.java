package com.company;
import java.util.Scanner;

public class Main {

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

    public static void PassarPerCaixa(){
        Carreto carr=new Carreto();
        
    }
}
