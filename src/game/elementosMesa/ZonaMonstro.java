package game.elementosMesa;

import game.baralho.Carta;
import game.mana.Mana;

import java.util.ArrayList;
import java.util.List;

public class ZonaMonstro{
    private List<Carta> campo = new ArrayList();



    public void invocarMonstro(Carta carta){
        if(carta.ehMonstro()){
            if(campo.size()<=6){
                campo.add(carta);
            }
            else throw new IllegalArgumentException("Zona de Monstros Máxima Atingida");
        }
        else throw new IllegalArgumentException("Está Carta não pode ser invocada");
    }

    public void mostrarCampo(){
        if(this.campo.size()==0){
            System.out.println("<<<Campo vazio!>>>");
        }
        for (Carta carta:campo){
            carta.resumoCartaCampo();
        }
    }

    public boolean verificaTamanho(){
        if(this.campo.size()==0) {
            System.out.println("Seu campo está vazio!!");
            return true;
        }
        return false;
    }
    public Carta recrutaCarta(String nome){
        for(int i=0;i<this.campo.size();i++){
            if(this.campo.get(i).vericarNome(nome)) {
                return this.campo.get(i);
            }
        }
        return null;
    }

    public void fortalecerUnidade(String nome, int n, int m){
        for (Carta carta:campo){
            if(carta.vericarNome(nome)){
                carta.reforcarCarta(n,m);
            }
        }
    }

    public void fortalecerTodasUnidades(int n, int m) {
        for (Carta carta:campo){
            carta.reforcarCarta(n,m);
        }
    }

    public void dobrar(String nome){
        for (Carta carta:campo){
            if(carta.vericarNome(nome)){
                carta.dobra();
            }
        }
    }

    public void criarBarreira(String nome) {
        for (Carta carta:campo){
            if(carta.vericarNome(nome)){
                carta.bloqueia();
            }
        }
    }

    public void curarUnidade(String nome) {
        for (Carta carta:campo){
            if(carta.vericarNome(nome)){
                carta.cura();
            }
        }
    }

    public void zerarPoder(String nome) {
        for (Carta carta:campo){
            if(carta.vericarNome(nome)){
                carta.zerar();
            }
        }
    }

    public Boolean matarOsNegativos() {
        boolean flag=false;
        for (int i=0;i<campo.size();i++){
            if(campo.get(i).estaMorta() &&campo.get(i).temBonusCarta()){
                campo.remove(campo.get(i));
                flag=true;
            }
        }
        return flag;
    }


    public void enfraquece(int n, int m) {
        for (Carta carta:campo){
            carta.enfraqueceCarta(n,m);
        }
    }
}
