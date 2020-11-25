package 简单题;

import com.sun.org.apache.regexp.internal.RE;

public class Q292_Nim游戏 {
    /*你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。

你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
*/

    //感觉像数学题，如果先手要获胜，总的石头数量一定不不能是4的整数倍

    class Solution {
        public boolean canWinNim(int n) {
            return (n%4!=0);
        }
    }
}
