package game;

public class Mana{
    private int quantidadeDeMana;

    public Mana(int mana) {
        quantidadeDeMana = mana;
    }

    public void adicionarMana(int mana){
        quantidadeDeMana = quantidadeDeMana + mana;
    }

    public void removerMana(Mana mana){
        quantidadeDeMana = quantidadeDeMana - mana.quantidadeDeMana;
    }

    public boolean verificarManaDisponivel(Mana mana){
        if(quantidadeDeMana >= mana.quantidadeDeMana) return true;
        else return false;
    }
}
