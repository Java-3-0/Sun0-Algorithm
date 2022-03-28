package LineCoding;

import java.util.StringTokenizer;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        int num1 = sol.solution(new String[]{"team_name : db application_name : dbtest error_level : info message : " +
                "test", "team_name : test application_name : I DONT CARE error_level : error message : x", "team_name : ThisIsJustForTest application_name : TestAndTestAndTestAndTest error_level : test message : IAlwaysTestingAndIWillTestForever", "team_name : oberervability application_name : LogViewer error_level : error"});
        int num = sol.solution(new String[]{"team_name : MyTeam application_name : YourApp error_level : info messag : IndexOutOfRange", "no such file or directory", "team_name : recommend application_name : recommend error_level : info message : RecommendSucces11", "team_name : recommend application_name : recommend error_level : info message : Success!", "   team_name : db application_name : dbtest error_level : info message : test", "team_name     : db application_name : dbtest error_level : info message : test", "team_name : TeamTest application_name : TestApplication error_level : info message : ThereIsNoError"});
        System.out.println(num1 + " " + num);
    }

    public int solution(String[] logs) {
        StringTokenizer st;
        int cnt = 0;
        for (String str : logs
        ) {
            if (str.length() > 100) {
                cnt++;
                continue;
            } else {
                String[] arr = str.split(" : ");
                int index = arr.length;
//                for (String now : arr
//                ) {
//                    System.out.println(now);
//                }
                if (index != 5) { // 이건 띄어쓰기가 있다는거
                    cnt++;
                    continue;
                }
                if (arr[0].equals("team_name")) {
                    String[] temp1 = arr[1].split(" ");
                    if (temp1.length != 2 || !check(temp1[0]) || !temp1[1].equals("application_name")) {
                        cnt++;
                        continue;
                    }
                    String[] temp2 = arr[2].split(" ");
                    if (temp2.length != 2 || !check(temp2[0]) || !temp2[1].equals("error_level")) {
                        cnt++;
                        continue;
                    }
                    String[] temp3 = arr[3].split(" ");
                    if (temp3.length != 2 || !check(temp3[0]) || !temp3[1].equals("message")) {
                        cnt++;
                        continue;
                    }
                    if (!check(arr[4])) {
                        cnt++;
                        continue;
                    }
                } else {
                    cnt++;
                }
//                System.out.println();
            }

        }
        return cnt;
    }

    private boolean check(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') continue;
            else if (s.charAt(i) >= 'A' && s.charAt(0) <= 'Z') continue;
            else
                return false;
        }
        return true;
    }
}

