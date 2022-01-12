import java.util.Arrays;

public class Salida
{
    //TODO: pintar simbolos en vez de numeros
    private final char CARACTER_1 = '1';
    private final char CARACTER_0 = ' ';

    /**
     * Escribe el encabezado.
     */
    public void encabezado()
    {
        System.out.println("==============================================");
        System.out.println("=          G a m e    O f    L i f e         =");
        System.out.println("==============================================");
    }

    /**
     * Escribe el menú. Sólo las opciones del 1 al 9 y la 0 para terminar.
     */
    public void menu()
    {
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
    public void pinta(int[][] matriz)
    {
        int numFilas = matriz.length;
        int numColumnas = matriz[0].length;

        // numeros de columnas
        System.out.print("    ");
        for (int j = 0; j < numColumnas; j++)
        {
            System.out.printf(" %-2d ", j);
        }
        System.out.println();

        // linea separadora incial
        System.out.print("   |");
        for (int j = 0; j < numColumnas; j++)
        {
            System.out.print("---|");
        }
        System.out.println();

        // filas
        for (int i = 0; i < numFilas; i++)
        {
            // numero de fila
            System.out.printf("%2d |", i);
            // por cada columna
            for (int j = 0; j < numColumnas; j++)
            {
                // el valor y un espacio
                if (matriz[i][j] == 0)
                {
                    System.out.print("   |");
                }
                else
                {
                    System.out.print(" 1 |");
                }
            }
            System.out.println();

            // linea separadora final
            System.out.print("   |");
            for (int j = 0; j < numColumnas; j++)
            {
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
    public void pintaShapes()
    {
        //NOTESTED pintaShapes. Utiliza Arrays.toString
        String contenido = "";
        int numEspacios = 0;
        String espacios = "";
        String linea = "";

        int[] array1 = null;
        int array1Size = 0;

        for (int name = 0; name < 7; name++)
        {
            contenido = "" + name + ". " + S.NAMES[name];
            numEspacios = 15 - contenido.length();
            espacios = String.format("%" + numEspacios + "s", " ");
            linea += contenido + espacios;
        }
        System.out.println(linea);

        // porsiaca
        contenido = "";
        numEspacios = 0;
        espacios = "";
        linea = "";


        for (int fila = 0; fila < 4; fila++)
        {
            linea = "";
            for (int col = 0; col < 7; col++)
            {
                if(S.SHAPES[col].length < fila + 1)
                {
                    System.out.print("               ");
                }
                else
                {
                    //array1 = Arrays.copyOf(S.SHAPES[col][fila],);
                    array1 = S.SHAPES[col][fila].clone();
                    numEspacios = 15 - (array1.length * 3);
                    espacios = rellenarDeEspacios(numEspacios);
                    linea += Arrays.toString(array1) + espacios;
                }
            }
            System.out.println(linea);
        }

    }

    private String rellenarDeEspacios(int numEspacios)
    {
        String salida = "";

        for (int i = 0; i < numEspacios; i++)
        {
            salida += " ";
        }

        return salida;
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
    public void fin()
    {
        System.out.println("==============================================");
        System.out.println("=   Always look on the bright side of life   =");
        System.out.println("==============================================");
    }

}
