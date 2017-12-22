import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

class MemoManager {//�޸� ���� �޴�
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
               System.out.println("-����� �޸� ����-");
            }
            if(br!=null) br.close();
      
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
               addmemo();
            }
            else if (selection == 2) {
               updatememo();
            }
            else if (selection == 3) {
               deletememo(br);
            }
            else if (selection == 4) {
               System.out.println("����ȭ������ ���ư��ϴ�.");
               break;
            }
            else {
               System.out.println("�ٽ� �Է��ϼ���.");
            }   
         }
      }
      catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public static void addmemo() throws IOException {   // �޸� ����
      System.out.println("�߰��� �޸𳻿��� �Է��ϼ���.");
      System.out.print("�Է�: ");
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

   public static void updatememo() {   //   �޸� ������Ʈ
      int number;
      String dummy = "";
      BufferedReader br1;
      
      try {
         br1 = new BufferedReader(new FileReader("MemoManagerMYK.txt"));
  
         while (true) {
            if (countNumberOfMemo == 0 ) {
               System.out.println("����� �޸� ����  �޸� ���� ����� ������ �� �����ϴ�.\n�޸���� �޴�ȭ������ ���ư��ϴ�.");
                break;
            }
            System.out.println("������ ���ϴ� �ش� �޸��� ��ȣ�� �Է��ϼ���.");
            Scanner sc3 = new Scanner(System.in);
            number = sc3.nextInt();
            
            if (countNumberOfMemo < number || number == 0) {
            	System.out.println("�ش� �޸� ����  �޸� ���� ����� ������ �� �����ϴ�.\n�޸���� �޴�ȭ������ ���ư��ϴ�.");
            	break;
            }
            
            String line;
            for (int i = 0; i<number-1; i++) {
            	line = br1.readLine();
            	dummy +=(line+"\r\n");
            }
            
            String updateData = br1.readLine();
            System.out.println("������ ���ϴ� �޸�: "+updateData);
            System.out.println("���ϴ� �������� �޸� �����ϼ���.");
            System.out.print("�Է�: ");
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
               
            System.out.println("�ش� �޸� �����Ͽ����ϴ�.");
            System.out.println("�޸���� �޴�ȭ������ ���ư��ϴ�.");
            break;      
         }
      }
      catch (IOException e) {
    	  e.printStackTrace();
      }            
   }
   
   public static void deletememo(BufferedReader br) throws Exception {   // �޸� ����
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
    			  System.out.println("����� �޸� ����  �޸� ���� ����� ������ �� �����ϴ�.\n�޸���� �޴�ȭ������ ���ư��ϴ�.");
    			  break;
    		  }  
    		  System.out.println("������ ���ϴ� �ش� �޸��� ��ȣ�� �Է��ϼ���.");
    		  Scanner sc3 = new Scanner(System.in);
    		  number = sc3.nextInt();	
   
    		  if (countNumberOfMemo < number || number == 0) {
    			  System.out.println("�ش� �޸� ����  �޸� ���� ����� ������ �� �����ϴ�.\n�޸���� �޴�ȭ������ ���ư��ϴ�.");
    			  break;
    		  }
    		  String line2;
    		  String dummy;
    		  String deleteData="";
    		  deleteData = selectMemoLineTobeDeleted(br, number);
           
    		  System.out.println("������ ���ϴ� �޸�: "+deleteData);
            
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
    			  System.out.println("�ش� �޸� �����Ͽ����ϴ�.");
    			  System.out.println("�޸���� �޴�ȭ������ ���ư��ϴ�.");
    		  } 
    		  else if (YesOrNo.equals("N") || YesOrNo.equals("n")) {
    			  System.out.println("�ش� �޸� �������� �ʾҽ��ϴ�.");
    			  System.out.println("�޸���� �޴�ȭ������ ���ư��ϴ�.");
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

class calculator{   // ���� �޴�
   static Scanner scan = new Scanner (System.in);
   calculator() {
      int input;
      do {
         System.out.println("\n=<���� �޴�>=");
         System.out.println(" 1.���");
         System.out.println(" 2.������ȯ");
         System.out.println(" 3.�ڷΰ���");
         System.out.println("===========");
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
         else {
            System.out.println("����ȭ������ ���ư��ϴ�.\n");
            break;
         }
      }while(true);
   }

   public static void calculate() {   //   ���
      double num1,num2,result=0;
      String operator;
      String answer;
      boolean run = true;
      
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
         result = Add(num1,num2);
      else if(operator.equals("-"))
         result = Sub(num1,num2);
      else if(operator.equals("*"))
         result = Mul(num1,num2);
      else if(operator.equals("/"))
         result = Div(num1,num2);
         

      System.out.println("������ : "+result);
      System.out.print("�ٽ� �Ͻðڽ��ϱ�? (Y/N) : ");
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
   

   public static void convert() {   // ������ȯ
      int menu;
      boolean run = true;
      boolean run1=true;
      double input;
      double result;
      String answer;
      
      do {
         run=true;
         System.out.println("\n==<������ȯ �޴�>==");
         System.out.println(" 1. pound->kg");
         System.out.println(" 2. kg->pound");
         System.out.println(" 3. inch->cm");
         System.out.println(" 4. cm->inch");
         System.out.println(" 5. ��F->��C");
         System.out.println(" 6. ��C->��F");
         System.out.println(" 7. �ڷΰ���");
         System.out.println("===============");
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
            while(run) {
               System.out.print("\n�Է�(pound) : ");
               input = scan.nextDouble();
               scan.nextLine();
               result = pound2kg(input);
               System.out.println("��ȯ ���(kg) : "+result);
            
               System.out.print("�ٽ� �Ͻðڽ��ϱ�? (Y/N) : ");
               answer = scan.nextLine();
               run = YesNo(answer);
            }
            break;
            
         case 2:
            while(run) {
               System.out.print("\n�Է�(kg) : ");
               input = scan.nextDouble();
               scan.nextLine();
               result = kg2pound(input);
               System.out.println("��ȯ ���(pound) : "+result);
               System.out.print("�ٽ� �Ͻðڽ��ϱ�? (Y/N) : ");
               answer = scan.nextLine();
               run = YesNo(answer);
            }
            break;
         case 3:
            while(run) {
               System.out.print("\n�Է�(inch) : ");
               input = scan.nextDouble();
               scan.nextLine();
               result = inch2cm(input);
               System.out.println("��ȯ ���(cm) : "+result);
               System.out.print("�ٽ� �Ͻðڽ��ϱ�? (Y/N) : ");
               answer = scan.nextLine();
               run = YesNo(answer);
            }
            break;
         case 4:
            while(run) {
               System.out.print("\n�Է�(cm) : ");
               input = scan.nextDouble();
               scan.nextLine();
               result = cm2inch(input);
               System.out.println("��ȯ ���(inch) : "+result);
               System.out.print("�ٽ� �Ͻðڽ��ϱ�? (Y/N) : ");
               answer = scan.nextLine();
               run = YesNo(answer);
            }
            break;
         case 5:
            while(run) {
               System.out.print("\n�Է�(��F) : ");
               input = scan.nextDouble();
               scan.nextLine();
               result = Fahrenheit2Celsius(input);
               System.out.println("��ȯ ���(��C) : "+result);
               System.out.print("�ٽ� �Ͻðڽ��ϱ�? (Y/N) : ");
               answer = scan.nextLine();
               run = YesNo(answer);
            }
            break;
         case 6:
            while(run) {
               System.out.print("\n�Է�(��C) : ");
               input = scan.nextDouble();
               scan.nextLine();
               result = Celsius2Fahrenheit(input);
               System.out.println("��ȯ ���(��F) : "+result);
               System.out.print("�ٽ� �Ͻðڽ��ϱ�? (Y/N) : ");
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
         System.out.print("�ٽ� �Է��ϼ��� : ");
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

class Accountbook { // ����� ���� �޴�
   public static int i=0;
   public static void mainaccount(Vector<item> v){
         
      Scanner scan = new Scanner(System.in);
      int number=1;
      while(number!=4){
         System.out.println("========= <Purchase List> ========");
         System.out.println("��ȣ\t���Գ�¥ \t��ǰ��\t��ǰ����   ");
         for(int i=0;i<v.size();i++){
            System.out.printf("[%d]%10d%10s%10d\n"
                  ,i+1,v.get(i).getday(),v.get(i).getname(),v.get(i).getprice());   
         }
         System.out.println("=================================\n");
         System.out.println("========== <����� ���� �޴�> ==========");
         System.out.println("1. ����� �ۼ�\n2. ����� ������Ʈ\n3. ���� ���� ����\n4. �ڷΰ���");
         System.out.println("=================================\n");
         System.out.print("�޴� ��ȣ �Է�: ");
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
      }
   }

   private static void deleteaccount(Vector<item> v) { // ���� ���� ����
      Scanner scan = new Scanner(System.in);
      if(v.size()==0){
               System.out.println("������ ǰ���� �����ϴ�.");
               return;
      }
      System.out.print("������ ���Գ����� ��ȣ�� �Է��ϼ���. ");
      int num;
      do{
         num = scan.nextInt()-1;
         if(num<0 || num >v.size()-1)
                  System.out.println("��ȣ�� �ٽ� �Է��ϼ���.");
      }while(num<0 || num >v.size()-1);
      System.out.println("��ȣ\t���Գ�¥ \t��ǰ��\t��ǰ����   ");
      System.out.printf("[%d]%10d%10s%10d\n"
            ,i+1,v.get(i).getday(),v.get(i).getname(),v.get(i).getprice());   
      System.out.println("���� �����Ͻðڽ��ϱ�?(Y/N)");
      String ans = scan.next();
      while(true){
         if(ans.equals("Y")||ans.equals("y")||ans.equals("N")||ans.equals("n")){
            if(ans.equals("Y")||ans.equals("y")){
               v.remove(num);
               break;
            }else if(ans.equals("N")||ans.equals("n")) return;
         }
         System.out.print("�ٽ� �Է��ϼ���.(Y/N)");
         ans = scan.next();
      }
   }
   
   private static void updateaccount(Vector<item> v) {   // ����� ������Ʈ
      Scanner scan = new Scanner(System.in);
      if(v.size()==0){
               System.out.println("������ ǰ���� �����ϴ�. ");
               return;
      }
      System.out.println("������ ���Գ����� ��ȣ�� �Է��ϼ���. ");
      int day, price, num;
      String name;
      do{
         num = scan.nextInt()-1;
         if(num<0 || num >v.size()-1)
                     System.out.println("��ȣ�� �ٽ� �Է��ϼ���.");
      }while(num<0 || num >v.size()-1);
      
      System.out.println("��ȣ\t���Գ�¥ \t��ǰ��\t��ǰ����   ");
      System.out.printf("[%d]%10d%10s%10d\n"
            ,i+1,v.get(i).getday(),v.get(i).getname(),v.get(i).getprice());   
      System.out.println("������ �׸��� ��ȣ�� �Է��ϼ���.");
      System.out.println("1.���Գ�¥\n2.��ǰ��\n3.��ǰ����");
      int cas;
      
      do{
         cas=scan.nextInt();
         if(cas==1){
            System.out.println("���Գ�¥:");
            day = scan.nextInt();
            v.get(num).setday(day);
         }else if(cas==2){
            System.out.println("��ǰ��:");
            name = scan.next();
            v.get(num).setname(name);
         }else if (cas==3){
            System.out.println("��ǰ����:");
            price = scan.nextInt();
            v.get(num).setprice(price);
         }else{
            System.out.println("1��~3�� ���̿��� �Է����ּ���.");
         }   
         }while(cas<1||cas>3);
      
      return;
   }
   
   public static void addaccount(Vector<item> v){   // ����� �ۼ�
      Scanner scan = new Scanner(System.in);
      System.out.print("���Գ����� ������ �Է��ϼ���. ");
      int day, price;
      String name;
      System.out.print("���Գ�¥:" );
      day = scan.nextInt();
      System.out.print("��ǰ��:" );
      name = scan.next();
      System.out.print("��ǰ����:" );
      price = scan.nextInt();
      item i1 = new item(day,name,price);
      v.add(i1);
      return;
   }
}

public class MainProgram {   //   ���� �޴�

   public static void main(String[] args) throws Exception {
      Scanner scan = new Scanner (System.in);
      Vector<item> v2 = new Vector<item>();
      while (true) {
      System.out.printf("========= MENU =========%n"
            + "1. Memo manager (�޸����)%n"
            + "2. Calculator (����)%n"
            + "3. Account book (�����)%n"
            + "4. Exit (����)%n"
            + "========================%n");
      System.out.printf("�޴� ��ȣ �Է�: ");
      int sel = scan.nextInt();   // ��ȣ �Է�

      if (sel==1) {
         MemoManager.domanagememo();
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
