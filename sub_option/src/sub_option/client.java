package sub_option;

import java.io.*;
import java.net.*;
import java.util.Scanner; 
 
public class client {
 
   public static void main(String argv[])
      {
	   try{
		    boolean isContinue =true;
			
			while(isContinue)
			{
				//Asking a user for operation Selection
				System.out.println("What kind of operation do you want to choose ? Please type a index number: ");
				boolean isValid =false;
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
				String selected= null;
				while(!isValid){
	
					System.out.println("1. Addition");
					System.out.println("2. Subtraction");
					System.out.println("3. Multiplication");
					System.out.println("4. Division");
					
					int selection = scanner.nextInt();
				
					switch(selection){
					
					 case 1 : 
						 selected ="add";
						
						 isValid=true;
						 break;
					 case 2 :
						 selected ="sub";
						 
						 isValid=true;
						 break;
					 case 3 :
						 selected ="mul";
						 isValid=true;
						 break;
					 case 4 :
						 selected ="div";
						 isValid=true;
						 break;
					 default :
						 System.out.println("Invalid choice : ");
						 isValid=false;
						 break; 
					}
				}
				
				//Asking two numbers for selected operations
				System.out.println("Please enter two numbers for this operation:");
				System.out.println("Num1 :");
				int num1 = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Num2 :");
				int num2= scanner.nextInt();
				
				
			@SuppressWarnings("resource")
			Socket socketClient = new Socket("localhost",6666);
		    System.out.println("Client: "+"Connection Established");	
				
		  //Connecting with Naming Server.
			
			DataOutputStream opToClient = new DataOutputStream(socketClient.getOutputStream());
			opToClient.writeInt(num1);
			opToClient.writeInt(num2);
			opToClient.writeUTF(selected);
			
			//Getting answer from Naming Server
			DataInputStream opInStream = new DataInputStream(socketClient.getInputStream());
			String answer = opInStream.readUTF();
			
			//Printing answer and asking for continuation
			System.out.println(answer);
			System.out.println("Enter 1 if you want to continue or 0 to exit :");
			int operation = scanner.nextInt();
			if(operation==0)
				isContinue=false;
		}
		System.out.println("Exit performed successfully.");
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
	finally{
		//opSocket.close();
	}
}
}