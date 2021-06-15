package game.baralho;

import game.Jogador;
import game.elementosMesa.CampoDeBatalha;
import game.elementosMesa.Nexus;
import game.elementosMesa.ZonaMonstro;
import game.enums.Efeitos;
import game.enums.Tracos;

import java.util.ArrayList;
import java.util.List;

public class Carta{
    private String nome;
    private Jogador jogador;


    public Carta(String nome){
        this.nome = nome;
    }

    public Carta(String nome,Efeitos efeito){
        this.nome = nome;
    }

    public Carta(String nome,Efeitos efeito, Tracos traco){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
