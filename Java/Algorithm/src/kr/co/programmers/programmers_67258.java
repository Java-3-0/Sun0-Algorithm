package kr.co.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class programmers_67258 {

	public static void main(String[] args) {
		programmers_67258 sol = new programmers_67258();
		System.out.println(
				sol.solution(new String[] { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" }).toString());
	}

	public int[] solution(String[] gems) {
		int[] answer = new int[2];
		HashSet<String> origin = new HashSet<String>(Arrays.asList(gems));
		HashMap<String, Integer> map = new HashMap<String, Integer>(origin.size());

		int l = 0, r = 0;
		int distance = gems.length + 1;
		while (true) {
			if (map.size() == origin.size()) { // 만약 보석이 다 있다면 왼쪽 줄이기
				map.put(gems[l], map.getOrDefault(gems[l], 0) - 1);
				if (map.get(gems[l]) == 0)
					map.remove(gems[l]);
				l++;
			} else if (r == gems.length) {
				break;
			} else {
				map.put(gems[r], map.getOrDefault(gems[r++], 0) + 1);
			}
			if (map.size() == origin.size()) {
				if (r - l < distance) {
					distance = r - l;
					answer[0] = l + 1;
					answer[1] = r;
				}
			}
		}
		return answer;
	}
}
