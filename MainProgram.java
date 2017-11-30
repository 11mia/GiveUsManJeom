
import java.util.Scanner;
import java.util.Vector;

class item{
	int day;
	String name;
	int price;

public item(int day, String name, int price){
	this.day = day;
	this.name = name;
	this.price = price;

}

public item() {
	// TODO Auto-generated constructor stub
}

public void setday(int day){
	this.day = day;
}
public void setname(String name){
	this.name = name;
}
public void setprice(int price){
	this.price = price;
}
public int getday(){
	return this.day;
}
public String getname(){
	return this.name;
}
public int getprice(){
	return this.price;
}


}



class Accountbook {

		public static int i=0;
		public static void mainaccount(Vector<item> v){
		//private static Object Vector;
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int number=1;
		//Vector<item> v = new Vector<item>();
		while(number!=4){

		System.out.println("========= <Purchase List> ========");
		System.out.println("  ��ȣ    ���Գ�¥      ��ǰ��      ��ǰ����   ");
		for(int i=0;i<v.size();i++){
			System.out.println(" ["+i+"] " + v.get(i).getday()
					+ "\t"+v.get(i).getname()+"\t"+v.get(i).getprice());
		}
		System.out.println("=================================\n");
		System.out.println("========== <����� ���� �޴�> ==========\n");
		System.out.println("1. ����� �ۼ�\n2. ����� ������Ʈ\n3. ���� ���� ����\n4. �ڷΰ���\n");
		System.out.println("=================================\n");
		System.out.println("�޴� ��ȣ �Է�:");
		number = scan.nextInt();
		switch(number){
		case 1:
			Accountbook.addaccount(v);
			break;
		case 2:
			Accountbook.updateaccount(v);
			break;
		case 3:
			Accountbook.deleteaccount(v);
			break;
		case 4:
			return;//�ڷΰ���
		default:
			System.out.println("1-4 ���̿��� �Է����ּ���");
			break;
		}
		}//main
}

	private static void deleteaccount(Vector<item> v) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("������ ���Գ����� ��ȣ�� �Է��ϼ���. ");
		int num = scan.nextInt();
		System.out.println("  ��ȣ    ���Գ�¥      ��ǰ��      ��ǰ����   ");
		System.out.println(" ["+num+"] " + v.get(num).getday()+"\t"+v.get(num).getname()+"\t"+v.get(num).getprice());
		System.out.println("���� �����Ͻðڽ��ϱ�?(Y/N)");
		String ans = scan.next();
		if(ans.equals("Y"))
			v.remove(num);
		else
			return;
	}
	private static void updateaccount(Vector<item> v) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("������ ���Գ����� ��ȣ�� �Է��ϼ���. ");
		int day, price;
		String name;
		int num = scan.nextInt();
		System.out.println("  ��ȣ    ���Գ�¥      ��ǰ��      ��ǰ����   ");
		System.out.println(" ["+num+"] " + v.get(num).getday()+"  "+v.get(num).getname()+"   "+v.get(num).getprice());
		System.out.println("������ �׸��� ��ȣ�� �Է��ϼ���.");
		System.out.println("1.���Գ�¥\n2.��ǰ��\n3.��ǰ����");
		int cas = scan.nextInt();
		switch(cas){
		case 1:
			System.out.println("���Գ�¥:");
			day = scan.nextInt();
			v.get(num).setday(day);
			break;
		case 2:
			System.out.println("��ǰ��:");
			name = scan.next();
			v.get(num).setname(name);
			break;
		case 3:
			System.out.println("��ǰ����:");
			price = scan.nextInt();
			v.get(num).setprice(price);
		default:
			break;
		}
		return;


	}
	public static void addaccount(Vector<item> v){
		Scanner scan = new Scanner(System.in);
		System.out.println("���Գ����� ������ �Է��ϼ���.");
		int day, price;
		String name;
		System.out.println("���Գ�¥:");
		day = scan.nextInt();
		System.out.println("��ǰ��:");
		name = scan.next();
		System.out.println("��ǰ����:");
		price = scan.nextInt();
		item i1 = new item(day,name,price);
		v.add(i1);
		return;


	}
}

