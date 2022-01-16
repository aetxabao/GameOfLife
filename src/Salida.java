package src;

import java.util.Arrays;

public class Salida {

    /**
     * Escribe el encabezado.
     */
    public void encabezado() {
        System.out.println("==============================================");
        System.out.println("=          G a m e    O f    L i f e         =");
        System.out.println("==============================================");
    }

    /**
     * Escribe el menú. Sólo las opciones del 1 al 9 y la 0 para terminar.
     */
    public void menu() {
        System.out.println("1. Imprimir el menú");              //MENU
        System.out.println("2. Definir dimensiones tablero");   //DEF_DIM
        System.out.println("3. Crear celdas aleatorias");       //RANDOM
        System.out.println("4. Copiar formas");                 //SHAPES
        System.out.println("5. Limpiar tablero");               //CLEAN
        System.out.println("6. Avanzar un estado");             //NEXT
        System.out.println("7. Avanzar N estados");             //N_FORWARD
        System.out.println("8. Buscar periodo");                //PERIOD
        System.out.println("9. Contar seres vivos");            //COUNT
        System.out.println("0. Terminar");                      //THE_END
    }

    /**
     * Pinta la martriz indicando el número de la fila y la columna y los valores 1 (el 0 no). Ejemplo:<br/>
     *      0   1   2   3  <br/>
     *    |---|---|---|---|<br/>
     *  0 |   |   |   |   |<br/>
     *    |---|---|---|---|<br/>
     *  1 |   |   | 1 |   |<br/>
     *    |---|---|---|---|<br/>
     *  2 |   |   | 1 |   |<br/>
     *    |---|---|---|---|<br/>
     *  3 |   |   | 1 |   |<br/>
     *    |---|---|---|---|<br/>
     * @param matriz matriz de enteros con valores "0" o "1".
     */
    public void pinta(int[][] matriz) {
        int numFilas = matriz.length;
        int numColumnas = matriz[0].length;
        System.out.print("    ");
        for (int j = 0; j < numColumnas; j++) {
            System.out.printf(" %-2d ", j);
        }
        System.out.println();
        System.out.print("   |");
        for (int j = 0; j < numColumnas; j++) {
            System.out.print("---|");
        }
        System.out.println();
        for (int i = 0; i < numFilas; i++) {
            System.out.printf("%2d |", i);
            for (int j = 0; j < numColumnas; j++) {
                if (matriz[i][j] == 0){
                    System.out.print("   |");
                }else {
                    System.out.print(" 1 |");
                }
            }
            System.out.println();
            System.out.print("   |");
            for (int j = 0; j < numColumnas; j++) {
                System.out.print("---|");
            }
            System.out.println();
        }
    }

    /**
     * Escribe los nombres de las formas definidas en S y debajo los arrays que componen cada una de las matrices.
     * Para la representación se establece un espacio de 15 caracteres por 5 filas para cada forma incluyendo su nombre.
     * Todos deben aparecer seguidos como en el ejemplo: <br/>
     * 0. BLOCK        1. BEEHIVE      2. LWSS         3. GLIDER       4. BLINKER      5. TOAD         6. QUINCE               <br/>
     * [1, 1]          [0, 1, 1, 0]    [1, 0, 0, 1, 0] [0, 1, 0]       [1, 1, 1]       [0, 1, 1, 1]    [1, 1, 1, 1, 1, 1, 1, 1]<br/>
     * [1, 1]          [1, 0, 0, 1]    [0, 0, 0, 0, 1] [0, 0, 1]                       [1, 1, 1, 0]    [1, 0, 1, 1, 1, 1, 0, 1]<br/>
     *                 [0, 1, 1, 0]    [1, 0, 0, 0, 1] [1, 1, 1]                                       [1, 1, 1, 1, 1, 1, 1, 1]<br/>
     *                                 [0, 1, 1, 1, 1]                                                                         <br/>
     */
    public void pintaShapes(){
        //TODO: pintaShapes. Utiliza Arrays.toString

    }

    /**
     * Escribe un texto.
     * @param str texto
     */
    public void escribe(String str) {
        System.out.println(str);
    }

    /**
     * Escribe un mensaje final.
     */
    public void fin() {
        System.out.println("==============================================");
        System.out.println("=   Always look on the bright side of life   =");
        System.out.println("==============================================");
    }

}
