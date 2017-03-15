import java.util.Random;

public class Field{

    int[] head;
    int[][] tail;
    Snake fieldSnake; 
    int[] food;
    int score = 0;

    public Field(){

        fieldSnake = new Snake();
        food = new int[] {19, 25};

    }

    private void drawBoard(){
        StdDrawPlus.setPenColor(StdDrawPlus.GREEN);
        StdDrawPlus.filledSquare(16.5, 16.5, 16.5);
        StdDrawPlus.setPenColor(StdDrawPlus.BLACK);
        StdDrawPlus.setPenRadius(0.025);
        StdDrawPlus.square(16.5, 16.5, 16.5);
        StdDrawPlus.setPenRadius();
        
    }

    private void drawFood(){
        StdDrawPlus.setPenColor(StdDrawPlus.BLUE);
        StdDrawPlus.filledSquare(food[0], food[1], 0.5);
        
    }

    private void foodFound() {
        Random rand = new Random();

        if (head[0] == food[0] && head[1] == food[1]) {
            fieldSnake.foodCollected();
            score += 1;
            food[0] = rand.nextInt(31) + 1;
            food[1] = rand.nextInt(31) + 1;
        }
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

    private void snakeUp(){
        fieldSnake.up();
    }

    private void snakeLeft(){
        fieldSnake.left();
    }

    private void snakeRight(){
        fieldSnake.right();
    }

    private boolean snakeAlive() {
        if (head == null) {
            return true;
        }
        if (head[0] == 0 || head[0] == 33 || head[1] == 0 || head[1] == 33) {
            return false;
        }
        /*if (tail.contains(head)) {
            return
        }*/
        return true;
    }

    public static void main(String[] args) {
        StdDrawPlus.setXscale(0, 33);
        StdDrawPlus.setYscale(0, 33);
        Field test = new Field();
        int i = 0;
        // direction key: 1 = left, 2 = up, 3 = right, 4 = down 
        int direction = 4;
        while(test.snakeAlive()) {
            test.drawBoard();
            test.drawSnake();
            test.foodFound();
            test.drawFood();
            while (i < 20000000/((test.score + 1) * 4)) {
                i += 1;
            }
            if(StdDrawPlus.isKeyPressed(37)){
                //Left Key has been pressed
                if (direction%2 == 0) {
                    direction = 1;
                }
            }
            if(StdDrawPlus.isKeyPressed(38)){
                //Up Key has been pressed
                if (direction%2 == 1) {
                    direction = 2;
                }
            }
            if(StdDrawPlus.isKeyPressed(39)){
                //Right Key has been pressed
                if (direction%2 == 0) {
                    direction = 3;
                }
            }
            if(StdDrawPlus.isKeyPressed(40)){
                //Down Key has been pressed
                if (direction%2 == 1) {
                    direction = 4;
                }
            }
            if (direction == 1) {
                test.snakeLeft();
            }
            if (direction == 2) {
                test.snakeUp();
            }
            if (direction == 3) {
                test.snakeRight();
            }
            if (direction == 4) {
                test.snakeDown();
            }
            i = 0;
            

        }
        
        System.out.println("The Snake Has Died");
    }
}