package TheDesk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DisplayMenus {

  static void optionsSelection() {

    List<String> arr = Stream.of(
        "1. I wish to review my expenditure",
        "2. I wish to add my expenditure",
        "3. I wish to delete my expenditure",
        "4. I wish to sort the expenditures",
        "5. I wish to search for a particular expenditure",
        "6. Close the application")
        .collect(Collectors.toList());

    List<Integer> expenses = initializeExpenses();
    Boolean exit = false;

    do {

      arr.forEach(System.out::println);
      int options = getInput("\nEnter your choice:\t");

      switch (options) {
        case 1:
          reviewExpenses(expenses);
          break;
        case 2:
          expenses = addExpenses(expenses);
          break;
        case 3:
          expenses = deleteExpenses(expenses);
          break;
        case 4:
          expenses = sortExpenses(expenses);
          break;
        case 5:
          searchExpenses(expenses);
          break;
        case 6:
          exit = true;
          break;
        default:
          System.out.println("You have made an invalid choice!");
          break;
      }
    } while (!exit);

    closeApp();
  }

  private static List<Integer> initializeExpenses() {
    return Stream.of(
        1000, 2300, 45000, 32000, 110)
        .collect(Collectors.toList());
  }

  private static void reviewExpenses(final List<Integer> expenses) {
    printChanges("Your saved expenses are listed below:", expenses);
    optionsSelection();
  }

  private static List<Integer> addExpenses(final List<Integer> expenses) {
    List<Integer> newExpenses = new ArrayList<>(expenses);

    int value = getInput("Enter the value to add your expenses:");

    newExpenses.add(value);
    printChanges("Your expenses are updated:", newExpenses);

    return newExpenses;
  }

  private static List<Integer> deleteExpenses(final List<Integer> expenses) {

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

  private static Integer getInput(String instruction) {
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

  private static void printChanges(String text, final List<Integer> expenses) {
    System.out.println(text);
    System.out.println("\t" + expenses + "\n");
  }

//  private static List<Integer> sortExpenses(final List<Integer> expenses) {
//    int arrlength = expenses.size();
//    //Complete the method. The expenses should be sorted in ascending order.
//
//  }
  private static List<Integer> sortExpenses(final List<Integer> expenses) {
    List<Integer> sortedExpenses = new ArrayList<>(expenses);



    return sortedExpenses;
  }

//  private static void searchExpenses(ArrayList<Integer> arrayList) {
//    int leng = arrayList.size();
//    System.out.println("Enter the expense you need to search:\t");
//    //Complete the method
//  }
  private static void searchExpenses(final List<Integer> expenses) {
    System.out.println();
  }

  private static void closeApp() {
    System.out.println("Closing your application... \nThank you!");
  }
}
