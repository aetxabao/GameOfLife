package src;
import java.util.Random;
import java.util.Arrays;

public class Gol {

    /** altura (n�mero de filas) */
    private int h;
    /** ancho (n�mero de columnas) */
    private int w;
    /** matriz principal */
    private int[][] a;
    /** matriz secundaria */
    private int[][] b;


    /**
     * Inicializa los atributos h y w e instancia las matrices "a" y "b".
     * @param h es la altura (n�mero de filas)
     * @param w es el ancho (n�mero de columnas)
     */
    public Gol(int h, int w) {
        h = h;
        w = w;
        a = new int[h][w];
        b = new int[h][w];

    }

    /**
     * Devuelve la situaci�n actual.
     * @return la matriz principal
     */
    public int[][] getSituacion() {
        return a;
    }

    /**
     * Asigna el valor 1 a la celda de la matriz principal "a".
     * @param f fila
     * @param c columna
     */
    public void ponerVivo(int f, int c) {
        a[f][c] = 1;
    }

    /**
     * Pone un n�mero de posiciones aleatorias con valor 1.
     * @param n n�mero de posiciones aleatorias
     */
    public void crearAleatorios(int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int ran = random.nextInt(a.length);
            int ran2 = random.nextInt(a[ran].length);
            a[ran][ran2] = 1;
        }
    }

    /**
     * Calcula el n�mero de celdas vecinas vivas (no se considera as� misma).
     * @param f fila
     * @param c columna
     * @return n�mero de celdas vecinas vivas
     */
    private int vecinos(int f, int c) {
        int conta = 0;
        if(f<a.length) {
            if(c<a[f].length) {
                for (int i = f - 1; i < f + 1; i++) {
                    for (int j = c - 1; j < c + 1; j++) {
                        if (i != f && j != c) {
                            if (a[i][j] == 1) {
                                conta++;
                            }
                        }
                    }
                }
                return conta;
            }
        }
        return 0;
    }

    /**
     * Cuenta todas las celdas vivas del tablero.
     * @return n�mero de celdas totales vivas
     */
    public int quedanVivos() {
        int conta = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j] ==1){
                    conta++;
                }
            }
        }
        return conta;
    }

    /**
     * Limpia la matriz principal "a".
     */
    public void limpiar() {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = 0;
            }
        }
    }

    /**
     * Establece todos los valores de las celdas de la matriz a 0.
     * @param m matriz
     */
    private void limpiar(int[][] m) {
        Arrays.fill(m,0);
    }

    /**
     * Copia en la matriz principal "a" a partir de la posici�n dada por la fila f y la columna c,
     * los valores de la matriz "m" pasada como par�metro.
     * @param f fila
     * @param c columna
     * @param m matriz
     */
    public void copiar(int f, int c, int[][] m) {
        //TODO: copiar. Cuidado con los l�mites. NO ENTIENDO LO QUE SE QUIERE HACER
    }

    /**
     * Devuelve una nueva instancia con las dimensiones y los valores de la matriz pasada como par�metro.
     * @param m matriz origen
     * @return copia de la matriz origen
     */
    private int[][] copiaDe(int[][] m) {
        int[][] c;
        c = Arrays.copyOf(m,m.length);
        return c;
    }

    /**
     * Comprueba si dos matrices tienen las mismas dimensiones y valores.
     * @param m1 matriz 1
     * @param m2 matriz 2
     * @return si son iguales
     */
    private boolean sonIguales(int[][] m1, int[][] m2) {
        if( Arrays.equals(m1,m2)){
            return true;
        }
        return false;
    }

    /**
     * Recorre todas las celdas de la matriz principal a y calcula el n�mero de vecinos que tiene.
     * En base a las reglas del juego de la vida en la matriz secundaria b se establecer� el valor
     * que tendr� la celda en el siguiente instante de tiempo. Tras haber recorrido todas las celdas
     * la matriz principal debe pasar a ser la secundaria y al rev�s, la secundaria la principal.
     * Para ello se debe utilizar una referencia local a una matriz sin instanciar, por ejemplo "x",
     * para que cuando "a" apunte a "b" la referencia de "a" no se pierda y apuntando "b" a "x" se
     * hace el cambio. Es el mismo mecanismo para intercambiar el valor de dos variables primitivas
     * utilizando una tercera variable local. Para que en la matriz secundaria "b" se vayan haciendo
     * los c�lculos es preciso limpiar la matriz "b" antes de empezar a recorrer las celdas.
     */
    public void avanza() {
        int n;
        int[][] x;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j] == 0 && vecinos(i,j)==3){
                    b[i][j]=1;
                }
                if(a[i][j] == 1 && vecinos(i,j)==2 && vecinos(i,j)==3){
                    b[i][j]=1;
                }else{
                    b[i][j]=0;
                }
            }
        }
        x = Arrays.copyOf(b, b.length);
        limpiar(b);
        a = Arrays.copyOf(x,x.length);
    }

    /**
     * Comprueba si el tablero es el mismo que en la situaci�n anterior despu�s de avanzar.
     * @return si la matriz principal es igual a la secundaria
     */
    public boolean haAvanzado() {
        return !sonIguales(a,b);
    }

    /**
     * Crea una copia local de la matriz principal "a" y avanza el estado hasta un n�mero l�mite
     * de veces comprobando cada vez si la copia local es igual a la matriz principal "a".
     * En caso de ser iguales el m�todo devuelve el n�mero de pasos transcurridos. Si se finaliza
     * el bucle sin encontrar el periodo se devolver� Integer.MAX_VALUE y la matriz principal
     * recuperar� los valores de antes de empezar.
     * @param limite valor m�ximo para el periodo
     * @return n�mero de estados de los que consta la secuencia o
     * Integer.MAX_VALUE si no es menor que el limite
     */
    public int detectaPeriodo(int limite) {
        int p = Integer.MAX_VALUE;
        int[][] m = copiaDe(a);
        //TODO: detectaPeriodo. Utiliza avanza y sonIguales.
        return p;
    }

}