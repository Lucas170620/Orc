package game.baralho.tipoCarta;

import game.Mana;
import game.Traco;
import game.baralho.Carta;
import game.enums.Tracos;

import java.util.ArrayList;
import java.util.List;

public class Monstro extends Carta {
    private int vida ;
    private int poder;
    private List<Traco> tracos = new ArrayList();

    public Monstro(String nome ,int mana,int poder , int vida) {
        super(nome,mana);
        this.vida = vida;
        this.poder = poder;
    }

    @Override
    public boolean ehMonstro() {
        return true;
    }

    public int mostrarPoder(){
        return poder;
    }

    protected void mostrarTipo(){
        System.out.println("Unidade");
    }

    public void reforcarCarta(int n, int m){
        poder = poder + n;
        vida = vida + m;
    }

    public void adicionarTraco(Tracos traco, int n, int m) {
        Traco novoTraco = new Traco(traco,n,m);
    }
}
