package codeup;

import java.util.Scanner;

public class CodeUp_1019 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		String s[]=sc.next().split("\\.");
		
		int year=Integer.parseInt(s[0]);
		int month=Integer.parseInt(s[1]);
		int day=Integer.parseInt(s[2]);
		
		System.out.println(String.format("%04d.%02d.%02d",year,month,day));
		
	}

}

// split()�� �̿���  .(��)�� �������� ���ڿ��� �ڸ�����
// [.], \\.�� �̿�
