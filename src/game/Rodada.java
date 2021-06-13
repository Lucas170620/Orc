package game;

import game.elementosMesa.CampoDeBatalha;
import game.elementosMesa.Mao;
import game.elementosMesa.ZonaMonstro;

public class Rodada{
    private Integer rodadas;
    private Jogador jogador1 , jogador2;

    public void novaRodada(){
        jogador1.altararPosicaoDeCombate();
        jogador2.altararPosicaoDeCombate();
        jogador1.comprarCarta();
        jogador2.comprarCarta();
    }
}
