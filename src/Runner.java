import game.Rodada;
import game.jogador.Jogador;

public class Runner{
    public static void main(String[] args){
        Rodada rodada = new Rodada();
        rodada.decidirConfronto();
        rodada.inicarJogo();
        rodada.novaRodada();
        rodada.novaRodada();
        rodada.novaRodada();
        rodada.novaRodada();
        rodada.novaRodada();
        //Game g = new Game();
        //g.start();
    }
}
