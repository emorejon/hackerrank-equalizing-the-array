import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        //Scanner and array provided by the problem already.
        Scanner scnr =  new Scanner(System.in);
        int n = scnr.nextInt();
        int[] array = new int[n];
        for(int i  = 0; i < n; i++){
            array[i] = scnr.nextInt();
        }

        // The LinkedList<Integer> list will be used to store already visited numbers in the array, to avoid repetition.
        List<Integer> list = new LinkedList<>();
        // The Map<Integer, Integer> map will be used to map each number to the amont of repetitions.
        Map<Integer,Integer> map = new HashMap<>();
        
        //for loop to iterate through all numbers in the array.
        for(int i = 0; i < array.length; i++){
            /*If the list already contains the number, we skip to the next number.
            Notice that we check for this BEFORE adding anything to the list, otherwise
            the answer will always be 1 because the list will always contain the number to check*/
            if(!list.contains(array[i])){
                map.put(array[i], 1);
                //Add number to the list for future comparison.
                list.add(array[i]);
            }
            /*If the number is already in the list. We get out the value for the key array[i], increase it by 1
            and put it back in the map*/
            else{
                //int add is just the variable we are using to increase the value on the map for the key in question.
                int add = map.get(array[i]) + 1;
                //Adding the new value for the same key.
                map.put(array[i], add);
            }
        }
        //Max is the int value we are going to return
        int max = 0;
        
        /*This for-each loop iterates through the values of the map. The key is irrelevant since we only care about
        the least amount of steps needed to equalize the array. We don't need to know which value is the most repeated,
        just the amount of repetitions.
        The loop assigns the highest value to the variable max.*/
        for(int values: map.values()){
            if(values > max){
                max = values;
            }
        }
        
        //The least amount of steps is length of the array minues the amount of repetition of the highest repeated value.
        System.out.println(array.length - max);
        
    }
}
