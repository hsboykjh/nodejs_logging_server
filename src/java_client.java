package send_client;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class client {
    
	public static void main(String[] args) throws IOException {
		
		//create socket connection ( ip address, port number ) 
		Socket tcpClient = new Socket("localhost", 6000); 
		
		//open file ( local )
		File myFile = new File("FILE_PATH");
		
		//set buffer size based on the size of localfile
        	byte[] mybytearray = new byte[(int) myFile.length()];
         
         	//open input stream of file
        	FileInputStream fis = new FileInputStream(myFile);
        	
        	//buffer inputstream
        	BufferedInputStream bis = new BufferedInputStream(fis);
        	
        	//read file's content
        	bis.read(mybytearray, 0, mybytearray.length);
        	
        	//open output stream
		DataOutputStream os = new DataOutputStream(tcpClient.getOutputStream());
		
		//write on ouput stream
		os.write(mybytearray, 0, mybytearray.length);
        
        	//flush
        	os.flush();
        	
        	//close streams
        	os.close();
        	fis.close();
        	bis.close();
         
         	//close socket connection
        	tcpClient.close();
	}
}
