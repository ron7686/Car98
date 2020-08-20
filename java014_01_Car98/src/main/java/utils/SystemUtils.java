package utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialClob;

public class SystemUtils {

	public static Blob fileToBolb(String filePath) {  //非文字檔
		Blob blob = null;
		try(
				FileInputStream fis = new FileInputStream(filePath);
				BufferedInputStream bfi = new BufferedInputStream(fis);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				){
				int len =0;
				byte[] b = new byte [512];
				while((len=bfi.read(b))!=-1) {
					baos.write(b, 0, len);
				}
				byte [] b0 =baos.toByteArray();
				blob = new SerialBlob(b0);
				
		}catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return blob;
	}

	public static Clob fileToClob(String filePath,String encoding) {  //純文字檔
		Clob clob =null;
		try(
				FileInputStream fis = new FileInputStream(filePath);
				InputStreamReader isr = new InputStreamReader(fis,encoding);
				BufferedReader bir = new BufferedReader(isr);
//				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				CharArrayWriter caw = new CharArrayWriter();
				){
				int len =0;
				char[] c = new char [512];
				while((len=bir.read(c))!=-1) {
					caw.write(c, 0, len);
				}
				char[] c0 =caw.toCharArray();
				clob = new SerialClob(c0);
				
		}catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return clob;
	}

}
