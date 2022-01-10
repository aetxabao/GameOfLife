import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Gol gol = new Gol(20,15);
        gol.crearAleatorios(50);
        int[][] array = gol.getSituacion();
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println(gol.quedanVivos());



    }
}
