package game;

public class Mana{
    private int quantidadeDeMana;

    public Mana(int mana) {
        quantidadeDeMana = mana;
    }

    public void adicionarMana(int mana){
        quantidadeDeMana = quantidadeDeMana + mana;
    }

    public void removerMana(int mana){
        quantidadeDeMana = quantidadeDeMana - mana;
    }

    public boolean verificarManaDisponivel(int mana){
        if(quantidadeDeMana <= mana) return true;
        else return false;
    }
}
