package readability;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("The text is:");
        Text text = new Text(ReadFile.readFileAsString(args[0]));
        System.out.println(text.toString());
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        System.out.println();
        switch (option) {
            case "ARI":
                new ARI(text).Acessment();
                break;
            case "FK":
                new FK(text).Acessment();
                break;
            case "SMOG":
                new SMOG(text).Acessment();
                break;
            case "CL":
                new CL(text).Acessment();
                break;
            case "all":
                double a = new ARI(text).Acessment();
                double b = new FK(text).Acessment();
                double c = new SMOG(text).Acessment();
                double d = new CL(text).Acessment();
                System.out.println("This text should be understood in average by " + (a + b + c + d) / 4 + "-year-olds.");
                break;
            default:
                System.out.println("Wrong input");
        }

    }
}
