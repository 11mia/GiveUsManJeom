import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

class MemoManager {//메모 관리 메뉴
   static int countNumberOfMemo = 0;
   static BufferedWriter bw;
   static BufferedReader br;
   static Vector<String> memoStorage;
   static String memo;
   
   public static void domanagememo() throws Exception {
      memoStorage = new Vector<String>();
      try {   
         while (true) {
            bw = new BufferedWriter(new FileWriter("MemoManagerMYK.txt", true));
            br = new BufferedReader(new FileReader("MemoManagerMYK.txt"));
            String strLine;
               
            System.out.println("\n===<Memo List>===");
            countNumberOfMemo=0;
                
            while((strLine = br.readLine())!= null) {
               System.out.println((countNumberOfMemo+1)+": "+strLine);
               countNumberOfMemo++;
            }
            
            if (countNumberOfMemo == 0) {
               System.out.println("-저장된 메모 없음-");
            }
            if(br!=null) br.close();
      
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
               addmemo();
            }
            else if (selection == 2) {
               updatememo();
            }
            else if (selection == 3) {
               deletememo(br);
            }
            else if (selection == 4) {
               System.out.println("메인화면으로 돌아갑니다.");
               break;
            }
            else {
               System.out.println("다시 입력하세요.");
            }   
         }
      }
      catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public static void addmemo() throws IOException {   // 메모 생성
      System.out.println("추가할 메모내용을 입력하세요.");
      System.out.print("입력: ");
      Scanner sc1 = new Scanner(System.in);
      memo = sc1.nextLine();
      memoStorage.add(memo);
      addStringMemo(bw, memo);
   }
   
   static BufferedWriter addStringMemo(BufferedWriter bw, String memo) {
      try {
    	  bw.write(memo);
    	  bw.newLine();
    	  bw.close();
      }
      catch (Exception e) {
    	  e.printStackTrace();
      }
      return bw ;   
   }

   public static void updatememo() {   //   메모 업데이트
      int number;
      String dummy = "";
      BufferedReader br1;
      
      try {
         br1 = new BufferedReader(new FileReader("MemoManagerMYK.txt"));
  
         while (true) {
            if (countNumberOfMemo == 0 ) {
               System.out.println("저장된 메모가 없어  메모 수정 기능을 수행할 수 없습니다.\n메모관리 메뉴화면으로 돌아갑니다.");
                break;
            }
            System.out.println("수정를 원하는 해당 메모의 번호를 입력하세요.");
            Scanner sc3 = new Scanner(System.in);
            number = sc3.nextInt();
            
            if (countNumberOfMemo < number || number == 0) {
            	System.out.println("해당 메모가 없어  메모 수정 기능을 수행할 수 없습니다.\n메모관리 메뉴화면으로 돌아갑니다.");
            	break;
            }
            
            String line;
            for (int i = 0; i<number-1; i++) {
            	line = br1.readLine();
            	dummy +=(line+"\r\n");
            }
            
            String updateData = br1.readLine();
            System.out.println("수정를 원하는 메모: "+updateData);
            System.out.println("원하는 내용으로 메모를 수정하세요.");
            System.out.print("입력: ");
            Scanner sc2_1 = new Scanner(System.in);
            String updateMemo = sc2_1.nextLine();
            dummy += updateMemo+"\r\n";   
            
            while((line = br1.readLine())!=null) {
               dummy +=(line + "\r\n");
            }
            
            FileWriter fw = new FileWriter("MemoManagerMYK.txt");
            fw.write(dummy);
            fw.close();
            br1.close();
               
            System.out.println("해당 메모를 수정하였습니다.");
            System.out.println("메모관리 메뉴화면으로 돌아갑니다.");
            break;      
         }
      }
      catch (IOException e) {
    	  e.printStackTrace();
      }            
   }
   
