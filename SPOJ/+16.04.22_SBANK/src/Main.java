/**
 * started April 22, 2016
 * completed April 22, 2016
 * from http://www.spoj.com/problems/SBANK
 *
 * Your task is to sort the bank account numbers in ascending order.
 * If an account appears twice or more in the list, write the number of repetitions just after the account number.
 */

import java.util.*;
import java.lang.*;

class Main
{
    static ArrayList<String> list;
    static HashMap<String, Integer> table;

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt(), n;

        for(int i=0; i<tests; i++){

            list = new ArrayList<>();

            n = sc.nextInt();
            StringBuilder acctNumber;
            for(int j=0; j<n; j++){

                acctNumber  = new StringBuilder();
                for(int k=0; k<6; k++){

                    acctNumber.append(sc.next());
                }

                list.add(acctNumber.toString());
            }

            list.sort((String s1, String s2) -> s1.compareTo(s2));

            String last = "";
            int count = 1;
            for(String item : list) {

                if(item.equals(last)) count++;

                else{

                    if(!last.equals("")) System.out.println(reformat(last) + count);
                    count = 1;
                }

                last = item;
            }

            System.out.println(reformat(last) + count + "\n");
        }
    }

    public static String reformat(String input){

        if(input.equals("")) return "";

        StringBuilder output = new StringBuilder();
        output.append(input.substring(0, 2) + " ");
        output.append(input.substring(2, 10) + " ");
        output.append(input.substring(10, 14) + " ");
        output.append(input.substring(14, 18) + " ");
        output.append(input.substring(18, 22) + " ");
        output.append(input.substring(22, 26) + " ");

        return output.toString();
    }
}