import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

import org.junit.Test;

/*	1513949	 ��ΰ�
 *  Account Unit Test*/
public class accountTest {

	@Test
	public void addtest(){
		Accountbook ac = new Accountbook();
		Vector<item> v = new Vector<item>();
		v = ac.adding(v, 20171222,"ramen",4500);
		boolean trueorfalse = false;
		if(v.get(0).getday()==20171222)
			if(v.get(0).getname().equals("ramen"))
				if(v.get(0).getprice()==4500)
					trueorfalse =true;
		assertTrue(trueorfalse == true);
		
	}

	@Test
	public void updatetest() throws IOException, ClassNotFoundException {
		Accountbook ac = new Accountbook();
		Vector<item> v = new Vector<item>();
		v = ac.adding(v, 20171222,"ramen",4500);
		//addTest()�� �����ϴ� ���� ������
		String name = v.get(0).getname();
		v = ac.update(v,0,2);
		//0�� ���ڵ��� "��ǰ��" �ٲٴ� �۾�
		assertFalse(v.get(0).getname().equals(name));
		}


}
