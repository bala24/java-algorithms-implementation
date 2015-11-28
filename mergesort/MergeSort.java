import java.util.Arrays;

public class MergeSort
{
    public static void main(String args[])
    {
        int array[] = {52,33,11,62,48,97,22,31,39};
        System.out.println(Arrays.toString(array));
        mergeSort(array, 0, array.length - 1); 
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int array[], int i, int r)
    {
        if (i < r)
        {
            int j = (i + r) / 2;
            mergeSort(array, i, j);
            mergeSort(array, j+1, r);
            merge(array, i, j, r);
        }
    }

    private static void merge(int array[], int left, int mid, int right)
    {  
        int temp[] = new int[right - left + 1];
        int tempPtr = 0;
        int i = left;
        int k = mid+1;
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

        while(i <= mid)
        {
            temp[tempPtr++] = array[i++];
        }

        while(k <= right)
        {
            temp[tempPtr++] = array[k++];
        }

        tempPtr = 0;
        while(tempPtr < (right - left + 1))
        {
            array[left + tempPtr] = temp[tempPtr++];
        }
    }
}
