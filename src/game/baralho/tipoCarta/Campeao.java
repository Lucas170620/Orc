package game.baralho.tipoCarta;

import game.baralho.Carta;
import game.Mana;
import game.elementosMesa.CampoDeBatalha;
import game.elementosMesa.ZonaMonstro;
import game.enums.Efeitos;
import game.enums.Tracos;

import java.util.ArrayList;
import java.util.List;

public class Campeao extends Carta{
    private Mana mana = new Mana();
    private int vida ;
    private int poder;
    private List<Efeitos> efeitos = new ArrayList();
    private List<Tracos> tracos = new ArrayList();

    public Campeao(String nome,int poder , int vida,Efeitos efeito,Tracos traco) {
        super(nome);
        this.vida = vida;
        this.poder = poder;
        efeitos.add(efeito);
        tracos.add(traco);
    }

    public Campeao(String nome,int poder , int vida,Tracos traco) {
        super(nome);
        this.vida = vida;
        this.poder = poder;
        tracos.add(traco);
    }

    public Campeao(String nome,int poder , int vida,Efeitos efeito) {
        super(nome);
        this.vida = vida;
        this.poder = poder;
        efeitos.add(efeito);
    }

    public Campeao(String nome,int poder , int vida) {
        super(nome);
        this.vida = vida;
        this.poder = poder;
    }

}
