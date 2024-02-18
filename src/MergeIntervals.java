import java.util.Arrays;

public class MergeIntervals {
    /**
     * Sort contents of 2d array based on the 0-th index
     * of each element
     */
    private void sort(int[][] intervals) {
        int n = intervals.length - 1;
        int mid = intervals.length / 2;
        swap(intervals, mid, n);
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            while (i <= j && intervals[i][0] < intervals[n][0]) {
                i++;
            }
            while (i <= j && intervals[j][0] >= intervals[n][0]) {
                j--;
            }
            if (i < j) {
                swap(intervals, i, j);
            }
        }
        swap(intervals, i, n);
    }

    private void swap(int[][] intervals, int index1, int index2) {
        int[] temp = intervals[index1];
        intervals[index1] = intervals[index2];
        intervals[index2] = temp;
    }

    private static String arrayToString(int[][] intervals) {
        StringBuilder str = new StringBuilder();
        str.append('[');
        for (int i = 0; i < intervals.length; i++) {
            str.append(Arrays.toString(intervals[i]));
            if (i != intervals.length - 1)
                str.append(", ");
        }
        str.append(']');
        return str.toString();
    }

    public int[][] merge(int[][] intervals) {
        return null;
    }

    public static void main(String[] args) {
        int[][] intervals = {{18,15}, {1,2}, {4,5}, {3,6}, {4,7}, {15,17}, {0,21}};
        MergeIntervals inter = new MergeIntervals();
        inter.sort(intervals);
        System.out.println(arrayToString(intervals));
    }
}