package microbenchmark.buffers;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


public class Microbenchmark {

	public static void main(String[] args) throws IOException {
		executeBuffer();
		executeInputStream();
	}
	
	
	private static void executeBuffer() throws IOException{
		System.out.println("****** Buffer *********");
		FileInputStream fileInput = new FileInputStream("src/main/resources/prueba.txt");
		
		long start = System.currentTimeMillis();

		BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);
		int i = 0;
		 while(bufferedInput.available()>0){
            bufferedInput.read();
            i++;
         }
		 
		long elapsed = System.currentTimeMillis() - start;
		
	    System.out.println("elapsed time = " + elapsed + "ms (i="+i +")");
	    System.out.println((elapsed * 1000.0) / 1000000 + " microseconds per execution");
	}
	
	
	private static void executeInputStream() throws IOException{
		System.out.println("******* InputStream ******* ");
		
		File file = new File("src/main/resources/prueba.txt");
		byte[] bytes = FileUtils.readFileToByteArray(file);
		
		long start = System.currentTimeMillis();
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		int i = 0;
		 while(byteArrayInputStream.available()>0){
            byteArrayInputStream.read();
            i++;
         }
		 
		long elapsed = System.currentTimeMillis() - start;
	    System.out.println("elapsed time = " + elapsed + "ms (i="+ i +")");
	    System.out.println((elapsed * 1000.0) / 1000000 + " microseconds per execution");
	}

}
