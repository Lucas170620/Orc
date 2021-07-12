package game;

import error.EndGameException;
import game.baralho.Carta;
import game.jogador.Jogador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combate {
    Jogador j1;
    Jogador j2;
    private Scanner leitor = new Scanner(System.in);
    private List<Carta> atacantes = new ArrayList();
    private List<Carta> defensores = new ArrayList();

    public Combate(Jogador jogador, Jogador adversario) {
        this.j1=jogador;
        this.j2=adversario;
    }
    public  Integer entraComNumerodeCombate(){
        Integer n;
        n = leitor.nextInt();
        leitor.nextLine();
        return n;
    }

    public void combater() {
        Integer contador = 0;
        Integer ler;
        String unidade;
        boolean verificador = true;
        System.out.println("ATAQUE DE JOGADOR: " + this.j1);
        System.out.println("Quantos ataques deseja fazer?");
        System.out.println("***************************************");
        ler= entraComNumerodeCombate();

        for (int i = 0; i < ler; i++) {
            System.out.println("Passe o nome das unidade atacante!");
            while (verificador) {
                try {
                    unidade = leitor.nextLine();
                    this.atacantes.add(j1.preparaCarta(unidade));
                    verificador = false;
                    this.atacantes.get(i).resumoCurtoCarta();
                    System.out.println("Preparada para o Ataque!");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    if (contador >= 3) {
                        throw new IllegalArgumentException("Muitas Tentativas erradas");
                    } else {
                        System.out.println("Erro: " + e.getMessage());
                        System.out.println("Digite Novamente");
                        contador++;
                        unidade = leitor.nextLine();
                        verificador = true;
                    }
                }
            }
        }

        verificador = true;
        for (int i = 0; i < atacantes.size(); i++) {
            boolean elusivo = this.atacantes.get(i).possuiElusivo();
            Carta carta;
            System.out.println("DECLARAÇÃO DE DEFENSORES");
            System.out.println("Defendendo contra:" );
            this.atacantes.get(i).resumoCurtoCarta();
            System.out.println("Deseja que ocorra declaração de defensores?");
            System.out.println("1-Sim");
            System.out.println("2-Não");
            ler= entraComNumerodeCombate();
            if(ler==1){

            while (verificador) {
                try {
                    System.out.println("Entre com o nome do seu defensor!" );
                    unidade = leitor.nextLine();
                    carta=j2.preparaCarta(unidade);
                    if(!(carta==null)  ||  !(elusivo && !carta.possuiElusivo())) {
                        this.atacantes.get(i).atacarCarta(carta);
                        if( this.atacantes.get(i).possuiDuploAtaque()) {
                            this.atacantes.get(i).atacarCarta(carta);
                        }
                        this.atacantes.get(i).possuiFuria(1,1);
                        verificador = false;
                        this.atacantes.get(i).resumoCurtoCarta();

                    }else{
                        System.out.println("O Nexus Sofreu Dano!");
                        j2.sofrerDano(this.atacantes.get(i).mostrarPoder());
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    if (contador >= 3) {
                        throw new IllegalArgumentException("Muitas Tentativas erradas");
                    } else {
                        System.out.println("Erro: " + e.getMessage());
                        System.out.println("Não existe esse monstro em seu campo!1");
                        contador++;
                        unidade = leitor.nextLine();
                        verificador = true;
                    }
                }
            }
        }
            else{
                System.out.println("O Nexus Sofreu Dano!");
                j2.sofrerDano(this.atacantes.get(i).mostrarPoder());
            }
        }

    }
}