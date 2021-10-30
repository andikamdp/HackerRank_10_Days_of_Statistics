package co.id.hackerank.Interquartile_range.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> val = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> freq = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.interQuartile(val, freq);

        bufferedReader.close();
    }
}


class Result {

    /*
     * Complete the 'interQuartile' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY values
     *  2. INTEGER_ARRAY freqs
     */

    public static void interQuartile(List<Integer> values, List<Integer> freqs) {
        // Print your answer to 1 decimal place within this function

        int q1,q3;
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < values.size(); i++) {
            for (int j = 0; j < freqs.get(i); j++) {
                arr.add(values.get(i));
            }
        }

        arr = arr.stream().sorted().collect(toList());
        q1 = q1(arr);
        q3 = q3(arr);

        print(q3-q1);

    }

    private static int q1(List<Integer> arr) {
        int value = 0, value1 = 0, value2 = 0;
        int lengthq2 = arr.size();//8;9;10;11
        int indexq2 = lengthq2%2==0? lengthq2 / 2 : (lengthq2 / 2) +1;//4:5:5:6

        int lengthq1 = lengthq2 - (lengthq2%2==0?indexq2:indexq2);//4:4:5:5
        int indexq1 = lengthq1 / 2;//2:2:2:2

        if (lengthq1 % 2 == 1) {//10:11
            value = arr.get(indexq1);//3:3//2:2
        } else {//8:9
            value1 = arr.get(indexq1 - 1);//2:1
            value2 = arr.get(indexq1);//:3:2
            value = (value1 + value2) / 2;
        }
        return value;
    }

    private static int q3(List<Integer> arr) {
        int value = 0, value1 = 0, value2 = 0;

        int lengthq2 = arr.size();//8;9;10;11
        int indexq2 = lengthq2%2==0? lengthq2 / 2 : (lengthq2 / 2) +1;//4:5:5:6

        int lengthq1 = lengthq2 - (lengthq2%2==0?indexq2:indexq2);//4:4:5:5
        int indexq1 = lengthq1 / 2;//2:2:2:2

        int indexq3 = indexq1 + indexq2;//6:7:7:8
        if (lengthq1 % 2 == 1) {//10:11
            value = arr.get(indexq3);//8:9:
        } else {//8:9
            value1 = arr.get(indexq3 - 1);
            value2 = arr.get(indexq3);
            value = (value1 + value2) / 2;
        }
        return value;
    }

    private static void print(double value){
        System.out.println(String.format("%.01f", value));
    }

}
