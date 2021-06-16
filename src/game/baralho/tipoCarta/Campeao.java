package game.baralho.tipoCarta;

import game.Efeito;
import game.Traco;
import game.baralho.Carta;
import game.Mana;
import game.enums.Tracos;

import java.util.ArrayList;
import java.util.List;

public class Campeao extends Carta{
    private Mana mana;
    private int vida ;
    private int poder;
    private List<Efeito> efeitos = new ArrayList();
    private List<Traco> tracos = new ArrayList();

    public Campeao(String nome,int mana,int poder , int vida) {
        super(nome);
        this.vida = vida;
        this.poder = poder;
        this.mana = new Mana(mana);
    }

    public List<Efeito> realizarEfeito(){
        return efeitos;
    }

    public int mostrarPoder(){
        return poder;
    }

}
