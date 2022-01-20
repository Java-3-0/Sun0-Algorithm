package kr.co.programmers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
public class programmers_17686 {

	public static void main(String[] args) {
		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		programmers_17686 sol = new programmers_17686();
		System.out.println(Arrays.toString(sol.solution(files)));
	}
	public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String oo1 = o1.split("[0-9]")[0];
				String oo2 = o2.split("[0-9]")[0];
				int order = oo1.toLowerCase().compareTo(oo2.toLowerCase());
				if(order==0) {
					order = numbering(o1.replace(oo1,"")) - numbering(o2.replace(oo2,""));
				}
				
				return order;
			}
			
		});
        return files;
    }
	private int numbering(String o1) {
		String num = "";
		for(int i = 0;i<o1.length() ;i++) {
			char c = o1.charAt(i);

			if(Character.isDigit(c) && num.length()<=5)
				num+=c;
			else
				break;
		}
		return Integer.parseInt(num);
	}

}
