
//18456kb,248ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_2304 {

	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		int[][] arr = new int[n][2];

		int maxHeight = 0;
		int maxindex = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			if (arr[i][1] > maxHeight) {
				maxHeight = arr[i][1];
				maxindex = arr[i][0];
			}
		}
		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
		int sum = 0;

		int i = 0;
		int leftHeight = arr[0][1];
		int leftIndex = arr[0][0];

		if (leftIndex != maxindex) {
			while (i < n) {
				if (arr[i][1] > leftHeight) {
					sum += leftHeight * (arr[i][0] - leftIndex);
					leftIndex = arr[i][0];
					leftHeight = arr[i][1];
				}
				i++;
				if (arr[i][0] == maxindex) {
					sum += leftHeight * (arr[i][0] - leftIndex);
					break;
				}
			}
		}

		i = n - 1;
		int rightHeight = arr[n - 1][1];
		int rightIndex = arr[n - 1][0];
		if (rightIndex != maxindex) {
			while (i >= 0) {
				if (arr[i][1] > rightHeight) {
					sum += rightHeight * (rightIndex - arr[i][0]);
					rightIndex = arr[i][0];
					rightHeight = arr[i][1];
				}
				i--;
				if (arr[i][0] == maxindex) {
					sum += rightHeight * (rightIndex - arr[i][0]);
					break;
				}
			}
		}

		System.out.println(sum + maxHeight);
	}

}
