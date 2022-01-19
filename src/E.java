/**
 * Clase con las constantes para gestionar las opciones del menú.
 */
public enum E {
    MENU_THE_END (0),
    MENU_PRINT_MENU (1), MENU_DEF_DIM (2), MENU_RANDOM (3),
    MENU_SHAPES (4), MENU_CLEAN (5), MENU_NEXT (6),
    MENU_N_FORWARD (7), MENU_PERIOD (8), MENU_COUNT (9);

    private int opcion;

    E(int opcion) {
        this.opcion = opcion;
    }

    public static E fromInteger(int x) {
        // En una línea en más sencillo, pero tiene más costo computacional.
        // Además, si los valores no coincidiesen con el índice del array no valdría.
        //return E.values()[x];
        // El switch son más líneas, pero nada complicado (no olvidar el default)
        switch (x)  {
            case 1: return MENU_PRINT_MENU;
            case 2: return MENU_DEF_DIM;
            case 3: return MENU_RANDOM;
            case 4: return MENU_SHAPES;
            case 5: return MENU_CLEAN;
            case 6: return MENU_NEXT;
            case 7: return MENU_N_FORWARD;
            case 8: return MENU_PERIOD;
            case 9: return MENU_COUNT;
            default: return MENU_THE_END;
        }
    }
//// COMO CONSTANTES ESTÁTICAS DE CLASE, SIN UTILIZAR ENUM:
//    /** 1. Imprimir el menú */
//    public final static int MENU = 1;
//    /** 2. Definir dimensiones tablero */
//    public final static int DEF_DIM = 2;
//    /** 3. Crear celdas aleatorias */
//    public final static int RANDOM = 3;
//    /** 4. Copiar formas */
//    public final static int SHAPES = 4;
//    /** 5. Limpiar tablero */
//    public final static int CLEAN = 5;
//    /** 6. Avanzar un estado */
//    public final static int NEXT = 6;
//    /** 7. Avanzar N estados */
//    public final static int N_FORWARD = 7;
//    /** 8. Buscar periodo */
//    public final static int PERIOD = 8;
//    /** 9. Contar seres vivos */
//    public final static int COUNT = 9;
//    /** 0. Terminar */
//    public final static int THE_END = 0;
}
