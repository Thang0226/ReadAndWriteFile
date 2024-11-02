import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
	public static void main(String[] args) {
		ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
		List<Integer> numbers = readAndWriteFile.readFile("files/numbers.txt");
		int maxValue = findMaxValue(numbers);
		readAndWriteFile.writeFile("files/result.txt", maxValue);
	}

	public List<Integer> readFile(String filePath) {
		List<Integer> list = new ArrayList<>();
		try (
				FileReader file = new FileReader(filePath);
				BufferedReader br = new BufferedReader(file);
		) {
			String line = "";
			while ((line = br.readLine()) != null) {
				list.add(Integer.parseInt(line));
			}
		} catch (Exception e) {
			System.out.println("File not found OR Content error");
		}
		return list;
	}

	public void writeFile(String filePath, int max) {
		try (
				FileWriter writer = new FileWriter(filePath, true);
				BufferedWriter br = new BufferedWriter(writer);
		) {
			br.write("Maximum value is: " + max + "\n");
		} catch (IOException e) {
			System.out.println("File not found!");
		}
	}

	public static int findMaxValue(List<Integer> list) {
		int max = list.get(0);
		for (int number : list) {
			if (number > max) {
				max = number;
			}
		}
		return max;
	}
}
