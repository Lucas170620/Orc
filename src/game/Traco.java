package game;

import game.enums.Efeitos;
import game.enums.Tracos;

public class Traco {
    private Tracos traco;
    private int n ;
    private int m ;
    Traco(Tracos traco){
        this.traco = traco;
    }

    public Traco(Tracos traco, int n, int m){
        this.traco = traco;
        this.n = n ;
        this.m = m ;
    }

    Traco(Tracos traco, int n){
        this.traco = traco;
        this.n = n ;
    }

    Tracos resolverTraco(){
        return traco;
    }

    int n(){
        return n;
    }

    int m(){
        return m;
    }
}
