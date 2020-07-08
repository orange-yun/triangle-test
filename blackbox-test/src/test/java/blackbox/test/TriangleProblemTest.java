package blackbox.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import blackbox.test.TriangleProblem;

@DisplayName("���ԡ�����")

class TriangleProblemTest {
	TriangleProblem t = new TriangleProblem();
	// ǰ����������1��a��100��1��b��100��1��c��100
	// �߽�ֵ����
	// �������ǰ��������������������������������κ�һ����Ԥ�ڽ��Ϊ��������
	@ParameterizedTest
	@MethodSource("checkRelation")
	@DisplayName("���Է�������")
	void test_checkRelation(int a, int b, int c, String s) {
		assertEquals(s, t.determine(a, b, c));
	}
	static Stream<Arguments> checkRelation(){
		return Stream.of(
				Arguments.of(100,50,50, "��������"),
				Arguments.of(50,100,50, "��������"),
				Arguments.of(50,50,100, "��������"));
	}
	
	// �������ǰ�����������������߳���ȣ�Ԥ�ڽ��Ϊ�ȱ�������;ǡ������������ȣ�Ԥ�ڽ��Ϊ����������;�����߶�����ȣ�Ԥ�ڽ��Ϊһ��������
	@ParameterizedTest
	@MethodSource("checkEquals")
	@DisplayName("�Ϸ������β���")
	void test_checkEquals(int a, int b, int c, String s) {
		assertEquals(s, t.determine(a, b, c));
	}
	static Stream<Arguments> checkEquals(){
		return Stream.of(
				Arguments.of(2,2,2, "�ȱ�������"),
				Arguments.of(1,50,50, "����������"),
				Arguments.of(50,1,50, "����������"),
				Arguments.of(50,50,1, "����������"),
				Arguments.of(99,50,60, "һ��������"),
				Arguments.of(50,99,60, "һ��������"),
				Arguments.of(50,60,99, "һ��������"));
	}
	
	// ���������ǰ��������������Ԥ�ڽ��Ϊ�׳��쳣
	@ParameterizedTest
	@MethodSource("checkEdgeLength")
	@DisplayName("�쳣����")
	void test_checkEdgeLength(int a, int b, int c) {
		Executable executable = () -> t.determine(a, b, c);
		assertThrows(IllegalArgumentException.class,executable);
	}
	static Stream<Arguments> checkEdgeLength(){
		return Stream.of(
				Arguments.of(0,50,50),
				Arguments.of(50,0,50),
				Arguments.of(50,50,0),
				Arguments.of(101,50,50),
				Arguments.of(50,101,50),
				Arguments.of(50,50,101));
	}	
	
	//�ȼ��໮��
	@ParameterizedTest
	@MethodSource("checkEquals_1")
	@DisplayName("�Ϸ������β���")
	void test_checkEquals_1(int a, int b, int c, String s) {
		assertEquals(s, t.determine(a, b, c));
	}
	static Stream<Arguments> checkEquals_1(){
		return Stream.of(
				Arguments.of(3,4,5, "һ��������"),
				Arguments.of(4,4,5, "����������"),
				Arguments.of(3,3,3, "�ȱ�������"));
	}
	
	@ParameterizedTest
	@MethodSource("checkRelation_1")
	@DisplayName("���Է�������")
	void test_checkRelation_1(int a, int b, int c, String s) {
		assertEquals(s, t.determine(a, b, c));
	}
	static Stream<Arguments> checkRelation_1(){
		return Stream.of(
				Arguments.of(50,10,5, "��������"),
				Arguments.of(10,50,5, "��������"),
				Arguments.of(10,5,50, "��������"));
	}
	
	@ParameterizedTest
	@MethodSource("checkEdgeLength_1")
	@DisplayName("�쳣����")
	void test_checkEdgeLength_1(int a, int b, int c) {
		Executable executable = () -> t.determine(a, b, c);
		assertThrows(IllegalArgumentException.class,executable);
	}
	static Stream<Arguments> checkEdgeLength_1(){
		return Stream.of(
				Arguments.of(110,60,80),
				Arguments.of(60,110,80),
				Arguments.of(60,80,110));
	}
	
}
