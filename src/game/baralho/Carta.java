package game.baralho;

import game.Efeito;
import game.Jogador;
import game.Traco;
import game.enums.Efeitos;
import game.enums.Tracos;

import java.util.ArrayList;
import java.util.List;

public abstract class Carta{
    private String nome;
    private Jogador jogador;
    private List<Efeito> efeitos = new ArrayList();


    public Carta(String nome){
        this.nome = nome;
    }

    public List<Efeito> realizarEfeito(){
        return  efeitos;
    }

    public abstract boolean ehMonstro();

    public void adicionarEfeito(Efeitos efeito, int n, int m) {
        Efeito novoEfeito = new Efeito(efeito,n,m);
        efeitos.add(novoEfeito);
    }

    public int mostrarPoder(){
        return 0;
    }
}
