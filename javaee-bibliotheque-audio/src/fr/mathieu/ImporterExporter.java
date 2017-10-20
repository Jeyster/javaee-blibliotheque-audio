package fr.mathieu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImporterExporter {

	private String textToWrite;

	public ImporterExporter(String textToWrite) {
		this.textToWrite = textToWrite;
	}

	public String getTextToWrite() {
		return textToWrite;
	}

	public void setTextToWrite(String textToWrite) {
		this.textToWrite = textToWrite;
	}

	public List<String> importLinesFromFile(String fileName) throws IOException {

		InputStream stream = getClass().getClassLoader().getResourceAsStream("/fr/mathieu/liste-chansons.txt");

		BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

		List<String> stringsList = new ArrayList<>();
		String line;

		while ((line = br.readLine()) != null) {

			String current = line;
			stringsList.add(current);
		}

		br.close();

		return stringsList;

	}

}
