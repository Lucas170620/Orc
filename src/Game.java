public class Game {
    private boolean escolherSair;
    public void start() {
        escolherSair = false;
        System.out.println("Game started!");
        while(!escolherSair) {
            drawBoard();
            readInput();
            updateBoard();
        }
        System.out.println("Game terminated. Bye!");
    }

    private void drawBoard(){
    }

    private void readInput(){
    }

    private void updateBoard(){
    }
}
