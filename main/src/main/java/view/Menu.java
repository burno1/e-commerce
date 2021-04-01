package view;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Author: Bruno Fernandes
 * Created at : 22/03/2021
 */
public abstract class Menu<T> {

    protected String title;
    protected Optional<String> description;
    protected List<String> options;

    /**
     * @param title       Title of the menu
     * @param description Description of the menu
     * @param options     A list of all possible options
     */
    public Menu(
            final String title,
            final String description,
            final List<String> options
    ) {
        this.title = title;
        this.description = Optional.of(description);
        this.options = options;
    }

    /**
     * A prompt that takes input from standard input
     *
     * @param question A question presented to the user
     * @return A string answer
     */
    public static String prompt(String question) {
        final Scanner sc = new Scanner(System.in);
        String input;

        do {
            System.out.println();
            System.out.println(question);
            input = sc.nextLine();

        } while (input.equals(""));

        return input;
    }

    /**
     * A prompt that takes input from standard input
     *
     * @param question A question presented to the user
     * @return An integer answer
     */
    public static int promptInt(String question, int min) {
        final Scanner sc = new Scanner(System.in);
        int input;

        do {
            System.out.println();
            System.out.println(question);

            while (!sc.hasNextInt()) {
                System.out.println("That's not a integer! Type again");
                sc.next();
            }
            input = sc.nextInt();


        } while (input < min);

        return input;
    }

    /**
     * A prompt that takes input from standard input
     *
     * @param question A question presented to the user
     * @return A double
     */
    public static double promptDouble(String question, double min) {
        final Scanner sc = new Scanner(System.in);
        double input;

        do {
            System.out.println();
            System.out.println(question);

            while (!sc.hasNextDouble()) {
                System.out.println("That's not a double! Type again");
                sc.next();
            }
            input = sc.nextDouble();

        } while (input < min);

        return input;
    }

    /**
     * Show menu on the console
     */
    public abstract void spawnMenu();


    /**
     * Verify entry given by the user accordinly to the enum
     */
    public abstract void verifyUserEntry(T entry);


}