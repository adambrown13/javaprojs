import java.util.ArrayList;

public class Snake {

    int size;
    ArrayList<int[]> tail;
    int[] head = {0,0};
    int tailAdd = 0;


    public Snake(){
        tail = new ArrayList<int[]>();
        tail.add(new int[] {16, 19});
        tail.add(new int[] {16, 18});
        tail.add(new int[] {16, 17});
        head[0] = 16;
        head[1] = 16;
        size = 4;

    }

    public void down() {
        if (tailAdd != 0) {
            tailAdd -= 1;
        } else {
            tail.remove(0);
        }
        tail.add(new int[] {head[0], head[1]});
        int temp = head[1];
        head[1] = temp - 1;

    }

    public void left() {
        if (tailAdd != 0) {
            tailAdd -= 1;
        } else {
            tail.remove(0);
        }
        tail.add(new int[] {head[0], head[1]});
        int temp = head[0];
        head[0] = temp - 1;

    }

    public void up() {
        if (tailAdd != 0) {
            tailAdd -= 1;
        } else {
            tail.remove(0);
        }
        tail.add(new int[] {head[0], head[1]});
        int temp = head[1];
        head[1] = temp + 1;

    }

    public void right() {
        if (tailAdd != 0) {
            tailAdd -= 1;
        } else {
            tail.remove(0);
        }
        tail.add(new int[] {head[0], head[1]});
        int temp = head[0];
        head[0] = temp + 1;

    }

    public void foodCollected() {
        tailAdd = 2;
        return;
    }

    public int[] returnHead() {
        return head;
    }

    public int[][] returnTail() {
        Object[] tempArr = tail.toArray();
        int[][] output = new int[tempArr.length][];
        for (int i = 0 ; i < tempArr.length; i++ ) {
            output[i] = (int[]) tempArr[i];
        }
        return output;
    }

}
