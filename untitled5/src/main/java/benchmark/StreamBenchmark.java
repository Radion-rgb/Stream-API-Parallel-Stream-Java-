package benchmark;


import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class StreamBenchmark {

    private List<Integer> data;
    private SequentialStreamTasks seq;
    private ParallelStreamTasks par;

    @Setup(Level.Iteration)
    public void setup() {
        data = DataGenerator.generateData();
        seq = new SequentialStreamTasks();
        par = new ParallelStreamTasks();
    }

    @Benchmark public long seqSum()       { return seq.sum(data); }
    @Benchmark public long parSum()       { return par.sum(data); }

    @Benchmark public double seqAvg()     { return seq.average(data); }
    @Benchmark public double parAvg()     { return par.average(data); }

    @Benchmark public double seqStdDev()  { return seq.stdDeviation(data); }
    @Benchmark public double parStdDev()  { return par.stdDeviation(data); }

    @Benchmark public List<Integer> seqDouble() { return seq.doubled(data); }
    @Benchmark public List<Integer> parDouble() { return par.doubled(data); }

    @Benchmark public List<Integer> seqFilter() { return seq.filtered(data); }
    @Benchmark public List<Integer> parFilter() { return par.filtered(data); }
}
