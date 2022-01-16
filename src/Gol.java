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
        //DONE: Gol. Inicializa e instancia.
        this.h = h;
        this.w = w;
        a = new int[h][w];
        b = new int[h][w];
    }

    /**
     * Devuelve la situación actual.
     * @return la matriz principal
     */
    public int[][] getSituacion() {
        //DONE: getSituacion. Devuelve.
        return a;
    }

    /**
     * Asigna el valor 1 a la celda de la matriz principal "a".
     * @param f fila
     * @param c columna
     */
    public void ponerVivo(int f, int c) {
        //DONE: ponerVivo. Asigna.
        b[f][c] = 1;
    }

    /**
     * Pone un número de posiciones aleatorias con valor 1.
     * @param n número de posiciones aleatorias
     */
    public void crearAleatorios(int n) {
        //DONE: crearAleatorios. Utiliza ponerVivo.
        int randomizerF = 0;
        int randomizerC = 0;

        randomizerF = (int)Math.random()*h+1;
        randomizerF = (int)Math.random()*w+1;
    }

    /**
     * Calcula el número de celdas vecinas vivas (no se considera así misma).
     * @param f fila
     * @param c columna
     * @return número de celdas vecinas vivas
     */
    private int vecinos(int f, int c) {
        //DONE: vecinos. Cuidado con los límites.
        int vivo = 0;
        for (int i = f-1; i < f+1; i++) {
            if (i != f){
                vivo++;
            }
            for (int j = c-1; j < c+1; j++) {
                if (j != c){
                    vivo++;
                }
            }
        }
        return vivo;
    }

    /**
     * Cuenta todas las celdas vivas del tablero.
     * @return número de celdas totales vivas
     */
    public int quedanVivos() {
        //DONE: quedanVivos. Utiliza si puedes Arrays.stream sino como quieras.
        int vivo = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1){
                    vivo++;
                }
            }
        }
        return vivo;
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
        //DONE: limpiar. Utiliza Arrays.fill.
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
        //TODO: copiar. Cuidado con los límites.
        //System.arraycopy(b,b[f][c],m,m[f][c],f);
    }

    /**
     * Devuelve una nueva instancia con las dimensiones y los valores de la matriz pasada como parámetro.
     * @param m matriz origen
     * @return copia de la matriz origen
     */
    private int[][] copiaDe(int[][] m) {
        //DONE: copiaDe. Utiliza Arrays.copyOf.
        return Arrays.copyOf(m,m.length);
    }

    /**
     * Comprueba si dos matrices tienen las mismas dimensiones y valores.
     * @param m1 matriz 1
     * @param m2 matriz 2
     * @return si son iguales
     */
    private boolean sonIguales(int[][] m1, int[][] m2) {
        //DONE: sonIguales. Utiliza Arrays.equals.
        return Arrays.equals(m1,m2);
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
        //TODO: avanza. Utiliza limpiar y vecinos.
    }

    /**
     * Comprueba si el tablero es el mismo que en la situación anterior después de avanzar.
     * @return si la matriz principal es igual a la secundaria
     */
    public boolean haAvanzado() {
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
        //TODO: detectaPeriodo. Utiliza avanza y sonIguales.
        return p;
    }

}