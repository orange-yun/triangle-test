package whitebox.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("���ԡ�����")
class TriangleProblemTest {
	TriangleProblem t = new TriangleProblem();
	@Test
	@DisplayName("·�����ǲ���-�׳��쳣")
	void path_test_exception() {
		Executable executable = () -> t.determine(0, 50, 50);
		assertThrows(IllegalArgumentException.class, executable);
	}
	
	@ParameterizedTest
	@MethodSource("Normal")
	@DisplayName("·�����ǲ���-��������")
	void path_test_Normal(int a, int b, int c, String s) {
		assertEquals(s, t.determine(a, b, c));
	}
	static Stream<Arguments> Normal(){
		return Stream.of(
				Arguments.of(50,10,5, "��������"),
				Arguments.of(3,4,5, "һ��������"),
				Arguments.of(4,4,5, "����������"),
				Arguments.of(3,3,3, "�ȱ�������"));
	}

	@Test
	@DisplayName("p-use���ǲ���-�׳��쳣")
	void p_use_test_exception() {
		Executable executable = () -> t.determine(0, 50, 50);
		assertThrows(IllegalArgumentException.class, executable);
	}
	
	@ParameterizedTest
	@MethodSource("puse_Normal")
	@DisplayName("p-use���ǲ���-��������")
	void p_use_test_Normal(int a, int b, int c, String s) {
		assertEquals(s, t.determine(a, b, c));
	}
	static Stream<Arguments> puse_Normal(){
		return Stream.of(
				Arguments.of(50,10,5, "��������"),
				Arguments.of(3,4,5, "һ��������"),
				Arguments.of(4,4,5, "����������"),
				Arguments.of(3,3,3, "�ȱ�������"));
	}
	
}
