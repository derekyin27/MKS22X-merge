import java.util.Arrays;
public class Merge{
  public static void mergesort(int[] data){
     mergesort(data, 0, data.length-1);
  }
  private static void mergesort(int[] data, int lo, int hi){
    if (lo >= hi) return;
    int mid = lo +(hi - lo)/2 ;
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
    public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Merge.mergesort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}
  }
