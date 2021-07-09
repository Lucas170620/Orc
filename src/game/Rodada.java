package game;

import game.enums.PosicaoDeCombate;
import game.jogador.Bot;
import game.jogador.Jogador;

import java.util.Scanner;

public class Rodada{
    private Integer rodadas;
    private Scanner leitor = new Scanner(System.in);
    private Jogador jogador1 , jogador2;

    public void decidirConfronto(){
        boolean verificador = true;
        System.out.println("Escolha um índice: ");
        System.out.println("1- Jogador vs Jogador");
        System.out.println("2- Jogador vs Bot ");
        System.out.println("3- Bot vs Bot");
        int scan = leitor.nextInt();
        while (verificador){
            try{
                verificador = false;
                switch (scan){
                    case 1:
                        jogador1 = new Jogador(1);
                        jogador2 = new Jogador(2);
                        break;
                    case 2:
                        jogador1 = new Jogador(1);
                        jogador2 = new Bot(2);
                        break;
                    case 3:
                        jogador1 = new Bot(1);
                        jogador2 = new Bot(2);
                        break;
                    default:
                        throw new IllegalArgumentException("Numero Inválido");
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                verificador = true;
                scan = leitor.nextInt();

            }
        }
    }

    public void inicarJogo(){
        jogador1.comecarJogo(jogador2);
        jogador1.alterarPosicaoDeCombate(PosicaoDeCombate.ATACANTE);
        jogador2.comecarJogo(jogador1);
        jogador2.alterarPosicaoDeCombate(PosicaoDeCombate.DEFENSOR);
        rodadas = 1;
    }

    public void novaRodada(){
        rodadas++;
        jogador1.alterarPosicaoDeCombate(rodadas);
        jogador2.alterarPosicaoDeCombate(rodadas);
        jogador1.topDeckCarta();
        jogador2.topDeckCarta();

    }

    public void realizarAcao(){
        if(jogador1.ehAtacante())
            jogador1.realizarAcao();
        else
            jogador2.realizarAcao();
    }

    public void mostrarResumo(){
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("RESUMO DA RODADA ATUAL");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        System.out.println("Rodada "+rodadas);
        System.out.println("Resumo Jogador 1: ");
        jogador1.mostrarResumo();
        System.out.println("Resumo Jogador 2: ");
        jogador2.mostrarResumo();
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");


    }
}
