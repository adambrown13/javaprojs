import java.util.Arrays;

class moderateProblems{

    private static void printList(int[] inList) {
        System.out.print("[");
        for (int i = 0; i < inList.length - 1 ; i++ ) {
            System.out.print(inList[i] + ",");
        }
        System.out.print(inList[inList.length - 1] + "]");
        
    }

    public static void inPlaceArraySwitch(int[] modifier, int first, int second){

        modifier[first] = modifier[first] - modifier[second];
        modifier[second] = modifier[second] + modifier[first];
        modifier[first] = modifier[second] - modifier[first];

    }

    public static void main(String[] args) {
        int total = 0;
        int correct = 0;

        //Things to use to test with

        int[] arrToModify = {1, 2, 3, 4, 5};
        int[] postArr = {1, 4, 3, 2, 5};
        int[] dummyArr = {1, 2, 3, 4, 5};

        //End initializing stuff

        //Tests starting
        System.out.println("---Testing---");
        System.out.println("Test 1: checking array switch");
        total += 1;
        inPlaceArraySwitch(arrToModify, 1, 3);
        if (Arrays.equals(arrToModify, postArr)) {
            System.out.println("Test 1: Passed");
            correct += 1;
        }else{
            System.out.println("Test 1: Failed");
            System.out.print("Expected:");
            printList(postArr);
            System.out.print("Received:");
            printList(arrToModify);
            System.out.println("");
        }
        total += 1;
        arrToModify[1] = 2;
        arrToModify[3] = 4;
        inPlaceArraySwitch(arrToModify, 3, 1);
        if (Arrays.equals(arrToModify, postArr)) {
            System.out.println("Test 2: Passed");
            correct += 1;
        }else{
            System.out.println("Test 2: Failed");
            System.out.print("Expected:");
            printList(postArr);
            System.out.print("Received:");
            printList(arrToModify);
            System.out.println("");
        } 
        //Tests completed

        System.out.println("Passed " + correct + "/" + total + " Tests");


    }
}