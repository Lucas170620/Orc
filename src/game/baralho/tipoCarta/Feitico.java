package game.baralho.tipoCarta;

import game.Efeito;
import game.baralho.Carta;
import game.Mana;
import game.enums.Efeitos;

import java.util.ArrayList;
import java.util.List;

public class Feitico extends Carta{

    public Feitico(String nome,int mana) {
        super(nome,mana);
    }

    @Override
    public boolean ehMonstro() {
        return false;
    }


    public void mostrarTipo(){
        System.out.println("Feitico");
    }
}
