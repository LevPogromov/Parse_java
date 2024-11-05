import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Укажите путь к входному файлу: ");
        String input = sc.nextLine();
        System.out.print("Укажите путь к выходному файлу: ");
        String output = sc.nextLine();
        File i = new File(input);
        if (!i.exists()) {
            System.err.print("File is not found");
            return;
        }
        Map<Character, Integer> mp = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(i));
            String str;
            while ((str = reader.readLine()) != null) {
                for (char c : str.toCharArray()) {
                    if ('a' <= c && 'z' >= c || 'A' <= c && 'Z' >= c){
                        mp.put(c, mp.getOrDefault(c, 0) + 1);
                    }
                }
            }
            reader.close();
        } catch (IOException e){
            System.err.print(e.getMessage());
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(output));
            for (Map.Entry<Character, Integer> entry : mp.entrySet()){
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
    }
}