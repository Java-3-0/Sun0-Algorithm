package LineCoding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        String[] task1 = {"development", "marketing", "hometask"};
        String[] task2 = {"recruitment", "education", "officetask"};
        String[] e = {"1 development hometask", "1 recruitment marketing", "2 hometask", "2 development marketing " +
                "hometask", "3 marketing", "3 officetask", "3 development"};
        sol.solution(3, task1, task2, e);
    }

    public int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {


        StringTokenizer st;
        HashSet<String> remote = new HashSet<>();
        HashSet<String> office = new HashSet<>();
        int[] goToWork = new int[num_teams];
        int[] candidate = new int[num_teams];

        for (int i = 0; i < num_teams; i++) {
            goToWork[i] = -1;
            candidate[i] = -1;
        }

        for (String task : remote_tasks) {
            remote.add(task);
        }
        for (String task : office_tasks) {
            office.add(task);
        }

        for (int i = 0; i < employees.length; i++) {
            st = new StringTokenizer(employees[i]);
            int team = Integer.parseInt(st.nextToken()) - 1;
            while (st.hasMoreTokens()) {
                String work = st.nextToken();
                if (office.contains(work) && goToWork[team] == -1) // 출근 할 일도 있고 팀에서 나가는 사람 없다면 내가 출근
                {
                    goToWork[team] = i + 1;
                }
            }
            if (goToWork[team] == -1 && candidate[team] == -1) {
                candidate[team] = i + 1;
            }
        }
        for (int i = 0; i < num_teams; i++) {
            if (goToWork[i] == -1)
                goToWork[i] = candidate[i];
        }
        Arrays.sort(goToWork);

        int[] answer = new int[employees.length - num_teams];
        int answerIndex = 0;
        int index = 0;

        for (int i = 0; i < employees.length; i++) {
            if (index >= num_teams || goToWork[index] != i + 1)
                answer[answerIndex++] = i + 1;
            else
                index++;
        }
        return answer;
    }
}
