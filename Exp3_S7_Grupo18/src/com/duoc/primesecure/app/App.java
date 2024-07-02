package com.duoc.primesecure.app;

import com.duoc.primesecure.primelist.PrimeList;
import com.duoc.primesecure.utilitarios.Utilitarios;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App{
    static PrimeList listadoNumerosPrimos = new PrimeList();
    
    public static void main(String[] args){
        menuPrincipal();
    }
    
    static void menuPrincipal(){
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        
        Utilitarios.limpiaPantalla();
        
        try{
            do{
                System.out.println("--- BIENVENIDO A PRIMESECURE ---");
                System.out.println("  - GESTION DE NUMERO PRIMOS -");
                System.out.println("");
                System.out.println("SELECCIONE UNA OPCION:");
                System.out.println("[1] AGREGAR NUMERO A LA LISTA");
                System.out.println("[2] ELIMINAR NUMERO DE LA LISTA");
                System.out.println("[3] LISTAR NUMEROS EN LA LISTA");
                System.out.println("[4] IMPRIMIR CANTIDAD DE NUMEROS EN LA LISTA");
                System.out.println("[5] SALIR");
                opcion = teclado.nextInt();
                if(opcion < 1 || opcion > 5){
                    Utilitarios.limpiaPantalla();
                    System.out.println("-- LA OPCION ("+opcion+") NO ES VALIDA --");
                    System.out.println("");
                }
            }while(opcion < 1 || opcion > 5);
        }catch(InputMismatchException e){
            Utilitarios.limpiaPantalla();
            System.out.println("ERROR: LA OPCION INGRESADA NO ES UN NUMERO");
            System.out.println("");
            menuPrincipal();
        }
        
        if(opcion == 1){
            Utilitarios.limpiaPantalla();
            int numero = pedirNumero("AGREGAR");
            if(!listadoNumerosPrimos.contains(numero)){
                try{
                    listadoNumerosPrimos.add(numero);
                    Utilitarios.limpiaPantalla();
                    System.out.println("EL NUMERO "+numero+" FUE AGREGADO A LA LISTA");
                }catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }else{
                System.out.println("ERROR: EL NUMERO "+numero+" YA ESTA EN LA LISTA");
            }
            System.out.println("");
            System.out.println("Presione ENTER para continuar...");
            teclado.nextLine(); teclado.nextLine();
            menuPrincipal();
        }
        
        if(opcion == 2){
            Utilitarios.limpiaPantalla();
            int numero = pedirNumero("ELIMINAR");
            if(listadoNumerosPrimos.contains(numero)){
                try{
                    listadoNumerosPrimos.remove(Integer.valueOf(numero));
                    Utilitarios.limpiaPantalla();
                    System.out.println("EL NUMERO "+numero+" FUE ELIMINADO DE LA LISTA");
                }catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }else{
                System.out.println("ERROR: EL NUMERO "+numero+" NO ESTA EN LA LISTA");
            }
            System.out.println("");
            System.out.println("Presione ENTER para continuar...");
            teclado.nextLine(); teclado.nextLine();
            menuPrincipal();
        }
        
        if(opcion == 3){
            Utilitarios.limpiaPantalla();
            listadoNumerosPrimos.ordenarLista();
            System.out.println("EL LISTADO DE NUMEROS PRIMOS ES:");
            for(int i=0; i<listadoNumerosPrimos.size(); i++){
                if(i > 0) System.out.print(", ");
                System.out.print(listadoNumerosPrimos.get(i));
            }
            System.out.println("");
            System.out.println("Presione ENTER para continuar...");
            teclado.nextLine(); teclado.nextLine();
            menuPrincipal();
        }
        
        if(opcion == 4){
            Utilitarios.limpiaPantalla();
            int cantidadNumeroEnLista = listadoNumerosPrimos.obtenerCantidadNumerosPrimos();
            String unidad = (cantidadNumeroEnLista == 1)? "NUMERO PRIMO" : "NUMEROS PRIMOS";    
            System.out.print("LA CANTIDAD DE NUMEROS PRIMOS EN LA LISTA ES DE "+cantidadNumeroEnLista+" "+unidad);
            System.out.println("");
            System.out.println("Presione ENTER para continuar...");
            teclado.nextLine(); teclado.nextLine();
            menuPrincipal();
        }
        
        if(opcion == 5){
            Utilitarios.limpiaPantalla();
            System.out.println("GRACIAS POR USAR LA GESTION DE NUMEROS PRIMOS DE PRIMESECURE");
        }
    }
    
    static int pedirNumero(String mensaje){
        Scanner teclado = new Scanner(System.in);
        int numero = 0;
        
        Utilitarios.limpiaPantalla();
        
        try{
            do{
                System.out.println("INGRESE UN NUMERO PARA "+mensaje+" DE LA LISTA");
                numero = teclado.nextInt();
                if(numero < 1){
                    Utilitarios.limpiaPantalla();
                    System.out.println("-- EL NUMERO DEBE SER MAYOR A UNO (1) --");
                    System.out.println("");
                }
            }while(numero < 1);
        }catch(InputMismatchException e){
            Utilitarios.limpiaPantalla();
            System.out.println("ERROR: LA OPCION INGRESADA NO ES UN NUMERO");
            System.out.println("");
            menuPrincipal();
        }
        return numero;
    }
}
