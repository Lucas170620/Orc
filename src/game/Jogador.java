package game;

import game.baralho.Carta;
import game.baralho.CartaFactory;
import game.baralho.Deck;
import game.elementosMesa.CampoDeBatalha;
import game.elementosMesa.Mao;
import game.elementosMesa.Nexus;
import game.elementosMesa.ZonaMonstro;
import game.enums.Efeitos;
import game.enums.PosicaoDeCombate;
import game.enums.TipoDeCarta;
import game.enums.Tracos;

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
        Carta carta = CartaFactory.criarCarta(TipoDeCarta.CAMPEAO,"Garen",5,5,5);
        carta.adicionarEfeito(Efeitos.CURAR_UNIDADE_ALIADA,0,0);
        deck.adicionarCarta(carta);
        carta = CartaFactory.criarCarta(TipoDeCarta.SEGUIDOR,"Tiana",8,7,7);
        carta.adicionarEfeito(Efeitos.ATACAR_O_NEXUS,0,0);
        deck.adicionarCarta(carta);
        carta = CartaFactory.criarCarta(TipoDeCarta.SEGUIDOR,"Vanguarda",4,3,3);
        carta.adicionarEfeito(Efeitos.FORTACELER_UNIDADES_ALIADAS,1,1);
        deck.adicionarCarta(carta);
        carta = CartaFactory.criarCarta(TipoDeCarta.SEGUIDOR,"Duelista",3,3,2);
        carta.adicionarEfeito(Efeitos.AO_SER_DESTUIDO_COMPRA_CARTA,0,0);
        deck.adicionarCarta(carta);
        carta = CartaFactory.criarCarta(TipoDeCarta.SEGUIDOR,"Defensor",2,2,2);
        deck.adicionarCarta(carta);
        carta = CartaFactory.criarCarta(TipoDeCarta.SEGUIDOR,"Poro",1,2,1);
        deck.adicionarCarta(carta);
        carta = CartaFactory.criarCarta(TipoDeCarta.SEGUIDOR,"Poro Defensor",1,1,2);
        carta.adicionarEfeito(Efeitos.AO_SER_DESTUIDO_COMPRA_CARTA,0,0);
        deck.adicionarCarta(carta);
        carta = CartaFactory.criarCarta(TipoDeCarta.FEITICO,"Julgamento",8,0,0);
        carta.adicionarEfeito(Efeitos.ATACA_TODOS,0,0);
        deck.adicionarCarta(carta);
        carta = CartaFactory.criarCarta(TipoDeCarta.FEITICO,"Valor Redobrado",6,0,0);
        carta.adicionarEfeito(Efeitos.CURAR_UNIDADE_ALIADA,0,0);
        carta.adicionarEfeito(Efeitos.DOBRAR_ATAQUE_E_DEFESA_UNIDADE_ALIADA,0,0);
        deck.adicionarCarta(carta);
        carta = CartaFactory.criarCarta(TipoDeCarta.FEITICO,"Golpe Certeiro",1,0,0);
        carta.adicionarEfeito(Efeitos.FORTALECER_UMA_UNIDADE,1,1);
        deck.adicionarCarta(carta);
        carta = CartaFactory.criarCarta(TipoDeCarta.FEITICO," Combate um-a-um",2,0,0);
        carta.adicionarEfeito(Efeitos.COMBATE_IMEDIATO,0,0);
        deck.adicionarCarta(carta);

    }

    public void topDeckCarta(){
        mao.topDeck(deck);
    }

    public void comecarJogo(Jogador adversario){
        this.adversario = adversario;
        int quantidade;
        deck.embaralharDeck();
        mao.maoInicial(deck);
        System.out.println("Deseja trocar cartas?\n1-Sim\nQualquer outro botão para não" );
        int verficador = leitor.nextInt();
        if (verficador == 1) {
            System.out.println("Quantas Cartas?");
            quantidade = leitor.nextInt();
             do{
                if (quantidade >= 0 && quantidade <= 4) {
                    mao.alterarCartas(deck, quantidade);
                    deck.embaralharDeck();
                } else{
                    System.out.println("Número inválido");
                    quantidade = leitor.nextInt();
                }
            }while(quantidade < 0 && quantidade>4);
        }
    }

    private  void aplicarEfeitos(Carta carta){
        List<Efeito> efeitos = carta.realizarEfeito();
        for (Efeito efeito:efeitos){
            Efeitos resolverEfeito = efeito.resolverEfeito();
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
