package TheDesk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeskOperations {

  static void reviewExpenses(final List<Integer> expenses) {
    printChanges("Your saved expenses are listed below:", expenses);
    DisplayMenus.optionsSelection();
  }

  static List<Integer> addExpenses(final List<Integer> expenses) {
    List<Integer> newExpenses = new ArrayList<>(expenses);

    int value = getInput("Enter the value to add your expenses:");

    newExpenses.add(value);
    printChanges("Your expenses are updated:", newExpenses);

    return newExpenses;
  }

  static List<Integer> deleteExpenses(final List<Integer> expenses) {

    int conChoice = getInput("\nYou are about the delete all your expenses!" +
        "\nConfirm by selecting 3 again...");

    if (conChoice == 3) {
      printChanges("All your expenses are erased!", new ArrayList<>());
      return new ArrayList<>();
    } else {
      System.out.println("Oops... try again!\n");
      return expenses;
    }
  }

  static Integer getInput(String instruction) {
    Scanner sc = new Scanner(System.in);
    boolean isPosInt = false;
    int value = 0;

    do {

      System.out.println(instruction);

      try {
        value = Integer.parseInt(sc.nextLine());
        if (value > 0) {
          isPosInt = true;
        } else {
          throw new IllegalArgumentException("You must enter a positive integer!");
        }
      } catch (Exception e) {
        if (e.getClass() == IllegalArgumentException.class) {
          System.out.println(e.getMessage());
        } else {
          System.out.println("Invalid input!\t");
        }
      }
    } while (!isPosInt);

    return value;
  }

  static void printChanges(String text, final List<Integer> expenses) {
    System.out.println(text);
    System.out.println("\t" + expenses + "\n");
  }
}
