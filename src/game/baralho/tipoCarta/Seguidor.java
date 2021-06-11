package game.baralho.tipoCarta;

import game.baralho.Carta;
import game.Mana;

import java.util.ArrayList;
import java.util.List;

public class Seguidor extends Carta{
    private List<Mana> mana = new ArrayList();

    public Seguidor(String nome) {
        super(nome);
    }
}
