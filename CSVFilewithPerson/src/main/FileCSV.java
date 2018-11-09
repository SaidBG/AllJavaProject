package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCSV {
	
	private static File file;
	
	private static BufferedReader bufferedReader;
	
	private String separator;
	private boolean hasTitle;
	private List<String> titleList = new ArrayList<>();
	private List<Person> dataList = new ArrayList<>();
	
	public void readTitle() throws IOException {
		titleList.clear();
		String line = "";
		bufferedReader = new BufferedReader(new FileReader(file));
		line = bufferedReader.readLine();
		if(hasTitle) {
			String[] tabString;
			tabString = line.split(separator);
			for(int i = 0 ; i < tabString.length; i++) {
				titleList.add(tabString[i]);
			}
		}
		else {
			System.out.println("This file doesn't have titles");
		}
	}
	
	public void readData() throws IOException {
		dataList.clear();
		String line = "";
		bufferedReader = new BufferedReader(new FileReader(file));
		if(hasTitle) {
			bufferedReader.readLine();
		}
		while(line != null) {
			line = bufferedReader.readLine();
			if(line != null){
				String[] tabString;
				tabString = line.split(separator);
				dataList.add(new Person(tabString[1],tabString[0],tabString[3],Integer.parseInt(tabString[2])));
			}
		}
	}
	
	public void displayTitle() {
		for (String stringList : titleList) {
			System.out.print(stringList + "  ");
		}
	}
	
	public void displayData() {
		for (Person listPerson : dataList) {
			System.out.println(listPerson.toString());
		}
	}
	
	public List<Person> getDataList() {
		return dataList;
	}
	
	public List<String> getTitleList() {
		return titleList;
	}
	
	FileCSV(String filePath, String separator, boolean hasTitle) {
		file = new File(filePath);
		this.separator = separator;
		this.hasTitle = hasTitle;
	}
}
