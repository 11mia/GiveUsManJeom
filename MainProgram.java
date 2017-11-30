
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
		System.out.println("  번호    구입날짜      상품명      상품가격   ");
		for(int i=0;i<v.size();i++){
			System.out.println(" ["+i+"] " + v.get(i).getday()
					+ "\t"+v.get(i).getname()+"\t"+v.get(i).getprice());
		}
		System.out.println("=================================\n");
		System.out.println("========== <가계부 관리 메뉴> ==========\n");
		System.out.println("1. 가계부 작성\n2. 가계부 업데이트\n3. 구입 내역 삭제\n4. 뒤로가기\n");
		System.out.println("=================================\n");
		System.out.println("메뉴 번호 입력:");
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
			return;//뒤로가기
		default:
			System.out.println("1-4 사이에서 입력해주세요");
			break;
		}
		}//main
}

	private static void deleteaccount(Vector<item> v) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 구입내역의 번호를 입력하세요. ");
		int num = scan.nextInt();
		System.out.println("  번호    구입날짜      상품명      상품가격   ");
		System.out.println(" ["+num+"] " + v.get(num).getday()+"\t"+v.get(num).getname()+"\t"+v.get(num).getprice());
		System.out.println("정말 삭제하시겠습니까?(Y/N)");
		String ans = scan.next();
		if(ans.equals("Y"))
			v.remove(num);
		else
			return;
	}
	private static void updateaccount(Vector<item> v) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 구입내역의 번호를 입력하세요. ");
		int day, price;
		String name;
		int num = scan.nextInt();
		System.out.println("  번호    구입날짜      상품명      상품가격   ");
		System.out.println(" ["+num+"] " + v.get(num).getday()+"  "+v.get(num).getname()+"   "+v.get(num).getprice());
		System.out.println("수정할 항목의 번호를 입력하세요.");
		System.out.println("1.구입날짜\n2.상품명\n3.상품가격");
		int cas = scan.nextInt();
		switch(cas){
		case 1:
			System.out.println("구입날짜:");
			day = scan.nextInt();
			v.get(num).setday(day);
			break;
		case 2:
			System.out.println("상품명:");
			name = scan.next();
			v.get(num).setname(name);
			break;
		case 3:
			System.out.println("상품가격:");
			price = scan.nextInt();
			v.get(num).setprice(price);
		default:
			break;
		}
		return;


	}
	public static void addaccount(Vector<item> v){
		Scanner scan = new Scanner(System.in);
		System.out.println("구입내역의 정보를 입력하세요.");
		int day, price;
		String name;
		System.out.println("구입날짜:");
		day = scan.nextInt();
		System.out.println("상품명:");
		name = scan.next();
		System.out.println("상품가격:");
		price = scan.nextInt();
		item i1 = new item(day,name,price);
		v.add(i1);
		return;


	}
}

