import java.util.HashMap;
import java.util.Scanner;

public class StringMatch {

    public static int gjetjaMostres(String text, String mostra) {
        HashMap<Character, Integer> hashMap = getShiftTable(mostra);
        int gjatesiaMostres = mostra.length();
        int gjatesiaTekstit = text.length();
        int i, j;
        Integer shift;
        for (i = gjatesiaMostres - 1; i < gjatesiaTekstit; shift =hashMap.get(text.charAt(i)),  i += shift != null? shift: gjatesiaMostres ) {
            for (j = 0; (j < gjatesiaMostres) && (text.charAt(i - j) == mostra.charAt(gjatesiaMostres - 1 - j)); j++) ;
            if (j == gjatesiaMostres)
                return i - gjatesiaMostres + 1;
        }
        return -1;
    }

    private static HashMap<Character, Integer> getShiftTable(String pattern) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int gjatesia = pattern.length();
        for (int i = 0; i < gjatesia - 1; i++)
            hashMap.put(pattern.charAt(i), gjatesia - 1 - i);
        return hashMap;
    }

    public static void main(String[] args) {
        System.out.print("Jepni nje string : ");
        String text = new Scanner(System.in).nextLine();
        System.out.print("Jepni mostren : ");
        String mostra = new Scanner(System.in).nextLine();
        int pozita = gjetjaMostres(text, mostra);
        if (pozita != -1)
            System.out.println("Mostra " + mostra + " u gjet ne poziten " + pozita);
        else
            System.out.println("Mostra " + mostra + " nuk u gjet!");
    }
}
