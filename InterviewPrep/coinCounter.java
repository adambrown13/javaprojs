import java.util.HashMap;

class coinCounter {

    private static int purseSimple(int cents) {
        if (cents < 0) {
            return 0;
        }
        if (cents < 5) {
            return 1;
        }
        if (cents < 10) {
            return 2;
        }
        if (cents < 25) {
            return (purseSimple(cents - 10) + purseSimple(cents - 5));
        }
        return purseSimple(cents - 25) + purseSimple(cents - 10) + purseSimple(cents - 5); 
    }

    private static int purseSimpleCorrect(int amount, int[] denoms, int index) {
        if (index >= denoms.length - 1) return 1;
        int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0; i * denomAmount <= amount ; i++ ) {
            int amountRemaining = amount - i * denomAmount;
            ways += purseSimpleCorrect(amountRemaining, denoms, index + 1);
        }
        return ways;
    }

    private static int purseDynamic(int amount, int[] denoms, int index, HashMap<Integer, Integer> results) {
        if (index >= denoms.length - 1) return 1;
        int denomAmount = denoms[index];
        int ways = 0;
        if (results.containsKey(amount)) {
            return results.get(amount);
        }
        for (int i = 0; i * denomAmount <= amount ; i++ ) {
            int amountRemaining = amount - i * denomAmount;
            if (results.containsKey(amountRemaining)) {
                System.out.println("AT LEAST A FEW TIMES");
                return results.get(amountRemaining);                
            }
            results.put(amount, amountRemaining);
            ways += purseSimpleCorrect(amountRemaining, denoms, index + 1);
        }
        return ways;
    }

    public static void main(String[] args) {
        int amount = Integer.parseInt(args[0]);
        int[] denoms = {25, 10, 5, 1};
        HashMap<Integer, Integer> results = new HashMap<Integer, Integer>();

        System.out.println(purseSimpleCorrect(amount, denoms, 0));
        System.out.println(purseDynamic(amount, denoms, 0, results));

    }
}
