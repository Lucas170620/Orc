package game;

public class Game {
    private boolean exitSelected;
    public void start() {
        exitSelected = false;
        System.out.println("game.Game started!");
        while(!exitSelected) {
            drawBoard();
            readInput();
            updateBoard();
        }
        System.out.println("game.Game terminated. Bye!");
    }

    private void drawBoard(){
    }
    private void readInput(){
    }
    private void updateBoard(){
    }
}
