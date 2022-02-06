package kr.co.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class programmers_64064 {

	public static void main(String[] args) {
		programmers_64064 sol = new programmers_64064();
		System.out.println(sol.solution(new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" },
				new String[] { "*rodo", "*rodo", "******" }));

	}

	private HashSet<String> set;
	private boolean[] visited;

	public int solution(String[] user_id, String[] banned_id) {
		visited = new boolean[user_id.length];
		set = new HashSet<String>();
		DFS(0, new ArrayList<String>(), user_id, banned_id);
		return set.size();
	}

	private void DFS(int len, ArrayList<String> arrayList, String[] user_id, String[] banned_id) {
		if (len == banned_id.length) {
			String[] str = new String[len];
			Collections.sort(arrayList);
			System.out.println(arrayList.toString());
			set.add(arrayList.toString());
			return;
		}
		for (int i = 0; i < user_id.length; i++) {
			if (isMatching(user_id[i], banned_id[len]) && !visited[i]) {
				visited[i] = true;
				arrayList.add(user_id[i]);
				DFS(len + 1, arrayList, user_id, banned_id);
				arrayList.remove(user_id[i]);
				visited[i] = false;
			}
		}

	}

	private boolean isMatching(String id, String ban_id) {
		if (id.length() != ban_id.length())
			return false;
		else {
			ban_id = ban_id.replace('*', '.');
			return id.matches(ban_id);
		}
	}
}
