package TheDesk;

import java.util.List;

public class DeskSearch {

  public static void searchExpenses(final List<Integer> expenses) {

    int query = DeskOperations.getInput("Search Expenses: What expense are you looking for?");

    boolean expenseFound = findExpense(expenses, query);

    if (expenseFound) {
      System.out.printf("Found %d in expense list.", query);
    } else {
      System.out.printf("%d not found.", query);
    }

    DisplayMenus.optionsSelection();
  }

  private static boolean findExpense(final List<Integer> expenses, final int query) {

    for (int ex : expenses) {
      if (ex == query) {
        return true;
      }
    }

    return false;
  }
}
