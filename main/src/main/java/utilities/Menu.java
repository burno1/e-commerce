package utilities;

import enums.MenuOptionEnum;
import model.Product;
import model.Store;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Author: Bruno Fernandes
 * Created at : 22/03/2021
 */
public class Menu {

    Store store = new Store();

    /** Title of the menu */
    private final String title;

    /** Optional description of the menu */
    private final Optional<String> description;

    /** Collection containing all possible actions */
    private final List<String> options;

    /**
     * @param title   Title of the menu
     * @param options A list of all possible options 
     */
    public Menu(
            final String title,
            final List<String> options
    ) {
        this.title = title;
        this.description = Optional.empty();
        this.options = options;
    }

    /**
     * @param title       Title of the menu
     * @param description Description of the menu
     * @param options     A list of all possible options
     */
    public Menu (
            final String title,
            final String description,
            final List<String> options
    ) {
        this.title = title;
        this.description = Optional.of(description);
        this.options = options;
    }


    /**
     * Show menu on the console
     */
    public void spawnMenu() {
        final Scanner sc = new Scanner(System.in);
        int choice = 0;

        System.out.println('\n' + this.title);
        this.description.ifPresent(s -> System.out.println(s));

        do {
            for (int i = 0; i < this.options.size(); i++) {
                System.out.println((i + 1) + " - " + this.options.get(i));
            }

            if (sc.hasNextInt())
                choice = sc.nextInt();

            if( MenuOptionEnum.EXIT == MenuOptionEnum.valueOf(this.options.get(choice - 1))) return;

            if (choice > 0 && (choice - 1) < this.options.size()) {
                verifyUserEntry(MenuOptionEnum.valueOf(this.options.get(choice - 1)));
            } else {
                System.out.println("Option unavailable");
            }

        } while (true);
    }

    /** A prompt that takes input from standard input
     * @param  question A question presented to the user
     * @return          A string answer
     */
    public static String prompt(String question) {
        final Scanner sc = new Scanner(System.in);
        String input = "";

        do {
            System.out.println();
            System.out.println(question);
            input = sc.nextLine();
        } while (input == "");

        return input;
    }

    /** A prompt that takes input from standard input
     * @param  question A question presented to the user
     * @return          An integer answer
     */
    public static int promptInt(String question, int min, int max) {
        final Scanner sc = new Scanner(System.in);
        int input = 0;

        do {
            System.out.println();
            System.out.println(question);

            if (sc.hasNextInt())
                input = sc.nextInt();

        } while (input < min || input > max);

        return input;
    }

    /** A prompt that takes input from standard input
     * @param  question A question presented to the user
     * @return          A double
     */
    public static double promptDouble(String question, double min) {
        final Scanner sc = new Scanner(System.in);
        double input = 0;

        do {
            System.out.println();
            System.out.println(question);

            if (sc.hasNextDouble())
                input = sc.nextDouble();

        } while (input < min);

        return input;
    }


    /**
     * Verify entry given by the user accordinly to the enum
     * @param entry enum passed to method
     */
    public void verifyUserEntry(MenuOptionEnum entry){
        switch (entry){
            case ADD:
                store.addProduct();
                break;
            case LIST:
                store.listProducts();
                break;
            case SEARCH:
                store.search();
                break;
            case EXIT:
        }
    }



}