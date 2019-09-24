package sub_option;

import java.io.*;

import java.net.*;

 
public class server{

public static void main(String [] args) throws Exception{

    //System.out.println(" Server is Running  " );

         while(true)

         {

        ServerSocket mysocket = new ServerSocket(6666);

        Socket connectionSocket = mysocket.accept();

 

            //BufferedReader reader =

            //new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            //BufferedWriter writer= 

            //new BufferedWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));

 

            try{

            System.out.println("Getting Addition Request.. ");

            DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());

            int num1 = inFromClient.readInt();

            int num2 = inFromClient.readInt();


            PrintWriter pr = new PrintWriter(connectionSocket.getOutputStream(),true);

           int answer=num1-num2 ;



    
          DataOutputStream outFromClient = new DataOutputStream(connectionSocket.getOutputStream());

         //String answer = null;
          outFromClient.writeUTF("Answer of operation is :"+answer);
         }catch(Exception e){

          e.printStackTrace();

        }finally{

       connectionSocket.close();

       mysocket.close();

}

}

}

 

}

