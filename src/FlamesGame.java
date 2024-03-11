import java.util.Scanner;

public class FlamesGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first person's name: ");
        String name1 = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

        System.out.println("Enter the second person's name: ");
        String name2 = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

        String flames = "flames";
        StringBuilder flamesBuilder = new StringBuilder(flames);

        // Removing common letters
        for (int i = 0; i < name1.length(); i++) {
            for (int j = 0; j < name2.length(); j++) {
                if (name1.charAt(i) == name2.charAt(j)) {
                    char commonLetter = name1.charAt(i);
                    int index = flamesBuilder.indexOf(String.valueOf(commonLetter));
                    if (index != -1) {
                        flamesBuilder.deleteCharAt(index);
                    }
                    break;
                }
            }
        }

        // Counting remaining letters
        int remainingLetters = flamesBuilder.length();

        // Finding the relationship status
        while (flamesBuilder.length() > 1) {
            int count = remainingLetters % flamesBuilder.length();
            flamesBuilder.deleteCharAt(count == 0 ? flamesBuilder.length() - 1 : count - 1);
        }

        // Mapping the result
        char resultLetter = flamesBuilder.charAt(0);
        String result = "";
        switch (resultLetter) {
            case 'f':
                result = "Friends";
                break;
            case 'l':
                result = "Lovers";
                break;
            case 'a':
                result = "Affectionate";
                break;
            case 'm':
                result = "Marriage";
                break;
            case 'e':
                result = "Enemies";
                break;
            case 's':
                result = "Siblings";
                break;
        }

        System.out.println("Relationship status between " + name1.toUpperCase() + " and " + name2.toUpperCase() + " is: " + result);
        scanner.close();
    }
}

