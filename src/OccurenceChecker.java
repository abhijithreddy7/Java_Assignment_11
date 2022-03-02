import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OccurenceChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file name:");
        String filename = sc.next();

        Map<Character,Integer> charCount = new HashMap<>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            PrintWriter pw = new PrintWriter("output.txt");

            int ch=0;
            while((ch=reader.read())!=-1) {
                char temp = (char) ch;
                if (charCount.containsKey(temp)) {
                    charCount.put(temp, charCount.get(temp) + 1);
                } else {
                    charCount.put(temp, 1);
                }
            }
            for(Map.Entry<Character,Integer> e:charCount.entrySet()){
                pw.println(e.getKey()+" "+e.getValue());
            }

            reader.close();
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}