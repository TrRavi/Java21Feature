package com.ravi.practice;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * Platform Threads:-
 * Virtual Threads:- independent of any OS thread, is used to run programs.
 *      The Java runtime suspends the virtual thread until it resumes when the code calls a
 *      blocked I/O operation. Virtual threads have a limited call stack and
 *      can only execute one HTTP client call or JDBC query. They are suitable for delayed operations,
 *      but not for extended CPU-intensive tasks.
 *
 *      Their goal is to provide scale (greater throughput) rather than speed (lower latency)
 */
public class VirtualThread {

    public static void main(String[] args) {
        Instant startTime = Instant.now();
        try (ExecutorService myExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10000).forEach( i -> myExecutor.submit(() ->{
                Thread.sleep(Duration.ofSeconds(1));
                return i;
            }));
        }
        Instant endTime = Instant.now();
        System.out.println(Duration.between(startTime, endTime));
    }

}
