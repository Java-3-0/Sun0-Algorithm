package kr.co.programmers;

import java.util.Iterator;

public class programmers_17687 {

	public String solution(int n, int t, int m, int p) {
		String answer = "";
		String binary_answer = "0";
		int num =1 ;
		int number =1 ;
		while(binary_answer.length()<t*m) {
			num=number;
			String temp="";
			while(num>0) {
				temp= num%n>9? String.valueOf((char)('A'+(num%n)-10))+temp:String.valueOf(num%n)+temp;
				num/=n;
			}
			binary_answer+=temp;
			System.out.println(binary_answer);
			number++;
		}
		for (int i = p-1; i < binary_answer.length(); i+=m) {
			answer+= binary_answer.charAt(i);
		}
//		int num = 1;// ���� ��ȯ�� ����
//		int turn = 1; // �ο��� ��ŭ ���ƾ���
//		if(turn == p) {
//			answer+="0"; // �� �� ������ ù��°�� ���: ������ 0�� �߰��ϱ�
//			turn = (turn+1)%m;
//		}
//		while(answer.length()<t) {
//			
//			while(num>0) {
//				String now_s ="";
//				
//				// n���� �ڸ� 
//				int now = num%n;
//				num/=n;
//				
//				if(turn == p) {
//					turn = (turn+1)%m;
//				}
//
//				turn = (turn+1)%m;
//			}
//			num+=1;
//		}
		return answer;
	}
	
	
	public static void main(String[] args) {
		programmers_17687 sol = new programmers_17687();
		System.out.println(sol.solution(16,16,2,2));
	}

}
