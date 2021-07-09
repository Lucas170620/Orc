package game.jogador;

import error.EndGameException;
import game.Efeito;
import game.mana.Mana;
import game.mana.ManaCristalizada;
import game.baralho.Carta;
import game.baralho.CartaFactory;
import game.baralho.Deck;
import game.elementosMesa.Mao;
import game.elementosMesa.Nexus;
import game.elementosMesa.ZonaMonstro;
import game.enums.Efeitos;
import game.enums.PosicaoDeCombate;
import game.enums.TipoDeCarta;

import java.util.List;
import java.util.Scanner;

public class Jogador{
    private Nexus nexus = new Nexus();
    private Scanner leitor = new Scanner(System.in);
    protected Deck deck = new Deck();
    protected Mao mao = new Mao();
    protected Mana mana = new Mana(1);
    protected ManaCristalizada manaCristalizada = new ManaCristalizada(0);
    private PosicaoDeCombate posicaoDeCombate;
    protected ZonaMonstro zonaMonstro = new ZonaMonstro();
    protected Jogador adversario;
    protected Integer jogador ;

    public Jogador(Integer jogador){
        this.jogador = jogador;
        deckPrincpal();
    }

    public void sofrerDano(int dano){
        nexus.sofrerDano(dano);
    }

    public void curarVida(int vidaCurada){
        nexus.recuperarVida(vidaCurada);
    }

    public void alterarPosicaoDeCombate(Integer rodada){
        switch (posicaoDeCombate){
            case ATACANTE:
                if(mana.verificarManaDisponivel(new Mana(1))){
                    manaCristalizada.adicionarMana(mana);
                }
                mana.zerarMana();
                mana.adicionarMana(new Mana(rodada));
                posicaoDeCombate = PosicaoDeCombate.DEFENSOR;
                break;
            case DEFENSOR:
                mana.zerarMana();
                mana.adicionarMana(new Mana(rodada));
                posicaoDeCombate = PosicaoDeCombate.ATACANTE;
                break;
        }
    }

    public void alterarPosicaoDeCombate(PosicaoDeCombate posicaoDeCombate){
        this.posicaoDeCombate = posicaoDeCombate;
    }

    public void deckPrincpal(){
        Carta carta = CartaFactory.criarCarta(TipoDeCarta.CAMPEAO,"Garen",5,5,5);
        carta.adicionarEfeito(Efeitos.CURAR_UNIDADE_ALIADA,0,0);
        carta.adicionarEfeito(Efeitos.FORTALECER_UMA_UNIDADE,1,1);
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
        carta = CartaFactory.criarCarta(TipoDeCarta.FEITICO,"Combate Um-a-Um",2,0,0);
        carta.adicionarEfeito(Efeitos.COMBATE_IMEDIATO,0,0);
        deck.adicionarCarta(carta);

    }

    public void topDeckCarta(){
        mao.topDeck(deck);
    }

