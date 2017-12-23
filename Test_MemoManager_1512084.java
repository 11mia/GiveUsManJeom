import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import org.junit.Test;

public class Test_MemoManager_1512084 {
	@Test
	public void testAddStringMemo() throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter("testAddMemo.txt"));
		BufferedReader br = new BufferedReader(new FileReader("testAddMemo.txt"));
		
		MemoManager.addStringMemo(bw, "add memo");
		
		assertEquals("add memo", br.readLine());
	}
	
	@Test
	public void testCorrectnessSeletedMemoToBeDeleted() throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter("testDeleteMemo.txt"));
		BufferedReader br = new BufferedReader(new FileReader("testDeleteMemo.txt"));
		
		bw.write("first");	bw.newLine();
		bw.write("second");	bw.newLine();
		bw.write("third");	bw.newLine(); bw.close();
		
		assertEquals(MemoManager.selectMemoLineTobeDeleted(br, 2), "second");		
	}	
}