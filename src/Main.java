import java.util.Scanner;
import java.util.Random;
import java.util.List;

class Win {
    public static boolean test(int a, int b) {
        return a > b;
    }
}

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int playerChoice;
        int playerWins = 0;
        int computerWins = 0;
        int computerChoice;
        int roundCounter = 1;
        String computerName = "Randó";
        String playerChoiceName;
        String computerChoiceName;

        System.out.println("Hej och välkommen till sten, sax, påse! ");
        System.out.println("Vad heter du? ");
        String name;

        while (true){
        try{
            name = new Scanner(System.in).nextLine();
            break;
        } catch (Exception e){
            System.out.println("För långt namn angivet!");
        }
        }

        System.out.println("Hej " + name + "! Din motståndare är " + computerName + ".");
        while (true){
            computerChoice = random.nextInt(3) + 1;
            System.out.println("Vad väljer du?");
            System.out.println("1. Sten");
            System.out.println("2. Sax");
            System.out.println("3. Påse");
            System.out.println("4. Avsluta spelet.");
            playerChoice = input();
            if (playerChoice == 4){
                boolean winCheck = Win.test(playerWins, computerWins);
                if (winCheck){
                    System.out.println("Du vann matchen, grattis!");
                }
                System.out.println("Spelet avslutas..");
                System.exit(0);

            }
            playerChoiceName = choiceName(playerChoice);
            computerChoiceName = choiceName(computerChoice);
            System.out.println( "Du valde " + playerChoiceName + " och " + computerName +  " valde " + computerChoiceName + ".");
            if (playerChoice == 1 && computerChoice == 2 || playerChoice == 2 && computerChoice == 3 || playerChoice == 3 && computerChoice == 1) {
                System.out.println("Du vann!");
                playerWins++;
            } else if (playerChoice == computerChoice) {
                System.out.println("Det blev oavgjort.");
            } else {
                System.out.println("Tyvärr vann " + computerName);
                computerWins++;
            }
            System.out.println("Ställningen är: " + playerWins + " - "+ computerWins);
            roundCounter++;
            System.out.println();
            System.out.println(" Runda " + roundCounter + " börjar nu!");
        }
    }

    public static String choiceName (int a) {
        while (true) {
            if (a == 1) {
                return "Sten";
            }
            if (a == 2) {
                return "Sax";
            }
            if (a == 3) {
                return "Påse";
            }
        }
    }

    public static int input() {
        List numbers = List.of(1, 2, 3, 4);
        Integer trueOrFalse;
        int input;
        while (true) {
            try {
                input = new Scanner(System.in).nextInt();
                int finalInput = input;
                trueOrFalse = (Integer) numbers
                        .stream()
                        .filter(num -> numbers.contains(finalInput))
                        .findAny()
                        .orElse(null);
                if (trueOrFalse == null) {
                    System.out.println("För hög siffra, välj mellan 1,2,3 eller 4!");
                } else {
                    return input;
                }
            } catch (Exception e) {
                    System.out.println("Du får inte skriva in bokstäver, försökt igen.");
            }
        }
    }
}