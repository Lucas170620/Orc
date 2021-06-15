package game.elementosMesa;

public class Nexus {
    private int pontosDeVida = 20;

    public void sofrerDano(int dano){
        pontosDeVida = pontosDeVida - dano;
    }

    public void recuperarVida(int vidaCurada) {
        pontosDeVida = pontosDeVida + vidaCurada;
    }
}