class MemoManager {//�޸�������
	public static void start(Vector v) {
		 while (true) {
	          System.out.println("\n===<Memo List>===");

	          if (v.size() == 0) {
	             System.out.println("-����� �޸� ����-");
	          }

	          for (int i = 0; i < v.size(); i++) {
	          Object obj = v.get(i);
	          String str = (String)obj;
	          System.out.print((i+1));
	          System.out.println(": " + str);
	          }
	          System.out.println("=================");
	          System.out.println("==<�޸� ���� �޴�>==");
	          System.out.println("1.�޸� ����");
	          System.out.println("2.�޸� ������Ʈ");
	          System.out.println("3.�޸� ����");
	          System.out.println("4.�ڷΰ���");
	          System.out.println("==============");
	          System.out.print("�Է�: ");

	          Scanner sc = new Scanner(System.in);
	          int selection = sc.nextInt();

	          if (selection == 1) {
	        	  MemoManager ob1 = new MemoManager();
	        	  ob1.addmemo(v);
	          }

	          else if (selection == 2) {
	        	  MemoManager ob2 = new MemoManager();
	        	  ob2.updatememo(v);

	          }

	          else if (selection == 3) {
	        	  MemoManager ob3 = new MemoManager();
	        	  ob3.deletememo(v);

	          }

	          else if (selection == 4) {
	        	  System.out.println("����ȭ������ ���ư��ϴ�.");
	        	  break;
	          }

	          else {
	          System.out.println("�ٽ� �Է��ϼ���.");
	          }
		 }//while
	}

	public void addmemo(Vector v) {
		 System.out.println("�߰��� �޸𳻿��� �Է��ϼ���.");
         System.out.print("�Է�: ");
		 Scanner sc1 = new Scanner(System.in);
         String memo = sc1.nextLine();
         //String memo1=sc1.ne
         v.add(memo);

	}

	public static void updatememo(Vector v) {
		int number;

		while(true) {
			if (v.size() == 0) {
				 System.out.println("����� �޸� ���� �޸� ���� ����� ������ �� �����ϴ�.\n�޸���� �޴�ȭ������ ���ư��ϴ�.");
				 break;
			 }

			System.out.println("������ �޸� ��ȣ�� �Է��ϼ���.");
			System.out.print("�Է�: ");
			Scanner sc2 = new Scanner(System.in);
			number = sc2.nextInt();

			if (number > v.size() || number == 0 || number < 0) {
				System.out.println("������ �ش� �޸� �����ϴ�.\n<MemoList>�� �ִ� �޸��ȣ�� �Է��ϼ���.");
			}

			else {
				Object obj = v.get(number-1);
				String str = (String)obj;
				System.out.print(number);
				System.out.println(": " + str);
				v.remove(number-1);
				System.out.println("���ϴ� �������� �޸� �����ϼ���.");
				System.out.print("�Է�: ");
				Scanner sc2_1 = new Scanner(System.in);
				String memo = sc2_1.nextLine();
				v.add(number-1, memo);
				break;
			}
		}
	}

	public static void deletememo(Vector v) {
		int number;
		String YesOrNo;
		while (true) {
			if (v.size() == 0) {
				System.out.println("����� �޸� ����  �޸� ���� ����� ������ �� �����ϴ�.\n�޸���� �޴�ȭ������ ���ư��ϴ�.");
 				break;
 			}

			System.out.println("������ ���ϴ� �ش� �޸��� ��ȣ�� �Է��ϼ���.");
			Scanner sc3 = new Scanner(System.in);
			number = sc3.nextInt();

			if (number > v.size() || number == 0 || number < 0) {
				System.out.println("�ش� �޸� �����ϴ�. ��ȿ�� �޸� ��ȣ �ٽ� �Է��ϼ���.");
				//break;//
			}

			else {
				while (true) {

				System.out.print("���� �ش� �޸� �����Ͻðڽ��ϱ�?(Y/N): ");
				Scanner sc4 = new Scanner(System.in);
				YesOrNo = sc4.nextLine();
				if (true == !(YesOrNo.equals("Y") || YesOrNo.equals("y") || YesOrNo.equals("N") || YesOrNo.equals("n")))
					System.out.println("'Y' �Ǵ�'N'���� ����� �ٽ� �Է��ϼ���.");
				else
					break;
				}

				if (YesOrNo.equals("Y") || YesOrNo.equals("y")) {

					v.remove(number-1);
					System.out.println("�ش� �޸� �����Ͽ����ϴ�.");
					System.out.println("�޸���� �޴�ȭ������ ���ư��ϴ�.");
				}

				else if (YesOrNo.equals("N") || YesOrNo.equals("n")) {
					System.out.println("�ش� �޸� �������� �ʾҽ��ϴ�.");
					System.out.println("�޸���� �޴�ȭ������ ���ư��ϴ�.");
				}

			break;
			}
        }//while
	}
}

