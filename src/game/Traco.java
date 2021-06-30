package game;
import game.baralho.Carta;
import game.enums.Efeitos;
import game.enums.Tracos;

public class Traco {
    private Tracos traco;
    private int n ;
    private int m ;


    public Traco(Tracos traco, int n, int m){ //Fúria expecificamente
        this.traco = traco;
        this.n = n ;
        this.m = m ;
    }


    public  Traco(Tracos traco){ //elusivo ou Ataque duplo
        this.traco = traco;
    }

    public  boolean verificaElusividade(){ //elusivo
        if(this.traco.equals(Tracos.ELUSIVO))
            return true;
        else return false;
    }
    public  boolean verificaAtaquesDuplos(){ //elusivo
        if(this.traco.equals(Tracos.ATAQUE_DUPLO))
            return true;
        else return false;
    }
    public  boolean verificaFuria(){ //elusivo
        if(this.traco.equals(Tracos.FURIA))
            return true;
        else return false;
    }


//    Tracos resolverTraco(){
//        return traco;
//    }
//
//    int n(){
//        return n;
//    }
//
//    int m(){
//        return m;
//    }
}
