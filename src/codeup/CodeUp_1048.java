package codeup;

import java.util.Scanner;

public class CodeUp_1048 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		System.out.println(a<<b);
	
	}

}

//시프트 연산 (a<<b) : a를 2b배 만큼 곱한 값을 출력한다.