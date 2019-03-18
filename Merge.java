public class Merge{
  public static void mergesort(int[] data){
     mergesort(data, 0, data.length-1);
  }
  private static void mergesort(int[] data, int lo, int hi){
    if (lo >= hi) return;
    for (int i =lo; i < hi; i++){

    }

  }
  private static void merge(int[] data, int[] data1){
    int lowest = Math.min(data.length, data1.length);
    int[] merged = new int[data.length + data1.length];
    int low = 0;
    if (lowest == data.length){
      low = data[0];
    for (int i =0; i < data.length; i++){
      if (data[i] < low) low = data[i];
    }
  }
  if (lowest == data1.length){
    low = data1[0];
  for (int i =0; i < data1.length; i++){
    if (data1[i] < low) low = data1[i];
  }
}
    for (int i =0; i <lowest; i++){

    for (int r = 0; r < merged.length; r++){
      System.out.print(merged[r] + " ");
    }

    }
  }
    public static void main(String[] args) {
      int[] test = {20, 21, 22, 23};
      int[] test1 = {1, 7, 90, 233, 1222, 23423};
      merge(test, test1);
    }
  }
