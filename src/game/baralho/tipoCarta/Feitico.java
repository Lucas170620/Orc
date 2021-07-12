package game.baralho.tipoCarta;

import game.baralho.Carta;
import game.enums.TipoDeCarta;

public class Feitico extends Carta{

    public Feitico(String nome,int mana) {
        super(nome,mana);
    }

//    public List<Efeito> realizarEfeito(){
//        return efeitos;
//    }

    @Override
    public boolean ehMonstro() {
        return false;
    }


    public void mostrarTipo(){
        System.out.println("\t\tFeitico");
    }

    @Override
    public void reforcarCarta(int n, int m) {}

    @Override
    public void atacarCarta(Carta carta) {}

    @Override
    public void receberAtaque(int poder) {}

    @Override
    public void dobra() { }

    @Override
    public void bloqueia() { }

    @Override
    public void cura() { }

    @Override
    public void zerar() {

    }

    @Override
    public boolean estaMorta() {
        return false;
    }

    @Override
    public void enfraqueceCarta(int n, int m) {

    }

    @Override
    public boolean temBonusCarta() {
        return false;
    }

    @Override
    public boolean possuiDuploAtaque() {
        return false;
    }

    @Override
    public void possuiFuria(int n, int m ) {

    }

    @Override
    public boolean possuiElusivo() {
        return false;
    }


    @Override
    public TipoDeCarta tipo() {
        return TipoDeCarta.FEITICO;
    }


}
