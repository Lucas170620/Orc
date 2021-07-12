package game.baralho;

import game.Efeito;
import game.enums.TipoDeCarta;
import game.mana.Mana;
import game.enums.Efeitos;

import java.util.ArrayList;
import java.util.List;

public abstract class Carta {
    protected String nome;
    private Mana mana;
    private List<Efeito> efeitos = new ArrayList();

    public Carta(String nome, int mana) {
        this.nome = nome;
        this.mana = new Mana(mana);
    }

    public List<Efeito> realizarEfeito() {
        return efeitos;
    }

    public abstract boolean ehMonstro();

    public void adicionarEfeito(Efeitos efeito, int n, int m) {
        Efeito novoEfeito = new Efeito(efeito, n, m);
        efeitos.add(novoEfeito);
    }

    public void adicionarEfeito(Efeitos efeito) {
        Efeito novoEfeito = new Efeito(efeito);
        efeitos.add(novoEfeito);
    }

    public int mostrarPoder() {
        return 0;
    }

    public void resumoCarta() {
        System.out.println("--------------------");
        System.out.println("O nome da carta:");
        System.out.println("\t" + nome);
        System.out.println("\tCusto de mana:");
        System.out.println("\t\t" + mana.toString());
        System.out.println("\tO tipo da carta é:");
        mostrarTipo();
        System.out.println("--------------------");

    }

    public void resumoCartaCampo() {
        System.out.println("--------------------");
        System.out.println("O nome da carta:");
        System.out.println("\t" + nome);
        System.out.println("\tO tipo da carta é:");
        mostrarTipo();
        System.out.println("--------------------");
    }

    public void resumoCurtoCarta() {
        System.out.println("\t" + nome);
    }

    protected abstract void mostrarTipo();

//    public void aplicaEfeitos(){
//        for (int i = 0; i < this.efeitos.size(); ++i) {
////            this.efeitos.get(i).verificaFuria();
//        }
//    }


    public boolean vericarNome(String nome) {
        if (nome.compareTo(this.nome) == 0) return true;
        else return false;
    }

    public Mana mostrarMana() {
        return mana;
    }

    public abstract void reforcarCarta(int n, int m);

    public abstract void atacarCarta(Carta carta);

    public abstract TipoDeCarta tipo();

    public abstract void receberAtaque(int poder);

    public abstract void dobra();

    public abstract void bloqueia();

    public abstract void cura();

    public abstract void zerar();

    public abstract boolean estaMorta();

    public abstract void enfraqueceCarta(int n, int m);

    public abstract boolean temBonusCarta();

    public abstract boolean possuiDuploAtaque();

    public abstract void possuiFuria(int n, int m);

    public abstract boolean possuiElusivo();
}
