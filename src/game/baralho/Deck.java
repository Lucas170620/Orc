package game.baralho;

import error.EndGameException;

import java.util.ArrayList;
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

    public void topDeck(List<Carta> mao){
        if(!cartas.isEmpty()){
            mao.add(cartas.get(0));
            cartas.remove(0);
        }
        else{
            throw new EndGameException("Deck-out");
        }
    }
}
