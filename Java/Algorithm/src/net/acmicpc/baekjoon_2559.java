
// 22076kb, 212ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2559 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int maxsum = 0, sum = 0;

		for (int j = 0; j < K; j++) {
			sum += arr[j];
		}
		maxsum = sum;
		for (int i = K; i < N; i++) {
			sum -= arr[i - K];
			sum += arr[i];
			if (maxsum < sum) {
				maxsum = sum;
			}
		}
		System.out.println(maxsum);
	}

}
