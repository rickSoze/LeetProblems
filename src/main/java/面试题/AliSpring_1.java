package 面试题;

import java.util.ArrayList;
import java.util.Scanner;

public class AliSpring_1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String[] s2 = s1.split(" ");
		int n = Integer.parseInt(s2[0]);
		int m = Integer.parseInt(s2[1]);
		int k = Integer.parseInt(s2[2]);

		String[][] map = new String[n][m];
		for (int i = 0; i < n; i++) {
			String s = in.nextLine();
			String[] s3 = s.split("");

			for (int j = 0; j < m; j++) {
				map[i][j]=s3[j];
			}
		}
		String move;
		int x=0,y=0;
		for (int i = 0; i < k; i++) {
			move=in.nextLine();
			if (move.equals("EAST")){
				for (int j = 0; j < m && y+1<m; j++) {
					if (map[x][y+1].equals(".")){
					    map[x][y]=".";
						map[x][y+1]="@";
						y=y+1;
					}else{
					    break;
					}
				}
			}else if (move.equals("WEST")) {
				for (int j = 0; j<m&&y-1>=0; j++) {
					if (map[x][y - 1] .equals(".")) {
						map[x][y] = ".";
						map[x][y - 1] = "@";
						y--;
					}else {
						break;
					}
				}
			}
			else if (move.equals("NORTH")) {
				for (int j = 0; j<n&&x-1>=0; j++) {
					if (map[x-1][y] .equals( ".")) {
						map[x][y] = ".";
						map[x - 1][y] = "@";
						x--;
					}else{
						break;
					}

				}
			}
			else{
				for (int j = 0; j<m && x+1<m; j++) {
					if (map[x+1][y].equals(".")) {
						map[x][y] = ".";
						map[x+1][y] = "@";
						x++;
					}else {
						break;
					}
				}
			}
		}

		System.out.println((x+1)+" "+(y+1));
	}
}
