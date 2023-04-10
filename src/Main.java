import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int vector[] = new int[1000000];
        int i = 0, inteiro;


        Path arquivo = Paths.get("C:/Users/0048606/Downloads/Instâncias-TP1/ListaInversamenteOrdenada-1000000.txt");

        try {
            List<String> linhas = Files.readAllLines(arquivo);
            for (String linha:linhas){
                vector[i++] = Integer.parseInt(linha);
            }
        }catch (IOException e) {
            System.out.println("Erro");
        }

        bogoSort(vector, 1000000);

        for (int j = 0; j < 1000000; j++){
            System.out.println(vector[j]);
        }

    }

    public static boolean is_sorted(int[] vector, int n){
        while (--n >= 1) {
            if (vector[n] < vector[n - 1]){
                return false;
            }
        }
        return true;
    }

    public static void shuffle (int[] vector, int n) {
        int position, random;
        Random gerador = new Random();
        for (int i = 0; i < n; i++) {
            position = vector[i];
            random = (gerador.nextInt(n));
            random = random % n;
            vector[i] = vector[random];
            vector[random] = position;
        }
    }

    public static void bogoSort (int[] vector, int n) {
        while (!is_sorted(vector,n)){
            shuffle(vector,n);
        }
    }
}