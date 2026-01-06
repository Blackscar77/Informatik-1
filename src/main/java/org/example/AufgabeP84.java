package org.example;

public class AufgabeP84 {

    public static void main(String[] args) {
        // Beispiele & Tests
        assert hRecurrent(0) == 1;
        assert hWhile(0) == 1;
        assert hFor(0) == 1;

        assert hRecurrent(1) == 2;
        assert hWhile(1) == 2;
        assert hFor(1) == 2;

        assert hRecurrent(2) == 2;
        assert hWhile(2) == 2;
        assert hFor(2) == 2;


        assert hRecurrent(3) == 4;
        assert hWhile(3) == 4;
        assert hFor(3) == 4;

        assert hRecurrent(4) == 0;
        assert hWhile(4) == 0;
        assert hFor(4) == 0;

        assert hRecurrent(10) == -1536;
        assert hWhile(10) == -1536;
        assert hFor(10) == -1536;


        assert hRecurrent(3) == hWhile(3) && hWhile(3) == hFor(3);
        assert hRecurrent(4) == hWhile(4) && hWhile(4) == hFor(4);
        assert hRecurrent(10) == hWhile(10) && hWhile(10) == hFor(10);

        System.out.println("Alle Tests erfolgreich!");
    }

    /**
     * Öffentliche rekursive Funktion. Sie verwendet eine endrekursive
     * Hilfsfunktion hTail(), welche die letzten drei Werte mitführt.
     */
    public static long hRecurrent(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n muss >= 0 sein");
        }
        // Basisfälle direkt behandeln
        if (n == 0) return 1;
        if (n == 1 || n == 2) return 2;

        // Tail-Recursive Helper:
        // Parameter: n, h(n-1), h(n-2), h(n-3)
        return hTail(n, 2, 2, 1);
    }

    /*
    Rekursive hilfsfunktion
     */
    private static long hTail(int n, long hm1, long hm2, long hm3) {
        if (n == 2) {
            return hm1;  // h(2) = hm1
        }
        long next = 2 * hm1 + 4 * hm2 - 8 * hm3;
        return hTail(n - 1, next, hm1, hm2);
    }


    /**
     * Iterative while Schleifen Version.
     */
    public static long hWhile(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n muss >= 0 sein");
        }
        if (n == 0) return 1;
        if (n == 1 || n == 2) return 2;

        long hm1 = 2;  // h(n-1)
        long hm2 = 2;  // h(n-2)
        long hm3 = 1;  // h(n-3)
        int k = 3;

        while (k <= n) {
            long next = 2 * hm1 + 4 * hm2 - 8 * hm3;
            hm3 = hm2;
            hm2 = hm1;
            hm1 = next;
            k++;
        }

        return hm1;
    }


    /**
     * Iterative for Schleifen Version.
     */
    public static long hFor(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n muss >= 0 sein");
        }
        if (n == 0) return 1;
        if (n == 1 || n == 2) return 2;

        long hm1 = 2, hm2 = 2, hm3 = 1;

        for (int k = 3; k <= n; k++) {
            long next = 2 * hm1 + 4 * hm2 - 8 * hm3;
            hm3 = hm2;
            hm2 = hm1;
            hm1 = next;
        }

        return hm1;
    }
}