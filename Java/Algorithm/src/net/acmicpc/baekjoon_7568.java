package net.acmicpc;

import java.util.Scanner;

public class baekjoon_7568 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[][] arr = new int[n][3];
		for (int i = 0; i < n; i++) {
			arr[i][0] = 1;
			arr[i][1] = in.nextInt();
			arr[i][2] = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j && arr[i][1] < arr[j][1] && arr[i][2] < arr[j][2])
					arr[i][0] += 1;
			}
			System.out.print(arr[i][0] + " ");
		}

	}

}
