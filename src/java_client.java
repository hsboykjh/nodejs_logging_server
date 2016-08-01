package send_client;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class client {
    
	public static void main(String[] args) throws IOException {
		 
		Socket tcpClient = new Socket("localhost", 6000); 
		File myFile = new File("FILE_PATH");
        byte[] mybytearray = new byte[(int) myFile.length()];
         
        FileInputStream fis = new FileInputStream(myFile);
        BufferedInputStream bis = new BufferedInputStream(fis);
        bis.read(mybytearray, 0, mybytearray.length);
        
		DataOutputStream os = new DataOutputStream(tcpClient.getOutputStream());
		
		os.write(mybytearray, 0, mybytearray.length);
        
        os.flush();
        os.close();
        fis.close();
        bis.close();
         
        tcpClient.close();
    }
}