public class MainProgram {//���θ޴�

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		Vector v = new Vector();
		Vector<item> v2 = new Vector<item>();
		while (true) {
		System.out.printf("========= MENU =========%n"
				+ "1. Memo manager (�޸����)%n"
				+ "2. Calculator (����)%n"
				+ "3. Account book (�����)%n"
				+ "4. Exit (����)%n"
				+ "========================%n");
		System.out.printf("�޴� ��ȣ �Է�: ");
		int sel = scan.nextInt();	// ��ȣ �Է�

		if (sel==1) {
			MemoManager menu1 = new MemoManager();
			menu1.start(v);
		}// �޸���� �޴� ȣ��
		else if (sel==2){
			new calculator();
		}// ���� �޴� ȣ��
		else if (sel==3){
            Accountbook.mainaccount(v2);
		}// ����� �޴� ȣ��
		else if (sel==4) { // ����
			break;
		}
		else {
			System.out.println("�ٽ� �Է��ϼ���. ");
		}
		}
	}
}

class calculator{
	static Scanner scan = new Scanner (System.in);
	calculator() {
		int input;
		boolean run=true;
		System.out.println("");

		do {
			System.out.println("1.���");
			System.out.println("2.������ȯ");
			System.out.println("3.�ڷΰ���");
			System.out.print("�Է� : ");

			input = scan.nextInt();
			while(input>3||input<0) {
				System.out.println("�ٽ� �Է��ϼ���. : ");
				input=scan.nextInt();
			}
			if(input==1)
				calculate();
			else if(input==2)
				convert();
			else
				run = false;
		}while(run);
	}

	public static void calculate() {
		double num1,num2,result=0;
		String operator;
		//boolean run=true;
		String answer;
		do {
		System.out.print("\n����1 : ");
		num1 = scan.nextDouble();
		scan.nextLine();
		System.out.print("����2 : ");
		num2 = scan.nextDouble();
		scan.nextLine();
		System.out.print("������(+,-,*,/) : ");
		operator=scan.nextLine();

		if(operator.equals("+"))
			result = num1+num2;
		else if(operator.equals("-"))
			result = num1-num2;
		else if(operator.equals("*"))
				result = num1*num2;
		else if(operator.equals("/"))
			result = num1/num2;

		System.out.println("������ : "+result);
		System.out.print("�ٽ� �Ͻðڽ��ϱ�? (Y/N) : ");
		answer = scan.nextLine();

		while(!(answer.equals("n")||answer.equals("N")||answer.equals("y")||answer.equals("Y"))) {
			System.out.print("�ٽ� �Է��ϼ��� : ");
			answer = scan.nextLine();
			//scan.nextLine();
		}
		if(answer.equals("n")||answer.equals("N")) {
			System.out.println("");
			break;
		}
		}while(true);

	}

	public static void convert() {
		int menu;
		boolean run=true;
		System.out.println("");
		do {
		System.out.println("1. pound->kg");
		System.out.println("2. kg->pound");
		System.out.println("3. inch->cm");
		System.out.println("4. cm->inch");
		System.out.println("5. ��F->��C");
		System.out.println("6. ��C->��F");
		System.out.println("7. �ڷΰ���");
		System.out.print("�Է�: ");
		menu = scan.nextInt();
		scan.nextLine();

		while(menu>7||menu<1) {
			System.out.print("�ٽ� �Է��ϼ���. : ");
			menu = scan.nextInt();
			scan.nextLine();
		}

		switch(menu) {
		case 1:
			pound2kg();
			System.out.println("");
			break;
		case 2:
			kg2pound();
			System.out.println("");
			break;
		case 3:
			inch2cm();
			System.out.println("");
			break;
		case 4:
			cm2inch();
			System.out.println("");
			break;
		case 5:
			Fahrenheit2Celsius();
			System.out.println("");
			break;
		case 6:
			Celsius2Fahrenheit();
			System.out.println("");
			break;
		case 7:
			run=false;
			System.out.println("");
			break;
		}


		}while(run);

	}

