package game.baralho.tipoCarta;

import game.baralho.Carta;
import game.Mana;

import java.util.ArrayList;
import java.util.List;

public class Feitico extends Carta{
    private List<Mana> mana = new ArrayList();

    public Feitico(String nome) {
        super(nome);
    }
}
