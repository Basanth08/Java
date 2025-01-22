package practicum1.question2;

/**
 * See handout for full instructions.
 */

public class FuzzyArrayCompare {
    /**
     * 
     * @param array1 - array of strings
     * @param array2 - array of strings
     * @return - true if arrays are the same length and contain the
     * same elements regardless of order, false otherwise
     */
    public static boolean fuzzyArrayCompare(String[] array1, String[] array2) {

        if(array1.length != array2.length) { 
            return false;
        }
        for(int i = 0; i < array1.length; i++) {
            String string1 = array1[i];
            boolean found = false;
            for(int j = 0; j < array2.length; j++) {
                if(string1.equals(array2[j])) {
                    found = true; 
                    break;
                }
            }
            if(!found) {
                return false;
            }
        }
        return true;
    }

    /**
     * The code below is provided as examples and validation.  Note that
     * during grading, additional tests may be run.  You may add additional
     * test cases to the main method.
     */
    public static void runTest(int testNum,String[] array1,String[] array2, boolean expected) {
        try {
            boolean actual = fuzzyArrayCompare(array1, array2);
            if (actual == expected) {
                System.out.println("Test " + testNum + ": Passed");
                return;
            }
        }
        catch (Exception e) {}

        System.out.println("Test " + testNum + ": FAILED");
    }

    public static void main(String[] args) {
        String[] array1 = new String[]{"dog","cat","mouse","dog","mouse","cat"};
        String[] array2 = new String[]{"cat","dog","dog","mouse","cat","mouse"};
        runTest(1,array1,array2,true);

        array1 = new String[]{"dog","cat","mouse","dog"};
        array2 = new String[]{"dog","mouse","cat"};
        runTest(2,array1,array2,false);

        array1 = new String[]{"dog","cat","mouse"};
        array2 = new String[]{"dog","mouse","cat"};
        runTest(3,array1,array2,true);

        array1 = new String[]{"dog","dog","dog"};
        array2 = new String[]{"dog","dog","dog"};
        runTest(4,array1,array2,true);
    }
    
}
