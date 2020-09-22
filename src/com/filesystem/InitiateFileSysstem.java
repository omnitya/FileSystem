/**
 * 
 */
package com.filesystem;

import java.util.Scanner;

/**
 * @author omnitya.jha
 *
 */
public class InitiateFileSysstem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String currentDirectory = "/opt/test";
		FileSystem fileSys = new FileSystemImpl(currentDirectory);
		int opt = 0;
		homeScreen();
		while(true) {
			opt = homeScreen();
			switch (opt) {
			case 0:
				break;
			case 1:
				System.out.println(fileSys.getCurrentDirectory());
				break;
				
			case 2:
				System.out.println(fileSys.getCurrentDirectoryListing());
				break;
				
			case 3:
				System.out.println("Enter folder name :");
				Scanner s = new Scanner(System.in);
				String input = s.next();
				fileSys.createDirectory(input);
				System.out.println("Created folder!");
				break;
				
			case 4:
				System.out.println("Enter directory name to change :");
				Scanner s1 = new Scanner(System.in);
				String input1 = s1.next();
				fileSys.changeDirectory(input1);
				System.out.println("Changed!");
				break;
				
			case 5:
				System.out.println("Enter file name :");
				Scanner s2 = new Scanner(System.in);
				String input2 = s2.next();
				fileSys.createFile(input2);
				System.out.println("Created file!");
				break;
				
			case 6:
				System.out.println("Enter file name :");
				Scanner s3 = new Scanner(System.in);
				String input3 = s3.next();
				fileSys.deleteFile(input3);
				System.out.println("Deleted file!");
				break;
				
			case 7:
				System.exit(0);
				break;

			default:
				break;
			}
		}
			
	}
	
	private static int homeScreen() {
		System.out.println("\n\n\n");
		System.out.println("choose from options, press 7 to quit :");
		System.out.println("1. pwd");
		System.out.println("2. ls");
		System.out.println("3. mkdir");
		System.out.println("4. cd");
		System.out.println("5. touch");
		System.out.println("6. rm");
		System.out.println("7. quit");
		
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

}
