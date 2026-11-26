import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class HM3_3 {

	public static void main(String[] args) throws IOException {
		example1();
		example2();
		example3();
	}

	// 範例一：使用 java.lang 的 String 類別
	private static void example1() {
		String message = "Hello, Java!";
		System.out.println("範例一：字串長度 = " + message.length());
		System.out.println("轉成大寫：" + message.toUpperCase());
	}

	// 範例二：使用 java.util 的 ArrayList 類別
	private static void example2() {
		ArrayList<String> fruits = new ArrayList<>(Arrays.asList("蘋果", "香蕉"));
		fruits.add("橘子");
		System.out.println("範例二：水果清單 = " + fruits);
	}

	// 範例三：使用 java.io 類別讀取記憶體中的文字
	private static void example3() throws IOException {
		String text = "第一行\n第二行";
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8)),
				StandardCharsets.UTF_8))) {
			System.out.println("範例三：讀取文字");
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
}
