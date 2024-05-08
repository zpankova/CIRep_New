package org.example;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
/*comment*/

public class NPBenchmarks {


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void measure_min() {
        NumbersProcessor.min("Speed_check.txt");
    }
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(NPBenchmarks.class.getSimpleName())
                .forks(1)
                .warmupIterations(1)
                .measurementIterations(1)
                .build();
        new Runner(options).run();
    }

}