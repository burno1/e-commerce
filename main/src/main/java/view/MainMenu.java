package view;

import enums.menu.CollectionsOptionsEnum;
import enums.menu.MainMenuOptionEnum;
import enums.menu.ProductMenuOptionsEnum;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: Bruno Fernandes
 * Created at : 31/03/2021
 */
public class MainMenu extends Menu<MainMenuOptionEnum>{
    /**
     * @param title       Title of the menu
     * @param description Description of the menu
     * @param options     A list of all possible options
     */
    public MainMenu(String title, String description, List<String> options) {
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
                if (MainMenuOptionEnum.EXIT.getCode() == choice) return;

                verifyUserEntry(MainMenuOptionEnum.getById(choice));
            } else {
                System.out.println("Option unavailable");
            }
        } while (true);
    }

    @Override
    public void verifyUserEntry(MainMenuOptionEnum entry) {
        switch (entry){
            case COLLECTION_MANAGEMENT:
                instantiateCollectionsMenu();
                break;
            case PRODUCT_MANAGEMENT:
                instantiateProductMenu();
                break;
            default:
                break;
        }

    }

    public void instantiateProductMenu(){
        List<String> enumNames = Stream.of(ProductMenuOptionsEnum.values())
                .map(ProductMenuOptionsEnum::getName)
                .collect(Collectors.toList());

        ProductMenu menu = new ProductMenu("ProductMenu","Select the operation you want to do", enumNames);
        menu.spawnMenu();
    }
    public void instantiateCollectionsMenu(){
        List<String> enumNames = Stream.of(CollectionsOptionsEnum.values())
                .map(CollectionsOptionsEnum::getName)
                .collect(Collectors.toList());

        CollectionMenu menu = new CollectionMenu("CollectionMenu","Select the operation you want to do", enumNames);
        menu.spawnMenu();
    }
}
