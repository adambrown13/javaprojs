import java.util.Scanner;
import java.util.Random;

class screwAround{

    String oneOne;
    String oneTwo;
    String oneThree;
    String twoOne;
    String twoTwo;
    String twoThree;
    String threeOne;
    String threeTwo;
    String threeThree;

    private screwAround(){
        oneOne = "11";
        oneTwo = "12";
        oneThree = "13";
        twoOne = "21";
        twoTwo = "22";
        twoThree = "23";
        threeOne = "31";
        threeTwo = "32";
        threeThree = "33";
        printBoard();
    }

    private void boardReset(){ 
        oneOne = " ";
        oneTwo = " ";
        oneThree = " ";
        twoOne = " ";
        twoTwo = " ";
        twoThree = " ";
        threeOne = " ";
        threeTwo = " ";
        threeThree = " ";
    }

    public void printBoard(){
        System.out.println(oneOne + " | " + oneTwo + " | " + oneThree);
        System.out.println("_________");
        System.out.println(twoOne + " | " + twoTwo + " | " + twoThree);
        System.out.println("_________");
        System.out.println(threeOne + " | " + threeTwo + " | " + threeThree);
    }

    public boolean move(int player, int place){
        String mark;
        if (player == 0) {
            mark = "X";
        } else {
            mark = "O";
        }
        int x = place/10;
        int y = place%10;
        if(x > 3 || x < 1 || y > 3 || y < 1) {
            return false;
        }
        if(x == 1) {
            if (y == 1) {
                if (oneOne != " ") {
                    return false;
                }
                oneOne = mark;
                return true;
            }
            if (y == 2) {
                if (oneTwo != " ") {
                    return false;
                }
                oneTwo = mark;
                return true;
            }
            if (oneThree != " ") {
                    return false;
            }
            oneThree = mark;
            return true;
        }
        if(x == 2) {
            if (y == 1) {
                if (twoOne != " ") {
                    return false;
                }
                twoOne = mark;
                return true;
            }
            if (y == 2) {
                if (twoTwo != " ") {
                    return false;
                }
                twoTwo = mark;
                return true;
            }
            if (twoThree != " ") {
                    return false;
            }
            twoThree = mark;
            return true;
        }
        if (y == 1) {
            if (threeOne != " ") {
                return false;
            }
            threeOne = mark;
            return true;
        }
        if (y == 2) {
            if (threeTwo != " ") {
                return false;
            }
            threeTwo = mark;
            return true;
        }
        if (threeThree != " ") {
            return false;
        }
        threeThree = mark;
        return true;
        

    }

    public int win(){
        if (oneOne == "X" && oneTwo == "X" && oneThree == "X" ||
            twoOne == "X" && twoTwo == "X" && twoThree == "X" ||
            threeOne == "X" && threeTwo == "X" && threeThree == "X" ||
            oneOne == "X" && twoOne == "X" && threeOne == "X" ||
            oneTwo == "X" && twoTwo == "X" && threeTwo == "X" ||
            oneThree == "X" && twoThree == "X" && threeThree == "X" ||
            oneOne == "X" && twoTwo == "X" && threeThree == "X" ||
            threeOne == "X" && twoTwo == "X" && oneThree == "X") {
            return 1;
        }
        if (oneOne == "O" && oneTwo == "O" && oneThree == "O" ||
            twoOne == "O" && twoTwo == "O" && twoThree == "O" ||
            threeOne == "O" && threeTwo == "O" && threeThree == "O" ||
            oneOne == "O" && twoOne == "O" && threeOne == "O" ||
            oneTwo == "O" && twoTwo == "O" && threeTwo == "O" ||
            oneThree == "O" && twoThree == "O" && threeThree == "O" ||
            oneOne == "O" && twoTwo == "O" && threeThree == "O" ||
            threeOne == "O" && twoTwo == "O" && oneThree == "O") {
            return 2;
        }
        return 0;
    }

    public void humans(String playerOne, String playerTwo){
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        while (win()==0 && counter < 9) {
            if (counter%2 == 0) {
                System.out.println(playerOne + ", play!");
            } else {
                System.out.println(playerTwo + ", play!");
            }
            int movePlay = Integer.parseInt(scanner.next());
            if (move(counter%2, movePlay)) {
                printBoard();
                counter += 1;
            }else{
                System.out.println("Invalid Move");
            }
            
        }
    }
    public void simpleBots(){
        int counter = 0;
        int[] moves = {11, 12, 13, 21, 22, 23, 31, 32, 33};
        boolean[] chosen = {false, false, false, false, false, false, false, false, false};
        while (win()==0 && counter < 9) {
            if (counter%2 == 0) {
                System.out.println("First Bot is going, play!");
            } else {
                System.out.println("Second Bot is going, play!");
            }
            boolean chosenPiece = true;
            int selection = -1;
            while (chosenPiece) {
                selection = new Random().nextInt(moves.length);
                chosenPiece = chosen[selection];
            }
            chosen[selection] = true;
            int movePlay = moves[selection];
            if (move(counter%2, movePlay)) {
                printBoard();
                counter += 1;
            }else{
                System.out.println("Invalid Move");
            }
            
        }
    }

    public static void main(String[] args) {
        screwAround board = new screwAround();
        board.boardReset();
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What is player 1's name?");
            String playerOne = scanner.next();
            System.out.println("What is player 2's name?");
            String playerTwo = scanner.next();
            board.humans(playerOne, playerTwo);
            if (board.win() == 1) {
                System.out.println("Congrats, "+ playerOne +", you won!");
                return;    
            } 
            if (board.win() == 2) {
                System.out.println("Congrats, "+ playerTwo +", you won!");    
                return;
            } else {
                System.out.println("It's a draw!");    
                return;
            }    
        } else {
            board.simpleBots();
            if (board.win() == 1) {
                System.out.println("First Bot won!");
                return;    
            } 
            if (board.win() == 2) {
                System.out.println("Second Bot won!");    
                return;
            } else {
                System.out.println("It's a draw!");    
                return;
            }  

        }
        
        
        

    }
}