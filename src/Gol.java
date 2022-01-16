import javax.crypto.spec.PSource;
import java.util.Arrays;

public class Gol {

    /** altura (número de filas) */
    private int h;
    /** ancho (número de columnas) */
    private int w;
    /** matriz principal */
    private int[][] a;
    /** matriz secundaria */
    private int[][] b;


    /**
     * Inicializa los atributos h y w e instancia las matrices "a" y "b".
     * @param h es la altura (número de filas)
     * @param w es el ancho (número de columnas)
     */
    public Gol(int h, int w) {
        this.h = h;
        this.w = w;
        a = new int[h][w];
        b = new int[h][w];
    }

    /**
     * Devuelve la situación actual.
     * @return la matriz principal
     */
    public int[][] getSituacion()
    {
        return a;

    }

    /**
     * Asigna el valor 1 a la celda de la matriz principal "a".
     * @param f fila
     * @param c columna
     */
    public void ponerVivo(int f, int c)
    {
        a[f][c] = 1;
    }

    /**
     * Pone un número de posiciones aleatorias con valor 1.
     * @param n número de posiciones aleatorias
     */
    public void crearAleatorios(int n)
    {
        for (int i = 0; i < n; i++) {

        }
            int f;
            int c;
            {
                f = (int) (Math.random() * h);
                c = (int) (Math.random() * w);
            } while (this.a[f][c] == 1);
            ponerVivo(f, c);
    }

    /**
     * Calcula el número de celdas vecinas vivas (no se considera así misma).
     * @param f fila
     * @param c columna
     * @return número de celdas vecinas vivas
     */
    private int vecinos(int f, int c)
    {
        return 0;
    }

    /**
     * Cuenta todas las celdas vivas del tablero.
     * @return número de celdas totales vivas
     */
    public int quedanVivos() {
    int vivos = 0;
        for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a[i].length; j++) {
            if (a[i][j] == 1){
                vivos++;
            }
        }
    }
        return vivos;
}

    /**
     * Limpia la matriz principal "a".
     */
    public void limpiar() {
        limpiar(a);
    }

    /**
     * Establece todos los valores de las celdas de la matriz a 0.
     * @param m matriz
     */
    private void limpiar(int[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = 0;
            }
        }
    }

    /**
     * Copia en la matriz principal "a" a partir de la posición dada por la fila f y la columna c,
     * los valores de la matriz "m" pasada como parámetro.
     * @param f fila
     * @param c columna
     * @param m matriz
     */
    public void copiar(int f, int c, int[][] m) {
        for (int i = f, j = 0; j < m.length; j++, i++) {

            if (i >= a.length || i < 0) {
                continue;
            }
            if (c + m[j].length >= a[i].length) {
                System.arraycopy(m[j],0, a[i], c, a[i].length - (c));
                continue;
            }
            System.arraycopy(m[j], 0, a[i], c, m[j].length);
        }
    }

    /**
     * Devuelve una nueva instancia con las dimensiones y los valores de la matriz pasada como parámetro.
     * @param m matriz origen
     * @return copia de la matriz origen
     */
    private int[][] copiaDe(int[][] m)
    {
        int[][] copy = Arrays.copyOf(m, m.length);
        return copy;
    }

    /**
     * Comprueba si dos matrices tienen las mismas dimensiones y valores.
     * @param m1 matriz 1
     * @param m2 matriz 2
     * @return si son iguales
     */
    private boolean sonIguales(int[][] m1, int[][] m2) {
        if (m1.length == m2.length) {
            int c = 0;
            for (int i = 0; i < m1.length; i++) {
                if (Arrays.equals(m1[i], m2[i])) {
                    c++;
                }
            }
            return (c == m1.length - 1);
        }
        return false;
    }

    /**
     * Recorre todas las celdas de la matriz principal a y calcula el número de vecinos que tiene.
     * En base a las reglas del juego de la vida en la matriz secundaria b se establecerá el valor
     * que tendrá la celda en el siguiente instante de tiempo. Tras haber recorrido todas las celdas
     * la matriz principal debe pasar a ser la secundaria y al revés, la secundaria la principal.
     * Para ello se debe utilizar una referencia local a una matriz sin instanciar, por ejemplo "x",
     * para que cuando "a" apunte a "b" la referencia de "a" no se pierda y apuntando "b" a "x" se
     * hace el cambio. Es el mismo mecanismo para intercambiar el valor de dos variables primitivas
     * utilizando una tercera variable local. Para que en la matriz secundaria "b" se vayan haciendo
     * los cálculos es preciso limpiar la matriz "b" antes de empezar a recorrer las celdas.
     */
    public void avanza() {
        int n;
        int[][] x;
        limpiar(a);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                n = vecinos(i, j);
                if((b[i][j] == 1 && (n == 2  || n == 3) || (b[i][j] == 0) && (n == 3))) {
                    a[i][j] = 1;
            }
        }
    }
        x = a;
        a = b;
        b = x;
    }


    /**
     * Comprueba si el tablero es el mismo que en la situación anterior después de avanzar.
     * @return si la matriz principal es igual a la secundaria
     */
    public boolean haAvanzado()
    {
        return !sonIguales(a,b);
    }

    /**
     * Crea una copia local de la matriz principal "a" y avanza el estado hasta un número límite
     * de veces comprobando cada vez si la copia local es igual a la matriz principal "a".
     * En caso de ser iguales el método devuelve el número de pasos transcurridos. Si se finaliza
     * el bucle sin encontrar el periodo se devolverá Integer.MAX_VALUE y la matriz principal
     * recuperará los valores de antes de empezar.
     * @param limite valor máximo para el periodo
     * @return número de estados de los que consta la secuencia o
     * Integer.MAX_VALUE si no es menor que el limite
     */
    public int detectaPeriodo(int limite) {
        int p = Integer.MAX_VALUE;
        int[][] m = copiaDe(a);

        for (int i = 0; i < limite; i++) {
            avanza();
            if(sonIguales(m, a))
            {
                return i;
            }
        }
        return p;
    }

}
