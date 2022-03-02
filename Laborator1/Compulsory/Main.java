import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello World!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        System.out.println(Arrays.toString(languages));

        int n = (int) (Math.random() * 1_000_000);
        n = n * 3;
        String binaryString = "10101";
        int decimal = Integer.parseInt(binaryString, 2);
        n = n + decimal;
        String hex = "FF";
        decimal = Integer.parseInt(hex, 16);
        n = n + decimal;
        n = n * 6;
        n = sumaCifre(n);
        int result = n;
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }

    static int sumaCifre(int n) {
        int suma;
        suma = 0;
        while (n > 9) {
            int copie = n;
            suma = 0;
            while (copie != 0) {
                suma += (copie % 10);
                copie = copie / 10;
            }
            n = suma;
        }
        return n;
    }
}


