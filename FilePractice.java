/*Program creates a file that consist of records the user enters
 *adds more records by append then use tokenizer to convert
 *to proper type. Then does some math to give a raise to each person
 */
package homework5;

import java.io.*;
import java.util.StringTokenizer;

public class FilePractice
{
	private static String filename = "dbs3.txt";
	public static void main(String[] args) throws java.io.IOException
	{
		String[] records = new String[7];//array of the first 7 records
	
		FileWriter wf = new FileWriter(filename);//for first 7 records
		BufferedWriter bw = new BufferedWriter(wf);
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);//for reading what user enters
		
		System.out.println("Enter 7 records that includes:");
		System.out.println("First Name Last Name ID Number Age"+
				" Salary Full/Part time status");
		
		//for loop to read in the records the user enters & writes to file
		for (int i= 0; i< records.length;i++)
		{
			records[i] = br.readLine();
			bw.write(records[i]+"\n");
			
		}//end for loop
		bw.close();//close bufferedwriter
		
		readFile();//call method that reads file
		
		//new filewriter for append
		FileWriter fw1 = new FileWriter(filename, true);
		BufferedWriter bw1 = new BufferedWriter(fw1);
		
		System.out.println("\n\nEnter 3 addition records");
		
		//new array for addition records
		String[] addRecords = new String[3];
		
		//for loop for addition records
		for(int i = 0; i < addRecords.length;i++)
		{
			addRecords[i] = br.readLine();
			bw1.write(addRecords[i] +"\n");
		}//end for loop
		bw1.close();//close reader that uses append mode
		br.close();//close reader reading in users input

		readFile();//call method that reads file
		
		tokenFiles();//call method of tokenized files		
	}//end main 
	//method that reads the file
	private static void readFile() throws IOException
	{
		String s1;
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		
		System.out.println("\ndbs3.txt File");
		while ((s1 = br.readLine())!=null)
		{
			System.out.println(s1);
		}//end while loop to read files
		
		br.close();//close the buffered reader
	}//end method readFile()
	//method that uses tokenizer
	private static void tokenFiles() throws IOException
	{
		FileReader fr = new FileReader(filename);
		BufferedReader br1 = new BufferedReader(fr);
		
		Double[] salaries = new Double[10];//array for salary
		Integer[] id = new Integer[10];//array for id
		Integer[] age = new Integer[10];//array for age
		String[] fName = new String[10];//array for first name
		String[] lName = new String[10];//array for last name
		String[] status = new String[10];//array for status
		Double[] raises = new Double[10];//array for the raised salary
		String s1;//string for readLine of files
		int i = 0;//index for loop of arrays
		
		System.out.println("\nWith a 2% raise\n");
		//while loop to convert to proper type
		while ((s1 = br1.readLine())!=null && i<10)
		{
			StringTokenizer st = new StringTokenizer(s1);//create new obj tokenizer
			fName[i] = st.nextToken();
			lName[i] = st.nextToken();
			id[i] = Integer.parseInt(st.nextToken());
			age[i] = Integer.parseInt(st.nextToken());				
			salaries[i] = Double.parseDouble(st.nextToken());
			status[i] = st.nextToken();
			
			System.out.println(fName[i]+" "+ lName[i]+" "+ id[i]+
						" "+ age[i]+" "+salaries[i]+" "+status[i]);	
			
			raises[i]= (salaries[i]*.02) +salaries[i];//calculate new salaries
			System.out.println("Salary with raise: " +raises[i]);//print raise amount
			i++;
		}//end while loop convert to proper type
		br1.close();//close this buffered reader
	}//end meethod tokenFiles()
}//end class FilePractice
