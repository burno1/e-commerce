package view;

import enums.menu.ProductMenuOptionsEnum;
import exception.ObjectNotFoundException;
import model.Product;
import service.CollectionService;
import service.ProductService;

import java.util.List;
import java.util.Scanner;

/**
 * Author: Bruno Fernandes
 * Created at : 31/03/2021
 */
public class ProductMenu extends Menu<ProductMenuOptionsEnum> {
    private final ProductService productService = new ProductService();
    private final CollectionService collectionService =new CollectionService();

    /**
     * @param title       Title of the menu
     * @param description Description of the menu
     * @param options     A list of all possible options
     */
    public ProductMenu(String title, String description, List<String> options) {
        super(title, description, options);
    }

    /**
     * Read the product in the console input
     */
    public Product readProduct() {
        String collectionName = Menu.prompt("What is the product collection?");
        String name = Menu.prompt("What is the product name?");
        double price = Menu.promptDouble("What is the product Price?", 0);
        String description = Menu.prompt("What is the product description?");
        int quantity = Menu.promptInt("What is the product quantity", 0);

        return new Product
                .Builder(name)
                .price(price)
                .description(description)
                .quantity(quantity)
                .collection(collectionName)
                .build();
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
                if (ProductMenuOptionsEnum.EXIT.getCode() == choice) return;

                verifyUserEntry(ProductMenuOptionsEnum.getById(choice));
            } else {
                System.out.println("Option unavailable");
            }
        } while (true);
    }

    @Override
    public void verifyUserEntry(ProductMenuOptionsEnum entry) {
        try {
            switch (entry) {
                case ADD:
                    Product readProduct = readProduct();
                    productService.addProduct(readProduct);
                    break;
                case LIST:
                    productService.listProducts().forEach(System.out::println);
                    break;
                case SEARCH:
                  String name = Menu.prompt("Type the name of the product");
                    System.out.println(productService.search(name).customPrint());
                break;
                default:
                    break;
            }
        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
