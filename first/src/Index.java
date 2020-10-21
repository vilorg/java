import javax.swing.*;
import java.util.Scanner;

public class Index {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);//create new Scanner
        String word = in.nextLine();//Read our word
        String[] array = word.split(""), sign = new String[array.length];
        int[] num = new int[array.length];//Create an array where we will enter our value
        format_array(array, sign, num);//Uses a function that formats our array
    }

    public static void format_array(String[] array, String[] sign, int[] num) {
        int[] schet = new int[array.length];
        int q = 0;
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case ("+"), ("-"), ("/"), ("*") -> {
                    schet[q] = i;
                    q += 1;
                }
            }
        }
        for (int i = 0; i < schet.length; i++) if (schet[i] != 0) sign[i] = array[schet[i]];
        for (int i = schet.length - 1; i >= 0; i--) {
            if (schet[i] == 0) continue;
            num[i] = pInt(i, schet, array);
            System.out.println(num[i]);
        }

    }

    public static int pInt(int i, int[] schet, String[] array) {
        int result = 0;
        if (i>0) {
            for (int w = schet[i] - schet[i - 1] - 2, n = schet[i - 1] + 1; w >= 0; --w, n++) {
                int pos = (int) Math.pow(10, w);
                result += Integer.parseInt(array[n]) * pos;
            }
        } else if (i==0){
            for (int w = schet[i] - 1, n = 0; w >= 0; --w, n++) {
                int pos = (int) Math.pow(10, w);
                result += Integer.parseInt(array[n]) * pos;
            }
        }
        return result;
    }
}