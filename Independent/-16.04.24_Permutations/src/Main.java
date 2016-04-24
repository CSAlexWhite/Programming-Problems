/**
 * Created by alexw on 4/24/2016.
 */
public class Main {

    public static void main(String[] args){

        char[] a = "1200".toCharArray();

        permute(a);
    }

    private static void permute(char[] a) {

        permute_help(a, 0, 1, a.length);
    }

    private static void permute_help(char[] s, int p1, int p2, int len) {

        print(s);

        if((p1 == len-1) || (p2 == len-1)) return;

        p1++;
        s = swap(s, p1, p2);
        permute_help(s, p1, p2, len);
        p2++;
        permute_help(s, p1, p2, len);
        s = swap(s, p1, p2);
        p2--;
        p1--;
    }

    private static void print(char[] s) {

        for(int i=0; i<s.length; i++) System.out.print(s[i]);
        System.out.println();
    }

    private static char[] swap(char[] s, int p1, int p2) {

        char temp = s[p1];
        s[p1] = s[p2];
        s[p2] = temp;

        return s;
    }
}