class MemoManager {//메모관리기능
	public static void start(Vector v) {
		 while (true) {
	          System.out.println("\n===<Memo List>===");

	          if (v.size() == 0) {
	             System.out.println("-저장된 메모 없음-");
	          }

	          for (int i = 0; i < v.size(); i++) {
	          Object obj = v.get(i);
	          String str = (String)obj;
	          System.out.print((i+1));
	          System.out.println(": " + str);
	          }
	          System.out.println("=================");
	          System.out.println("==<메모 관리 메뉴>==");
	          System.out.println("1.메모 생성");
	          System.out.println("2.메모 업데이트");
	          System.out.println("3.메모 삭제");
	          System.out.println("4.뒤로가기");
	          System.out.println("==============");
	          System.out.print("입력: ");

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
	        	  System.out.println("메인화면으로 돌아갑니다.");
	        	  break;
	          }

	          else {
	          System.out.println("다시 입력하세요.");
	          }
		 }//while
	}

	public void addmemo(Vector v) {
		 System.out.println("추가할 메모내용을 입력하세요.");
         System.out.print("입력: ");
		 Scanner sc1 = new Scanner(System.in);
         String memo = sc1.nextLine();
         //String memo1=sc1.ne
         v.add(memo);

	}

	public static void updatememo(Vector v) {
		int number;

		while(true) {
			if (v.size() == 0) {
				 System.out.println("저장된 메모가 없어 메모 수정 기능을 수행할 수 없습니다.\n메모관리 메뉴화면으로 돌아갑니다.");
				 break;
			 }

			System.out.println("수정할 메모 번호를 입력하세요.");
			System.out.print("입력: ");
			Scanner sc2 = new Scanner(System.in);
			number = sc2.nextInt();

			if (number > v.size() || number == 0 || number < 0) {
				System.out.println("수정할 해당 메모가 없습니다.\n<MemoList>에 있는 메모번호를 입력하세요.");
			}

			else {
				Object obj = v.get(number-1);
				String str = (String)obj;
				System.out.print(number);
				System.out.println(": " + str);
				v.remove(number-1);
				System.out.println("원하는 내용으로 메모를 수정하세요.");
				System.out.print("입력: ");
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
				System.out.println("저장된 메모가 없어  메모 삭제 기능을 수행할 수 없습니다.\n메모관리 메뉴화면으로 돌아갑니다.");
 				break;
 			}

			System.out.println("삭제를 원하는 해당 메모의 번호를 입력하세요.");
			Scanner sc3 = new Scanner(System.in);
			number = sc3.nextInt();

			if (number > v.size() || number == 0 || number < 0) {
				System.out.println("해당 메모가 없습니다. 유효한 메모 번호 다시 입력하세요.");
				//break;//
			}

			else {
				while (true) {

				System.out.print("정말 해당 메모를 삭제하시겠습니까?(Y/N): ");
				Scanner sc4 = new Scanner(System.in);
				YesOrNo = sc4.nextLine();
				if (true == !(YesOrNo.equals("Y") || YesOrNo.equals("y") || YesOrNo.equals("N") || YesOrNo.equals("n")))
					System.out.println("'Y' 또는'N'으로 제대로 다시 입력하세요.");
				else
					break;
				}

				if (YesOrNo.equals("Y") || YesOrNo.equals("y")) {

					v.remove(number-1);
					System.out.println("해당 메모를 삭제하였습니다.");
					System.out.println("메모관리 메뉴화면으로 돌아갑니다.");
				}

				else if (YesOrNo.equals("N") || YesOrNo.equals("n")) {
					System.out.println("해당 메모를 삭제하지 않았습니다.");
					System.out.println("메모관리 메뉴화면으로 돌아갑니다.");
				}

			break;
			}
        }//while
	}
}

