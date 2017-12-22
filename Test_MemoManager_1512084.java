import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import org.junit.Test;

public class Test_MemoManager_1512084 {
	@Test
	public void testAddStringMemo() throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter("testAddMemoMYK.txt"));
		BufferedReader br = new BufferedReader(new FileReader("testAddMemoMYK.txt"));
		
		MemoManager.addStringMemo(bw, "첫번째 메모 추가");
		
		assertEquals("첫번째 메모 추가", br.readLine());
	}
	
	@Test
	public void testCorrectnessSeletedMemoToBeDeleted() throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter("testDeleteMemoMYK.txt"));
		BufferedReader br = new BufferedReader(new FileReader("testDeleteMemoMYK.txt"));
		
		bw.write("첫번째 줄 메모");	bw.newLine();
		bw.write("두번째 줄 메모");	bw.newLine();
		bw.write("세번째 줄 메모");	bw.newLine(); bw.close();
		
		assertEquals(MemoManager.selectMemoLineTobeDeleted(br, 2), "두번째 줄 메모");		
	}	
}