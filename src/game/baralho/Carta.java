package game.baralho;

import game.Efeito;
import game.Jogador;

import java.util.List;

public abstract class Carta{
    private String nome;
    private Jogador jogador;


    public Carta(String nome){
        this.nome = nome;
    }

    public abstract List<Efeito> realizarEfeito();

    public int mostrarPoder() {
        return 0;
    }

    public abstract boolean ehMonstro();
}
