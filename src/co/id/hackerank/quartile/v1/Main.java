package co.id.hackerank.quartile.v1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> data = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());

        List<Integer> data= new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,10,11));

        List<Integer> res = Result.quartiles(data);

        res.forEach(System.out::println);

//        bufferedWriter.write(
//                res.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'quartiles' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> quartiles(List<Integer> arr) {
        // Write your code here
        arr = arr.stream().sorted().collect(toList());
        List<Integer> result = new ArrayList<>();
        result.add(q1(arr));
        result.add(median(arr));
        result.add(q3(arr));

        return result;
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

    private static int median(List<Integer> arr) {
        int value = 0, value1 = 0, value2 = 0;

        int length = arr.size();
        int index = length / 2;

        if (length % 2 == 1) {
            value = arr.get(index);
        } else {
            value1 = arr.get(index - 1);
            value2 = arr.get(index);
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

}
