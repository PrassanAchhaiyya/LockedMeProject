package simplilearnFinalProject;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LockedMe {
	static final String projectFilesPath="C:\\Users\\C Prassan\\Desktop\\LockedMeFiles";
	/**
	 * Displays menu for end users
	 */
	public static void displayMenu() {
		System.out.println("********************************************");
		System.out.println("\tWELCOME TO LockedMe.com secure app");
		System.out.println("\tDeveloped by Prassan Achhaiyya");
		System.out.println("********************************************");
		System.out.println("\t1. Display all the files");
		System.out.println("\t2. Add a new file");
		System.out.println("\t3. Delete Files");
		System.out.println("\t4. Search file");
		System.out.println("\t5. Exit");
		System.out.println("********************************************");
	}
	/**
	 * this method retrieves all the files
	 */
	public static void getAllFiles() {
		File folder =new File(projectFilesPath);
		File[] listOfFiles = folder.listFiles();
		if(listOfFiles.length>0)
		{
			System.out.println("FILES LIST");
			for(var l:listOfFiles) {
				System.out.println(l.getName());
			}
		}else {
			System.out.println("Folder is empty");
		}
	}
	/**
	 * this method will create a file
	 */
	public static void createFiles() {
		try {
			Scanner obj = new Scanner(System.in);
			String fileName;
			System.out.println("Enter the file name");
			fileName=obj.nextLine();

			int linesCount;
			System.out.println("Enter how many lines");
			linesCount=Integer.parseInt(obj.nextLine());
			FileWriter fw=new FileWriter(projectFilesPath+"\\"+fileName);
			//Read line by line from user
			for(int i=1;i<=linesCount;i++) {
				System.out.println("enter file line");
				fw.write(obj.nextLine()+"\n");
			}
			System.out.println("file created successfully");
			fw.close();
		}catch(Exception ex) {
			System.out.println("error : "+ex.getMessage());
		}

	}
	/**
	 * this method will delete file from directory
	 */
	public static void deleteFiles() {
		try {
			Scanner obj = new Scanner(System.in);
			String fileName;
			getAllFiles();
			System.out.println("\nEnter the file name to be deleted");
			fileName=obj.nextLine();
			File f = new File(projectFilesPath+"\\"+fileName);
			if(f.exists()) {
				f.delete();
				System.out.println("File deleted");
			}else {
				System.out.println("File doesnt exist");
			}
		}catch(Exception ex){
			System.out.println("error "+ex.getMessage());
		}

	}
	/**
	 * this method is used to search for a file
	 */
	public static void searchFiles() {
		try
		{
			Scanner obj=new Scanner(System.in);
			String filename;
			System.out.println("Enter the file name to be searched");
			filename=obj.nextLine();
			ArrayList<String> allFileNames = new ArrayList<String>();
			File folder = new File(projectFilesPath);
			File[] listOfFiles=folder.listFiles();
			if(listOfFiles.length>0)
			{
				for(var l:listOfFiles)
				{
					allFileNames.add(l.getName());
				}
			}
			if(allFileNames.contains(filename)) {
				System.out.println("File found");
			}else {
				System.out.println("File not found");
			}
		}
		catch(Exception ex) {
				System.out.println("error : "+ex.getMessage());
		}

	}

}
