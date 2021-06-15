package game;

import game.baralho.Carta;
import game.baralho.Deck;
import game.elementosMesa.CampoDeBatalha;
import game.elementosMesa.Mao;
import game.elementosMesa.Nexus;
import game.elementosMesa.ZonaMonstro;
import game.enums.Efeitos;
import game.enums.PosicaoDeCombate;

import java.util.List;
import java.util.Scanner;

public class Jogador{
    private Nexus nexus = new Nexus();
    private Scanner leitor = new Scanner(System.in);
    private Deck deck = new Deck();
    private Mao mao = new Mao();
    private PosicaoDeCombate posicaoDeCombate;
    private ZonaMonstro zonaMostro = new ZonaMonstro();
    private CampoDeBatalha campoDeBatalha = new CampoDeBatalha();

    public Jogador(){
        deckPrincpal();
    }

    public void sofrerDano(int dano){
        nexus.sofrerDano(dano);
    }

    public void curarVida(int vidaCurada){
        nexus.recuperarVida(vidaCurada);
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

    public void topDeckCarta(){
        mao.topDeck(deck);
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

    /*
    public  void aplicarEfeitos(Carta carta){
        List<Efeitos> efeitos = carta.realizarEfeito();
        for (Efeitos efeito:efeitos){
            switch (efeito){
                case ZERA_PODER:
                    break;
                case ATACA_TODOS:
                    break;
                case ATACAR_O_NEXUS:
                    break;
                case DANO_N_AO_NEXUS:
                    break;
                case COMBATE_IMEDIATO:
                    break;
                case CURAR_UNIDADE_ALIADA:
                    break;
                case FORTALECER_UMA_UNIDADE:
                    break;
                case FORTACELER_UNIDADES_ALIADAS:
                    break;
                case AO_SER_DESTUIDO_COMPRA_CARTA:
                    break;
                case DESTRUIR_MOSTRO_E_COLOCAR_NA_MAO:
                    break;
                case CRIA_BARREIRA_DE_PROTECAO_DE_DANO:
                    break;
                case DOBRAR_ATAQUE_E_DEFESA_UNIDADE_ALIADA:
                    break;
            }

        }
    }
    */
    //discutir aplicar efeitos
}
