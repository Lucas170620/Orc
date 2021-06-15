package game.baralho.tipoCarta;

import game.baralho.Carta;
import game.Mana;

import java.util.ArrayList;
import java.util.List;

public class Seguidor extends Carta{
    private Mana mana = new Mana();
    private int vida ;
    private int poder;

    public Seguidor(String nome,int poder , int vida) {
        super(nome);
        this.vida = vida;
        this.poder = poder;
    }

}
