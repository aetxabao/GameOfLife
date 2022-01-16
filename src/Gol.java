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
        this.a = new int[h][w];
        this.b = new int[h][w];
    }

    /**
     * Devuelve la situación actual.
     * @return la matriz principal
     */
    public int[][] getSituacion() {
        //DONE: getSituacion. Devuelve.
        return this.a;
    }

    /**
     * Asigna el valor 1 a la celda de la matriz principal "a".
     * @param f fila
     * @param c columna
     */
    public void ponerVivo(int f, int c) {
        //DONE: ponerVivo. Asigna.
        this.a[f][c] = 1;
    }

    /**
     * Pone un número de posiciones aleatorias con valor 1.
     * @param n número de posiciones aleatorias
     */
    public void crearAleatorios(int n) {
        //DONE: crearAleatorios. Utiliza ponerVivo.
        for (int i = 0; i < n; i++) {
            int f = (int)(Math.random()*this.h);
            int c = (int)(Math.random()*this.w);
            System.out.println(f);
            System.out.println(c);
            ponerVivo(f,c);
        }
    }

    /**
     * Calcula el número de celdas vecinas vivas (no se considera así misma).
     * @param f fila
     * @param c columna
     * @return número de celdas vecinas vivas
     */
    private int vecinos(int f, int c) {
        //DONE: vecinos. Cuidado con los límites.
        int vecinos = 0;
        for (int fila = f; fila < f; fila++) {
            for (int columna = c-1; columna < c+1 ; columna++) {
                if(fila < this.h){
                    vecinos++;
                }
            }
        }
        return vecinos;
    }

    /**
     * Cuenta todas las celdas vivas del tablero.
     * @return número de celdas totales vivas
     */
    //POR HACER// public int quedanVivos() {
    //TODO: quedanVivos. Utiliza si puedes Arrays.stream sino como quieras.
    //int cuenta = 0;
    // for(int[])
    //    }
    //  }

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
        for(int[] fila: m){
            Arrays.fill(fila,0);
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
        for (int i = f; i < m.length; i++) {
            if(i >= this.a.length || i < 0){
                //Por resolver// return ;
            }
        }
    }

    /**
     * Devuelve una nueva instancia con las dimensiones y los valores de la matriz pasada como parámetro.
     * @param m matriz origen
     * @return copia de la matriz origen
     */
    private int[][] copiaDe(int[][] m) {
        //DONE: copiaDe. Utiliza Arrays.copyOf.
        int[][] copia = Arrays.copyOf(m, m.length);
        return copia;
    }

    /**
     * Comprueba si dos matrices tienen las mismas dimensiones y valores.
     * @param m1 matriz 1
     * @param m2 matriz 2
     * @return si son iguales
     */
    private boolean sonIguales(int[][] m1, int[][] m2) {
        //TODO: sonIguales. Utiliza Arrays.equals.
        return true;
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
        limpiar(this.b);
        for (int i = 0; i < this.a.length; i++) {
            for (int j = 0; j < this.a[i].length; j++) {
                n = this.vecinos(i,j);
                if(this.a[i][j] == 1){
                    //Por hacer
                }
            }
        }
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
        //DONE: detectaPeriodo. Utiliza avanza y sonIguales.
        for (int i = 0; i < limite; i++) {
            avanza();
            if(sonIguales(m, this.a)){
                return i;
            }
        }
        return p;
    }

}
