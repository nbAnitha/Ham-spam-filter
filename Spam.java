import java.util.List;

public class Spam {
	
	public static void main(String[] args) {
		
		
		String filename = "";
		String datasetPath = null;
		
		try {
			datasetPath = args[0];
			filename = args[1];
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		SpamWords spamWords = new SpamWords();
		SpamDataset spamDataset = new SpamDataset();
		SpamFilter spamFilter = new SpamFilter();
		
		try {
			String spamdata = spamWords.spamData();
			List<String> spamEmailFileList = spamDataset.spamEmailToList(datasetPath);
			spamFilter.evidence(filename, datasetPath, spamdata);
			spamFilter.spamAndHam(filename, datasetPath, spamEmailFileList, spamdata);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
