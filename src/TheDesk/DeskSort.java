package TheDesk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeskSort {

  private static List<Integer> rawList = new ArrayList<>();

  private static int rawEnd() { return rawList.size() - 1; }

  public static List<Integer> quickSort(final List<Integer> expenses) {

    rawList.addAll(expenses);

    qSort(0, rawEnd());

    System.out.println("" +
        "Your expenses have been sorted:" +
        "\n\t" + rawList);

    return rawList;
  }

  private static void qSort(final int start, final int end) {
    if (start < end) {
      int pIndex = partition(start, end);

      qSort(start, pIndex - 1);
      qSort(pIndex + 1, end);
    }
  }

  private static int partition (final int start, final int end) {

    int pivot = rawList.get(end);
    int i = start - 1;

//    System.out.print("\nStart: " + start +
//        " End: " + end +
//        " Pivot: " + pivot +
//        "\nBegin: " + printSort(start, end));

    for (int j = start; j < end; j++) {
      if (rawList.get(j) <= pivot) {
        i++;
        Collections.swap(rawList, i, j);
//        System.out.print("pass " + i + ": " + printSort(start, end));
      }
    }

    Collections.swap(rawList, i + 1, end);
//    System.out.println("final: " + printSort(start, end));

    return i + 1;
  }

  private static String printSort(final int start, final int end) {
    StringBuilder sb = new StringBuilder();

    for (int i = start; i < end; i++) {
      sb.append(rawList.get(i)).append(", ");
    }

    sb.append(rawList.get(end));
    sb.append("\n");

    return sb.toString();
  }
}
