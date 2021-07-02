public class Game {
    private boolean escolherSair;
    public void start() {
        escolherSair = false;
        System.out.println("Jogo Começou!");
        while(!escolherSair) {
            drawBoard();
            lerEntrada();
            atualizarMesa();
        }
        System.out.println("Jogo Acabou!");
    }

    private void drawBoard(){
    }

    private void lerEntrada(){
    }

    private void atualizarMesa(){
    }
}
