import java.util.Scanner;

public class FizzBuzz {
    public String calc(int value) {
        String fizzString = "";
        if(value % 3 == 0) {
            fizzString = "Fizz";
        }
        if(value % 5 == 0) {
            fizzString +=  "Buzz";
        }

        return fizzString.length() > 0 ? fizzString : String.valueOf(value);
    }

    public void checkFromInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number:");
        String value = input.nextLine();
        int intValue = Integer.parseInt(value);
        System.out.println("The result is: " + calc(intValue));
    }

    public void printRange(int start, int end) {
        for(int i = start; i <= end; i++) {
            System.out.println(calc(i));
        }
    }
}
