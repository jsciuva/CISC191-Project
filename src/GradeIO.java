

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

/**
 * 
 * Lead Author(s):
 * 
 * 
 * @author Jamie Sciuva
 * @author
 *         <<add additional lead authors here, with a full first and last name>>
 * 
 *         Other contributors:
 *         <<add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 * 
 *         References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         Gaddis, T. (2015). Starting out with Java: From control structures
 *         through objects. Addison-Wesley.
 * 
 *         <<add more references here>>
 * 
 *         Version/date:
 * 
 *         Responsibilities of class: Holds some functions for reading and
 *         writing to and from a file and a website
 * 
 */
/**
 */

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
				content += scan.next();
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

//	// will create a file or append data to an existing file
//	public static void appendTestResult(String fileName, String data) {
//		// creates a new File object using fileName
//		// creates a new FileWriter object using File object
//		// creates a new PrintWriter object using the FileWriter object and sets
//		// autoFlush to on
//		PrintWriter outputFileWriter = null;
//		try {
//			outputFileWriter = new PrintWriter(
//					new FileWriter(new File(fileName), true));
//			// write data to the file
//			outputFileWriter.println(data);
//		}
//		catch (IOException e) {
//			e.getMessage();
//		}
//		finally {
//			// ensure that PrintWriter object is closed
//			if (outputFileWriter != null) {
//				outputFileWriter.close();
//			}
//		}
//	}


}
