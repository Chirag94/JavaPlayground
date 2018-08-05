package myPackage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Chapter1 {



		public static void main(String[] args) {
			// TODO Auto-generated method stub

			//System.out.println(Question1( "chirag"));
			//System.out.println(Question2("chirag","grachi"));
			//System.out.println(URLIfy("Mr John Smith",13));
			//System.out.println(PalindromePermutation("Taco cat"));
			//System.out.println(OneAway("pale","pily"));
			System.out.println(Compression("AB"));
			
		}

		private static String Compression(String string) {
			// TODO Auto-generated method stub
			int ar[]=new int [256];
			for (char c : string.toCharArray()) {
				ar[c]++;
			}
			StringBuffer sb2=new StringBuffer();
			for (int i=0;i<ar.length;i++) {
				
				
				if(ar[i]>=1) {
					sb2.append((char)i);
					sb2.append(ar[i]);
				}
			}
			System.out.println(sb2);
			
			//
			HashMap<Character,Integer> hm=new HashMap<>();
			StringBuffer sb;
			for (char c : string.toCharArray()) {
				if(!hm.containsKey(c)) hm.put(c, 1);
				else {
					int temp=hm.get(c);
					temp++;
					hm.replace(c, temp);
				}
			}
			if(string.length()<=hm.keySet().size()) return string;
			else {
				 sb=new StringBuffer();
				for ( Map.Entry<Character, Integer> set : hm.entrySet()) {
					sb.append(set.getKey()+set.getValue().toString());
				}
			}
			return sb.toString();
		}

		private static Boolean OneAway(String string1, String string2) {
			// TODO Auto-generated method stub
			//Needs further check not completely implemented yet
			//Check for Zero Edit first, it can be done later as well
			if(string1.equals(string2)) return true;
			// Operations are remove,replace and insert
			// Check for remove and insert is such that length varies in one and all characters are same
			if(string1.length()>=string2.length()) { 
				if(string1.length()-string2.length()>1) return false;
			}
			else {
				if(string2.length()-string1.length()>1) return false;
			}
			int ar[]=new int[256];
			for (char c : string1.toCharArray()) {
				ar[c]++;
			}
			for (char c : string2.toCharArray()) {
				ar[c]--;
			}
			// if 2 strings are same, all values are zero
			// if one remove and insert operation far, then exactly one value will be one
			int count=0;
			for (int i : ar) {
				if(i>=1)count++;
				if(count>2) return false; 
			}
			if(count==1) return true;
			
			
			
			
			
			
			
			
			return false;
		}

		private static boolean PalindromePermutation(String string) {
			// TODO Auto-generated method stub
			//We can have a palindromic permutaion iff every chacracter occurs evenly and at most one character occurs oddly
			int ar[]=new int[256];
			for (char c : string.toLowerCase().replaceAll("\\s", "").toCharArray()) {
				ar[c]+=1;
			}
			int count=0;
			Boolean valid=true;
			for (int i : ar) {
				if(i%2!=0)count++;
				if(count>1) {
					valid=false; return valid;
				}
			}
			
			return true;
		}

		private static String URLIfy(String input, int i) {
			// TODO Auto-generated method stub
			char [] ch=input.toCharArray();
			StringBuffer sb=new StringBuffer();
			for (char c : ch) {
				if(c==' ')sb.append("%20");
				else sb.append(c);
			}
			return sb.toString();
			
		}

		private static Boolean Question2(String input1, String input2) {
			// TODO check if input1 is a permutation of input2 or not
			/*if(input1.length()!=input2.length()) return false;
				char[] ch1= input1.toCharArray();
				char[] ch2= input2.toCharArray();
				Arrays.sort(ch1);
				Arrays.sort(ch2);
				return Arrays.equals(ch1,ch2);		
				*/
			if(input1.length()!=input2.length()) return false;
			int [] test=new int[256];
			for(int i=0;i<input1.length();i++) {
				test[input1.charAt(i)]++;
				test[input2.charAt(i)]--;
			}
			for (int i : test) {
				if(i!=0) return false;
			}	
			return true;
		
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
