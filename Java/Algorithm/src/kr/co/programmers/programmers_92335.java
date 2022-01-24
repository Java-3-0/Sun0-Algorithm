package kr.co.programmers;

public class programmers_92335 {

	public static void main(String[] args) {
		programmers_92335 sol = new programmers_92335();
		sol.solution(437674, 3);

	}

	public boolean isPrime(String number) {
		long num = Long.valueOf(number).longValue();
		System.out.println(num);
		if (num < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public int solution(int num, int n) {
		int answer = 0;
		String temp = "";
		String number = "";
		String now = "";
		while (num > 0) {
			temp = num % n > 9 ? String.valueOf((char) ('A' + (num % n) - 10)) + temp : String.valueOf(num % n) + temp;
			num /= n;
		}

		String[] arr = temp.split("");
		for (String s : arr) {
			if (Integer.parseInt(s) != 0) {
				number += s;
			} else {
				if (number != "" && isPrime(number))
					answer += 1;
				number = "";
			}
		}

		if (number != "" && isPrime(number))
			answer += 1;

		return answer;
	}
}
