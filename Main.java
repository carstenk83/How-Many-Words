import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
* Main class that reads input, finds 
* all unique words, and prints them alphabetically
* Code that reads input used from Lab 12
* split function from Satya
* 
* @author Joanna Klukowska
* @author Carsten Kaiser 
*/
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> wordList = new ArrayList<>();

        while (scanner.hasNext()) {
          String[] words = scanner.next().toLowerCase().split("[^a-z]+");
        
          for (String word : words){
            if (!word.isEmpty() && !wordList.contains(word)){
              wordList.add(word);
            }
          }
        }

        mergeSort(wordList);

        for(int i = 0; i < wordList.size(); i++){
          System.out.println(wordList.get(i));
        }

        scanner.close();
    }

    /** 
    * MergeSort method wrapper
    * Calls on merge sort recursive method to sort
    * ArrayList alphabetically
    *
    * Used own code from lab 8
    *
    * @param data ArrayList with unique words from input
    */ 
    public static void mergeSort(ArrayList<String> data){
      mergeSortRec(data, 0, data.size() - 1);
    }


    /** 
    * Recursive MergeSort method
    * Sorts ArrayList alphabetically using recursion
    * also calls on the method merge to merge the sorted arrays
    * 
    * Used own code from lab 8
    *
    * @param data ArrayList with unique words from input
    * @param firstIndex integer of the first index in the given ArrayList
    * @param lastIndex integer of the last index in the given ArrayList
    */
    public static void mergeSortRec(ArrayList<String> data, int firstIndex, int lastIndex){
      if(firstIndex >= lastIndex){
        return;
      }
     
      int mid = (firstIndex + lastIndex) / 2;

      mergeSortRec(data, firstIndex, mid);
      mergeSortRec(data, mid + 1, lastIndex);

      merge(data, firstIndex, mid, mid + 1, lastIndex);

    }


    /** 
    * Merges two sorted arrays alphabetically
    *
    * Used own code from lab 8
    *
    * @param data ArrayList with unique words from input
    * @param firstIndexLeft first index of the left half in the given ArrayList
    * @param lastIndexLeft last index of the left half in the given ArrayList
    * @param firstIndexRight first index of the right half in the given ArrayList
    * @param lastIndexRight last index of the right half in the given ArrayList
    */
    public static void merge(ArrayList<String> data, int firstIndexLeft, 
    int lastIndexLeft, int firstIndexRight, int lastIndexRight){
      String[] temp = new String[lastIndexRight - firstIndexLeft + 1];
      
      int indexLeft = firstIndexLeft;
      int indexRight = firstIndexRight;
      int index = 0;

      while(indexLeft <= lastIndexLeft && indexRight <= lastIndexRight){
        int compare = data.get(indexLeft).compareTo(data.get(indexRight));

        if(compare < 0){
          temp[index] = data.get(indexLeft);
          index++;
          indexLeft++;
        } else {
          temp[index] = data.get(indexRight);
          index++;
          indexRight++;
        }

      }

      while(indexLeft <= lastIndexLeft){
        temp[index] = data.get(indexLeft);
        index++;
        indexLeft++;
      }

      while(indexRight <= lastIndexRight){
        temp[index] = data.get(indexRight);
        index++;
        indexRight++;
      }

      for (int i = 0; i < temp.length; i++) {
        data.set(firstIndexLeft + i, temp[i]);
      }

    }
}



