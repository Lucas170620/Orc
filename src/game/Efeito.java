package game;

import game.enums.Efeitos;

public class Efeito {
    private Efeitos efeito;
    private int n ;
    private int m ;
    Efeito(Efeitos efeito){
        this.efeito = efeito;
    }

    Efeito(Efeitos efeito, int n , int m){
        this.efeito = efeito;
        this.n = n ;
        this.m = m ;
    }

    Efeito(Efeitos efeito, int n){
        this.efeito = efeito;
        this.n = n ;
    }

    Efeitos resolverEfeito(){
        return efeito;
    }

    int n(){
        return n;
    }

    int m(){
        return m;
    }

}
