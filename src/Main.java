import problem21_40.SearchInRotatedSortedArray;


public class Main {

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        int validNum = solution.search(new int[]{1}, 0);
        System.out.println(validNum);
    }
}
