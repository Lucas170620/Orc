package game.baralho;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Deck{
    private List<Carta> cartas = new ArrayList();

    public void adicionarCarta(Carta carta){
        cartas.add(carta);
    }

    public void embaralharDeck(){
        Collections.shuffle(cartas);
    }

    public void topDeck(List<Carta> mao) {
        if(!cartas.isEmpty()){
            mao.add(cartas.get(0));
            cartas.remove(0);
        }
        else{
            System.out.println("Deck-out");
        }
    }

    public void mostrarDeck(){
        System.out.println("-----");
        System.out.println("Cartas no Deck:");
        for (Carta carta:cartas){
            System.out.println(carta.getNome());
        }

    }
}
