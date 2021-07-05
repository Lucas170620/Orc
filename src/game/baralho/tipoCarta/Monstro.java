package game.baralho.tipoCarta;

import game.Traco;
import game.baralho.Carta;
import game.enums.TipoDeCarta;

import java.util.ArrayList;
import java.util.List;

public class Monstro extends Carta {
    private int vida;
    private int poder;
    private List<Traco> tracos = new ArrayList();

    public Monstro(String nome, int mana, int poder, int vida) {
        super(nome, mana);
        this.vida = vida;
        this.poder = poder;
    }

    @Override
    public boolean ehMonstro() {
        return true;
    }

    public int mostrarPoder() {
        return poder;
    }

    protected void mostrarTipo() {
        System.out.println("Unidade");
    }

    @Override
    public TipoDeCarta tipo() {
        return null;
    }


    public boolean possuiElusivo() {
        for (int i = 0; i < this.tracos.size(); ++i) {
            if (this.tracos.get(i).verificaElusividade()) {
                return true;
            }
        }
        return false;
    }

    public boolean possuiDuploAtaque() {
        for (int i = 0; i < this.tracos.size(); ++i) {
            if (this.tracos.get(i).verificaAtaquesDuplos()) {
                return true;
            }
        }
        return false;
    }

    public void possuiFuria(int n,int m) {
        for (int i = 0; i < this.tracos.size(); ++i) {
            if (this.tracos.get(i).verificaFuria()) {
                this.vida=this.vida+n;
                this.poder=this.vida+m;
            }
        }}}
//
//    public void reforcarCarta(int n, int m){
//        poder = poder + n;
//        vida = vida + m;
//
//    }
//
////    public void adicionarTraco(Tracos traco, int n, int m) {
////        Traco novoTraco = new Traco(traco,n,m);
////    }
////    public void adicionarTraco(Tracos traco) {
////        Traco novoTraco = new Traco(traco);
////        tracos.add(novoTraco);
////    }
////
////}
////