package game;

import game.baralho.Carta;
import game.baralho.Deck;
import game.elementosMesa.Mao;

import java.util.ArrayList;

public class Jogador{
    private Deck deck = new Deck();
    private Mao mao = new Mao();

    public Jogador(){
        deckPrincpal();
    }

    void deckPrincpal(){
        Carta hero = new Carta("Teferi");
        Carta narset = new Carta("Narset");
        Carta counter = new Carta("memory lapse");
        Carta brain = new Carta("brainstorm");
        Carta saw= new Carta("Saw it crow");

        deck.adicionarCarta(hero);
        deck.adicionarCarta(hero);
        deck.adicionarCarta(hero);
        deck.adicionarCarta(hero);
        deck.adicionarCarta(narset);
        deck.adicionarCarta(narset);
        deck.adicionarCarta(narset);
        deck.adicionarCarta(narset);
        deck.adicionarCarta(brain);
        deck.adicionarCarta(brain);
        deck.adicionarCarta(brain);
        deck.adicionarCarta(brain);
        deck.adicionarCarta(counter);
        deck.adicionarCarta(counter);
        deck.adicionarCarta(counter);
        deck.adicionarCarta(counter);
        deck.adicionarCarta(saw);
        deck.adicionarCarta(saw);
        deck.adicionarCarta(saw);
        deck.adicionarCarta(saw);
    }
    public void comecarJogo(){
        deck.embaralharDeck();
        mao.maoInicial(deck);
    }


}
