package game.elementosMesa;

import game.baralho.Carta;

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
            return false;
        }
        return true;
    }

    public void fortalecerUnidade(String nome, int n, int m){
        boolean verificador = true;
        for (Carta carta:campo){
            if(carta.vericarNome(nome)){
                verificador = false;
                carta.reforcarCarta(n,m);
            }
        }
    }
}
