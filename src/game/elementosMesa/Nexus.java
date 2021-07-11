package game.elementosMesa;

public class Nexus {
    private int pontosDeVida = 20;

    public void sofrerDano(int dano){
        pontosDeVida = pontosDeVida - dano;
    }
    public boolean verificaNexus(){
      if(this.pontosDeVida>0)
          return true;
      return false;
    }
    public void nexusVida() {
        System.out.println("Vida Nexus:"+this.pontosDeVida);
    }

    public void recuperarVida(int vidaCurada) {
        pontosDeVida = pontosDeVida + vidaCurada;
    }
}
