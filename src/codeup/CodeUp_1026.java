package codeup;

import java.util.Scanner;

public class CodeUp_1026 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		String s[]=sc.next().split(":");
		
		if(s[1].equals("00"))
			System.out.println("0");
		else
			System.out.println(s[1]);
		
	}

}

// �ּҰ��� ���Ҷ��� "=="
// ���밪�� ���Ҷ��� equals()

