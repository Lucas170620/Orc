package game.jogador;

import game.baralho.Carta;

public class Artificial extends Jogador{
    public void invocarUnidade(){
        Carta carta = mao.invocarCarta(mana);
        zonaMostro.invocarMontro(carta);
        mao.removerDaMao(carta);
        mana.removerMana(carta.mostrarMana());
    }
}
