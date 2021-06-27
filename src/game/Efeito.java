package game;

import game.enums.Efeitos;

public class Efeito {
    private Efeitos efeito;
    private int n ;
    private int m ;

    public Efeito(Efeitos efeito, int n , int m){
        this.efeito = efeito;
        this.n = n ;
        this.m = m ;
    }


    public Efeitos resolverEfeito(){
        return efeito;
    }

    public int n(){
        return n;
    }

    public int m(){
        return m;
    }

}
