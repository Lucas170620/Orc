package game.baralho.tipoCarta;

import game.Traco;
import game.baralho.Carta;
import game.enums.TipoDeCarta;
import game.enums.Tracos;

import java.util.ArrayList;
import java.util.List;

public class Monstro extends Carta {
    private int vida;
    private int vidaMax;
    private int poder;
    private List<Traco> tracos = new ArrayList();
    private boolean barreira=false;



    public Monstro(String nome, int mana, int poder, int vida) {
        super(nome, mana);
        this.vida = vida;
        this.vidaMax = vida;
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
    public void atacarCarta(Carta carta) {
        System.out.println("--------------------------------");
        System.out.println("a Carta "+this.nome+"Atacou:");
        carta.resumoCurtoCarta();
        carta.receberAtaque(this.poder);
    }


    public void receberAtaque(int dano) {
        if(this.barreira){
            System.out.println("Barreira de Monstro Destruida!");
            barreira=false;
        }else {
            this.vida=this.vida-dano;
        }
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
        }}

@Override
    public void reforcarCarta(int n, int m){
        poder = poder + n;
        vida = vida + m;

    }

    @Override
    public void dobra() {
        poder = 2*poder;
        vidaMax=2*vidaMax;
        vida = 2*vida;

    }

    @Override
    public void bloqueia() {
        this.barreira=true;
    }

    @Override
    public void cura() {
        this.vida=vidaMax;
    }

    @Override
    public void zerar() {
        this.poder=0;
    }

    @Override
    public boolean estaMorta() {
       if(this.vida<=0)
        return true;
       else
           return false;
    }


    public void adicionarTraco(Tracos traco, int n, int m) {
        Traco novoTraco = new Traco(traco,n,m);
    }
    public void adicionarTraco(Tracos traco) {
        Traco novoTraco = new Traco(traco);
        tracos.add(novoTraco);
    }


}