package kr.co.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class programmers_17684 {

	static int[] solution(String msg) {
		List<Integer> answer = new ArrayList<Integer>();
        int num=0;
        int index=1;
        String tmp = null,ttmp=null;
        
        HashMap<String, Integer> hs = new HashMap<String,Integer>();
        for(int i = 0;i<26;i++) {
        	String st = String.valueOf((char)(i+'A'));
        	hs.put(st, index++);
        }
        
        for(int i = 0,j=0;i<msg.length();) {
        	for(j = 1;j<msg.length()-i+1;j++) {
        		tmp =msg.substring(i, i+j);
        		if(!hs.containsKey(tmp)) {
        			hs.put(tmp,index++);
        			break;
        		}
        		else {
        			ttmp=tmp;
        			num = hs.get(tmp);
        	}}
        	answer.add(num);
        	i+=ttmp.length();
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
	
	public static void main(String[] args) {
		String str = "TOBEORNOTTOBEORTOBEORNOT";
		int[] a = solution(str);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}

}
