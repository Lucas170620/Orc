package game.baralho.tipoCarta;

import game.Efeito;
import game.baralho.Carta;
import game.Mana;
import game.enums.Efeitos;

import java.util.ArrayList;
import java.util.List;

public class Feitico extends Carta{
    private String nome;
    private Mana mana;
    private List<Efeito> efeitos = new ArrayList();

    public Feitico(String nome,int mana) {
        super();
        this.mana = new Mana(mana);
        this.nome = nome;
    }

    public List<Efeito> realizarEfeito(){
        return efeitos;
    }

    @Override
    public boolean ehMonstro() {
        return false;
    }

    public void resumoCarta(){
        System.out.println("Nome da Carta: "+nome);
        System.out.println("Carta Tipo Feitiço");
    }
}
