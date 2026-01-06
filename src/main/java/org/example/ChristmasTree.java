package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class ChristmasTree {

    public static void main(String[] args) {
        Stack<Integer> tree = new Stack<>();          // Stapel für die Baumebenen
        Queue<Integer> conveyor = new LinkedList<>(); // Warteschlange als Förderband
        //
        tree.push(2);
        tree.push(3);
        tree.push(1);

        // Beginn Ihres Codes
/*
        for (int i = 0; i < 3; i++) {
            tree.pop();
        }

        for (int i = 3; i>0; i--) {
            tree.push(i);
            //3 --> 2 --> 1
        }
 */

        // Stack --> LiFo Last in First Out
        // Queue --> FiFo First in First Out

        // Initialer Stack: [1, 3, 2] (Pop-Reihenfolge: 1, 3, 2)
        // Ziel Stack: [1, 2, 3] (Pop-Reihenfolge: 1, 2, 3)

        // 1. Element 1 auf Queue
        to_conveyor(tree, conveyor); // Stack: [3, 2], Queue: [1]

        // 2. Element 3 auf Queue
        to_conveyor(tree, conveyor); // Stack: [2], Queue: [1, 3]

        // 3. Element 2 auf Queue
        to_conveyor(tree, conveyor); // Stack: [], Queue: [1, 3, 2]

        // 4. Element 1 zurück auf Stack
        from_conveyor(tree, conveyor); // Stack: [1], Queue: [3, 2]

        // 5. Element 1 wieder zurück auf Queue (jetzt am Ende)
        // Das Element 1 ist nun korrekt hinter den anderen.
        to_conveyor(tree, conveyor); // Stack: [], Queue: [3, 2, 1]

        // 6. Element 3 (Stamm) zurück auf Stack
        from_conveyor(tree, conveyor); // Stack: [3], Queue: [2, 1]

        // 7. Element 2 (Mitte) zurück auf Stack
        from_conveyor(tree, conveyor); // Stack: [2, 3], Queue: [1]

        // 8. Element 1 (Spitze) zurück auf Stack
        from_conveyor(tree, conveyor); // Stack: [1, 2, 3], Queue: []

        // Ende Ihres Codes
        printBigTree(tree); // Baum ausgeben
    }

    // Verschiebt ein Element vom Stapel auf das Förderband
    public static void to_conveyor(Stack<Integer> tree, Queue<Integer> conveyor) {
        if (!tree.isEmpty()) {
            conveyor.add(tree.pop());
        }
    }

    // Verschiebt ein Element vom Förderband zurück auf den Stapel
    public static void from_conveyor(Stack<Integer> tree, Queue<Integer> conveyor) {
        if (!conveyor.isEmpty()) {
            tree.push(conveyor.poll());
        }
    }

    // Gibt den ganzen Baum Ebene für Ebene aus
    public static void printBigTree(Stack<Integer> tree_sizes) {
        int maxWidth = 21; //
        System.out.println();
        while (!tree_sizes.isEmpty()) {
            int w = tree_sizes.pop();
            printTriangle(w, maxWidth);
        }
        printTrunk(maxWidth);
    }

    // Zeichnet eine Ebene
    private static void printTriangle(int w, int maxWidth) {
        //
        for (int i = -1; i <= 1; i++) {
            int stars = (w + i) * 2 + 1;
            int spaces = (maxWidth - stars) / 2;
            printChars(' ', spaces);
            System.out.print(colorLine("*".repeat(stars)));
            System.out.println();
        }
    }

    // Zeichnet den Stamm des Baums
    private static void printTrunk(int width) {
        int trunkWidth = 3;
        int spaces = (width - trunkWidth) / 2;
        for (int i = 0; i < 2; i++) {
            printChars(' ', spaces);
            printChars('|', trunkWidth);
            System.out.println();
        }
    }

    // Hilfsfunktion: druckt ein Zeichen mehrfach
    private static void printChars(char c, int count) {
        for (int i = 0; i < count; i++) System.out.print(c);
    }

    // Färbt die Zeile in Weihnachtsfarben
    private static StringBuilder colorLine(String text) {
        Random random = new Random();
        final String GREEN = "\u001B[32m";
        final String BLUE = "\u001B[34m";
        final String RED = "\u001B[31m";
        final String RESET = "\u001B[0m";
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            double r = random.nextDouble(); // от 0.0 до 1.0
            String color;
            if (r < 0.50) {
                color = GREEN;         // 50%
            } else if (r < 0.75) {
                color = BLUE;          // 25%
            } else {
                color = RED;           // 25%
            }
            result.append(color).append(c).append(RESET);
        }
        return result;
    }
}
