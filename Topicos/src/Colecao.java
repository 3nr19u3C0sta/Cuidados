import java.util.ArrayList;
import java.util.Arrays;


public class Colecao {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        /*
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums,target)));
         */

        ArrayList correspondente = new ArrayList();
        int resto;
        for (int i = 0; i < nums.length; i++) {
            resto = target - nums[i];
            if(correspondente.contains(resto)){
                return new int[]{correspondente.indexOf(resto), i};
            }
            correspondente.add(nums[i]);
        }
        return null;
    }
}
