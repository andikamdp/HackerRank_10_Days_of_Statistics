package co.id.hackerank.mean_median_mode.v1;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int count;
        double[] datas;
        count = sc.nextInt();
        datas=new double[count];
        for (int i=0;i<count;i++){
            datas[i] = sc.nextDouble();
        }
        Arrays.sort(datas);
        mean(datas);
        median(datas);
        mode(datas);
    }

    private static void mean(double[] datas){
        double value=0;
        for (int i=0;i<datas.length;i++){
            value+=  datas[i];
        }
        value/=datas.length;
        print(value);
    }

    private static void median(double[] datas){
        double value=0, value1=0 ,value2=0;

        int length = datas.length;
        int index =length/2;
        if(length%2==1){
            value=datas[index];
        }else{
            value1=datas[index-1];
            value2=datas[index];
            value=(value1+value2)/2;
        }
        print(value);
    }

    private static void mode(double[] datas){
        double mostOccurence = 0,current = 0;
        int maxMostOccurence=0,occurenceCurrent = 0;
        for (int i=0;i<datas.length;i++){
            current = datas[i];
            occurenceCurrent=0;
            for (int j=i;j<datas.length;j++){
                if(current==datas[j]){
                    occurenceCurrent++;
                }
            }

            if(maxMostOccurence<occurenceCurrent){
                mostOccurence=current;
                maxMostOccurence=occurenceCurrent;
            }else if(maxMostOccurence==occurenceCurrent){
                if(mostOccurence>current){
                    mostOccurence=current;
                }
            }
        }
        print(mostOccurence);
    }

    private static void print(double value){
        System.out.println(String.format("%.01f", value));
    }
}
