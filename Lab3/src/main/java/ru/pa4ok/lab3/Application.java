package ru.pa4ok.lab3;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import ru.pa4ok.lab3.impl.BubbleSorter;
import ru.pa4ok.lab3.impl.InsertSorter;
import ru.pa4ok.lab3.impl.MergeSorter;
import ru.pa4ok.lab3.impl.QuickSorter;
import ru.pa4ok.lab3.impl.SelectSorter;
import ru.pa4ok.lab3.impl.ShellSorter;

/**
 * забавно, но похожим я уже занимался, поэтому 70% лабы это копипаст
 * https://github.com/Pa4ok/Pa4okLib/blob/master/src/main/java/ru/pa4ok/library/util/SortUtil.java
 *
 * все сортировки сделаны под int[], чтобы упростить и сделать более явными результаты тестирования
 * временные сложности указаны непосредственно в классах реализациях алгоритмов
 * тесты на корректность реализации: src/test/java/ru/pa4ok/lab3/ImplTest.java
 *
 * почитать про библиотеку на бенчмарки можно тут
 * https://www.baeldung.com/java-microbenchmark-harness
 *
 * Benchmark           Mode  Cnt    Score   Error  Units
 * Application.bubble    ss   10  185.085 ± 7.378  ms/op
 * Application.insert    ss   10   20.698 ± 3.764  ms/op
 * Application.java      ss   10    7.581 ± 1.016  ms/op
 * Application.merge     ss   10    7.459 ± 0.663  ms/op
 * Application.quick     ss   10    6.276 ± 1.363  ms/op
 * Application.select    ss   10   43.041 ± 1.488  ms/op
 * Application.shell     ss   10    7.695 ± 0.520  ms/op
 *
 * в java.util.Arrays.sort() используется алгоритм быстрой сортировки с 2 указателями
 * который оптимизирован и рассчитан на хоть как-то упорядоченные данные
 * поэтому на полностью рандомных данных есть небольшой отрыв у обычного quick алгоритма
 */
public class Application
{
    private static final Random RAND = new Random();
    private static final int ARR_SIZE = 10000;
    private static final int ARR_MIN_VALUE = -10000;
    private static final int ARR_MAX_VALUE = 10000;

    public static void main(String[] args) throws Exception
    {
        org.openjdk.jmh.Main.main(args);
    }

    private static int[] getDirtyArray()
    {
        int[] arr = RAND.ints(ARR_SIZE, ARR_MIN_VALUE, ARR_MAX_VALUE).toArray();
        System.arraycopy(arr, 0, arr, 0, arr.length);
        return arr;
    }

    @Benchmark
    @Fork(value = 10, warmups = 5)
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void java()
    {
        int[] arr = getDirtyArray();
        Arrays.sort(arr);
    }

    @Benchmark
    @Fork(value = 10, warmups = 5)
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void bubble()
    {
        int[] arr = getDirtyArray();
        BubbleSorter.INSTANCE.sort(arr);
    }

    @Benchmark
    @Fork(value = 10, warmups = 5)
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void insert()
    {
        int[] arr = getDirtyArray();
        InsertSorter.INSTANCE.sort(arr);
    }

    @Benchmark
    @Fork(value = 10, warmups = 5)
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void merge()
    {
        int[] arr = getDirtyArray();
        MergeSorter.INSTANCE.sort(arr);
    }

    @Benchmark
    @Fork(value = 10, warmups = 5)
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void quick()
    {
        int[] arr = getDirtyArray();
        QuickSorter.INSTANCE.sort(arr);
    }

    @Benchmark
    @Fork(value = 10, warmups = 5)
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void select()
    {
        int[] arr = getDirtyArray();
        SelectSorter.INSTANCE.sort(arr);
    }

    @Benchmark
    @Fork(value = 10, warmups = 5)
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void shell()
    {
        int[] arr = getDirtyArray();
        ShellSorter.INSTANCE.sort(arr);
    }
}
