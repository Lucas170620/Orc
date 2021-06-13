package game;

import game.baralho.Carta;
import game.baralho.Deck;
import game.elementosMesa.CampoDeBatalha;
import game.elementosMesa.Mao;
import game.elementosMesa.ZonaMonstro;
import game.enums.PosicaoDeCombate;

import java.util.Scanner;

public class Jogador{
    private Scanner leitor = new Scanner(System.in);
    private Deck deck = new Deck();
    private Mao mao = new Mao();
    private PosicaoDeCombate posicaoDeCombate;
    private ZonaMonstro zonaMostro = new ZonaMonstro();
    private CampoDeBatalha campoDeBatalha = new CampoDeBatalha();

    public Jogador(){
        deckPrincpal();
    }

    public void altararPosicaoDeCombate(){
        switch (posicaoDeCombate){
            case ATACANTE:
                posicaoDeCombate = PosicaoDeCombate.DEFENSOR;
                break;
            case DEFENSOR:
                posicaoDeCombate = PosicaoDeCombate.ATACANTE;
                break;
        }
    }

    public void altararPosicaoDeCombate(PosicaoDeCombate posicaoDeCombate){
        this.posicaoDeCombate = posicaoDeCombate;
    }

    public void deckPrincpal(){
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

    public void comprarCarta(){
        mao.comprar(deck);
    }

    public void comecarJogo(){
        int quantidade;
        deck.embaralharDeck();
        mao.maoInicial(deck);
        mostrarResumoJogador();
        System.out.println("Deseja trocar cartas?\n1-Sim\nQualquer outro botão para não" );
        int verficador = leitor.nextInt();
        if (verficador == 1) {
            System.out.println("Quantas Cartas?");
            quantidade = leitor.nextInt();
             do{
                if (quantidade >= 0 && quantidade <= 4) {
                    mao.alterarCartas(deck, quantidade);
                    deck.embaralharDeck();
                    mostrarResumoJogador();
                } else{
                    System.out.println("Número inválido");
                    quantidade = leitor.nextInt();
                }
            }while(quantidade < 0 && quantidade>4);
        }
    }

    public void mostrarResumoJogador(){
        mao.mostrarMao();
        deck.mostrarDeck();
    }
}
