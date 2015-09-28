import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;
public class Formatter {
	private static String title;
	private static String author;
	private static String page;
	private static String text;
	private static String purpose;
	private static String narrative;
	private static String detail;
	private static Scanner console = new Scanner(System.in);
	public static void main(String[]args) throws FileNotFoundException{
		readSaveFile();
		System.out.println("Book: " + title + " by " + author);
		ask();
		print();
	}
	public static void readSaveFile () throws FileNotFoundException{
		try {
		Scanner text = new Scanner (new File("save.sav"));
		} catch (FileNotFoundException e ){
			PrintStream output = new PrintStream(new File("save.sav"));
			System.out.println("Hi! This program makes it easier to record: Purpose, Narrative, and Detail for Ms. Woehr's class");
				System.out.println("To start, what is the title and author of the book your reading?");
			System.out.print("Title: ");
			title = console.nextLine();
			System.out.print("Author: ");
			author = console.nextLine();
			output.println("A: " + title + " B: " + author);
			
		}
		Scanner text = new Scanner (new File("save.sav"));
		ArrayList<String> titleA = new ArrayList<String>();
		ArrayList<String> authorA = new ArrayList<String>();
		while (text.hasNextLine()){
			String temp = text.nextLine();
			titleA.add(temp.substring(temp.indexOf("A:")+3, temp.indexOf("B:")-1));
			title = titleA.get(0);
			authorA.add(temp.substring(temp.indexOf("B:")+3));
			author = authorA.get(0);
		}
	}
	public static boolean isNumber (String s){
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	public static void ask (){
		System.out.print("What page # is this in? ");
		InputMismatchException e;
		page = console.next();
		while (isNumber(page) == false){
			console.nextLine();
			System.out.print("Only whole numbers! ");
			page = console.next();
		}
		console.nextLine();
		System.out.println("Text: What is this in reference to?");
		text = console.nextLine();
		System.out.println("Purpose: Why you think characters do or say what they do?");
		purpose = console.nextLine();
		System.out.println("Narrative: What happened? Flow of the plot, action, events.");
		narrative = console.nextLine();
		System.out.println("Detail: Minor, focused details of the story.");
		detail = console.nextLine();
	}
	public static void print(){
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		System.out.println("\nHere's what you should copy and paste!\n");
		System.out.println("Book: " + title + " by " + author);
		System.out.println("Date: " + dateFormat.format(date));
		System.out.println("Page: " + Integer.parseInt(page));
		Scanner aut = new Scanner (author);
		aut.next();
		System.out.println("Text: \"" + text + "\" (" + aut.next() + " " + page + ")");
		System.out.println("Purpose: " + purpose);
		System.out.println("Narrative: " + narrative);
		System.out.println("Detail: " + detail);
		System.out.println();
	}
}