public class MainProgram {//메인메뉴

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		Vector v = new Vector();
		Vector<item> v2 = new Vector<item>();
		while (true) {
		System.out.printf("========= MENU =========%n"
				+ "1. Memo manager (메모관리)%n"
				+ "2. Calculator (계산기)%n"
				+ "3. Account book (가계부)%n"
				+ "4. Exit (종료)%n"
				+ "========================%n");
		System.out.printf("메뉴 번호 입력: ");
		int sel = scan.nextInt();	// 번호 입력

		if (sel==1) {
			MemoManager menu1 = new MemoManager();
			menu1.start(v);
		}// 메모관리 메뉴 호출
		else if (sel==2){
			new calculator();
		}// 계산기 메뉴 호출
		else if (sel==3){
            Accountbook.mainaccount(v2);
		}// 가계부 메뉴 호출
		else if (sel==4) { // 종료
			break;
		}
		else {
			System.out.println("다시 입력하세요. ");
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
			System.out.println("1.계산");
			System.out.println("2.단위변환");
			System.out.println("3.뒤로가기");
			System.out.print("입력 : ");

			input = scan.nextInt();
			while(input>3||input<0) {
				System.out.println("다시 입력하세요. : ");
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
		System.out.print("\n숫자1 : ");
		num1 = scan.nextDouble();
		scan.nextLine();
		System.out.print("숫자2 : ");
		num2 = scan.nextDouble();
		scan.nextLine();
		System.out.print("연산자(+,-,*,/) : ");
		operator=scan.nextLine();

		if(operator.equals("+"))
			result = num1+num2;
		else if(operator.equals("-"))
			result = num1-num2;
		else if(operator.equals("*"))
				result = num1*num2;
		else if(operator.equals("/"))
			result = num1/num2;

		System.out.println("연산결과 : "+result);
		System.out.print("다시 하시겠습니까? (Y/N) : ");
		answer = scan.nextLine();

		while(!(answer.equals("n")||answer.equals("N")||answer.equals("y")||answer.equals("Y"))) {
			System.out.print("다시 입력하세요 : ");
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
		System.out.println("5. °F->°C");
		System.out.println("6. °C->°F");
		System.out.println("7. 뒤로가기");
		System.out.print("입력: ");
		menu = scan.nextInt();
		scan.nextLine();

		while(menu>7||menu<1) {
			System.out.print("다시 입력하세요. : ");
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
			System.out.print("\n입력(pound) : ");
			input = scan.nextDouble();
			scan.nextLine();
			result = input*0.453592;
			System.out.println("변환 결과(kg) : "+result);
			System.out.print("다시 하시겠습니까? (Y/N) : ");
			answer = scan.nextLine();
			while(!(answer.equals("n")||answer.equals("N")||answer.equals("y")||answer.equals("Y"))) {
				System.out.print("다시 입력하세요 : ");
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
			System.out.print("\n입력(kg) : ");
			input = scan.nextDouble();
			scan.nextLine();
			result = input*2.20462;
			System.out.println("변환 결과(pound) : "+result);
			System.out.print("다시 하시겠습니까? (Y/N) : ");
			answer = scan.nextLine();
			while(!(answer.equals("n")||answer.equals("N")||answer.equals("y")||answer.equals("Y"))) {
				System.out.print("다시 입력하세요 : ");
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
			System.out.print("\n입력(inch) : ");
			input = scan.nextDouble();
			scan.nextLine();
			result = input*2.54;
			System.out.println("변환 결과(cm) : "+result);
			System.out.print("다시 하시겠습니까? (Y/N) : ");
			answer = scan.nextLine();
			while(!(answer.equals("n")||answer.equals("N")||answer.equals("y")||answer.equals("Y"))) {
				System.out.print("다시 입력하세요 : ");
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
			System.out.print("\n입력(cm) : ");
			input = scan.nextDouble();
			scan.nextLine();
			result = input*0.393701;
			System.out.println("변환 결과(inch) : "+result);
			System.out.print("다시 하시겠습니까? (Y/N) : ");
			answer = scan.nextLine();
			while(!(answer.equals("n")||answer.equals("N")||answer.equals("y")||answer.equals("Y"))) {
				System.out.print("다시 입력하세요 : ");
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
			System.out.print("\n입력(°F) : ");
			input = scan.nextDouble();
			scan.nextLine();
			result = (input-32)/1.8;
			System.out.println("변환 결과(°C) : "+result);
			System.out.print("다시 하시겠습니까? (Y/N) : ");
			answer = scan.nextLine();
			while(!(answer.equals("n")||answer.equals("N")||answer.equals("y")||answer.equals("Y"))) {
				System.out.print("다시 입력하세요 : ");
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
			System.out.print("\n입력(°F) : ");
			input = scan.nextDouble();
			scan.nextLine();
			result = input*1.8+32;
			System.out.println("변환 결과(°C) : "+result);
			System.out.print("다시 하시겠습니까? (Y/N) : ");
			answer = scan.nextLine();
			while(!(answer.equals("n")||answer.equals("N")||answer.equals("y")||answer.equals("Y"))) {
				System.out.print("다시 입력하세요 : ");
				answer = scan.nextLine();
			}
			if(answer.equals("n")||answer.equals("N"))
				break;
		}
	}

}
