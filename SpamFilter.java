import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SpamFilter {
	
	private SpamWords spamWords = new SpamWords();
	private List<String> spamAllTags = new ArrayList<>();
	private String categorynames[] = spamWords.spamData().split("----");
	private String categorytitle = "";
	private String evidence = "";
	private HashMap<String, String> categoryAndSpamWords = new HashMap<>();
	
	
	private void spamWordFilter() {
		
		for (int i = 0; i < categorynames.length; i++) {
			String categoryline = categorynames[i];
			String categorySpamWords[] = categoryline.split("\t");
			categorytitle = categorySpamWords[0];
			for (int p = 1; p < categorySpamWords.length; p++) {
				spamAllTags.add(categorySpamWords[p]);
				categoryAndSpamWords.put(categorySpamWords[p], categorytitle);
			}
		}
	}
	
	public void spamAndHam(String filename, String datasetPath, List<String> results, String spamData) {
		int spam = 0, ham = 0;
		try {
			
			spamWordFilter();
			
			for (File file : new File(datasetPath).listFiles()) {
				if (file.isFile()) {
					String fileName = file.getName();
					Scanner scan = new Scanner(new File(datasetPath + fileName));
					String allFileData = "";
					while (scan.hasNext()) {
						allFileData = allFileData + scan.nextLine();
					}
					int tempValue = 0;

					for (String match : spamAllTags) {
						if (allFileData.contains(match)) {
							tempValue++;
						}
					}
					if (tempValue != 0) {
						spam++;
					} else {
						ham++;
					}
				}
			}
			
			System.out.println("Number of spam messages is: " + spam + " and ham is: " + ham);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void evidence(String filename, String datasetPath, String spamdata) {
		try {
			
				spamWordFilter();
				String title = "";
				File file = new File(datasetPath + filename);
				if (file.isFile()) {		
					Scanner scan = new Scanner(new File(datasetPath + filename));
					String fileSingleData = "";
					while (scan.hasNext()) {
						fileSingleData = fileSingleData + scan.nextLine();
					}

					for (String match : spamAllTags) {
						if (fileSingleData.contains(match)) {
							title += categoryAndSpamWords.get(match);
							evidence += match + ", ";
							
						}
					}
				}

			if (!evidence.isEmpty()) {
				System.out.println(filename + " is " + title + " spam");
				System.out.println("Evidence: " + evidence);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
