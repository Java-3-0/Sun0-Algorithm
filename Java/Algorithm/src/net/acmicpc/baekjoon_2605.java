package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class baekjoon_2605 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] temp = bf.readLine().split(" ");
		LinkedList<Integer> arr = new LinkedList<Integer>();

		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(temp[i]), i + 1);
		}
		for (int i = n - 1; i >= 0; i--) {
			System.out.print(arr.get(i) + " ");
		}
	}

}
