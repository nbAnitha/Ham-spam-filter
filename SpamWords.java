import java.io.File;
import java.util.Scanner;

public class SpamWords {
	
	private String spamWordsFile = "spamWords/spamwords.txt";
	
	public String spamData() {
		try {
			File file = new File(spamWordsFile);
			Scanner scanner = new Scanner(file);
			String spamData = "";
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				if (!line.isEmpty()) {
					spamData += line;
				} else {
					spamData += "\t";
				}
			}
			
			scanner.close();
			
			return spamData;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
