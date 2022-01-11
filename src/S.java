package src;

/**
 * Clase con formas típicas del juego de la vida. <br/>
 * http://www.it.uc3m.es/jvillena/irc/practicas/09-10/04mem.pdf <br/>
 * https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 */
public class S {
    private final static int[][] BLOCK = {{1,1},{1,1}};
    private final static int[][] BEEHIVE = {{0,1,1,0},{1,0,0,1},{0,1,1,0}};
    private final static int[][] LWSS = {{1,0,0,1,0},{0,0,0,0,1},{1,0,0,0,1},{0,1,1,1,1}};
    private final static int[][] GLIDER = {{0,1,0},{0,0,1},{1,1,1}};
    private final static int[][] BLINKER = {{1,1,1}};
    private final static int[][] TOAD = {{0,1,1,1},{1,1,1,0}};
    private final static int[][] QUINCE = {{1,1,1,1,1,1,1,1},{1,0,1,1,1,1,0,1},{1,1,1,1,1,1,1,1}};

    /** Array con las matrices con las formas. Primer índice la forma, segundo la fila, tercero la columna. */
    public final static int[][][] SHAPES = {BLOCK, BEEHIVE, LWSS, GLIDER, BLINKER, TOAD, QUINCE};
    /** Array con los nombres de las formas en el orden que aparecen en SHAPES. */
    public final static String[] NAMES = {"BLOCK", "BEEHIVE", "LWSS", "GLIDER", "BLINKER", "TOAD", "QUINCE"};
}
