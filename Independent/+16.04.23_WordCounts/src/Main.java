/**
 * started April 23, 2016
 * completed April 22, 2016
 *
 * How would you find the maximum occurrence of a word in a huge file.
 */

import java.io.File;
import java.util.*;
import java.lang.*;
import java.util.regex.Pattern;

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        HashMap<String, Integer> table = new HashMap<>();

        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("big.txt"));
        String input;
        Integer tempCount;

        Pattern p = Pattern.compile("\\W");

        while(sc.hasNext()){

            input = sc.next();
            input = input.toLowerCase();
            input = p.matcher(input).replaceAll("");

            if(table.containsKey(input))
                table.put(input, table.get(input)+1);

            else table.put(input, 1);
        }

        PriorityQueue<String> sortedList1 = new PriorityQueue<>(
                (String s1, String s2) -> table.get(s2) - table.get(s1));

        ArrayList<String> sortedList2 = new ArrayList<String>();

        for(String key : table.keySet()){

            sortedList1.add(key);
            sortedList2.add(key);
        }

        for(String key : sortedList1){

            System.out.println(key +  " : " + table.get(key));
        }

        sortedList2.sort((String s1, String s2) -> table.get(s2) - table.get(s1));

        for(String key : sortedList2){

            System.out.println(key +  " : " + table.get(key));
        }
    }
}

/**
 * Notes: this might work faster if it weren't for having to do the regex on each word to remove the commas and such.
 */