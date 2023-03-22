
import java.util.Scanner;

public class Main {
    private static int counter = 0;

    public static void main(String[] args) {
        int i = Integer.parseInt(args[0]);
        Scanner tastiera = new Scanner(System.in);
        String s = tastiera.next();
        int size = s.length();
        anagram(s, 0, size - 1, i);

    }

    private static void anagram(String str, int start, int end, int numero) {
        if (counter == numero) {
            counter = 0;
            System.exit(0);
        }

        if (start == end) {
            counter++;
            str = str.substring(0, 1).toUpperCase() + str.substring(1);
            System.out.println(str);


        } else {
            for (int i = start; i <= end; i++) {
                str = swap(str, start, i);
                anagram(str, start + 1, end, numero);
                str = swap(str, start, i);
            }

        }

    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }


}