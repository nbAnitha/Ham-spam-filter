import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SpamDataset {
	
	private List<String> spamEmailFileList = new ArrayList<>();
	
	public List<String> spamEmailToList(String datasetPath) {
		try {
			File[] files = new File(datasetPath).listFiles();
			for (File file : files) {
				if (file.isFile()) {
					spamEmailFileList.add(file.getName());
				}
			}
			
			return spamEmailFileList;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
