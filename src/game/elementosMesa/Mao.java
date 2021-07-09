package game.elementosMesa;

import game.mana.Mana;
import game.baralho.Carta;
import game.baralho.Deck;
import game.mana.ManaCristalizada;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mao{
    private List<Carta> mao = new ArrayList();


    public void maoInicial(Deck deck) {
        for (int i = 0 ; i < 4; i++) deck.topDeck(mao);
    }

    public void alterarCartas(Deck deck, int quantidade){
        for(int i = 0 ; i < quantidade ;i++){
            deck.adicionarCarta(mao.get(i));
            mao.remove(i);
            deck.topDeck(mao);
        }
    }

    public void topDeck(Deck deck) {
        deck.topDeck(mao);
    }

    public void mostrarMao(){
        for (Carta carta:mao){
            carta.resumoCurtoCarta();
        }
    }
    public void mostrarMaoCompleta(){
        for (Carta carta:mao){
            carta.resumoCarta();
        }
    }

    public void mostraNomesMao(){
        for (Carta carta:mao){
            carta.resumoCurtoCarta();
        }
    }

    public Carta invocarCarta(String nome, Mana mana){
        for(Carta carta:mao){
            if(carta.vericarNome(nome)){
                if(mana.verificarManaDisponivel(carta.mostrarMana())){
                    mao.remove(carta);
                    return carta;
                }
                else{
                    throw new IllegalArgumentException("Nao Há mana disponivel");
                }
            }
        }
        throw new IllegalArgumentException("Carta Não está na sua mao");
    }

    public Carta invocarCarta(Mana mana){
        Carta carta;
        List<Carta> maoDisponivel = new ArrayList();
        boolean verificador = true;
        Random random = new Random();
        for(Carta cartaDeck: mao){
            if(mana.verificarManaDisponivel(cartaDeck.mostrarMana()) && cartaDeck.ehMonstro()){
                maoDisponivel.add(cartaDeck);
            }
        }
        if(!maoDisponivel.isEmpty()){
            carta = maoDisponivel.get(random.nextInt(maoDisponivel.size()));
            return carta;
        }
        else throw new IllegalArgumentException("Nao tem carta com mana disponivel");

    }

    public void removerDaMao(Carta carta) {
        mao.remove(carta);
    }

    public boolean verificarCustosMonstro(Mana mana){
        for(Carta carta: mao){
            if(mana.verificarManaDisponivel(carta.mostrarMana()) && carta.ehMonstro()){
                return true;
            }
        }
        return  false;
    }

    public boolean verificarCustosFeitico(Mana mana , ManaCristalizada manaCristalizada) {
        for(Carta carta: mao){
            if(manaCristalizada.verificarManaDisponivel(carta.mostrarMana(),mana) && !carta.ehMonstro()){
                return true;
            }
        }
        return  false;
    }

    public Carta ativarFeitico(Mana mana, ManaCristalizada manaCristalizada){
        Carta carta;
        List<Carta> maoDisponivel = new ArrayList();
        Random random = new Random();
        for(Carta cartaDeck: mao){
            if(manaCristalizada.verificarManaDisponivel(cartaDeck.mostrarMana(),mana) && !cartaDeck.ehMonstro()){
                maoDisponivel.add(cartaDeck);
            }
        }
        if(!maoDisponivel.isEmpty()){
            carta = maoDisponivel.get(random.nextInt(maoDisponivel.size()));
            return carta;
        }
        else throw new IllegalArgumentException("Nao tem carta com mana disponivel");

    }

    public Carta ativarFeitico(String nome, Mana mana,ManaCristalizada manaCristalizada){
        for(Carta carta:mao){
            if(carta.vericarNome(nome)){
                if(manaCristalizada.verificarManaDisponivel(carta.mostrarMana(),mana)){
                    mao.remove(carta);
                    return carta;
                }
                else{
                    throw new IllegalArgumentException("Nao Há mana disponivel");
                }
            }
        }
        throw new IllegalArgumentException("Carta Não está na sua mao");
    }
}
