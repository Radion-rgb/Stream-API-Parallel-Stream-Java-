package benchmark;

import java.util.*;
import java.util.stream.*;

public class DataGenerator { public static List<Integer> generateData() {
    Random rand = new Random();
    return IntStream.range(0, 10_000_000)
            .map(i -> rand.nextInt(100) + 1)
            .boxed()
            .collect(Collectors.toList());
}
}
