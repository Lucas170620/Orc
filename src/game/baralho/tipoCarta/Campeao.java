package game.baralho.tipoCarta;

import game.Efeito;
import game.baralho.Carta;
import game.Mana;
import game.enums.Tracos;

import java.util.ArrayList;
import java.util.List;

public class Campeao extends Carta{
    private Mana mana = new Mana();
    private int vida ;
    private int poder;
    private List<Efeito> efeitos = new ArrayList();
    private List<Tracos> tracos = new ArrayList();

    public Campeao(String nome,int poder , int vida) {
        super(nome);
        this.vida = vida;
        this.poder = poder;
    }

    public List<Efeito> realizarEfeito(){
        return efeitos;
    }

    public int mostrarPoder(){
        return poder;
    }

}
