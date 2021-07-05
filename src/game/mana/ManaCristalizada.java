package game.mana;

import game.enums.TipoDeCarta;

public class ManaCristalizada extends Mana {

    public ManaCristalizada(int quantidadeDeMana) {
        super(quantidadeDeMana);
    }

    public void adicionarMana(Mana mana){
        int auxiliar = quantidadeDeMana + mana.quantidadeDeMana;
        if(auxiliar <= 3){
            quantidadeDeMana = auxiliar;
        }
        else {
            quantidadeDeMana = 3;
        }

    }

    public void removerMana(Mana mana, TipoDeCarta tipoDeCarta){
        if(tipoDeCarta.compareTo(TipoDeCarta.FEITICO)==0) {
            quantidadeDeMana = quantidadeDeMana - mana.quantidadeDeMana;
        }
        else throw new IllegalArgumentException("Está Carta não pode ser invocada");
    }
}
