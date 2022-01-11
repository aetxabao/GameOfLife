import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Gol gol = new Gol(20,20);
        gol.copiar(1,1,S.SHAPES[3]);
        int[][] array = gol.getSituacion();

        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        gol.avanza();
        array = gol.getSituacion();
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        gol.avanza();
        array = gol.getSituacion();
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}
