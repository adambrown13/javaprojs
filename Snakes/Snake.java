import java.util.ArrayList;

public class Snake {
    int size;
    ArrayList<int[]> tail;
    int[] head = {0,0};

    public Snake(){
        tail = new ArrayList<int[]>();
        int[] inputArr = {16, 17};
        tail.add(inputArr);
        inputArr[1] = 18;
        tail.add(inputArr);
        inputArr[1] = 19;
        tail.add(inputArr);
        head[0] = 16;
        head[1] = 16;

    }


}
