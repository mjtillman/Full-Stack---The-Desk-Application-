package TheDesk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DisplayMenus {

  static void optionsSelection() {

    List<String> arr = Stream.of(
        "\n",
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
      int options = DeskOperations.getInput("\nEnter your choice:\t");

      switch (options) {
        case 1:
          DeskOperations.reviewExpenses(expenses);
          break;
        case 2:
          expenses = DeskOperations.addExpenses(expenses);
          break;
        case 3:
          expenses = DeskOperations.deleteExpenses(expenses);
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
        50, 23, 88, 9, 18, 61, 32)
//        1000, 2300, 45000, 32000, 110)
        .collect(Collectors.toList());
  }

  private static List<Integer> sortExpenses(final List<Integer> expenses) {
      return DeskSort.quickSort(expenses);
  }

  private static void searchExpenses(final List<Integer> expenses) {
    DeskSearch.searchExpenses(expenses);
  }

  private static void closeApp() {
    System.out.println("Closing your application... \nThank you!");
  }
}
