package blackbox.test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TriangleProblem {
	String determine(int a,int b,int c) {
		checkEdgeLength(a, b, c);
		if(checkRelation(a, b, c)) {
			String s = checkEquals(a, b, c);
			return s;
		}
		return "��������";
	}

	//���ÿ���ߵĳ��Ƿ���0-100֮��
	void checkEdgeLength(int... length) {
		IntStream.of(length).boxed().forEach(l -> {
			if(0 >=l || l > 100) {
				throw new IllegalArgumentException("bad length" + l);
			}
		});
	}
	
	//����Ƿ񹹳�������
	boolean checkRelation(int a, int b, int c) {
		if(a + b <= c || a + c <= b || b + c <= a) {
			System.out.println("������������");
			return false;
		}
		return true;
	}
	
	//�ж������ε�����
	String checkEquals(int a, int b, int c) {
		Map<Integer, String> map = new HashMap<Integer,String>() {{
			put(0,"һ��������");
			put(1,"����������");
			put(3,"�ȱ�������");
		}};
		//���numberֵΪ0,1,3ʱ�ֱ��Ӧһ�������Σ����������κ͵ȱ�������
		int number = checkEquals(a, b) + checkEquals(b, c) + checkEquals(a, c);
		System.out.println(number);
		return map.get(number);
	}
	
	int checkEquals(int a, int b) {
		return a == b ? 1 : 0; 
	}
}
