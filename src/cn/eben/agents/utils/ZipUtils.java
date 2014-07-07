package cn.eben.agents.utils;

import java.io.File;
import java.io.IOException;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

public class ZipUtils {
	/** 
	 * @author ѹ��ָ����Ŀ¼�Լ���ѹָ����ѹ���ļ�(����ZIP��ʽ). 
	 */  

	    public final static String encoding = "GBK";     
	  
	    /** 
	     * 1.����ѹ��Ŀ¼(֧�ֶ༶)<br> 
	     * 2.����ѹ���ļ�<br> 
	     * 3.���ѹ���ļ���·����·��������, �����Զ�����<br> 
	     *  
	     * @param src 
	     *            ��Ҫ����ѹ����Ŀ¼ 
	     * @param zip 
	     *            ������ɵ�ѹ���ļ���·�� 
	     */  
	    public static void zip(File src, File dest) throws IOException {  
	        Project prj = new Project();  
	        Zip zip = new Zip();  
	        zip.setProject(prj);  
	        zip.setDestFile(dest);  
	        FileSet fileSet = new FileSet();  
	        fileSet.setProject(prj);  
	        if (src.isFile()) {  
	            fileSet.setFile(src);  
	        } else {  
	            fileSet.setDir(src);  
	        }  
	        zip.addFileset(fileSet);  
	        zip.execute();  
	    }  
	  
	    /** 
	     * ��ָ����ѹ���ļ���ѹ��ָ����Ŀ��Ŀ¼��. ���ָ����Ŀ��Ŀ¼�����ڻ��丸·��������, �����Զ�����. 
	     *  
	     * @param zip 
	     *            �����ѹ��ѹ���ļ� 
	     * @param dest 
	     *            ��ѹ������Ŀ¼Ŀ¼ 
	     */  
	    public static void unzip(File src, File dest) throws IOException {  
	        Project proj = new Project();  
	        Expand expand = new Expand();  
	        expand.setProject(proj);  
	        expand.setTaskType("unzip");  
	        expand.setTaskName("unzip");  
	        expand.setSrc(src);  
	        expand.setDest(dest);  
	        expand.setEncoding(encoding);//���ñ��벻���٣������ļ����������  
	        expand.execute();  
	    }  
	  
	      
	  
	  
	  
//	    public static void main(String[] args) {  
//	        // D:\\evidence\\20120712\\����ص�1997_2012071213114144\\����С˵��_www.xs8.cn  
//	        try {  
//	            ZipUtils  
//	                    .zip(  
//	                            new File(  
//	                                    "D:\\evidence\\20120712\\����ص�1997_2012071213114144\\����С˵��_www.xs8.cn"),  
//	                            new File(  
//	                                    "D:\\evidence\\20120712\\����ص�1997_2012071213114144\\����.zip"));  
//	              
//	              
//	              
//	            ZipUtils  
//	            .unzip(new File(  
//	            "D:\\evidence\\20120712\\����ص�1997_2012071213114144\\����.zip"),new File(  
//	            "D:\\test\\"));  
//	        } catch (IOException e) {  
//	            // TODO Auto-generated catch block  
//	            e.printStackTrace();  
//	        }  
//	    }  

}
