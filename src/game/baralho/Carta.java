package game.baralho;

import game.Efeito;
import game.Jogador;
import game.Mana;
import game.Traco;
import game.enums.Efeitos;
import game.enums.Tracos;

import java.util.ArrayList;
import java.util.List;

public abstract class Carta{

    private Jogador jogador;
    private String nome;
    private Mana mana;
    private List<Efeito> efeitos = new ArrayList();

    public Carta(String nome , int mana) {
        this.nome = nome;
        this.mana = new Mana(mana);
    }

    public List<Efeito> realizarEfeito(){
        return  efeitos;
    }

    public abstract boolean ehMonstro();

    public void adicionarEfeito(Efeitos efeito, int n, int m) {
        Efeito novoEfeito = new Efeito(efeito,n,m);
        efeitos.add(novoEfeito);
    }

    public int mostrarPoder(){
        return 0;
    }

    public void resumoCarta(){
        System.out.println("O nome da carta:");
        System.out.println(nome);
        System.out.println("o tipo da carta é:");
        mostrarTipo();
    }

    protected abstract void mostrarTipo();

    public boolean vericarNome(String nome){
        if(nome.compareTo(this.nome)==0) return true;
        else return false;
    }

    public Mana mostrarMana(){
        return mana;
    }
}
