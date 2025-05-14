package benchmark;

import java.util.*;

public class ParallelStreamTasks {

    public long sum(List<Integer> list) {
        return list.parallelStream().mapToLong(Integer::longValue).sum();
    }

    public double average(List<Integer> list) {
        return list.parallelStream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public double stdDeviation(List<Integer> list) {
        double avg = average(list);
        return Math.sqrt(list.parallelStream()
                .mapToDouble(i -> Math.pow(i - avg, 2))
                .average()
                .orElse(0));
    }

    public List<Integer> doubled(List<Integer> list) {
        return list.parallelStream().map(i -> i * 2).toList();
    }

    public List<Integer> filtered(List<Integer> list) {
        return list.parallelStream()
                .filter(i -> i % 2 == 0 && i % 3 == 0)
                .toList();
    }
}
