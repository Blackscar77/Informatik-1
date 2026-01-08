package org.example;

public class SquareMatrix {

    private int[][] matrix;
    private final int size;


    public static void main(String[] args) {
        int[][] a = new int[2][2];
        //1     2
        //3     4
        //[Zeile][Spalte]
        a[0][0] = 1;
        a[0][1] = 2;
        a[1][0] = 3;
        a[1][1] = 4;

        /*
        Alternative zu dem Oben.
        int[][] a = {
                {1, 2},  // Zeile 0
                {3, 4}   // Zeile 1
        };
         */

        SquareMatrix matrixA = new SquareMatrix(a);


        int[][] b = new int[2][2];
        //10     20
        //100     200
        //[Zeile][Spalte]
        b[0][0] = 10;
        b[0][1] = 20;
        b[1][0] = 100;
        b[1][1] = 200;

        SquareMatrix matrixB = new SquareMatrix(b);

        System.out.println("2x2");

        System.out.println("matrixA:");
        System.out.println(matrixA.toString());
        System.out.println("matrixB:");
        System.out.println(matrixB.toString());


        System.out.println("add:");
        System.out.println(matrixA.add(matrixB));


        System.out.println("addInplace: 1. print matrixA, add matrixB to MatrixA --> 3. print matrixA");
        System.out.println(matrixA);
        matrixA.addInplace(matrixB);
        System.out.println(matrixA);


        //Es wird mit der addierten matrixA weitergemacht
        System.out.println("Transpose:");
        System.out.println(matrixA.transpose());

        System.out.println("transposeInplace:");
        matrixA.transposeInplace();
        System.out.println(matrixA);


        //Es wird mit der addierten und transponierten matrixA weitergemacht
        System.out.println("Rotate:");
        System.out.println(matrixA.rotate());

        System.out.println("RotateInplace:");
        matrixA.rotateInplace();
        System.out.println(matrixA);


        System.out.println("3x3");


    }

    public SquareMatrix(int[][] data) {
        this.size = data.length;
        this.matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.matrix[i][j] = data[i][j];
            }
        }
    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < size; i++) { //Geht die Zeilen durch
            for (int j = 0; j < size; j++) { // Geht die Spalten durch
                temp += this.matrix[i][j] + "  ";
            }
            temp += "\n";
        }
        return temp;
    }

    public SquareMatrix add(SquareMatrix otherMatrix) {
        if (otherMatrix.size == size) {
            int[][] newdata = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    newdata[i][j] = this.matrix[i][j] + otherMatrix.matrix[i][j];
                }
            }
            return new SquareMatrix(newdata);
        } else {
            System.out.println("Die angegeben Matrix ist zu groß oder klein. Sie muss die größe " + size + " besitzen");
        }
        return null;
    }

    public void addInplace(SquareMatrix otherMatrix) {
        if (otherMatrix.size == size) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    this.matrix[i][j] += otherMatrix.matrix[i][j];
                }
            }
        }
    }

    //Transpose - Die Zeilen werden zu Spalten. Die Spalten werden zu Zeilen.
    public SquareMatrix transpose() {

        int[][] newdata = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newdata[j][i] = this.matrix[i][j];
            }
        }
        return new SquareMatrix(newdata);
    }

    public void transposeInplace() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        /*
        int[][] temp = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temp[i][j] = this.matrix[i][j];
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.matrix[j][i] = temp[i][j];
            }
        }

         */
    }

    // Rotate (90 Grad im Uhrzeigersinn)
    // Zeile i wird zu Spalte (n-1-i)
    public SquareMatrix rotate() {
        int[][] newData = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newData[j][size - 1 - i] = this.matrix[i][j];
            }
        }
        return new SquareMatrix(newData);
    }

    public void rotateInplace() {
        // transponieren + horizontales Spiegeln
        transposeInplace();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][size - 1 - j];
                matrix[i][size - 1 - j] = temp;
            }
        }
    }
}
