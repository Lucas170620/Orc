package game;

public class Rodada{
    private Integer rodadas;
    private Jogador jogador1 = new Jogador(), jogador2 = new Jogador();

    public void inicarJogo(){
        jogador1.comecarJogo(jogador2);
        jogador2.comecarJogo(jogador1);
        rodadas = 1;
    }

    public void novaRodada(){
        jogador1.altararPosicaoDeCombate();
        jogador2.altararPosicaoDeCombate();
        jogador1.topDeckCarta();
        jogador2.topDeckCarta();
    }

    public void mostrarResumo(){
        System.out.println("Rodada "+rodadas);
        System.out.println("Resumo Jogador 1: ");
        jogador1.mostrarResumo();
        System.out.println("Resumo Jogador 2: ");
        jogador2.mostrarResumo();

    }
}
