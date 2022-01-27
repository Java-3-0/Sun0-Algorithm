package kr.co.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class programmers_92343 {

	public static void main(String[] args) {
		programmers_92343 sol = new programmers_92343();
		sol.solution(new int[] { 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 }, new int[][] { { 0, 1 }, { 1, 2 }, { 1, 4 },
				{ 0, 8 }, { 8, 7 }, { 9, 10 }, { 9, 11 }, { 4, 3 }, { 6, 5 }, { 4, 6 }, { 8, 9 } });
		sol.solution(new int[] { 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0 }, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 3 },
				{ 1, 4 }, { 2, 5 }, { 2, 6 }, { 3, 7 }, { 4, 8 }, { 6, 9 }, { 9, 10 } });
	}

	List<Integer>[] tree;

	List<Integer> maxSheep;

	public int solution(int[] info, int[][] edges) {

		tree = new ArrayList[info.length];
		maxSheep = new ArrayList<Integer>();
		List<Integer> canGo = new ArrayList<Integer>();

		// 트리 만들기
		for (int i = 0; i < edges.length; i++) {
			int parent = edges[i][0];
			int child = edges[i][1];
			if (tree[parent] == null)
				tree[parent] = new ArrayList<Integer>();
			tree[parent].add(child);
		}
		canGo.add(0);
		DFS(info, 0, 1, 0, canGo);

		return Collections.max(maxSheep);
	}

	public void DFS(int[] info, int idx, int sheep, int wolf, List<Integer> canGo) {
		if (sheep <= wolf)
			return;

		maxSheep.add(sheep);
		List<Integer> list = new ArrayList<>();
		list.addAll(canGo);

		list.remove(Integer.valueOf(idx));
		if (tree[idx] != null) { // 자식이 있을 때
			for (int child : tree[idx]) { // 갈 수 있는 리스트에 child 추가
				list.add(child);
			}
		}

		for (Integer child : list) {
			if (info[child] == 0)
				DFS(info, child, sheep + 1, wolf, list);
			else
				DFS(info, child, sheep, wolf + 1, list);
		}

		return;

	}
}
