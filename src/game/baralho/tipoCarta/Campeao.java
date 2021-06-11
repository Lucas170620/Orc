package game.baralho.tipoCarta;

import game.baralho.Carta;
import game.Mana;

import java.util.ArrayList;
import java.util.List;

public class Campeao extends Carta{
    private List<Mana> mana = new ArrayList();

    public Campeao(String nome) {
        super(nome);
    }
}
