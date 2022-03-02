

import java.lang.*;
import java.util.*;

/**
 * Tema1 + Bonus PA
 *
 * @author Ioana Amalia Mareci 2A2
 */
public class Main {

    public static int lungime = 2;//lungimea celui mai lung subsir-bonus
    public static int[] subsir;//un subsir de lungime maxima -bonus

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        int n, p;
        String alfabet = "";
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            p = scanner.nextInt();
            alfabet = scanner.next();
            //validarea
            if (n < 0 || p < 0)
                System.exit(0);
            for (int i = 0; i < alfabet.length(); i++)
                if (!alfabet.matches("[a-zA-Z]+"))
                    System.exit(0);
        } else {
            String input = args[0];
            if (!esteNumar(input)) {
                System.out.println(input + " is not a valid integer");
                System.exit(0);
            }
            n = Integer.parseInt(input);

            String input2 = args[1];
            if (!esteNumar(input2)) {
                System.out.println(input2 + " is not a valid integer");
                System.exit(0);
            }
            p = Integer.parseInt(input2);

            for (int i = 2; i < args.length; i++) {
                String input3 = args[i];
                if (Character.isLetter(input3.charAt(0)))
                    alfabet += input3;
                else {
                    System.exit(0);
                }
            }
        }
        //generare sir de cuvinte
        String[] words = generareCuvinte(n, p, alfabet);

        System.out.println(Arrays.toString(words));

        //creare matrice booleana
        boolean[][] matrix = generareMatrice(n, p, words);
        afisareMatrice(n, matrix);
        //creare lista vecini
        ArrayList<Integer>[] vecini = generareVecini(n, matrix);
        afisareVecini(vecini, n);
        //afisa timp rulare
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);

        //Pentru bonus=cel mai lung subsir de cuvinte vecine (echivlent cu cel mai lung ciclu dintr un graf)
        cautareSubsiruri(n, matrix);
        afisareSubsir(words);
    }

    /**
     * Functia esteNumar verifica daca inputul este numar sau nu
     */
    public static boolean esteNumar(String input) {
        boolean isNumeric = true;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                isNumeric = false;
            }
        }
        return isNumeric;
    }

    /**
     * Functia genereaza n cuvinte de lungime p cu lietere alese random din value
     *
     * @return words - String[] de cuvinte generate
     */
    public static String[] generareCuvinte(int n, int p, String alfabet) {
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            String word = "";
            for (int j = 0; j < p; j++) {
                Random r = new Random();
                char c = alfabet.charAt(r.nextInt(alfabet.length()));
                word += c;
            }
            words[i] = word;
        }
        return words;
    }

    /**
     * Functia genereaza o structura de date de tipul  ArrayList<Integer>[] unde pentru fiecare index sunt asociati vecinii lui
     *
     * @return vecini - un ArrayList<Integer>[] in care se afla vecinii fiecarui cuvant reprezentat de un index(1-cuvantul 1,2-cuvatul 2 ,etc)
     */
    public static ArrayList<Integer>[] generareVecini(int n, boolean[][] matrix) {
        ArrayList<Integer>[] vecini = new ArrayList[n];
        // initializing
        for (int i = 0; i < n; i++) {
            vecini[i] = new ArrayList<>();
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++)
                if (matrix[k][i] && i != k)
                    vecini[k].add(i);
        }
        return vecini;
    }

    /**
     * Functia genereaza matricea booleana in care se verifica daca doua cuvinte din wrords sunt vecine sau nu
     *
     * @return matrix - matricea booleana a vacinilor
     */
    public static boolean[][] generareMatrice(int n, int p, String[] words) {
        boolean[][] matrix = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < p; k++)
                    for (int l = 0; l < p; l++)
                        if (words[i].regionMatches(k, words[j], l, 1)) {
                            matrix[i][j] = true;
                            break;
                        }
            }
        }
        return matrix;
    }

    public static void afisareMatrice(int n, boolean[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    public static void afisareVecini(ArrayList<Integer>[] vecini, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Pentru " + i + ": ");
            for (int j = 0; j < vecini[i].size(); j++) {
                System.out.print(vecini[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    /**
     * Functia cauta prin toate ciclurile/subsirurile posibile pentru a o descoperi pe cea mai mare
     * apeleaza functia recursiva creareSubsir pe rand cu toate nodurile ca optiuni de inceput
     */
    public static void cautareSubsiruri(int n, boolean[][] matrix) {
        int[] ciclu = new int[n + 1];
        int[] vizitat = new int[n + 1];
        subsir = new int[n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                ciclu[j] = 0;
                vizitat[j] = 0;
            }
            ciclu[0] = i;
            creareSubsir(i, 1, n, matrix, ciclu, vizitat);
        }
    }


    /**
     * Functia back este o functie recursiva pentru afla toate ciclurile din matricea booleana matrix care poate fi vazuta ca un graf
     *
     * @param k   -indicele de la care incepem sa cautam
     * @param pas-    pasul la care suntem
     * @param n-dimensiunea  matricei
     * @param matrix-matricea booleana a vecinilor
     * @param ciclu    - elemenetele ciclului/subsirului de cuvinte vecine
     * @param vizitat  -cuvintele vizitate
     */
    public static void creareSubsir(int k, int pas, int n, boolean[][] matrix, int[] ciclu, int[] vizitat) {

        for (int i = 0; i < n; i++)
            if (vizitat[i] == 0 && matrix[ciclu[pas - 1]][i]) {
                ciclu[pas] = i;
                vizitat[i] = 1;
                if (ciclu[pas] == k && pas > 2)
                    esteMaxim(pas, ciclu);
                else
                    creareSubsir(k, pas + 1, n, matrix, ciclu, vizitat);
                vizitat[i] = 0;
            }
    }

    /**
     * @param n     -lungimea ciclului
     * @param ciclu []- elemenetele ciclului
     */
    public static void esteMaxim(int n, int[] ciclu) {
        if (n >= lungime) {
            lungime = n;
            for (int i = 0; i <= n; i++)
                subsir[i] = ciclu[i];
        }
    }

    public static void afisareSubsir(String[] words) {
        if (lungime == 2)
            System.out.println("Nu s-a putut gasi un sir de cuvinte de lungime >=3");
        else {
            System.out.println("lungimea maxima a unui subsir este : " + lungime);
            for (int i = 0; i < lungime; i++)
                System.out.print(words[subsir[i]] + ",");
        }
    }
    
}

