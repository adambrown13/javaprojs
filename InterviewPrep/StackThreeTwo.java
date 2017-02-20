import java.util.Arrays;

class StackThreeTwo {

    int size;

    public StackThreeTwo(int constSize){
      size = constSize;
    }

    public boolean push(int input){
      return false;
    }

    public int pop(){
      return -1;
    }

    public int min(){
      return -1;
    }

    public static void main(String args[]) {
    StackThreeTwo st = new StackThreeTwo(5);
    int total = 0;
    boolean testResult;
    boolean backOne;
    boolean backTwo;
    boolean backThree;
    int outInt;
    int outIntTwo;
    System.out.println("Running Tests");
    testResult = st.push(5);
    System.out.println("Testing : Initialized and One Element Added");
    if (testResult) {
      System.out.println("PASSED Test One");
      total += 1;
    } else {
      System.out.println("FAILED Test One");
      System.out.println("Expected:" + true + "||Got:" + false);
    }
    System.out.println("Testing : Four Elements Added");
    testResult = st.push(2);
    backOne = st.push(6);
    backTwo = st.push(1);
    backThree = st.push(8);
    if (testResult && backOne && backTwo && backThree) {
      System.out.println("PASSED Test Two");
      total += 1;
    } else {
      System.out.println("FAILED Test Two");
      System.out.println("Expected:" + true + "-" + true + "-" + true + "-" + true + "||Got:" + testResult + "-" + backOne + "-" + backTwo + "-" + backThree);
    }
    System.out.println("Testing : Can't Add More Elements");
    testResult = st.push(1000);
    if (!testResult) {
      System.out.println("PASSED Test Three");
      total += 1;
    } else {
      System.out.println("FAILED Test Three");
      System.out.println("Expected:" + false + "||Got:" + testResult);
    }
    System.out.println("Testing : Pop works once");
    outInt = st.pop();
    if (outInt == 8) {
      System.out.println("PASSED Test Four");
      total += 1;
    } else {
      System.out.println("FAILED Test Four");
      System.out.println("Expected:" + 8 + "||Got:" + outInt);
    }
    System.out.println("Testing : Min works");
    testResult = st.push(8);
    outInt = st.min();
    if (outInt == 1) {
      System.out.println("PASSED Test Five");
      total += 1;
    } else {
      System.out.println("FAILED Test Five");
      System.out.println("Expected:" + 1 + "||Got:" + outInt);
    }
    System.out.println("Testing : Multiple Pops works");
    outInt = st.pop();
    outIntTwo = st.pop();
    if (outInt == 8 && outIntTwo == 1) {
      System.out.println("PASSED Test Six");
      total += 1;
    } else {
      System.out.println("FAILED Test Six");
      System.out.println("Expected:" + 8 +" & "+ 1 + "||Got:" + outInt +" & "+ outIntTwo );
    }
    System.out.println("Testing : Min updates");
    outInt = st.min();
    if (outInt == 2) {
      System.out.println("PASSED Test Seven");
      total += 1;
    } else {
      System.out.println("FAILED Test Seven");
      System.out.println("Expected:" + 2 + "||Got:" + outInt);
    }
    System.out.println(total + "/7");
    System.out.println("Tests Completed");
  }
}