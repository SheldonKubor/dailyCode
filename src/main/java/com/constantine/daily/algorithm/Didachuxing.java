package com.constantine.daily.algorithm;

/**
 * //  有一排石碓，每碓石头的数量不一样，想办法石碓中拿到最多的石头，不能拿相邻的石碓
 * // 1 4 9 34 2 3 = 41
 * // 1 8 1 1 8 1 = 16
 * // 1 8 9 8 1 = 16
 * // int max(int[])
 *
 *
 * // node
 * //   left
 * //   right
 * // Node parent(Node root,Node a,Node b)
 */
public class Didachuxing {

    public static void main(String[] args) {
        int [] nums = {1,4,9,34,2,3};
        System.out.println(RecOpt(nums,nums.length-1));
        System.out.println(DpOpt(nums));
    }

    /**
     * opt(i) = opt(i-2) + nums[i] 选i
     * opt(i) = opt(i-1)            不选i
     *
     * opt(0) = nums[0]
     * opt(1) = max(nums[0],nums[1])
     * @param nums
     * @return
     */
    public static int RecOpt(int [] nums, int i){
        if (i == 0){
            return nums[0];
        } else if (i == 1) {
            return Math.max(nums[0],nums[1]);
        } else {
            int a = RecOpt(nums,i-2) + nums[i];
            int b = RecOpt(nums,i-1);
            return Math.max(a,b);
        }
    }

    public static int DpOpt(int [] nums){

        int [] opt = new int[nums.length];
        opt[0] = nums[0];
        opt[1] = Math.max(nums[0],nums[1]);

        for(int i = 2;i<nums.length;i++){
            int a = opt[i-2] + nums[i];
            int b = opt[i-1];
            opt[i] = Math.max(a,b);
        }

        return opt[nums.length - 1];
    }

    public static Node parent(Node root,Node p, Node q){
        if(root == null || root == p || root == q) return root;
        Node left = parent(root.left, p, q);
        Node right = parent(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

}
