package com.duoc.primesecure.primelist;

import java.util.ArrayList;
import java.util.Collections;

public class PrimeList extends ArrayList<Integer>{

    public boolean isPrime(int numero){
        if(numero <= 1) return false;
        if(numero <= 3) return true;
        if(numero % 2 == 0 || numero % 3 == 0) return false;
        for (int i=5; i*i<=numero; i+=6){
            if(numero % i == 0 || numero % (i + 2) == 0) return false;
        }
        return true;
    }
    
    @Override
    public boolean add(Integer numero){
        if(!isPrime(numero)){
            throw new IllegalArgumentException("SOLO PUEDEN SER AGREGADOS NUMEROS PRIMOS");
        }
        return super.add(numero);
    }
    
    @Override
    public boolean remove(Object objeto){
        if(objeto instanceof Integer && isPrime((Integer) objeto)){
            return super.remove(objeto);
        }
        throw new IllegalArgumentException("SOLO PUEDEN SER ELIMINADOS NUMEROS PRIMOS.");
    }
    
    public int obtenerCantidadNumerosPrimos(){
        return this.size();
    }
    
    public void ordenarLista(){
        Collections.sort(this);
    }
}
