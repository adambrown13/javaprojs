import java.util.Arrays;

class RecursiveSort
{
  public int[] takesAllSorts(int[] firstArr, int[] secondArr){
    int prev = -100000;
    int curr = -100000;
    int pointerA = 0;
    int pointerB = 0;
    int pointerT = 0;
    int[] movingArr = new int[firstArr.length + secondArr.length];
    if (movingArr.length == 0) {
      return null;
    }
    return actualMerge(firstArr, secondArr, movingArr, curr, prev, pointerA, pointerB, pointerT);
  } 


  public int[] actualMerge(int[] firstArr, int[] secondArr, int[] movingArr, int curr, int prev, int pointerA, int pointerB, int pointerT) {
    if (firstArr.length == 0 && secondArr.length == 0) {
      return null;
    }
    if (pointerA == firstArr.length && pointerB == secondArr.length && pointerT == movingArr.length) {
      return movingArr;
    }
    int tempPrev = curr;
    if ((secondArr.length == 0 || secondArr.length - 1 < pointerB)|| (pointerA < firstArr.length && firstArr[pointerA] < secondArr[pointerB])) {
      curr = firstArr[pointerA];
      if (tempPrev > curr) {
        System.out.println("Something Broke AAAA");
        return null;
      }
      pointerA += 1;
    } else if((firstArr.length == 0 || firstArr.length - 1 < pointerA) || (pointerB < secondArr.length && firstArr[pointerA] > secondArr[pointerB])) {
      curr = secondArr[pointerB];
      if (tempPrev > curr) {
        System.out.println("Something Broke BBBB");
        return null;
      }
      pointerB += 1;  
    }
    movingArr[pointerT] = curr;
    pointerT += 1;
    //System.out.println("movingArr=" + Arrays.toString(movingArr));
    //System.out.println("Pointers: A=" + pointerA + " B=" + pointerB + " T=" + pointerT);
    return actualMerge(firstArr, secondArr, movingArr, curr, prev, pointerA, pointerB, pointerT);
    
      /*System.out.println("Something went wrong: ||Status||");
      System.out.println("movingArr=" + Arrays.toString(movingArr));
      System.out.println("Pointers: A=" + pointerA + " B=" + pointerB + " T=" + pointerT);
      return null;*/
    
  }

  public static void main(String args[]) {
    RecursiveSort rs = new RecursiveSort();
    int total = 0;
    int[] smallSortedArr = {1, 2, 3};
    int[] smallFirstHalfArr = {1, 3};
    int[] smallSecondHalfArr = {2, 4};
    int[] justFour = {4};
    int[] twoFours = {4, 4};
    int[] manyRepeats = {1, 1, 3, 3, 6, 6, 7};
    int[] manyRepeatsDone = {1, 1, 3, 3, 4, 4, 6, 6, 7};
    int[] smallFinishedArr = {1, 2, 3, 4};
    int[] smallUnSortedArr = {1, 3, 2};
    int[] largeOneArr = {-12, -4, 37, 55, 88, 124, 188, 1004, 6083};
    int[] largeTwoArr = {-132, -44, 33, 65, 98, 224, 388, 3004, 64083, 100040};
    int[] largeBothArr = {-132, -44, -12, -4, 33, 37, 55, 65, 88, 98, 124, 188, 224, 388, 1004, 3004, 6083, 64083, 100040};
    int[] emptyArr = {};
    int[] shitOnMeArr;
    System.out.println("Running Tests");
    shitOnMeArr = rs.takesAllSorts(smallSortedArr, emptyArr);
    if (Arrays.equals(shitOnMeArr, smallSortedArr)) {
      System.out.println("PASSED Test One");
      total += 1;
    } else {
      System.out.println("FAILED Test One");
      System.out.println("Expected:" + Arrays.toString(smallSortedArr) + "||Got:" + Arrays.toString(shitOnMeArr));
    }
    shitOnMeArr = rs.takesAllSorts(emptyArr, emptyArr);
    if (shitOnMeArr == null) {
      System.out.println("PASSED Test Two");
      total += 1;
    } else {
      System.out.println("FAILED Test Two");
      System.out.println("Expected:" + null + "||Got:" + Arrays.toString(shitOnMeArr));
    }
    shitOnMeArr = rs.takesAllSorts(smallSortedArr, justFour);
    if (Arrays.equals(shitOnMeArr, smallFinishedArr)) {
      System.out.println("PASSED Test Three");
      total += 1;
    } else {
      System.out.println("FAILED Test Three");
      System.out.println("Expected:" + Arrays.toString(smallFinishedArr) + "||Got:" + Arrays.toString(shitOnMeArr));
    }
    shitOnMeArr = rs.takesAllSorts(justFour, smallSortedArr);
    if (Arrays.equals(shitOnMeArr, smallFinishedArr)) {
      System.out.println("PASSED Test Four");
      total += 1;
    } else {
      System.out.println("FAILED Test Four");
      System.out.println("Expected:" + Arrays.toString(smallFinishedArr) + "||Got:" + Arrays.toString(shitOnMeArr));
    }
    shitOnMeArr = rs.takesAllSorts(smallFirstHalfArr, smallSecondHalfArr);
    if (Arrays.equals(shitOnMeArr, smallFinishedArr)) {
      System.out.println("PASSED Test Five");
      total += 1;
    } else {
      System.out.println("FAILED Test Five");
      System.out.println("Expected:" + Arrays.toString(smallFinishedArr) + "||Got:" + Arrays.toString(shitOnMeArr));
    }
    //shitOnMeArr = rs.takesAllSorts(justFour, justFour);
    if (Arrays.equals(shitOnMeArr, smallFinishedArr)) {
      System.out.println("PASSED Test Six");
      total += 1;
    } else {
      System.out.println("FAILED Test Six");
      System.out.println("Expected:" + Arrays.toString(twoFours) + "||Got:" + Arrays.toString(shitOnMeArr));
    }
    shitOnMeArr = rs.takesAllSorts(manyRepeats, twoFours);
    if (Arrays.equals(shitOnMeArr, manyRepeatsDone)) {
      System.out.println("PASSED Test Seven");
      total += 1;
    } else {
      System.out.println("FAILED Test Seven");
      System.out.println("Expected:" + Arrays.toString(manyRepeatsDone) + "||Got:" + Arrays.toString(shitOnMeArr));
    }
    shitOnMeArr = rs.takesAllSorts(largeOneArr, largeTwoArr);
    if (Arrays.equals(shitOnMeArr, largeBothArr)) {
      System.out.println("PASSED Test Eight");
      total += 1;
    } else {
      System.out.println("FAILED Test Eight");
      System.out.println("Expected:" + Arrays.toString(largeBothArr));
      System.out.println("|||||Got:" + Arrays.toString(shitOnMeArr));
    }
    System.out.println(total + "/8");
    System.out.println("Tests Completed");
  }
}
