import java.util.Scanner;

/**
 * Clase para leer de la entrada estándar.
 */
public class Entrada {

    private Scanner teclado;

    /**
     * Crea la instancia de teclado.
     */
    public Entrada() {
        teclado = new Scanner(System.in);
    }

    /**
     * Imprime un mensaje que solicitará un valor entre unos límites hasta que se cumpla.
     * @param txt mensaje explicativo
     * @param min valor mínimo
     * @param max valor máximo
     * @return valor introducido entre el mínimo y el máximo ambos inclusive.
     */
    public int leerEntero(String txt, int min, int max) {
        int v = -1;
        while (v < min || v > max) {
            System.out.printf("%s [%d-%d]: ", txt, min, max);
            v = teclado.nextInt();
        }
        teclado.nextLine();
        return v;
    }

}
