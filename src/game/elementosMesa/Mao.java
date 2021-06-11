package game.elementosMesa;

import game.baralho.Carta;
import game.baralho.Deck;

import java.util.ArrayList;
import java.util.List;

public class Mao{
    private List<Carta> mao = new ArrayList();


    public void maoInicial(Deck deck){
        for (int i = 0 ; i < 4; i++) deck.topDeck(mao);
    }

    public void alterarCartas(Deck deck, int quantidade){
        for(int i = 0 ; i < quantidade ;i++){
            deck.adicionarCarta(mao.get(i));
            mao.remove(i);
            deck.topDeck(mao);
        }
    }
}
