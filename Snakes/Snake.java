import java.util.ArrayList;

public class Snake {
    int size;
    ArrayList<Integer[]> tail;
    int[] head = int[2];

    public Snake(){
        tail = new ArrayList<Integer[]>();
        int[] inputArr = {16, 17};
        tail.add(inputArr);
        int[] inputArr = {16, 18};
        tail.add(inputArr);
        int[] inputArr = {16, 19};
        tail.add(inputArr);
        head = [16, 16];

    }


}
