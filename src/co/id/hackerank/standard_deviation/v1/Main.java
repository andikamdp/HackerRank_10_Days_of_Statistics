package co.id.hackerank.standard_deviation.v1;

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

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> vals = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.stdDev(vals);

        bufferedReader.close();
    }

    public static void stdDev(List<Integer> arr) {
        // Print your answers to 1 decimal place within this function

    }
}


class Result {

    /*
     * Complete the 'stdDev' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void stdDev(List<Integer> arr) {
        // Print your answers to 1 decimal place within this function
        print(Math.sqrt(vairance(arr)));

    }

    private static double vairance(List<Integer> arr){
        double mean = mean(arr);
        double value=0;
        for (int i=0;i<arr.size();i++){
            double sqDistance = (arr.get(i)-mean);
            value+=(sqDistance*sqDistance);
        }
        value/=arr.size();
        return value;
    }
    private static double mean(List<Integer> arr){
        double value=0;
        for (int i=0;i<arr.size();i++){
            value+=arr.get(i);
        }
        value/=arr.size();
        return value;
    }
    private static void print(double value){
        System.out.println(String.format("%.01f", value));
    }
}

