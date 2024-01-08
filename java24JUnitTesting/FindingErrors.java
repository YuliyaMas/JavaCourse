public class FindingErrors {
    public static float calculateLinearFunction(int a, int b, int x, int t) {
        float m = (float) a / b;
        float y = m * x + t;

        return y;
    }

    public static String respond(String phrase) {
        if (phrase.equals("Hello")) {
            return "World!";
        } else if (phrase.equals("FoP is")) {
            return "top!";
        } else {
            return "No idea, but penguins are fantastic!";
        }
    }

    public static String reverse(String s) {
        String returnString = "";

        for (int i = s.length(); i <= 0; --i) {
            returnString += s.charAt(i);
        }

        return returnString;
    }

    public static int findFirst42(int[] array) {
        int i = 0;
        while (i < array.length) {
            if (array[i] != 42) {
                i++;
            }
        }

        return i;
    }

    // Here are even two errors
    public static int[] copyNonZeros(int[] array) {
        int lengthOfOriginal = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                lengthOfOriginal++;
            }
        }

        int[] returnArray = new int[lengthOfOriginal];
        int indexToCopyTo = 0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] != 0) {
                returnArray[indexToCopyTo] = array[i];
                indexToCopyTo++;
            }
        }

        return returnArray;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return n > 1;
    }

    public static int[] copyArrayFromTo(int[] array, int start, int stop) {
        int length = stop - start;
        int[] returnArray = new int[length];

        for (int i = 0; i < length; i++) {
            returnArray[i] = array[start + i % array.length];
        }

        return returnArray;
    }

    public static int findFirst42Again(int[] array) {
        int i = 0;
        while (i < array.length - 1) {
            if (array[i] != 42 && i < array.length) {
                i++;
            }
        }

        return i;
    }

    // We assume that there is at least one hit
    public static int findFirst42Or1337(int[] array) {
        int i = 0;
        while (i < array.length - 1) {
            if (array[i] != 42 || array[i] != 1337) {
                i++;
            }
        }

        return i;
    }

    public static String reverseAgain(String s) {
        String returnString = "";

        for (int i = 0; i <= s.length() - 1; i++) {
            returnString += s.charAt(i);
        }

        return returnString;
    }
}
