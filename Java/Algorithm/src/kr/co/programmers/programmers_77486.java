package kr.co.programmers;

import java.util.HashMap;

public class programmers_77486 {
    public static void main(String[] args) {
        programmers_77486 sol = new programmers_77486();
        String[] str = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] str1 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] str2 = {"young", "john", "tod", "emily", "mary"};
        int[] int1 = {12, 4, 2, 5, 10};
        solution(str, str1, str2, int1);
    }

    static public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, node> tree = new HashMap<>();

        for (int i = 0; i < referral.length; i++) {
            if (referral[i].equals("-")) {
                tree.put(enroll[i], new node(enroll[i]));
            } else {
                tree.put(enroll[i], new node(enroll[i], referral[i]));
            }
        }

        for (int i = 0; i < seller.length; i++) {
            node now = tree.get(seller[i]);
            int money = amount[i] * 100;
            int not_my_money = (int) (money * 0.1);
            int my_money = money - not_my_money;
            System.out.println(my_money + " " + not_my_money);
            now.setMoney(my_money);
            while (!now.parent.equals("none") && not_my_money > 0) {
                now = tree.get(now.parent);
                int temp = (int) (not_my_money * 0.1);
                my_money = not_my_money - temp;
                not_my_money = temp;
                now.setMoney(my_money);
            }
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = tree.get(enroll[i]).money;
        }
        return answer;
    }

    static class node {
        String name;
        String parent;
        int money;

        public node(String name) {
            this.name = name;
            this.parent = "none";
            this.money = 0;
        }

        public node(String name, String parent) {
            this.name = name;
            this.parent = parent;
            this.money = 0;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public void setMoney(int money) {
            this.money += money;
        }

    }
}
