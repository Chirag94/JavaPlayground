package myPackage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Chapter1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Question1( "chirag"));
		System.out.println(Question2("asd","das"));
		
	}

	private static Boolean Question2(String input1, String input2) {
		// TODO check if input1 is a permutation of input2 or not
		if(input1.length()==input2.length()) {
			char[] ch1= input1.toCharArray();
			char[] ch2= input2.toCharArray();
			Arrays.sort(ch1);
			Arrays.sort(ch2);
			for(int i=0;i<ch1.length;i++ ) {
				if(ch1[i]==ch2[i])continue;
				else return false;
			}
			return true;
		}
		return false;
	}

	private static Boolean Question1(String input) {
		for(int i=0;i<input.length();i++) {
			for(int j=i+1;j<input.length();j++) {
				if(input.charAt(i)==input.charAt(j))return false;
			}
		}
		return true;
		/*
		
		Set<Character> set=new TreeSet<>();
		for (Character i : input.toCharArray()) {
			set.add(i);
		}
		if(set.size()==input.length()) return true;
		else return false;
		//This is a different approach where without the use of additional DS we can perform the computation in O(n) time
		//Check out Geeks for Geeks for reference
		int checkcBit=0;
		for(int i=0;i<input.length();i++) {
			int index=input.charAt(i)-'a';
			if((checkcBit&1<<index)>0)return false;
			checkcBit=checkcBit|1<<index;
		}
		return true;
		*/
		
	}

}
