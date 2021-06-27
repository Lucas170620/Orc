package game.jogador;

import game.baralho.Carta;

public class Bot extends Jogador{
    public void invocarUnidade(){
        Carta carta = mao.invocarCarta(mana);
        zonaMostro.invocarMontro(carta);
        mao.removerDaMao(carta);
        mana.removerMana(carta.mostrarMana());
    }
    public void comecarJogo(Jogador adversario){
        this.adversario = adversario;
        deck.embaralharDeck();
        mao.maoInicial(deck);
        mao.mostrarMao();
    }
}
