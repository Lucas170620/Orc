package game.baralho.tipoCarta;

import game.Efeito;
import game.baralho.Carta;
import game.Mana;
import game.enums.TodosEfeitos;

import java.util.ArrayList;
import java.util.List;

public class Feitico extends Carta{
    private Mana mana = new Mana();
    private List<Efeito> efeitos = new ArrayList();

    public Feitico(String nome) {
        super(nome);
    }

    public List<Efeito> realizarEfeito(){
        return efeitos;
    }
}
