import error.EndGameException;
import game.Rodada;

import java.util.Scanner;

public class Game {
    private boolean escolherSair;
    private Rodada rodada = new Rodada();
    private Scanner leitor = new Scanner(System.in);
    Integer jogador;
    public void start() {
        escolherSair = false;
        System.out.println("Jogo Começou!");
        rodada.decidirConfronto();
        rodada.inicarJogo();


        jogador = 1 ;
        while(!escolherSair) {
            try {
                drawBoard();
                lerEntrada();
                atualizarMesa();
            }catch (EndGameException e){
                System.out.println(e.getMessage());
                escolherSair = true;
            }

        }
        System.out.println("Jogo Acabou!");
    }

    private void drawBoard(){
        rodada.mostrarResumo();
    }

    private void lerEntrada(){
        rodada.realizarAcao();

    }

    private void atualizarMesa(){
            rodada.novaRodada();
    }
}
