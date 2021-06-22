package game.elementosMesa;

import game.Mana;
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

    public void topDeck(Deck deck) {
        deck.topDeck(mao);
    }

    public void mostrarMao(){
        for (Carta carta:mao){
            carta.resumoCarta();
        }
    }

    public Carta invocarCarta(String nome, Mana mana){
        for(Carta carta:mao){
            if(carta.vericarNome(nome)){
                if(mana.verificarManaDisponivel(carta.mostrarMana())){
                    mao.remove(carta);
                    return carta;
                }
                else{
                    throw new IllegalArgumentException("Nao Há mana disponivel");
                }
            }
        }
        throw new IllegalArgumentException("Carta Não está na sua mao");
    }
}
