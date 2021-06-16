package game;

import game.baralho.Carta;
import game.baralho.Deck;
import game.elementosMesa.CampoDeBatalha;
import game.elementosMesa.Mao;
import game.elementosMesa.Nexus;
import game.elementosMesa.ZonaMonstro;
import game.enums.TodosEfeitos;
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
    private Jogador adversario;

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
    }

    public void topDeckCarta(){
        mao.topDeck(deck);
    }

    public void comecarJogo(Jogador adversario){
        this.adversario = adversario;
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

    private  void aplicarEfeitos(Carta carta){
        List<Efeito> efeitos = carta.realizarEfeito();
        for (Efeito efeito:efeitos){
            TodosEfeitos resolverEfeito = efeito.resolverEfeito();
            switch (resolverEfeito){
                case ZERA_PODER:
                    break;
                case ATACA_TODOS:
                    break;
                case ATACAR_O_NEXUS:
                    adversario.sofrerDano(carta.mostrarPoder());
                    break;
                case DANO_N_AO_NEXUS:
                    adversario.sofrerDano(efeito.n());
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
}
