package game.baralho.tipoCarta.montro;

import game.Traco;
import game.Mana;
import game.baralho.tipoCarta.Monstro;

import java.util.ArrayList;
import java.util.List;

public class Campeao extends Monstro {
    private int ataques;
    private int danoCausado;
    private int seguidoresMortos;
    private int subirDano;

    public Campeao(String nome,int mana,int poder , int vida) {
        super(nome,mana,poder , vida);
    }
}
