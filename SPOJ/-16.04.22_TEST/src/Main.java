/**
 * started April 22, 2016
 * completed April 22, 2016
 * from http://www.spoj.com/problems/TEST
 *
 * Your program is to use the brute-force approach in order to find the Answer to Life, the Universe,
 * and Everything. More precisely... rewrite small numbers from input to output. Stop processing input
 * after reading in the number 42. All numbers at input are integers of one or two digits.
 */

import java.util.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        int current = sc.nextInt();
        while(current != 42){

            System.out.println(current);
            current = sc.nextInt();
        }
    }
}