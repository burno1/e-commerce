package view;

import enums.menu.CollectionsOptionsEnum;
import enums.menu.MainMenuOptionEnum;
import model.MainCollection;
import model.Product;
import service.CollectionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author: Bruno Fernandes
 * Created at : 31/03/2021
 */
public class CollectionMenu extends Menu<CollectionsOptionsEnum> {
    CollectionService collectionService = new CollectionService();
    /**
     * @param title       Title of the menu
     * @param description Description of the menu
     * @param options     A list of all possible options
     */
    public CollectionMenu(String title, String description, List<String> options) {
        super(title, description, options);
    }

    @Override
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
                if (CollectionsOptionsEnum.EXIT.getCode() == choice) return;

                verifyUserEntry(CollectionsOptionsEnum.getById(choice));
            } else {
                System.out.println("Option unavailable");
            }
        } while (true);
    }

    @Override
    public void verifyUserEntry(CollectionsOptionsEnum entry) {
        switch (entry){
            case ADD:
                collectionService.addMainCollection(readCollection());
                break;
            case ADD_SUB:
                System.out.println("ADD_SUB");
                break;
            case LIST:
                collectionService.listCollections().forEach(System.out::println);
                break;
            case LIST_PRODUCTS:
                System.out.println("LIST_PRODUCTS");
                break;
            case SEARCH:
                System.out.println("SEARCH");
                break;
            default:
                break;
        }

    }

    private MainCollection readCollection() {
        String name = Menu.prompt("What is the collection name?");
        String description = Menu.prompt("What is the collection name?");

        System.out.println("Write keywords for the collection, press '0' to end");
        List<String> keywords = new ArrayList<>();
        final Scanner sc = new Scanner(System.in);
        String input;

        do {
            input = sc.nextLine();
            keywords.add(input);
            System.out.println(keywords.size());
        } while (!"0".equals(input) && keywords.size() != 5);

        return new MainCollection(name,description,keywords);
    }
}
