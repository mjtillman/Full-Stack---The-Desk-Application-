package TheDesk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeskSort {

  private static int getEnd(List<Integer> list) {
    return list.size() - 1;
  }

  public static List<Integer> quickSort(final List<Integer> expenses) {

    List<Integer> rawSortedList = sort(expenses);
    List<Integer> sortedList = partitioner(rawSortedList);

    return sortedList;
  }

  private static List<Integer> sort(List<Integer> sortedList) {

    System.out.print("Begin sort: \t");
    printSort(sortedList);

    int end = getEnd(sortedList);
    int pivot = sortedList.get(end);

    for (int i = 0; i < end; i++) {
      if (sortedList.get(i) > pivot) {
        Collections.swap(sortedList, i, i + 1);
      }
    }

    int pivotIndex = sortedList.indexOf(pivot);

    for (int j = 0; j < end; j++) {
      if (sortedList.get(j) > pivot) {
        Collections.swap(sortedList, j, pivotIndex);
        break;
      }
    }

    System.out.print("End sort: \t");
    printSort(sortedList);

    return sortedList;
  }

  private static List<Integer> partitioner(final List<Integer> partitionedList) {

    List<Integer> partition1 = new ArrayList<>(partitionedList.subList(0, partitionedList.size() / 2 + 1));
    List<Integer> partition2 = new ArrayList<>(partitionedList.subList(partitionedList.size() / 2 + 1, partitionedList.size()));

    List<Integer> sortedPartition1 = sort(partition1);
    List<Integer> sortedPartition2 = sort(partition2);

    List<Integer> finalList = new ArrayList<>();
    finalList.addAll(sortedPartition1);
    finalList.addAll(sortedPartition2);

    printSort(finalList);

    return finalList;
  }

  private static void printSort(List<Integer> list) {
    for (int i : list) {
      System.out.printf("%d, ", i);
    }
    System.out.printf("%n");
  }

}
