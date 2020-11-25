package 中等题;

public class Q11_盛最多水的容器 {
    /*给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
    在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
    使得它们与 x 轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器，且 n 的值至少为 2。
输入：[1,8,6,2,5,4,8,3,7]
输出：49
    * */

    /**
     * 思路： 因为装水的多少取决于短的木板，因此使用双指针，每次只移动短的木板，因为即使移动
     * 长的模板，整个的面积不会增加，只能减少；  然后每次移动记录当前的面积，当双指针碰到的时候
     * ，那个最大的值就是目标值
     *
        下面是简化后的代码：
     * */
    class Solution {
        public int maxArea(int[] height) {
            int i = 0, j = height.length - 1, res = 0;
            while(i < j){
                res = height[i] < height[j] ?
                        Math.max(res, (j - i) * height[i++]):
                        Math.max(res, (j - i) * height[j--]);
            }
            return res;
        }
    }


    class Solution2 {
        public int maxArea(int[] height) {
            int l=0,r=height.length-1;
            int res=Math.min(height[l],height[r]) * (r-l);
            while (r!=l){
                if (height[r]>height[l]){
                    l++;
                    res=Math.max(res,Math.min(height[l],height[r]) * (r-l));

                }else {
                    r--;
                    res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
                }
            }
            return res;
        }
    }

}
