public class Merge{
  public static void mergesort(int[] data){
     mergesort(data, 0, data.length-1);
  }
  private static void mergesort(int[] data, int lo, int hi){
    if (lo >= hi) return;
    int mid = (hi - lo)/2 + 1;
    mergesort(data, lo, mid);
    mergesort(data, mid+1, hi);
    merge(data, lo, mid, hi);
    }


  private static void merge(int[] data, int low, int mid, int high){

    int temp1 = mid - low + 1;
    int temp2 = high - mid;
    int[] left = new int[temp1];
    int[] right = new int[temp2];//making temporary arrays for merge, splits the given array bounds in half
    for (int i = 0; i < temp1; i++){
      left[i]=data[low+i];//copy values from original array into temps
    }
    for (int i = 0; i < temp2; i++){
      right[i] = data[mid+i+1];
    }
    int index1 = 0;//variables for while loop
    int index2 = 0;
    int index3 = low;
    while (index1 < temp1 && index2 < temp2){//easier than for loop
      if (left[index1] <= right[index2]){//find smaller value, add it to original array starting at lowest bound index.
        data[index3] = left[index1];
        index1++;
      }
      else if (left[index1] > right[index2]){
        data[index3] = right[index2];
        index2++;
      }
      index3++;
    }
    // now add all remaining values
    while (index1 < temp1){
      data[index3] = left[index1];
      index1++;
      index3++;
    }
    while (index2 < temp2){
      data[index3] = right[index2];
      index2++;
      index3++;
    }

    }
    public static void main(String[] args) {
      int[] test = {20, 21, 22, 23};
    }
  }
