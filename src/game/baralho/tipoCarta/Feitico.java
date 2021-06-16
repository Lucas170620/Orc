package game.baralho.tipoCarta;

import game.Efeito;
import game.baralho.Carta;
import game.Mana;

import java.util.ArrayList;
import java.util.List;

public class Feitico extends Carta{
    private Mana mana;
    private List<Efeito> efeitos = new ArrayList();

    public Feitico(String nome,int mana) {
        super(nome);
        this.mana = new Mana(mana);
    }

    public List<Efeito> realizarEfeito(){
        return efeitos;
    }

    @Override
    public boolean ehMonstro() {
        return false;
    }
}
