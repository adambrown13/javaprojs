public class Field{

    int[] head;
    int[][] tail;
    Snake fieldSnake; 

    public Field(){

        fieldSnake = new Snake();

    }

    private void drawBoard(){
        StdDrawPlus.setPenColor(StdDrawPlus.GREEN);
        StdDrawPlus.filledSquare(16.5, 16.5, 16.5);
        StdDrawPlus.setPenColor(StdDrawPlus.BLACK);
        StdDrawPlus.setPenRadius(0.025);
        StdDrawPlus.square(16.5, 16.5, 16.5);
        StdDrawPlus.setPenRadius();
        
    }

    private void drawSnake(){
        head = fieldSnake.returnHead();
        StdDrawPlus.setPenColor(StdDrawPlus.RED);
        StdDrawPlus.filledSquare(head[0], head[1], 0.5);
        tail = fieldSnake.returnTail();
        StdDrawPlus.setPenColor(StdDrawPlus.WHITE);
        for (int[] coord : tail) {
            StdDrawPlus.filledSquare(coord[0], coord[1], 0.5);
        }
        
    }

    private void snakeDown(){
        fieldSnake.down();
    }

    private boolean snakeAlive() {
        if (head == null) {
            return true;
        }
        if (head[0] == 0 || head[0] == 33 || head[1] == 0 || head[1] == 33) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        StdDrawPlus.setXscale(0, 33);
        StdDrawPlus.setYscale(0, 33);
        Field test = new Field();
        
        while(test.snakeAlive()) {
            test.drawBoard();
            test.drawSnake();
            test.snakeDown();

        }
        
        System.out.println("The Snake Has Died");
    }
}