package cxx.note.algorithm.sort;

public class SortAge {

    private static int AGEUPPER = 99;
    public int[] sort(int[] arr) {
        int[] ageC = new int[AGEUPPER + 1];
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; ++i) {
            ageC[arr[i]]++;
        }
        int index = 0;
        for(int j = 0; j <= AGEUPPER; ++j) {
            for(int i = 0; i < ageC[j]; ++i) {
                result[index++] = j;
            }
        }
        return result;
    }

}
