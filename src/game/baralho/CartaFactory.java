package game.baralho;

import game.baralho.tipoCarta.Campeao;
import game.baralho.tipoCarta.Feitico;
import game.baralho.tipoCarta.Seguidor;
import game.enums.TipoDeCarta;

import java.util.List;

public class CartaFactory{
    public static Carta criarCarta(TipoDeCarta tipoDeCarta,String nome,int mana,int poder , int vida){
        switch (tipoDeCarta){
            case CAMPEAO:
                return new Campeao(nome,mana,poder,vida);
            case FEITICO:
                return new Feitico(nome,mana);
            case SEGUIDOR:
                return new Seguidor(nome,mana,poder,vida);
            default:
                throw new IllegalArgumentException("Não Existe este tipo de carta");
        }
    }

}
