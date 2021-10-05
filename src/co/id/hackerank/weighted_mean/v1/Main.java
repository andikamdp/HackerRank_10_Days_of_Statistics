package co.id.hackerank.weighted_mean.v1;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Main {
    /*
     * Complete the 'weightedMean' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY X
     *  2. INTEGER_ARRAY W
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> vals = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> weights = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        weightedMean(vals, weights);

        bufferedReader.close();
    }

    public static void weightedMean(List<Integer> X, List<Integer> W) {
        // Write your code here
        double sumWeight=0, sumValue=0;
        double weightedMean;

        for (int i=0; i<X.size();i++){
            sumWeight+=W.get(i);
            sumValue+=(W.get(i)*X.get(i));
        }
        weightedMean=sumValue/sumWeight;
        System.out.println(String.format("%.01f", weightedMean));
    }

}