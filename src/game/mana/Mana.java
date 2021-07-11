package game.mana;

import game.enums.TipoDeCarta;

public class Mana{
    protected int quantidadeDeMana;

    public Mana(int mana) {
        quantidadeDeMana = mana;
    }

    public void adicionarMana(Mana mana){
        int auxiliar = quantidadeDeMana + mana.quantidadeDeMana;
        if(auxiliar <= 10){
            quantidadeDeMana = auxiliar;
        }
        else {
            quantidadeDeMana = 10;
        }

    }

    public void removerMana(Mana mana, TipoDeCarta tipoDeCarta){
        quantidadeDeMana = quantidadeDeMana - mana.quantidadeDeMana;
    }

    public boolean verificarManaDisponivel(Mana mana){
        if(quantidadeDeMana >= mana.quantidadeDeMana) return true;
        else return false;
    }


    public void zerarMana() {
        quantidadeDeMana = 0;
    }

    @Override
    public String toString() {
        return "Mana{" +quantidadeDeMana +
                '}';
    }
}
