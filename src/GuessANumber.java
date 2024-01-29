import java.util.Random;
import java.util.Scanner;

public class GuessANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomNumber = new Random();
        int compNumber = randomNumber.nextInt(100);
        int fails = 0;

        System.out.println("Game is going to start");
        System.out.println("You have 3 attempts");

        while(true){
            System.out.println("Guess a number (1 - 100)");
            String playerInput = scanner.nextLine();
            boolean isValid = true;


            if(playerInput.length() <= 2 || playerInput.equals("100")) {
                for (int index = 0; index < playerInput.length(); index++) {
                    if (playerInput.charAt(index) < 48 || playerInput.charAt(index) > 57) {
                        isValid = false;
                        break;
                    }
                }
            }else{
                isValid = false;
            }

            if(isValid){
                int playersNumber = Integer.parseInt(playerInput);
                if(playersNumber == compNumber){
                    System.out.println("You guessed it");
                    break;
                } else if (playersNumber > compNumber) {
                    fails++;
                    if(fails == 3){
                        System.out.println("You lost");
                        return;
                    }
                    System.out.println("Try lower number");
                }else{

                    fails++;
                    if(fails == 3){
                        System.out.println("You lost");
                        return;
                    }
                    System.out.println("Try higher number");
                }

            }else{
                System.out.println("Invalid input");
            }


        }
    }
}
