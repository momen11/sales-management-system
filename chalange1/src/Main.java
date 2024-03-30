import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        //You write in the header of the question
        // that you want three numbers whose sum is the target, then
        //in the output you want two numbers whose sum is the target
        //but I decided I do three numbers whose sum is the target


        //Array of numbers
int[] arr={1,5,7,9,6};
int target =15;
        System.out.println("array of three numbers "+sum(arr,target));

    }
    public static ArrayList<Integer> sum(int[] numbers,int target ){
        //list of numbers will return by function
        ArrayList<Integer> arr=new ArrayList<>();
        //hash set we add numbers in it
        HashSet<Integer> numbers2=new HashSet<>();
          //for loop to add numbers on hash set
        for (int i=0;i< numbers.length;i++){
            numbers2.add(numbers[i]);
        }

        for(int i=0;i<(numbers.length)-2;i++){
            //new sum is sum-1 will be target - index of i
            int sum_1=target-numbers[i];
            for (int j=i+1;j<numbers.length;j++){
                //new sum is sum-2 will be target - index of j
                int sum_2=sum_1-numbers[j];
                //if sum2 in array then sum2+ value of index i + value of index j = target
                if (numbers2.contains(sum_2)){
                    if (sum_2!=numbers[i] && sum_2!=numbers[j]){
                    arr.add(numbers[i]);
                    arr.add(numbers[j]);
                    arr.add(sum_2);
                    return arr;}

                }

            }
        }
return arr;
    }
}