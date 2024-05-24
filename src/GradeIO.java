

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class GradeIO {

	// reads data from a file
	public static String readGrade(String fileName) {
		File myFile = new File(fileName);
		Scanner scan = null;
		// attempt to open the file with the Scanner object
		try {
			scan = new Scanner(myFile);
			String content = "";
			// add each line of the file to the string
			while (scan.hasNext()) {
				content += scan.next() + "\n";
			}
			return content;
		}
		// when the file is not found do this
		catch (FileNotFoundException e) {
			e.printStackTrace();
			e.getMessage(); // Error message for user
			return ""; // function must return a String, even if file not found
		}
		finally {
			// ensure a File object is associated with the Scanner object and
			// close
			if (scan != null) {
				scan.close();
			}
		}
	}

	// creates a file and writes data to it
	// will overwrite files with the same name
	public static void writeGrade(String fileName, String data) {
		// attempt to open a file with PrintWriter object, and write data to the
		// file
		PrintWriter outputFileWriter = null;
		try {
			outputFileWriter = new PrintWriter(fileName);
			outputFileWriter.println(data);
			outputFileWriter.close();
		}
		catch (FileNotFoundException e) {
			e.getMessage();
		}
		finally {
			// ensure that PrintWriter object is closed
			if (outputFileWriter != null)
			outputFileWriter.close();
		}
	}



}