   public static void deletememo(BufferedReader br) throws Exception {   // 메모 삭제
      int number;
      String YesOrNo;
      String line;
      br= new BufferedReader(new FileReader("MemoManagerMYK.txt"));
      BufferedReader br1 = new BufferedReader(new FileReader("MemoManagerMYK.txt"));
      BufferedReader br2;
      
      try {
    	  memoStorage.removeAllElements();
    	  while((line = br1.readLine())!=null) {
    		  memoStorage.add(line);
    	  }
    	  
    	  while (true) {
    		  if (countNumberOfMemo == 0) {
    			  System.out.println("저장된 메모가 없어  메모 삭제 기능을 수행할 수 없습니다.\n메모관리 메뉴화면으로 돌아갑니다.");
    			  break;
    		  }  
    		  System.out.println("삭제를 원하는 해당 메모의 번호를 입력하세요.");
    		  Scanner sc3 = new Scanner(System.in);
    		  number = sc3.nextInt();	
   
    		  if (countNumberOfMemo < number || number == 0) {
    			  System.out.println("해당 메모가 없어  메모 삭제 기능을 수행할 수 없습니다.\n메모관리 메뉴화면으로 돌아갑니다.");
    			  break;
    		  }
    		  String line2;
    		  String dummy;
    		  String deleteData="";
    		  deleteData = selectMemoLineTobeDeleted(br, number);
           
    		  System.out.println("삭제를 원하는 메모: "+deleteData);
            
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
    			  memoStorage.remove(number-1);
    			  br2 = new BufferedReader(new FileReader("MemoManagerMYK.txt"));
    			  String memoBunch="";
    			  for (int i = 0; i<number-1; i++) {
    				  line2 = br2.readLine();
    				  memoBunch +=(line2+"\r\n");
    			  }        
    			  deleteData = br2.readLine();
    			  while((line2 = br2.readLine())!=null) {
    				  memoBunch +=(line2 + "\r\n");
    			  }
    			  br2.close();
    			  FileWriter fw = new FileWriter("MemoManagerMYK.txt");
               
    			  fw.write(memoBunch);
    			  fw.close();         
    			  System.out.println("해당 메모를 삭제하였습니다.");
    			  System.out.println("메모관리 메뉴화면으로 돌아갑니다.");
    		  } 
    		  else if (YesOrNo.equals("N") || YesOrNo.equals("n")) {
    			  System.out.println("해당 메모를 삭제하지 않았습니다.");
    			  System.out.println("메모관리 메뉴화면으로 돌아갑니다.");
    			  break;
    		  }
    		  break;     	 
    	  }	
      }
      catch (IOException e) {
    	  e.printStackTrace();
      }            
   }
   
   public static String selectMemoLineTobeDeleted(BufferedReader br, int selectedLine) throws IOException {
	   for (int i = 0; i<selectedLine-1; i++) {
		   br.readLine();
	   }
	   String delData = br.readLine();
	   return delData;
   }
}

class calculator{   // 계산기 메뉴
   static Scanner scan = new Scanner (System.in);
   calculator() {
      int input;
      do {
         System.out.println("\n=<계산기 메뉴>=");
         System.out.println(" 1.계산");
         System.out.println(" 2.단위변환");
         System.out.println(" 3.뒤로가기");
         System.out.println("===========");
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
         else {
            System.out.println("메인화면으로 돌아갑니다.\n");
            break;
         }
      }while(true);
   }

