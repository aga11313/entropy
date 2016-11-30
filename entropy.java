package mathsia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.pow;
import java.math.*;


public class MathsIA {

    //the main function
    public static void main(String[] args) {
        int entropy = 0; //initilize the variable for the value of entropy
        
        File textFile = new File("passwords.txt");
	    FileReader in;
        BufferedReader readFile;
	    String lineOfText;

        int count = 0;
        
        try{
			in = new FileReader(textFile);
			readFile = new BufferedReader(in);
                        
            String array[] = new String[14344391]; //array of the total length of the password file
            int counter[] = new int[14344391]; // counter array which counts occurences of each password
            int length[] = new int[1000];
            int current = 0;
			
            while ((lineOfText = readFile.readLine()) != null)
			{                
                array[current] = lineOfText;
                current++;
                            
			}
                System.out.print("Finished reading...");
                        
                System.out.println("sorting");
                quickSort(array, 0, array.length-1); //performs a quicksort algorithm on the array of passwords

                int first = 0;
                for(int i = 1; i<array.length; i++){
                    length[array[i].length()]++;
                    if(array[i] == null ? array[i-1] == null : array[i].equals(array[i-1])){
                        counter[first]++;        
                    }
                    else{
                        first = i;
                        counter[i]++;
                    }
                }
                       
                double sum = 0;
                double result;
               
                for(int i=0; i<counter.length; i++){        
                    if(counter[i] != 0){
                        double a = (pow(85,20));
                        double ba = (counter[i])*(0.0000000697136602);
                        result = (ba)*(log(ba,a));
                        sum = sum + result;
                    }
                }
                System.out.println("Enthropy: " + (-1*sum));
                System.out.println("\nEnd");
                        
                        
			readFile.close();
			in.close();
                               
		    } 
            catch (FileNotFoundException e){
			    System.out.println("File does not exist or could not be found.");
			    System.err.println("FileNotFoundException: " + e.getMessage());
		    } 
            catch (IOException e) {
			    System.out.println("Problem reading file.");
			    System.err.println("IOException: " + e.getMessage());
		    }
            
        }
        
        //method to calculate logarithms of basy any other than 10
        public static double log( double a, double b ){
            return Math.log(a) / Math.log(b);
        }
        
        //quicksort method to sort an array of strings    
        private static void quickSort(String[] a, int start, int end) {

        int i = start;
        int j = end;

        if (j - i >= 1)
        {
            // The pivot point of the method is set to the first element int the array.
            String pivot = a[i];
            while (j > i)
            {
                // from the left. Stop advancing the counter when we reach
                // the right or an element that is greater than the pivot String.
                while ((a[i].compareTo(pivot) <= 0 && i < end && j > i)){
                    i++;
                }
                // from the right. Stop advancing the counter when we reach
                // the left or an element that is less than the pivot String.
                while ((a[j].compareTo(pivot) >= 0 && j > start && j >= i)){
                    j--;
                }
                // check the two elements in the center.
                if (j > i)
                    swap(a, i, j);
            }
            // Two scans meet in the center of the array and stop.
            // The left partition and right partition are not
            // sorted themselves. The recursive code sorts the left and right partitions.

            // Swap the pivot point with the last element of the left partition.
            swap(a, start, j);
            // sort left partition
            quickSort(a, start, j - 1);
            // sort right partition
            quickSort(a, j + 1, end);
        }
    }
     //This method swaps two elements.
    private static void swap(String[] a, int i, int j)
    {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
}
    

