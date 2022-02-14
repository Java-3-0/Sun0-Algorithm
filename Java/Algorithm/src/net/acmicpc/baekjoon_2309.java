package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;

public class baekjoon_2309 {

	private static int[] arr;
	private static boolean flg;
	private static Stack<Integer> sumarr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		sumarr = new Stack<Integer>();
		arr = new int[9];
		flg = true;
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		find100(0, 0);

	}

	private static void find100(int sum, int i) {

		if (sum == 100 && sumarr.size() == 7 && flg) {
			Collections.sort(sumarr);
			for (Integer in : sumarr) {
				System.out.println(in);
			}
			flg = false;
			return;
		}
		if (i >= 9)
			return;

		sumarr.push(arr[i]);
		find100(sum + arr[i], i + 1);
		sumarr.pop();
		find100(sum, i + 1);

	}

}