    public void comecarJogo(Jogador adversario) {
        this.adversario = adversario;
        int quantidade;
        deck.embaralharDeck();
        mao.maoInicial(deck);
        mao.mostrarMao();
        System.out.println("Deseja trocar cartas?\n1-Sim\nOutro botão-Não" );
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

    public void aplicarEfeitos(Carta carta){
        boolean verificador = true;
        String nome;
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
                    System.out.println("Qual Unidade você quer fortalecer");
                    nome = leitor.next();
                    while (verificador){
                        try {
                            verificador =false;
                            zonaMonstro.fortalecerUnidade(nome,efeito.n(),efeito.m());
                        }catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                            nome= leitor.next();
                            verificador =true;
                        }


                    }

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
                default:
                    throw new IllegalStateException("Unexpected value: " + resolverEfeito);
            }
        }
    }


    public void mostrarResumo(){
        System.out.println("Campo do Jogador: ");
        zonaMonstro.mostrarCampo();
    }

    public void mostrarMaoatual(){
        System.out.println("Mão do Jogador " + jogador+":");
        mao.mostrarMaoCompleta();
    }

    public void mostrarManaJogador(){
        System.out.println("Mana Atual:" + this.mana);
        mao.mostrarMaoCompleta();
    }



    public boolean ehAtacante() {
        if(posicaoDeCombate.compareTo(PosicaoDeCombate.ATACANTE)==0) return true;
        else return false;
    }

    public void invocarUnidade(){
        Integer contador = 0;
        if(!mao.verificarCustosMonstro(mana)){
            throw new IllegalArgumentException("Não há cartas invocaveis"); //tratar exception
        }
        boolean verificador = true;
        String unidade;
        Carta carta = null;
        System.out.println("Deseja invocar qual unidade?");
        System.out.println("Escreva o Nome!");

        this.mao.mostraNomesMao();
        unidade = leitor.nextLine();
        while(verificador){
            try {
                carta = mao.invocarCarta(unidade, mana);
                verificador = false;
                System.out.println("Carta Invocada Com Sucesso");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                if(contador>=3){
                    throw new IllegalArgumentException("Muitas Tentativas erradas");
                }
                else {
                    System.out.println("Erro: "+e.getMessage());
                    System.out.println("Digite Novamente");
                    contador++;
                    unidade = leitor.nextLine();
                    verificador = true;
                }
            }

        }
        mao.removerDaMao(carta);
        zonaMonstro.invocarMonstro(carta);
        aplicarEfeitos(carta);
        mana.removerMana(carta.mostrarMana(),carta.tipo());
    }

    public void realizarAcao(){
        Integer ler;
        System.out.println("JOGADA DE JOGADOR: "+jogador);

        System.out.println("1-Deseja Ver sua Mão?");
        System.out.println("1-Sim");
        System.out.println("2-Não");
        ler = leitor.nextInt();
        leitor.nextLine();
        if(ler==1){
            mostrarMaoatual();
        }else{
            System.out.println(" ");

        }
        System.out.println("Jogador: "+jogador);
        System.out.println("***************************************");
        System.out.println("0-Deseja Sair");
        System.out.println("1-Deseja Invocar Monstro");
        System.out.println("2-Deseja Invocar Feitiço");
        System.out.println("3-Entrar Em Combate:");

        System.out.println("Digite qualquer outro botão para não fazer nada!");
        System.out.println("***************************************");

        ler = leitor.nextInt();
        leitor.nextLine();
        switch (ler){
            case 0:
                throw new EndGameException("Você Digitou para sair");
            case 1:
                try {
                    invocarUnidade();
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try {
                    ativarFeitico();

                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                if(this.zonaMonstro.verificaTamanho()){
                    System.out.println("Por favor tente novamente");
                    this.realizarAcao();
                }
                break;

        }
        if(jogador == 1) jogador = 2;
        else jogador = 1;
    }

    protected void ativarFeitico() {
        Integer contador = 0;
        if(!mao.verificarCustosFeitico(mana,manaCristalizada)){
            throw new IllegalArgumentException("Não há Feitiços disponiveis"); //tratar exception
        }
        boolean verificador = true;
        String unidade;
        Carta carta = null;
        System.out.println("Deseja ativar qual feitiço?");
        unidade = leitor.nextLine();
        while(verificador){
            try {
                verificador = false;
                carta = mao.ativarFeitico(unidade, mana,manaCristalizada);

            }catch (IllegalArgumentException e){
                if(contador>=3){
                    throw new IllegalArgumentException("Muitas Tentativas erradas");
                }
                else {
                    System.out.println("Erro: "+e.getMessage());
                    System.out.println("Digite Novamente");
                    contador++;
                    unidade = leitor.nextLine();
                    verificador = true;
                }
            }

        }
        mao.removerDaMao(carta);
        if(mana.verificarManaDisponivel(carta.mostrarMana())) {
            mana.removerMana(carta.mostrarMana(), carta.tipo());
        }
        else {
            Mana manaTotal = new Mana(0);
            manaTotal.adicionarMana(carta.mostrarMana());
            manaTotal.removerMana(mana, TipoDeCarta.FEITICO);
            mana.zerarMana();
            manaCristalizada.removerMana(manaTotal,TipoDeCarta.FEITICO);
        }
    }
}