   public static void calculate() {   //   계산
      double num1,num2,result=0;
      String operator;
      String answer;
      boolean run = true;
      
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
         result = Add(num1,num2);
      else if(operator.equals("-"))
         result = Sub(num1,num2);
      else if(operator.equals("*"))
         result = Mul(num1,num2);
      else if(operator.equals("/"))
         result = Div(num1,num2);
         

      System.out.println("연산결과 : "+result);
      System.out.print("다시 하시겠습니까? (Y/N) : ");
      answer = scan.nextLine();
      run = YesNo(answer);
      }while(run);
   }
   
   public static double Add(double num1,double num2) {
      return num1+num2;
   }
   public static double Sub(double num1,double num2) {
      return num1-num2;
   }
   public static double Mul(double num1,double num2) {
      return num1*num2;
   }
   public static double Div(double num1,double num2) {
      return num1/num2;
   }
   

   public static void convert() {   // 단위변환
      int menu;
      boolean run = true;
      boolean run1=true;
      double input;
      double result;
      String answer;
      
      do {
         run=true;
         System.out.println("\n==<단위변환 메뉴>==");
         System.out.println(" 1. pound->kg");
         System.out.println(" 2. kg->pound");
         System.out.println(" 3. inch->cm");
         System.out.println(" 4. cm->inch");
         System.out.println(" 5. °F->°C");
         System.out.println(" 6. °C->°F");
         System.out.println(" 7. 뒤로가기");
         System.out.println("===============");
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
            while(run) {
               System.out.print("\n입력(pound) : ");
               input = scan.nextDouble();
               scan.nextLine();
               result = pound2kg(input);
               System.out.println("변환 결과(kg) : "+result);
            
               System.out.print("다시 하시겠습니까? (Y/N) : ");
               answer = scan.nextLine();
               run = YesNo(answer);
            }
            break;
            
         case 2:
            while(run) {
               System.out.print("\n입력(kg) : ");
               input = scan.nextDouble();
               scan.nextLine();
               result = kg2pound(input);
               System.out.println("변환 결과(pound) : "+result);
               System.out.print("다시 하시겠습니까? (Y/N) : ");
               answer = scan.nextLine();
               run = YesNo(answer);
            }
            break;
         case 3:
            while(run) {
               System.out.print("\n입력(inch) : ");
               input = scan.nextDouble();
               scan.nextLine();
               result = inch2cm(input);
               System.out.println("변환 결과(cm) : "+result);
               System.out.print("다시 하시겠습니까? (Y/N) : ");
               answer = scan.nextLine();
               run = YesNo(answer);
            }
            break;
         case 4:
            while(run) {
               System.out.print("\n입력(cm) : ");
               input = scan.nextDouble();
               scan.nextLine();
               result = cm2inch(input);
               System.out.println("변환 결과(inch) : "+result);
               System.out.print("다시 하시겠습니까? (Y/N) : ");
               answer = scan.nextLine();
               run = YesNo(answer);
            }
            break;
         case 5:
            while(run) {
               System.out.print("\n입력(°F) : ");
               input = scan.nextDouble();
               scan.nextLine();
               result = Fahrenheit2Celsius(input);
               System.out.println("변환 결과(°C) : "+result);
               System.out.print("다시 하시겠습니까? (Y/N) : ");
               answer = scan.nextLine();
               run = YesNo(answer);
            }
            break;
         case 6:
            while(run) {
               System.out.print("\n입력(°C) : ");
               input = scan.nextDouble();
               scan.nextLine();
               result = Celsius2Fahrenheit(input);
               System.out.println("변환 결과(°F) : "+result);
               System.out.print("다시 하시겠습니까? (Y/N) : ");
               answer = scan.nextLine();
               run = YesNo(answer);
            }
            break;
         case 7:
            run1=false;
            break;
         }
      }while(run1);
   }
   
   public static boolean YesNo(String answer) {
      while(!(answer.equals("n")||answer.equals("N")||answer.equals("y")||answer.equals("Y"))) {
         System.out.print("다시 입력하세요 : ");
         answer = scan.nextLine();
      }
      if(answer.equals("n")||answer.equals("N"))
         return false;
      else
         return true;
      
   }

   
   public static double pound2kg(double input) {
      double result;
      result = input*0.453592;
      return result;
   }

   public static double kg2pound(double input) {
      double result;
      result = input*2.20462;
      return result;   
   }

   public static double inch2cm(double input) {
      double result;
      result = input*2.54;
      return result;   
   }

   public static double cm2inch(double input) {
      double result;
      result = input*0.393701;
      return result;
   }

   public static double Fahrenheit2Celsius(double input) {
      double result;
      result = (input-32)/1.8;
      return result;
   }

   public static double Celsius2Fahrenheit(double input) {
      double result;
      result = input*1.8+32;
      return result;
   }
}


class item{
   int day;
   String name;
   int price;

   public item(int day, String name, int price){
      this.day = day;
      this.name = name;
      this.price = price;
   }

   public item() {}

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

class Accountbook { // 가계부 관리 메뉴
   public static int i=0;
   public static void mainaccount(Vector<item> v){
         
      Scanner scan = new Scanner(System.in);
      int number=1;
      while(number!=4){
         System.out.println("========= <Purchase List> ========");
         System.out.println("번호\t구입날짜 \t상품명\t상품가격   ");
         for(int i=0;i<v.size();i++){
            System.out.printf("[%d]%10d%10s%10d\n"
                  ,i+1,v.get(i).getday(),v.get(i).getname(),v.get(i).getprice());   
         }
         System.out.println("=================================\n");
         System.out.println("========== <가계부 관리 메뉴> ==========");
         System.out.println("1. 가계부 작성\n2. 가계부 업데이트\n3. 구입 내역 삭제\n4. 뒤로가기");
         System.out.println("=================================\n");
         System.out.print("메뉴 번호 입력: ");
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
      }
   }