	public static void pound2kg() {
		double input;
		double result;
		String answer;
		//System.out.println("");
		while(true) {
			System.out.print("\n�Է�(pound) : ");
			input = scan.nextDouble();
			scan.nextLine();
			result = input*0.453592;
			System.out.println("��ȯ ���(kg) : "+result);
			System.out.print("�ٽ� �Ͻðڽ��ϱ�? (Y/N) : ");
			answer = scan.nextLine();
			while(!(answer.equals("n")||answer.equals("N")||answer.equals("y")||answer.equals("Y"))) {
				System.out.print("�ٽ� �Է��ϼ��� : ");
				answer = scan.nextLine();
			}
			if(answer.equals("n")||answer.equals("N"))
				break;
		}
	}

	public static void kg2pound() {
		double input;
		double result;
		String answer;
		while(true) {
			System.out.print("\n�Է�(kg) : ");
			input = scan.nextDouble();
			scan.nextLine();
			result = input*2.20462;
			System.out.println("��ȯ ���(pound) : "+result);
			System.out.print("�ٽ� �Ͻðڽ��ϱ�? (Y/N) : ");
			answer = scan.nextLine();
			while(!(answer.equals("n")||answer.equals("N")||answer.equals("y")||answer.equals("Y"))) {
				System.out.print("�ٽ� �Է��ϼ��� : ");
				answer = scan.nextLine();
			}
			if(answer.equals("n")||answer.equals("N"))
				break;
		}
	}

	public static void inch2cm() {
		double input;
		double result;
		String answer;
		while(true) {
			System.out.print("\n�Է�(inch) : ");
			input = scan.nextDouble();
			scan.nextLine();
			result = input*2.54;
			System.out.println("��ȯ ���(cm) : "+result);
			System.out.print("�ٽ� �Ͻðڽ��ϱ�? (Y/N) : ");
			answer = scan.nextLine();
			while(!(answer.equals("n")||answer.equals("N")||answer.equals("y")||answer.equals("Y"))) {
				System.out.print("�ٽ� �Է��ϼ��� : ");
				answer = scan.nextLine();
			}
			if(answer.equals("n")||answer.equals("N"))
				break;
		}
	}

	public static void cm2inch() {
		double input;
		double result;
		String answer;
		while(true) {
			System.out.print("\n�Է�(cm) : ");
			input = scan.nextDouble();
			scan.nextLine();
			result = input*0.393701;
			System.out.println("��ȯ ���(inch) : "+result);
			System.out.print("�ٽ� �Ͻðڽ��ϱ�? (Y/N) : ");
			answer = scan.nextLine();
			while(!(answer.equals("n")||answer.equals("N")||answer.equals("y")||answer.equals("Y"))) {
				System.out.print("�ٽ� �Է��ϼ��� : ");
				answer = scan.nextLine();
			}
			if(answer.equals("n")||answer.equals("N"))
				break;
		}
	}

	public static void Fahrenheit2Celsius() {
		double input;
		double result;
		String answer;
		while(true) {
			System.out.print("\n�Է�(��F) : ");
			input = scan.nextDouble();
			scan.nextLine();
			result = (input-32)/1.8;
			System.out.println("��ȯ ���(��C) : "+result);
			System.out.print("�ٽ� �Ͻðڽ��ϱ�? (Y/N) : ");
			answer = scan.nextLine();
			while(!(answer.equals("n")||answer.equals("N")||answer.equals("y")||answer.equals("Y"))) {
				System.out.print("�ٽ� �Է��ϼ��� : ");
				answer = scan.nextLine();
			}
			if(answer.equals("n")||answer.equals("N"))
				break;
		}
	}

	public static void Celsius2Fahrenheit() {
		double input;
		double result;
		String answer;
		while(true) {
			System.out.print("\n�Է�(��F) : ");
			input = scan.nextDouble();
			scan.nextLine();
			result = input*1.8+32;
			System.out.println("��ȯ ���(��C) : "+result);
			System.out.print("�ٽ� �Ͻðڽ��ϱ�? (Y/N) : ");
			answer = scan.nextLine();
			while(!(answer.equals("n")||answer.equals("N")||answer.equals("y")||answer.equals("Y"))) {
				System.out.print("�ٽ� �Է��ϼ��� : ");
				answer = scan.nextLine();
			}
			if(answer.equals("n")||answer.equals("N"))
				break;
		}
	}

}
