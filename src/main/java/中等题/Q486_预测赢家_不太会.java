package 中等题;

public class Q486_预测赢家_不太会 {

    /*
    *
给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿
* ，…… 。
* 每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
    给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。

    * */


    class Solution {
        public boolean PredictTheWinner(int[] nums) {
            if (nums.length%2==0) return true;
            return total(nums,0,nums.length-1,1)>=0;
        }
        public int total(int[] nums, int start,int end,int turn){
            if (start == end) return nums[start]*turn;
            int startScore = nums[start]*turn + total(nums,start+1,end,turn*-1);
            int endScore = nums[end]*turn + total(nums,start,end-1,turn*-1);
            if (turn==1){
                return Math.max(startScore,endScore);
            }else return Math.min(startScore,endScore);
        }

    }
}
