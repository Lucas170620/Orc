package game.elementosMesa;

import game.Mana;
import game.baralho.Carta;
import game.baralho.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

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

    public Carta invocarCarta(Mana mana){
        Carta carta;
        List<Carta> maoDisponivel = new ArrayList();
        boolean verificador = true;
        Random random = new Random();
        for(Carta cartaDeck: mao){
            if(mana.verificarManaDisponivel(cartaDeck.mostrarMana())){
                maoDisponivel.add(cartaDeck);
            }
        }
        if(!maoDisponivel.isEmpty()){
            carta = mao.get(random.nextInt(mao.size()));
            return carta;
        }
        else throw new IllegalArgumentException("Nao tem carta com mana disponivel");

    }

    public void removerDaMao(Carta carta) {
        mao.remove(carta);
    }
}
