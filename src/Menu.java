package src;

/**
 * Clase que gestiona la ejecución de la aplicación.
 */
public class Menu {

    private Gol gol;
    private int h;
    private int w;
    private final Entrada entrada;
    private final Salida salida;

    /**
     * Instancia la entrada y la salida.
     */
    public Menu() {
        entrada = new Entrada();
        salida = new Salida();
    }

    /**
     * Sigue el flujo de un juego.
     */
    public void run() {
        inicio();
        gameLoop();
        fin();
    }

    /**
     * Inicialización del tablero representado por gol. Imprime el encabezado y el menú.
     */
    private void inicio() {
        h = 12;
        w = 40;
        gol = new Gol(h,w);
        salida.encabezado();
        salida.menu();
    }

    /**
     * Bucle en el que se le solicita al usuario una opción hasta que escribe la opción 0 de salida.
     */
    private void gameLoop() {
        int opc = entrada.leerEntero("Opción", 0, 9);
        while ( opc != E.THE_END ) {
            switch(opc){
                case E.MENU:
                    salida.menu();
                    break;
                case E.DEF_DIM:
                    definirDimensiones();
                    break;
                case E.RANDOM:
                    crearCeldasAleatorias();
                    break;
                case E.SHAPES:
                    copiarForma();
                    break;
                case E.CLEAN:
                    limpiarTablero();
                    break;
                case E.NEXT:
                    avanzar();
                    break;
                case E.N_FORWARD:
                    avanzarN();
                    break;
                case E.PERIOD:
                    detectaPeriodo();
                    break;
                case E.COUNT:
                    contar();
                    break;
                default:
            }
            opc = entrada.leerEntero("Opción", 0, 9);
        }
    }

    /**
     * Redefine las dimensiones del tablero. Crea una nueva instancia. Se pierden valores antiguos.
     */
    public void definirDimensiones(){
        h = entrada.leerEntero("Numero de filas", 4, 40);
        w = entrada.leerEntero("Numero de columnas", 4, 80);
        gol = new Gol(h,w);
        salida.pinta(gol.getSituacion());
    }

    /**
     * Solicita el número de celdas aleatorias vivas que se van a agregar al tablero.
     */
    public void crearCeldasAleatorias(){
        int x = entrada.leerEntero("Numero de celdas", 1, h*w);
        gol.crearAleatorios(x);
        salida.pinta(gol.getSituacion());
    }

    /**
     * Copia una forma a partir de una posición en el tablero. Se imprime la lista de formas disponibles y el
     * estado del tablero para ubicar la forma.
     */
    public void copiarForma(){
        salida.pintaShapes();
        int i = entrada.leerEntero("Figura", 0, S.NAMES.length-1);
        salida.pinta(gol.getSituacion());
        int f = entrada.leerEntero("Numero de fila", 0, h-1);
        int c = entrada.leerEntero("Numero de columna", 0, w-1);
        gol.copiar(f,c,S.SHAPES[i]);
        salida.pinta(gol.getSituacion());
    }

    /**
     * Limpia el tablero. Todos los valores se establecen a 0.
     */
    public void limpiarTablero(){
        gol.limpiar();
        salida.pinta(gol.getSituacion());
    }

    /**
     * Avanza la situación del tablero en un instante de tiempo.
     */
    public void avanzar(){
        gol.avanza();
        salida.pinta(gol.getSituacion());
    }

    /**
     * Avanza la situación del tablero en N instantes de tiempo o hasta que la situación se establece. Si la situación
     * estable se alcanza antes se indica mediante un mensaje. Se pinta la situación alcanzada.
     */
    public void avanzarN(){
        int n = entrada.leerEntero("Cuanto", 1, 10000);
        for (int i = 0; i < n; i++) {
            gol.avanza();
            if (!gol.haAvanzado()){
                salida.escribe("No ha avanzado en " + i + " iteraciones.");
                break;
            }
        }
        salida.pinta(gol.getSituacion());
    }

    /**
     * Se busca el número de estados diferentes hasta que se vuelve a repetir la secuencia.
     */
    public void detectaPeriodo(){
        int n = gol.detectaPeriodo(1000);
        if (n==Integer.MAX_VALUE){
            salida.escribe("No se ha detectado periodo");
        }else{
            salida.escribe("El periodo es " + n );
        }
    }

    /**
     * Cuenta el número de celdas que hay vivas en el tablero.
     */
    public void contar(){
        int n = gol.quedanVivos();
        salida.escribe("Quedan " + n + " vivos.");
    }

    /**
     * Termina el programa imprimiendo un mensaje de fin.
     */
    private void fin() {
        salida.fin();
    }

}
