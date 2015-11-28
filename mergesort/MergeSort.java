import java.util.Arrays;

public class MergeSort
{
    public static void main(String args[])
    {
        // Array to be sorted
        int array[] = {52,33,11,62,48,97,22,31,39};
        
        // To show the unsorted array
        System.out.println(Arrays.toString(array));
        
        // Merge sort
        mergeSort(array, 0, array.length - 1); 
        
        // Sorted array 
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int array[], int i, int r)
    {
        if (i < r)
        {
            int j = (i + r) / 2;

            // Divide the first half
            mergeSort(array, i, j);

            // Divide the second half
            mergeSort(array, j+1, r);

            // Merge them all
            merge(array, i, j, r);
        }
    }

    private static void merge(int array[], int left, int mid, int right)
    {  
        int temp[] = new int[right - left + 1];
        int tempPtr = 0;
        int i = left;
        int k = mid+1;

        // Regular merge. Compare the values from each array and add it 
        // to the temp array. 
        while(i <= mid && k <= right)
        {
           if(array[i] > array[k])
           { 
               temp[tempPtr++] = array[k++];
           }
           else
           { 
               temp[tempPtr++] = array[i++];
           }
        }

        // Add the rest of the elements from first array if there are any
        while(i <= mid)
        {
            temp[tempPtr++] = array[i++];
        }

        // Add the rest of the elements from second array if there are any
        while(k <= right)
        {
            temp[tempPtr++] = array[k++];
        }

        // Copy them back to the original array
        tempPtr = 0;
        while(tempPtr < (right - left + 1))
        {
            array[left + tempPtr] = temp[tempPtr++];
        }
    }
}
