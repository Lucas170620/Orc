package game.baralho.tipoCarta.montro;

import game.baralho.tipoCarta.Monstro;
import game.enums.TipoDeCarta;

public class Campeao extends Monstro {
    private int ataques;
    private int danoCausado;
    private int seguidoresMortos;
    private int subirDano;

    public Campeao(String nome,int mana,int poder , int vida) {
        super(nome,mana,poder,vida);
    }

    public void mostrarTipo(){
        System.out.println("\t\tCampeão");
    }

    public TipoDeCarta tipo() {
        return TipoDeCarta.CAMPEAO;
    }
}