   private static void deleteaccount(Vector<item> v) { // 구입 내역 삭제
      Scanner scan = new Scanner(System.in);
      if(v.size()==0){
               System.out.println("삭제할 품목이 없습니다.");
               return;
      }
      System.out.print("삭제할 구입내역의 번호를 입력하세요. ");
      int num;
      do{
         num = scan.nextInt()-1;
         if(num<0 || num >v.size()-1)
                  System.out.println("번호를 다시 입력하세요.");
      }while(num<0 || num >v.size()-1);
      System.out.println("번호\t구입날짜 \t상품명\t상품가격   ");
      System.out.printf("[%d]%10d%10s%10d\n"
            ,i+1,v.get(i).getday(),v.get(i).getname(),v.get(i).getprice());   
      System.out.println("정말 삭제하시겠습니까?(Y/N)");
      String ans = scan.next();
      while(true){
         if(ans.equals("Y")||ans.equals("y")||ans.equals("N")||ans.equals("n")){
            if(ans.equals("Y")||ans.equals("y")){
               v.remove(num);
               break;
            }else if(ans.equals("N")||ans.equals("n")) return;
         }
         System.out.print("다시 입력하세요.(Y/N)");
         ans = scan.next();
      }
   }
   
   private static void updateaccount(Vector<item> v) {   // 가계부 업데이트
      Scanner scan = new Scanner(System.in);
      if(v.size()==0){
               System.out.println("수정할 품목이 없습니다. ");
               return;
      }
      System.out.println("수정할 구입내역의 번호를 입력하세요. ");
      int day, price, num;
      String name;
      do{
         num = scan.nextInt()-1;
         if(num<0 || num >v.size()-1)
                     System.out.println("번호를 다시 입력하세요.");
      }while(num<0 || num >v.size()-1);
      
      System.out.println("번호\t구입날짜 \t상품명\t상품가격   ");
      System.out.printf("[%d]%10d%10s%10d\n"
            ,i+1,v.get(i).getday(),v.get(i).getname(),v.get(i).getprice());   
      System.out.println("수정할 항목의 번호를 입력하세요.");
      System.out.println("1.구입날짜\n2.상품명\n3.상품가격");
      int cas;
      
      do{
         cas=scan.nextInt();
         if(cas==1){
            System.out.println("구입날짜:");
            day = scan.nextInt();
            v.get(num).setday(day);
         }else if(cas==2){
            System.out.println("상품명:");
            name = scan.next();
            v.get(num).setname(name);
         }else if (cas==3){
            System.out.println("상품가격:");
            price = scan.nextInt();
            v.get(num).setprice(price);
         }else{
            System.out.println("1번~3번 사이에서 입력해주세요.");
         }   
         }while(cas<1||cas>3);
      
      return;
   }
   
   public static void addaccount(Vector<item> v){   // 가계부 작성
      Scanner scan = new Scanner(System.in);
      System.out.print("구입내역의 정보를 입력하세요. ");
      int day, price;
      String name;
      System.out.print("구입날짜:" );
      day = scan.nextInt();
      System.out.print("상품명:" );
      name = scan.next();
      System.out.print("상품가격:" );
      price = scan.nextInt();
      item i1 = new item(day,name,price);
      v.add(i1);
      return;
   }
}

public class MainProgram {   //   메인 메뉴

   public static void main(String[] args) throws Exception {
      Scanner scan = new Scanner (System.in);
      Vector<item> v2 = new Vector<item>();
      while (true) {
      System.out.printf("========= MENU =========%n"
            + "1. Memo manager (메모관리)%n"
            + "2. Calculator (계산기)%n"
            + "3. Account book (가계부)%n"
            + "4. Exit (종료)%n"
            + "========================%n");
      System.out.printf("메뉴 번호 입력: ");
      int sel = scan.nextInt();   // 번호 입력

      if (sel==1) {
         MemoManager.domanagememo();
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
