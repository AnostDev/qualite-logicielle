package calculatrice;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class Bugs {
    private int x;
    private Integer y;

    Bugs() {
        Bugs b = new Bugs();
        x = b.getX();
    }

    Bugs(int x, int z) {
        x = x;
        this.y  = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    public boolean equals(Object o) {
        Bugs b = (Bugs) o;

        return (y.intValue() == b.y.intValue());
    }

    static Boolean randomBoolean() {
        Boolean b = null;

        long time = System.currentTimeMillis();

        switch ((int) time % 3) {
            case 0:
                b = Boolean.TRUE;
                break;
            case 1:
                b = Boolean.FALSE;
                break;
        }

        return b;
    }

    static float convertMillisInSecs(int numMillis) {
        return (float) (numMillis / 1000);
    }

    static <T> int binarySearch(T[] array, Comparable<T> key) {
        if (array == null && array.length == 0)
            return -1;

        int low = 0, high = array.length - 1;

        while (low <= high) {
            final int mid = (low + high) / 2;
            final int cmp = key.compareTo(array[mid]);

            if (cmp == 0)
                return mid;

            if (cmp < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return array.length;
    }

    static String concatStrings(String[] strs) {
        String str = new String();

        for (int i = 0; i < strs.length - 1; i++)
            str = str + strs[i] + " ";

        return str + strs[strs.length - 1];
    }

    static void hello(String lang) {
        if (lang == "English") {
            System.out.println("Hello!");
        } else if (lang == "Francais") {
            System.out.println("Bonjour!");
        } else {
            System.out.println("Sorry, I don't speak " + lang);
        }
    }

    static String digitToString(int i) {
        StringBuffer buffer = new StringBuffer();

        switch (i) {
            case 0:
                buffer.append("zero");
                break;
            case 1:
                buffer.append("un");
                break;
            case 2:
                buffer.append("deux");
                break;
            case 3:
                buffer.append("trois");
                break;
            case 4:
                buffer.append("quatre");
                break;
            case 5:
                buffer.append("cinq");
                break;
            case 6:
                buffer.append("six");
                break;
            case 7:
                buffer.append("sept");
                break;
            case 8:
                buffer.append("huit");
            case 9:
                buffer.append("neuf");
                break;
        }

        return buffer.toString();
    }

    static boolean isOdd(int i) {
        return (i % 2 == 1);
    }

    static boolean isodd(int i) {
        return ((i & 2) == 1);
    }

    public static void main(String[] args) {
        String[] strs = { "Un", "Deux", "Trois"};

        System.out.println("strs: " + concatStrings(strs));

        hello("Francais");
        String lang = new String("English");
        hello(lang);

        System.out.println(digitToString(8));

        Integer[] array = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println("array: " + array);
        System.out.println(binarySearch(array, 3));

        Bugs bugs = new Bugs(0, 1);

        int i = 3;
        String str = new Integer(i).toString();
        System.out.println("isOdd(" + str + "): " + isOdd(i));
        i = -1;
        System.out.println("isOdd(" + i + "): " + isOdd(i));

        Map<Integer, Bugs> map = new HashMap<Integer, Bugs>();

        Bugs b1 = new Bugs(0, 1);
        Bugs b2 = new Bugs(0, 2);
        Bugs b3 = new Bugs(0, 3);

        map.put(b1.hashCode(), b1);
        map.put(b2.hashCode(), b2);
        map.put(b3.hashCode(), b3);

        Collection<Bugs> c = map.values();

        for (Bugs bug : c)
            System.out.println("bug: " + bug);

        int numMillis = 1500;
        System.out.println(numMillis + "ms: " + convertMillisInSecs(numMillis) + "secs");

        boolean b = randomBoolean();
        System.out.println("random boolean: " + b);
    }
}
