import java.util.Scanner;

public class RunDictionary extends Dictionary {
    public static void main(String[] args) {
        RunDictionary test = new RunDictionary();

        Scanner sc = new Scanner(System.in);
        String input;
    
        System.out.print(">>> ");
        while(!(input = sc.nextLine()).equals("q")){
            System.out.println(test.meaning(input));
            System.out.print(">>> ");
        }
    }

    @Override
    public String ask(String word) {
        
        return null;
    }
}