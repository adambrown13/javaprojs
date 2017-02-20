import java.util.Scanner;

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

    public void move(int player, int place){
        String mark;
        if (player == 0) {
            mark = "X";
        } else {
            mark = "O";
        }
        int x = place/10;
        int y = place%10;
        if(x > 3 || x < 1 || y > 3 || y < 1) {
            System.out.println("Invalid Move!");
            return;
        }
        if(x == 1) {
            if (y == 1) {
                oneOne = mark;
                return;
            }
            if (y == 2) {
                oneTwo = mark;
                return;
            }
            oneThree = mark;
            return;
        }
        if(x == 2) {
            if (y == 1) {
                twoOne = mark;
                return;
            }
            if (y == 2) {
                twoTwo = mark;
                return;
            }
            twoThree = mark;
            return;
        }
        if (y == 1) {
            threeOne = mark;
            return;
        }
        if (y == 2) {
            threeTwo = mark;
            return;
        }
        threeThree = mark;
        return;
        

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

    public static void main(String[] args) {
        screwAround board = new screwAround();
        Scanner scanner = new Scanner(System.in);
        board.boardReset();
        System.out.println("What is player 1's name?");
        String playerOne = scanner.next();
        System.out.println("What is player 2's name?");
        String playerTwo = scanner.next();
        int counter = 0;
        while (board.win()==0) {
            if (counter%2 == 0) {
                System.out.println(playerOne + ", play!");
            } else {
                System.out.println(playerTwo + ", play!");
            }
            int movePlay = Integer.parseInt(scanner.next());
            board.move(counter%2, movePlay);
            board.printBoard();
            counter += 1;
        }
        if (board.win() == 1) {
            System.out.println("Congrats, "+ playerOne +", you won!");    
        } else{
            System.out.println("Congrats, "+ playerTwo +", you won!");    
        }
        

    }
}