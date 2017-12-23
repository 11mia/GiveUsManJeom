import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;

public class Test_1515655 {		/* 1515655 임소희 (main & organization 담당)
 								   메뉴 1,2,3 기능 중 일부 기능 테스트 */
	@Test
	public void testDivide() {	// 나누기 연산 (정수로 나누어 떨어지지 않는 경우 정수 아닌 소수로 나옴)
		assertTrue(calculator.Div(100,3)==33.333333333333336); 
	}
	
	@Test
	public void testMemoUpdated() throws Exception { // 수정할 메모 번호를 정확히 수정하는지 테스트
		BufferedWriter bw = new BufferedWriter(new FileWriter("MemoManagerMYK.txt"));
		BufferedReader br = new BufferedReader(new FileReader("MemoManagerMYK.txt"));
			
		bw.write("이 테스트는");
		bw.newLine();
		bw.write("수정할 메모번호를 입력받아");
		bw.newLine();
		bw.write("해당번호의 메모를 수정하고");
		bw.newLine();
		bw.write("정확하게 수정되었는지");
		bw.newLine();
		bw.write("확인하는 테스트입니다.");
		bw.newLine();
		bw.close();
			
		assertEquals(MemoManager.selectMemoLineTobeUpdated(br, 4), "정확하게 수정되었는지"); //수정할 메모확인
		br.close();
		
		
		BufferedReader br1 = new BufferedReader(new FileReader("MemoManagerMYK.txt"));
		String tobeupdated = "updated!!!";
		String before = MemoManager.readAllMemo(br1, 4, tobeupdated); // 수정 내용 및 전체 memoList를 String에 담기	
		br1.close();
		
		System.out.println(before); // 콘솔창에서 최종수정내용 제대로 담았는지 확인
		
	    FileWriter fw = new FileWriter("MemoManagerMYK.txt");
		MemoManager.UpdateStringMemo(fw, before);//수정
		fw.close();
		
		BufferedReader br2 = new BufferedReader(new FileReader("MemoManagerMYK.txt"));
		assertEquals(MemoManager.selectMemoLineTobeUpdated(br2, 4), tobeupdated); //수정되었는지 확인		
	}
}

