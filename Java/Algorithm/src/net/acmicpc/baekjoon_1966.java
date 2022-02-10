//14604kb,148ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class baekjoon_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());

		for (int t = 0; t < test_case; t++) {
			ArrayDeque<Integer[]> que = new ArrayDeque<Integer[]>();

			String[] index = bf.readLine().split(" ");

			int count = Integer.parseInt(index[0]);
			int target = Integer.parseInt(index[1]);

			String[] rank = bf.readLine().split(" ");
			int[] isExist = new int[10];

			for (int i = 0; i < count; i++) {
				int num = Integer.parseInt(rank[i]);
				que.offer(new Integer[] { i, num });
				isExist[num]++;
			}
			int cnt = 0;
			a: for (int i = 9; i > 0; i--) {
				while (isExist[i] > 0) {
					Integer[] num = que.pollFirst();
					if (num[1] != i)
						que.addLast(num);
					else {
						cnt++;
						isExist[i]--;
						if (num[0] == target) {
							break a;
						}
					}
				}
			}
			System.out.println(cnt);

		}

	}

}
