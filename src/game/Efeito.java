package game;

import game.enums.TodosEfeitos;

public class Efeito {
    private TodosEfeitos efeito;
    private int n ;
    private int m ;
    Efeito(TodosEfeitos efeito){
        this.efeito = efeito;
    }

    Efeito(TodosEfeitos efeito, int n , int m){
        this.efeito = efeito;
        this.n = n ;
        this.m = m ;
    }

    Efeito(TodosEfeitos efeito, int n){
        this.efeito = efeito;
        this.n = n ;
    }

    TodosEfeitos resolverEfeito(){
        return efeito;
    }

    int n(){
        return n;
    }

    int m(){
        return m;
    }

}
