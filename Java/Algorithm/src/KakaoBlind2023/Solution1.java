package KakaoBlind2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
//        String today = "2022.05.19";
//        String[] terms = {"A 6", "B 12", "C 3"};
//        String[] privacies = {"2021.07.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        System.out.println(Arrays.toString(sol.solution(today, terms, privacies)));
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st;

        HashMap<String, Integer> termMap = new HashMap<>();

        for (int i = 0; i < terms.length; i++) {
            st = new StringTokenizer(terms[i]);
            String termName = st.nextToken();
            Integer termDuration = Integer.parseInt(st.nextToken());
            termMap.put(termName, termDuration);
        }

        for (int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i]);
            String date = st.nextToken();
            String termName = st.nextToken();

            date = calculateTerm(date, termMap.get(termName));
            if (date.compareTo(today) < 0)
                list.add(i + 1);
        }

        answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    private String calculateTerm(String date, Integer duration) {
        String[] spliceDate = date.split("\\.");
        int year = Integer.parseInt(spliceDate[0]);
        int month = Integer.parseInt(spliceDate[1]);
        int dates = Integer.parseInt(spliceDate[2]);

        year += duration / 12;
        month += duration % 12;
        dates -= 1;

        if (dates == 0) {
            month -= 1;
            dates = 28;
        }
        if (month > 12) {
            year += 1;
            month -= 12;
        }

        String strYear = String.valueOf(year);
        String strMonth = month < 10 ? "0" + month : String.valueOf(month);
        String strDate = dates < 10 ? "0" + dates : String.valueOf(dates);

        String newDate = strYear + "." + strMonth + "." + strDate;
        return newDate;
    }
}