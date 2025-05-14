package benchmark;

import java.util.*;
import java.util.stream.*;
public class SequentialStreamTasks {

    public long sum(List<Integer> list) {
        return list.stream().mapToLong(Integer::longValue).sum();
    }

    public double average(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public double stdDeviation(List<Integer> list) {
        double avg = average(list);
        return Math.sqrt(list.stream()
                .mapToDouble(i -> Math.pow(i - avg, 2))
                .average()
                .orElse(0));
    }

    public List<Integer> doubled(List<Integer> list) {
        return list.stream().map(i -> i * 2).toList();
    }

    public List<Integer> filtered(List<Integer> list) {
        return list.stream()
                .filter(i -> i % 2 == 0 && i % 3 == 0)
                .toList();
    }
}
