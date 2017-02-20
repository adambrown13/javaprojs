import java.util.ArrayList;

class stringCombos {

    private static void printList(ArrayList<String> inList) {
        for (String point : inList ) {
            System.out.print(point + " ");
        }
        System.out.println();
    }

    private static int factorial(int input) {
        int counter = input - 1;
        int output = input;
        while (counter != 0) {
            output = counter * output;
            counter -= 1;
        }
        return output;
    }

    private static ArrayList<String> manyPoints(String inString, String movingPoint){
        ArrayList<String> outputList = new ArrayList<String>();
        for (int i = 0; i < inString.length() + 1; i++) {
            outputList.add(inString.substring(0, i) + movingPoint + inString.substring(i, inString.length()));
        }
        return outputList;
    }

    private static ArrayList<String> recursivePoint(ArrayList<String> inString, String inPoint){
        ArrayList<String> outputList = new ArrayList<String>();
        String sampleFirst = inString.get(0);
        if (sampleFirst.length() == 1) {
            return inString; 
        }
        else {
            ArrayList<String> tempArr;
            ArrayList<String> realtempArr = new ArrayList<String>();
            realtempArr.add(sampleFirst.substring(0, sampleFirst.length()-1));
            String lastChar = sampleFirst.substring(sampleFirst.length()-1, sampleFirst.length());
            ArrayList<String> brokenDown = recursivePoint(realtempArr, lastChar);
            for (String midString : brokenDown) {
                tempArr = manyPoints(midString, sampleFirst.substring(sampleFirst.length()-1, sampleFirst.length()));
                outputList.addAll(tempArr);    
            }
            
        }
        return outputList;

    }

    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }
        ArrayList<String> start = new ArrayList<String>();
        start.add(args[0]);
        printList(recursivePoint(start, start.get(0).substring(args[0].length()-1, args[0].length())));
    }
}