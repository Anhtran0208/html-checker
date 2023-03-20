/*
 * The HTMLParser will read all HTML file and check if there is any error in this file. 
 * It has 2 variables: stack is of type StackLL<String> to store all opening tags. 
 * tags is of type "ArrayList<String>" to store all HTML tags.
 * 
 * @author Anh Tran
 * Assignment 4
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class HTMLParser {
  private StackLL<String> stack;
  private ArrayList<String> tags;

  /*
   * Constructor: create HTMLParser with 2 empty stack and tags arraylist
   */
  public HTMLParser(){
	this.stack = new StackLL<>();
	this.tags = new ArrayList<>();
  }

  /*
   * getTagsFromFile method to get all the HTML tags from the file 
   * @param filename: the file that will be read 
   * @return the arraylist that includes all HTML tags
   */
  public ArrayList<String> getTagsFromFile(String filename) throws FileNotFoundException{
	//Code to open a file, then read it through the Scanner
	File infile = new File(filename);
	Scanner dataIn = new Scanner(infile);
	String expression;

	//Go through each line in the file
	while (dataIn.hasNextLine()) {
		//Get the next line
	  expression = dataIn.nextLine();

	  //Split breaks up a String based on where the HTML tags start 
	  String[] line = expression.split(">");

	  //Loop through each String from the array created from the input and add all HTML tags to the arraylist 
	  for(int tagIndex = 0; tagIndex < line.length; tagIndex++){
		if (line[tagIndex].indexOf("<") > 0){
			tags.add(line[tagIndex].substring(line[tagIndex].indexOf("<")));
		}
		else if (line[tagIndex].indexOf("<") == 0){
			tags.add(line[tagIndex]);
		}
	  }
	}
	//Close the Scanner when done; optional, but prevents a warning
	dataIn.close();
	return tags;
}

/*
 * checkValid method to check if there is any error in the file 
 * @param tags that include HTML tags
 * @return true if there is no error
 * @return false if there is an error 
 */
  public boolean checkValid(ArrayList<String> tags){
	//Loop through each tag in tags array 
	for (String tag: tags){
		//If the tag is a closing tag
		if (tag.indexOf("/") > 0 ){
			//check if the stack is empty or not. If the stack is empty, that means there is no matching opening tag, then return false
			if (stack.isEmpty()){
				return false;
			}

			//check if the substring after "/" in the closing tag is the same as the substring after "<" in the opening tag. If not, return false 
			if (!tag.substring(2).equalsIgnoreCase(stack.pop().substring(1))){
				return false;
			}
		}

		//if the tag is an opening tag, push the tag into stack
		else if (tag.charAt(1) != '/'){
			stack.push(tag);
		}
	}

	//check if the stack is empty or not. If the stack is empty, return true. Otherwise, return false;
	if (!stack.isEmpty() ){
		return false;
	}
	else{
		return true;
	}
  }

  //main method 
  public static void main(String[] args) throws FileNotFoundException{
    HTMLParser parser = new HTMLParser();
    ArrayList<String> tags = parser.getTagsFromFile(args[0]);
	boolean result = parser.checkValid(tags);
	if (result == true){
		System.out.println("No error found in the file");
	}
	else{
		System.out.println("Error found in the file");
	}
  }
}
