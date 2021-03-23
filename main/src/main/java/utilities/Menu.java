package utilities;

import enums.MenuOptionEnum;
import exception.ObjectNotFoundException;
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

    /**
     * Title of the menu
     */
    private final String title;
    /**
     * Optional description of the menu
     */
    private final Optional<String> description;
    /**
     * Collection containing all possible actions
     */
    private final List<String> options;
    private Store store = new Store();

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
                System.out.println("That's not a number! Type again");
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
                System.out.println("That's not a number! Type again");
                sc.next();
            }
            input = sc.nextDouble();

        } while (input < min);

        return input;
    }

    /**
     * Show menu on the console
     */
    public void spawnMenu() {
        final Scanner sc = new Scanner(System.in);
        int choice = 0;

        System.out.println('\n' + this.title);
        this.description.ifPresent(System.out::println);

        do {
            for (int i = 0; i < this.options.size(); i++) {
                System.out.println((i + 1) + " - " + this.options.get(i));
            }

            while (!sc.hasNextInt()) {
                System.out.println("That's not a number! Type again");
                sc.next();
            }
            choice = sc.nextInt();

            if (choice > 0 && (choice - 1) < this.options.size()) {
                if (MenuOptionEnum.EXIT == MenuOptionEnum.valueOf(this.options.get(choice - 1))) return;

                verifyUserEntry(MenuOptionEnum.valueOf(this.options.get(choice - 1)));
            } else {
                System.out.println("Option unavailable");
            }
        } while (true);
    }

    /**
     * Verify entry given by the user accordinly to the enum
     *
     * @param entry enum passed to method
     */
    public void verifyUserEntry(MenuOptionEnum entry) {
        try {
            switch (entry) {
                case ADD:
                    Product readProduct = readProduct();
                    store.addProduct(readProduct);
                    break;
                case LIST:
                    if (store.listProducts().size() == 0) {
                        System.out.println("No products to show");
                        break;
                    }
                    store.listProducts().forEach(System.out::println);
                    break;
                case SEARCH:
                    Product product;
                    String name = Menu.prompt("Type the name of the product");
                    product = store.search(name);
                    System.out.println(product.customPrint());
                    break;
                default:
                    break;
            }
        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Read the product in the console input
     */
    public Product readProduct() {
        String name = Menu.prompt("What is the product name?");
        double price = Menu.promptDouble("What is the product Price?", 0);
        String description = Menu.prompt("What is the product description?");
        int quantity = Menu.promptInt("What is the product quantity", 0);
        String category = Menu.prompt("What is the product category?");

        return new Product
                .Builder(name)
                .price(price)
                .description(description)
                .quantity(quantity)
                .category(category)
                .build();
    }
}