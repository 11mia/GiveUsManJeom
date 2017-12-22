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
		
		MemoManager.addStringMemo(bw, "ù��° �޸� �߰�");
		
		assertEquals("ù��° �޸� �߰�", br.readLine());
	}
	
	@Test
	public void testCorrectnessSeletedMemoToBeDeleted() throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter("testDeleteMemoMYK.txt"));
		BufferedReader br = new BufferedReader(new FileReader("testDeleteMemoMYK.txt"));
		
		bw.write("ù��° �� �޸�");	bw.newLine();
		bw.write("�ι�° �� �޸�");	bw.newLine();
		bw.write("����° �� �޸�");	bw.newLine(); bw.close();
		
		assertEquals(MemoManager.selectMemoLineTobeDeleted(br, 2), "�ι�° �� �޸�");		
	}	
}