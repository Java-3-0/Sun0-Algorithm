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
			number++;
		}
		for (int i = p-1; i < binary_answer.length() && answer.length()<t; i+=m) {
			answer+= binary_answer.charAt(i);
		}
		return answer;
	}
	
	
	public static void main(String[] args) {
		programmers_17687 sol = new programmers_17687();
		System.out.println(sol.solution(16,16,2,2));
	}

}
