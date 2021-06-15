package game.baralho.tipoCarta;

import game.baralho.Carta;
import game.Mana;
import game.enums.Efeitos;
import game.enums.Tracos;

import java.util.ArrayList;
import java.util.List;

public class Feitico extends Carta{
    private Mana mana = new Mana();
    private List<Efeitos> efeitos = new ArrayList();

    public Feitico(String nome,int poder , int vida,Efeitos efeito) {
        super(nome);
        efeitos.add(efeito);
    }

    public Feitico(String nome,int poder , int vida) {
        super(nome);
    }
}
