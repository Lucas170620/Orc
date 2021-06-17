package game.baralho.tipoCarta.montro;

import game.Traco;
import game.Mana;
import game.baralho.tipoCarta.Monstro;
import game.enums.Tracos;

import java.util.ArrayList;
import java.util.List;

public class Seguidor extends Monstro {
    private String nome;

    public Seguidor(String nome,int mana,int poder , int vida) {
        super(mana,poder , vida);
        this.nome = nome;
    }

    public void resumoCarta(){
        System.out.println("Nome da Carta: "+nome);
        System.out.println("Carta Tipo Seguidor");
    }
}
