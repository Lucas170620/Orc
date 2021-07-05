package game.baralho.tipoCarta;

import game.baralho.Carta;
import game.enums.TipoDeCarta;

public class Feitico extends Carta{

    public Feitico(String nome,int mana) {
        super(nome,mana);
    }

//    public List<Efeito> realizarEfeito(){
//        return efeitos;
//    }

    @Override
    public boolean ehMonstro() {
        return false;
    }


    public void mostrarTipo(){
        System.out.println("Feitico");
    }

    @Override
    public TipoDeCarta tipo() {
        return TipoDeCarta.FEITICO;
    }
}
