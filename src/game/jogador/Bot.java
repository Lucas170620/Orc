package game.jogador;

import game.Efeito;
import game.baralho.Carta;
import game.enums.Efeitos;
import game.enums.TipoDeCarta;
import game.mana.Mana;

import java.util.List;

public class Bot extends Jogador{
    public Bot(Integer jogador){
        super(jogador);
    }
    public void invocarUnidade(){
        Carta carta = mao.invocarCarta(mana);
        zonaMonstro.invocarMonstro(carta);
        mao.removerDaMao(carta);
        mana.removerMana(carta.mostrarMana(),carta.tipo());
    }

    public void comecarJogo(Jogador adversario){
        this.adversario = adversario;
        deck.embaralharDeck();
        mao.maoInicial(deck);
        mao.mostrarMao();
    }

    public void aplicarEfeitos(Carta carta){
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

    public boolean realizarAcao(){
        Integer ler;
        System.out.println("Jogador: "+jogador);
        if(mao.verificarCustosMonstro(mana)){
            invocarUnidade();
        }
        else if (mao.verificarCustosFeitico(mana,manaCristalizada)){
            ativarFeitico();
        }

        return false;
    }

    protected void ativarFeitico(){
        Carta carta = mao.ativarFeitico(mana,manaCristalizada);
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
