package game.elementosMesa;

import game.baralho.Carta;

import java.util.ArrayList;
import java.util.List;

public class ZonaMonstro{
    private List<Carta> campo = new ArrayList();

    public void invocarMontro(Carta carta){
        if(carta.ehMonstro()){
            if(campo.size()<=6){
                campo.add(carta);
            }
            else throw new IllegalArgumentException("Zona de Monstros Máxima Atingida");
        }
        else throw new IllegalArgumentException("Está Carta não pode ser invocada");
    }

    public void mostrarCampo(){
        for (Carta carta:campo){
            carta.resumoCarta();
        }
    }
}
