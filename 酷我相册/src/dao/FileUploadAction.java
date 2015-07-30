package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport{
	private File uploadFile;
	private String uploadFileContentType;
	private String uploadFileFileName;
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String execute() throws Exception{
		InputStream is=new FileInputStream(uploadFile);
		String userinfo="123";
		String uploadPath=ServletActionContext.getServletContext().getRealPath("/upload");//�����ϴ�Ŀ¼
		File toFile=new File(uploadPath,this.getFileName()+userinfo+".png");
		OutputStream os=new FileOutputStream(toFile);
//		String path=""upload\"+getFileName()+userinfo+".png"";
		String path="upload"+"\\"+this.getFileName()+userinfo+".png";
		System.out.println("�Ǻ���"+toFile);
		System.out.println("����·����"+path);
		
		byte[] buffer=new byte[1024];
		int length=0;
		while((length=is.read(buffer))>0){
			os.write(buffer, 0, length);
		}
		is.close();
		os.close();
		return SUCCESS;
		
	}
	private String getFileName() {
		// TODO Auto-generated method stub
		java.util.Date dt = new Date();  
		long lSysTime1 = dt.getTime() / 1000;   //�õ�������Date���͵�getTime()���غ�����  
		SimpleDateFormat sdf= new SimpleDateFormat("MMddyyyyHHmmss");  
		//ǰ���lSysTime���������ȳ�1000�õ�����������תΪjava.util.Date����  
		java.util.Date dt1 = new Date(lSysTime1 * 1000);    
		String sDateTime = sdf.format(dt1);  //�õ���ȷ����ı�ʾ��08/31/2006 21:08:00  
		System.out.println(sDateTime);  

		return sDateTime;
	}
	
	

}
