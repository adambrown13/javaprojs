class multTables {
    public static void main(String args[]) {
        int intNum = Integer.parseInt(args[0]);
        for (int i = 1; i <  intNum + 1; i++ ) {
            for (int j = 1; j < intNum + 1; j++ ) {
                System.out.print ( String.format ( "%4d", j * i ));
            }
            System.out.println();
        }
    }
}