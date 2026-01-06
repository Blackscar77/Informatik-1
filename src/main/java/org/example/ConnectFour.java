package org.example;

import java.util.Scanner;

public class ConnectFour {

    private static final int ROWS = 6;
    private static final int COLUMNS = 7;

    private int[][] field = new int[ROWS][COLUMNS]; // 0: leer, 1: Spieler 1, 2: Spieler 2
    private int currentPlayer = 1; //1: player1, 2: player2
    private int status = 0; // 0: läuft, 1: Spieler 1 gewinnt, 2: Spieler 2 gewinnt, 3: Unentschieden


    private int rounds = 1; //Anzahl der bereits gespielten Runden

    public static void main(String[] args) {
        play();

        //connectFour.dropDisc(4);
    }

    /**
     * Methode die das Spiel mittels einer Zahleneingabe in der Console Spielbar macht.
     */
    public static void play() {
        ConnectFour game = new ConnectFour();

        Scanner scanner = new Scanner(System.in);

        while (game.getCurrentStatus() == 0) {
            if (scanner.hasNextInt()) {
                game.dropDisc(scanner.nextInt());
            } else {
                System.out.println("Gibt bitte eine Gültige Zahl ein (0-6)");
                scanner.next(); //ungültige eingabe verwerfen
            }
        }
    }

    public ConnectFour() {
        reset();
    }

    /**
     * setzt das Spielfeld in den Anfangszustand zurück
     */
    public void reset() {
        field = new int[ROWS][COLUMNS];
        currentPlayer = 1;
        rounds = 1;
        status = 0;

        printBoard();
    }

    /**
     * lässt einen Stein der Farbe currentPlayer in die angegebene Spalte fallen und gibt
     * anschließend den aktuellen Spielstand sowie eine Statusmeldung aus, wobei zu testen ist, ob ein
     * Stein in die angegebene Spalte eingefügt werden kann.
     */
    public void dropDisc(int column) {
        if (status != 0) {
            System.out.println("Das Spiel ist bereits beendet.");
            return;
        }

        if (column >= COLUMNS || column < 0) {
            System.out.println("Ungültige Spalte! Es gibt nur 7 Spalten (0-6).");
            return;
        }

        if (isColumnFull(column)) {
            System.out.println("Die Spalte " + column + " ist voll!");
            return;
        }

        //Setzen des Spielsteins
        field[findFreeRow(column)][column] = currentPlayer;
        rounds++;

        int winner = hasWon();
        if (winner != 0) {
            status = winner; // Setzt status auf 1 oder 2
        } else if (isBoardFull()) {
            status = 3; //Unentschieden
        } else {
            switchPlayer();
        }

        printBoard();
    }

    /**
     * prüft, ob eine Spalte bereits voll ist
     */
    private boolean isColumnFull(int column) {
        if (field[0][column] != 0) return true;
        else return false;
    }

    /**
     * ermittelt die Zeile, in die ein neuer Stein in der gewählten Spalte fallen würde.
     */
    private int findFreeRow(int column) {
        //Kein wert gefunden --> Spalte ist voll
        int freeRow = -1;

        for (int r = ROWS - 1; r >= 0; r--) {
            if (field[r][column] == 0) {
                freeRow = r;
                break;
            }
        }
        return freeRow;
    }


    /**
     * gibt das aktuelle Spielfeld in der Konsole aus.
     */
    public void printBoard() {
        System.out.println("---------------------------");
        System.out.println(printStatusMessage());
        System.out.println("---------------------------");


        System.out.print("  |  ");
        //Spalten
        for (int c = 0; c < COLUMNS; c++) {
            System.out.print(c + "  ");
        }
        System.out.print("|");

        System.out.println();

        //Zeilen
        for (int r = 0; r < ROWS; r++) {

            System.out.print(r + " |  ");


            //Spalten
            for (int c = 0; c < COLUMNS; c++) {
                //System.out.print(field[r][c] + "  ");


                if (field[r][c] == 0) System.out.print(".  ");
                else if (field[r][c] == 1) System.out.print("X  ");
                else if (field[r][c] == 2) System.out.print("O  ");

            }
            System.out.print("|");

            System.out.println();
        }


        System.out.println("---------------------------");
    }

    /**
     * gibt eine passende Meldung zum aktuellen Spielstatus aus.
     */
    private String printStatusMessage() {

        // 0: läuft, 1: Spieler 1 gewinnt, 2: Spieler 2 gewinnt, 3: Unentschieden
        switch (status) {
            case 0: {
                return "Runde: " + rounds + "\nSpieler " + currentPlayer + " ist am Zug!";
            }
            case 1: {
                return "Spieler 1 hat nach " + rounds + " Runden gewonnen!!!";
            }

            case 2: {
                return "Spieler 2 hat nach " + rounds + " Runden gewonnen!!!";
            }

            case 3: {
                return "Dieses mal hat keiner Gewonnen. Beim nächsten mal gewinnt bestimmt einer. Ihr habt " + rounds + " Runden gespielt.";
            }

            default:
                return null;
        }
    }

    /**
     * gibt den aktuellen Spieler zurück.
     */
    public int getCurrentStatus() {
        return status;
    }

    /**
     * gibt den aktuellen Spieler zurück.
     */
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * wechselt den aktuellen Spieler.
     */
    private void switchPlayer() {
        if (currentPlayer == 1) {
            currentPlayer = 2;
        } else if (currentPlayer == 2) {
            currentPlayer = 1;
        }
    }

    /**
     * prüft, ob ein Spieler gewonnen hat.
     */
    private int hasWon() {
        // 1. Horizontal prüfen (Reihen)
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c <= COLUMNS - 4; c++) {
                int symbol = field[r][c];
                if (symbol != 0 && symbol == field[r][c + 1] && symbol == field[r][c + 2] && symbol == field[r][c + 3]) {
                    return symbol;
                }
            }
        }

        // 2. Vertikal prüfen (Spalten)
        for (int c = 0; c < COLUMNS; c++) {
            for (int r = 0; r <= ROWS - 4; r++) {
                int symbol = field[r][c];
                if (symbol != 0 && symbol == field[r + 1][c] && symbol == field[r + 2][c] && symbol == field[r + 3][c]) {
                    return symbol;
                }
            }
        }

        // 3. Diagonal prüfen (von links oben nach rechts unten \)
        for (int r = 0; r <= ROWS - 4; r++) {
            for (int c = 0; c <= COLUMNS - 4; c++) {
                int symbol = field[r][c];
                if (symbol != 0 && symbol == field[r + 1][c + 1] && symbol == field[r + 2][c + 2] && symbol == field[r + 3][c + 3]) {
                    return symbol;
                }
            }
        }

        // 4. Diagonal prüfen (von links unten nach rechts oben /)
        for (int r = 3; r < ROWS; r++) {
            for (int c = 0; c <= COLUMNS - 4; c++) {
                int symbol = field[r][c];
                if (symbol != 0 && symbol == field[r - 1][c + 1] && symbol == field[r - 2][c + 2] && symbol == field[r - 3][c + 3]) {
                    return symbol;
                }
            }
        }

        return 0; // Kein Sieger
    }

    /**
     * prüft, ob das gesamte Spielfeld gefüllt ist.
     */
    private boolean isBoardFull() {
        for (int c = 0; c < COLUMNS; c++) {
            if (!isColumnFull(c)) return false;
        }
        return true;
    }
}
