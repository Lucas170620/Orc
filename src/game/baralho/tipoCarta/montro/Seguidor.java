package game.baralho.tipoCarta.montro;

import game.baralho.tipoCarta.Monstro;
import game.enums.TipoDeCarta;

public class Seguidor extends Monstro {

    public Seguidor(String nome,int mana,int poder , int vida) {
        super(nome,mana,poder ,vida);
    }

    public void mostrarTipo(){
        System.out.println("Seguidor");
    }

    public TipoDeCarta tipo() {
        return TipoDeCarta.SEGUIDOR;
    }
}
