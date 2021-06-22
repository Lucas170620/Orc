package game.baralho.tipoCarta.montro;

import game.Traco;
import game.Mana;
import game.baralho.tipoCarta.Monstro;

import java.util.ArrayList;
import java.util.List;

public class Campeao extends Monstro{
    private String nome;
    private int ataques;
    private int danoCausado;
    private int seguidoresMortos;
    private int subirDano;

    public Campeao(String nome,int mana,int poder , int vida) {
        super(mana,poder,vida);
        this.nome = nome;
    }

    public void resumoCarta(){
        System.out.println("Nome da Carta: "+nome);
        System.out.println("Carta Tipo Campeão");
    }
}
