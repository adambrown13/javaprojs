import java.util.HashMap;

class childstep {

    private static int counter(int steps) {
        if (steps < 3) {
            return steps;
        }
        if (steps == 3) {
            return 4;
        }
        return counter(steps - 3) + counter(steps - 2) + counter(steps - 1);
    } 
    private static int correctCounter(int steps) {
        if (steps < 0) {
            return 0;
        }
        if (steps == 0) {
            return 1;
        }
        return counter(steps - 3) + counter(steps - 2) + counter(steps - 1);
    } 

    public static void main(String args[]) {
        int steps = Integer.parseInt(args[0]);
        HashMap<Integer, Integer> results = new HashMap<Integer, Integer>();
        if (steps < 3) {
            System.out.println(steps);
            return;
        }
        if (steps == 3) {
            System.out.println(4);
            return;
        
        }
        results.put(0,0);
        results.put(1,1);
        results.put(2,2);
        results.put(3,4);
        for (int i = 3; i < steps; i++) {
            results.put(i, (results.get(i-3)+results.get(i-2)+results.get(i-1))); 
        }
        System.out.println(counter(steps));
        System.out.println(correctCounter(steps));
        System.out.println(results.get(steps - 3) + results.get(steps - 2) + results.get(steps - 1));
    }
}