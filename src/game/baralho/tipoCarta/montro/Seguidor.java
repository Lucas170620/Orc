package game.baralho.tipoCarta.montro;

import game.Traco;
import game.Mana;
import game.baralho.tipoCarta.Monstro;
import game.enums.Tracos;

import java.util.ArrayList;
import java.util.List;

public class Seguidor extends Monstro {

    public Seguidor(String nome,int mana,int poder , int vida) {
        super(nome,mana,poder ,vida);
    }

    public void mostrarTipo(){
        System.out.println("Seguidor");
    }
}
