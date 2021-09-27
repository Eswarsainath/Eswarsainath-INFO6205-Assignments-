package edu.neu.coe.info6205.util;
import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.GenericSort;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.elementary.InsertionSort;
import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.Config;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class BenchmarkTimerInsertionSort {
    private static Config config;

    public static Integer[] partiallySortedArray(int m){


        Random rand = new Random();
        Integer[] a = new Integer[m];
        for (int i = 0; i<m/2; i++){
            a[i] = i;
        }

        for (int i = m/2; i<m; i++){

            a[i] =  rand.nextInt(m) + m/2;
        }

        return a;
    }


    public static Integer[] reverseSortedArray(int m){

        Integer[] a = new Integer[m];
        for(int i = 0; i<m;i++){
            a[i] = m-i;
        }
        return a;
    }

    public static Integer[] sortedArray(int m){

        Integer[] a = new Integer[m];
        for(int i = 1; i<=m;i++){
            a[i-1] = i;
        }
        return a;
    }


    public static Integer[] randomArray(int m){


        Random rand = new Random();
        Integer[] a = new Integer[m];
        for(int i = 0; i<m;i++){
            a[i] = rand.nextInt(m);
        }
        return a;
    }


    public static void runBenchmarkTest(int m, String description, Supplier<Integer[]> supplier){

        Helper<Integer> helper = new BaseHelper<>(description, m, config);
        final GenericSort<Integer> sort = new InsertionSort<>(helper);
        final Benchmark<Integer[]> benchmark = new Benchmark_Timer<>(
                description ,
                (xs) -> Arrays.copyOf(xs, xs.length),
                sort::sort,
                null

        );
        System.out.println(benchmark.runFromSupplier(supplier, 5)+  " ms");
    }


    public static void main(String[] args) {


        int m = 3000;



        String description = "Insertion sort for partially sorted array of size: " + m;
        Supplier<Integer[]> supplier = () -> partiallySortedArray(m);
        runBenchmarkTest(m, description, supplier);

        description = "Insertion sort for reversely sorted array of size: " + m;
        supplier = () -> reverseSortedArray(m);
        runBenchmarkTest(m, description, supplier);

        description = "Insertion sort for sorted array of size: " + m;
        supplier = () -> sortedArray(m);
        runBenchmarkTest(m, description, supplier);

        description = "Insertion sort for random numbers in a array of size: " + m;
        supplier = () -> randomArray(m);
        runBenchmarkTest(m, description, supplier);






    }



}
