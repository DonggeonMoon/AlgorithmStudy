import java.util.List;

public class SearchTest {
    public static void main(String[] args) {
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int target = 12;
        int index = interpolationSearch.search(arr, target);
    }
}
