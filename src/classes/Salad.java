/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author George.Giazitzis
 */
public class Salad {

    private final Scanner sc = new Scanner(System.in);
    private ArrayList<Ingredient> ingredientChosen = new ArrayList();
    private ArrayList<Ingredient> availableIngr = new ArrayList();
    private int numberOfSalads = 0;
    private float totalCost = 0;

    public Salad() {
        System.out.println("Welcome to our Salad bar!");
        chooseSalad();
    }

    private void chooseSalad() {
        numberOfSalads++;
        System.out.println("We offer a plethora of salads but you can also create your own!"
                + "\nInsert \"1\" for a Caesar's Salad \nInsert \"2\" for a Chicken Salad"
                + "\nInsert \"3\" for Village Salad\nInsert \"4\" to craete your own!"
                + "\nYou get a 30% discount if you order 3 or more Salads!");
        loop:
        do {
            String choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.println("A Caesar's salad!");
                    caesarSalad();
                    break loop;
                case "2":
                    System.out.println("A Chicken Salad!");
                    chickenSalad();
                    break loop;
                case "3":
                    System.out.println("A Village Salad!");
                    villageSalad();
                    break loop;
                case "4":
                    System.out.println("Let's create your salad together:");
                    availableIngredients();
                    break loop;
                default:
                    System.out.println("Invalid input, please try again!");
            }
        } while (true);
    }

    private void caesarSalad() {
        ingredientChosen.add(new Ingredient("Chicken", 1.20f));
        ingredientChosen.add(new Ingredient("Lettuce", 0.50f));
        ingredientChosen.add(new Ingredient("Parmesan Cheese", 0.70f));
        ingredientChosen.add(new Ingredient("Ceasar's sauce", 0.40f));
        ingredientChosen.add(new Ingredient("Crouton", 0.40f));
        ingredientChosen.add(new Ingredient("Arugula", 0.70f));
        ingredientChosen.add(new Ingredient("Almonds", 1.00f));
        addRemoveIngr();
    }

    private void chickenSalad() {
        ingredientChosen.add(new Ingredient("Chicken", 1.20f));
        ingredientChosen.add(new Ingredient("Lettuce", 0.50f));
        ingredientChosen.add(new Ingredient("Celery", 0.60f));
        ingredientChosen.add(new Ingredient("Apple", 0.70f));
        ingredientChosen.add(new Ingredient("Olives", 0.55f));
        ingredientChosen.add(new Ingredient("Mayonnaise", 0.35f));
        addRemoveIngr();
    }

    private void villageSalad() {
        ingredientChosen.add(new Ingredient("Lettuce", 0.50f));
        ingredientChosen.add(new Ingredient("Tomato", 0.60f));
        ingredientChosen.add(new Ingredient("Cucumber", 0.40f));
        ingredientChosen.add(new Ingredient("Feta cheese", 0.70f));
        ingredientChosen.add(new Ingredient("Onion", 0.35f));
        ingredientChosen.add(new Ingredient("Olives", 0.55f));
        ingredientChosen.add(new Ingredient("Oregano", 0.20f));
        addRemoveIngr();
    }

    private void addRemoveIngr() {

        float sum = 0;
        System.out.println("Your salad contains:");
        for (int i = 0; i < ingredientChosen.size(); i++) {
            System.out.println(ingredientChosen.get(i).getName() + "  " + ingredientChosen.get(i).getPrice() + "$");
            sum += ingredientChosen.get(i).getPrice();
        }
        System.out.print("Total:   ");
        System.out.printf("%.2f", sum);
        System.out.print("$\n\n");
        System.out.println("Insert \"add\" to add extra ingredients, \"remove\" to remove ingredients, \"end\" Proceed to Checkout, \"new\" To order an additional Salad!");
        loop:
        do {
            String choice = sc.next();
            switch (choice) {
                case "add":
                    System.out.println("Which ingredient would you like to add?");
                    availableIngredients();
                    break loop;
                case "remove":
                    System.out.println("Which ingredient would you like to remove?");
                    removeIngredient();
                    break loop;
                case "end":
                    totalCost += sum;
                    checkout();
                    break loop;
                case "new":
                    totalCost += sum;
                    System.out.println("What should your next salad be?");
                    ingredientChosen.clear();
                    chooseSalad();
                    break loop;
                default:
                    System.out.println("Invalid input, please try again!");
            }
        } while (true);
    }

    private void availableIngredients() {
        if (availableIngr.isEmpty()) {
            availableIngr.add(new Ingredient("Chicken", 1.20f));
            availableIngr.add(new Ingredient("Lettuce", 0.50f));
            availableIngr.add(new Ingredient("Parmesan Cheese", 0.70f));
            availableIngr.add(new Ingredient("Ceasar's sauce", 0.40f));
            availableIngr.add(new Ingredient("Crouton", 0.40f));
            availableIngr.add(new Ingredient("Arugula", 0.70f));
            availableIngr.add(new Ingredient("Almonds", 1.00f));
            availableIngr.add(new Ingredient("Celery", 0.50f));
            availableIngr.add(new Ingredient("Apple", 0.70f));
            availableIngr.add(new Ingredient("Mayonnaise", 0.35f));
            availableIngr.add(new Ingredient("Tomato", 0.60f));
            availableIngr.add(new Ingredient("Cucumber", 0.40f));
            availableIngr.add(new Ingredient("Feta cheese", 0.70f));
            availableIngr.add(new Ingredient("Onion", 0.35f));
            availableIngr.add(new Ingredient("Olives", 0.55f));
            availableIngr.add(new Ingredient("Oregano", 0.20f));
        }
        addIngredient();
    }

    private void addIngredient() {
        float sum = 0;
        loop:
        do {
            System.out.println("Your salad contains:");
            for (int i = 0; i < ingredientChosen.size(); i++) {
                System.out.println(ingredientChosen.get(i).getName() + "  " + ingredientChosen.get(i).getPrice() + "$");
                sum += ingredientChosen.get(i).getPrice();
            }
            System.out.print("Total:   ");
            System.out.printf("%.2f", sum);
            System.out.print("$\n\n");
            System.out.println("Available ingredients:");
            for (int i = 0; i < availableIngr.size(); i++) {
                System.out.println(availableIngr.get(i).getName() + "  " + availableIngr.get(i).getPrice() + "$  Ingredient No: " + (i + 1));
            }
            System.out.println("Insert a number to the corresponding ingredient you would like to add, insert \"remove\" to remove ingredients, insert \"end\" to Checkout, insert \"new\" to order an additional Salad!");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    ingredientChosen.add(new Ingredient("Chicken", 1.20f));
                    break;
                case "2":
                    ingredientChosen.add(new Ingredient("Lettuce", 0.50f));
                    break;
                case "3":
                    ingredientChosen.add(new Ingredient("Parmesan Cheese", 0.70f));
                    break;
                case "4":
                    ingredientChosen.add(new Ingredient("Ceasar's sauce", 0.40f));
                    break;
                case "5":
                    ingredientChosen.add(new Ingredient("Crouton", 0.40f));
                    break;
                case "6":
                    ingredientChosen.add(new Ingredient("Arugula", 0.70f));
                    break;
                case "7":
                    ingredientChosen.add(new Ingredient("Almonds", 1.00f));
                    break;
                case "8":
                    ingredientChosen.add(new Ingredient("Celery", 0.50f));
                    break;
                case "9":
                    ingredientChosen.add(new Ingredient("Apple", 0.70f));
                    break;
                case "10":
                    ingredientChosen.add(new Ingredient("Mayonnaise", 0.35f));
                    break;
                case "11":
                    ingredientChosen.add(new Ingredient("Tomato", 0.60f));
                    break;
                case "12":
                    ingredientChosen.add(new Ingredient("Cucumber", 0.40f));
                    break;
                case "13":
                    ingredientChosen.add(new Ingredient("Feta cheese", 0.70f));
                    break;
                case "14":
                    ingredientChosen.add(new Ingredient("Onion", 0.35f));
                    break;
                case "15":
                    ingredientChosen.add(new Ingredient("Olives", 0.55f));
                    break;
                case "16":
                    ingredientChosen.add(new Ingredient("Oregano", 0.20f));
                    break;
                case "end":
                    totalCost += sum;
                    checkout();
                    break loop;
                case "remove":
                    System.out.println("What ingredient would you like to remove?");
                    removeIngredient();
                    break loop;
                case "new":
                    totalCost += sum;
                    System.out.println("What should your next salad be?");
                    ingredientChosen.clear();
                    chooseSalad();
                    break loop;
                default:
                    System.out.println("Invalid input,please try again!");
            }
            sum = 0;
        } while (true);
    }

    private void removeIngredient() {
        float sum = 0;
        String choice;
        do {
            System.out.println("Your salad contains:");
            for (int i = 0; i < ingredientChosen.size(); i++) {
                System.out.println(ingredientChosen.get(i).getName() + "  " + ingredientChosen.get(i).getPrice() + "$  Ingredient No: " + (i + 1));
                sum += ingredientChosen.get(i).getPrice();
            }
            System.out.print("Total:   ");
            System.out.printf("%.2f", sum);
            System.out.print("$\n\n");
            System.out.println("Insert a number to the corresponding ingredient you would like to remove, insert \"add\" to add ingredients, insert \"end\" to Checkout, insert \"new\" to order an additional Salad!");
            choice = sc.next();
            Scanner test = new Scanner(choice);
            if (test.hasNextInt()) {
                if (Integer.parseInt(choice) <= 0 || Integer.parseInt(choice) > ingredientChosen.size()) {
                    System.out.println("Wrong numeric value, please try again!");
                }
                for (int i = 0; i < ingredientChosen.size(); i++) {
                    if (Integer.parseInt(choice) == (i + 1)) {
                        ingredientChosen.remove(i);
                    }
                }
            } else {
                if (choice.equalsIgnoreCase("end")) {
                    totalCost += sum;
                    checkout();
                    break;
                } else if (choice.equalsIgnoreCase("add")) {
                    System.out.println("What ingredient would you like to add?");
                    availableIngredients();
                    break;
                } else if (choice.equalsIgnoreCase("new")) {
                    totalCost += sum;
                    System.out.println("What should your next salad be?");
                    ingredientChosen.clear();
                    chooseSalad();
                    break;
                }
                System.out.println("Wrong input, please try again!");
            }
            sum = 0;
        } while (true);
    }

    private void checkout() {
        if (numberOfSalads >= 3) {
            totalCost *= 0.7;
            System.out.println("Your order is eligible for our 30% discount!");
        }
        System.out.print("Number of salads: " + numberOfSalads + ", That would be: ");
        System.out.printf("%.2f", totalCost);
        System.out.print("$\nThank you very much! Have a nice day!");
    }
}
