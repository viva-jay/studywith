import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class 직사각형_별찍기 {
	private OutputStream captor;

	@BeforeEach
	void setPrintStreamToByteStream(){
		captor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(captor));
	}

	@DisplayName("주어진 숫자에 해당하는 가로 세로 크기를 가진 직사각형을 그릴 수 있다")
	@Test
	void given_two_numbers_then_print_rectangle(){
		printRectangle(5,3);
		String result = captor.toString().trim();

		assertThat(result).contains("*****\r\n*****\r\n*****");
	}

	public void printRectangle(int width, int length){
		for(int lengthIndex = 0; lengthIndex < length; lengthIndex++){
			for(int widthIndex = 0; widthIndex < width; widthIndex++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
