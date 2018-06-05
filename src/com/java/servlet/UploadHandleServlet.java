package com.java.servlet;  

import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.util.List;  

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

import org.apache.commons.fileupload.FileItem;  
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload;  

/** 
 *  
 * @author zero 
 * 
 */  
public class UploadHandleServlet extends HttpServlet {  
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
          
System.out.println("get the request from the page....");  
          
        String path = req.getRealPath("/upload");//create a path to save the file uploaded  
          
System.out.println(path);  
          
        File file = new File(path);  
        file.mkdirs();  
            
        DiskFileItemFactory factory = new DiskFileItemFactory();    
        factory.setRepository(file);   //set temporary file  
        factory.setSizeThreshold(1024*1024);//set temporary file's size  
          
        ServletFileUpload upload = new ServletFileUpload(factory);  
        upload.setHeaderEncoding("UTF-8");//set the encoding language  
          
        try {  
            List<FileItem> list = (List<FileItem>)upload.parseRequest(req);  //get the item list from the from label  
      
            for(FileItem item : list) {  
                String name = item.getFieldName();   //get the file(field or real file)'s name  
                if(item.isFormField()) {  
System.out.println("just a simple field....");  
                String value = item.getString();  
System.out.println(name + " = " + value );  
                    req.setAttribute(name, value);  
                }else{  
                     String value = item.getName();//this item is real file  
                       
System.out.println("got a real file");        

                     int start = value.lastIndexOf("\\");  
                     String filename = value.substring(start+1);//获得真正的文件名字，通常这一步转化只有在使用Opera浏览器时才需要使用  
                       
System.out.println("file name : " + filename);  
                      
                     req.setAttribute(name,  filename);  
                      
                     File f1 = new File(path,filename);  
                       
                     OutputStream os = new FileOutputStream(f1);  
                     InputStream is = item.getInputStream();  
                       
                     byte[] buffer = new byte[400];  
                     int length;  
                       
                     while((length = is.read(buffer))!=-1) {  
                         os.write(buffer, 0, length);  
                     }  
                       
                     is.close();  
                     os.close();  
System.out.println("generate a file in the server.....");  
                    req.getRequestDispatcher("welcome.jsp?&fileName=upload/" + filename).forward(req, resp);  
                }  
            }  
        }catch(Exception e) {  
            e.printStackTrace();  
        }  
          
    }  
      
    @Override  
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){  
        try {  
            doGet(req, resp);  
        } catch (ServletException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  