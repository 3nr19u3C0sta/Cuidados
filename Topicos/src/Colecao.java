import java.util.ArrayList;
import java.util.Arrays;


public class Colecao {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
    public static int[] twoSum(int[] nums, int target) {
        ArrayList correspondente = new ArrayList();
        int resto;
        for (int i = 0; i < nums.length; i++) {
            resto = target - nums[i];
            correspondente.add(nums[i]);
            if(correspondente.contains(resto)){
                return new int[]{correspondente.indexOf(resto), i};
            }
        }
        return null;
    }
}
