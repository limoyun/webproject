package me.gacl.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListFileServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String uploadFilePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        
        Map<String,String> fileNameMap = new HashMap<String,String>();
        
        listfile(new File(uploadFilePath),fileNameMap);     
        request.setAttribute("fileNameMap", fileNameMap);
        request.getRequestDispatcher("/welcome.jsp").forward(request, response);       
    }
       
    public void listfile(File file,Map<String,String> map){    
        if(!file.isFile()){      
            File files[] = file.listFiles();           
            for(File f : files){              
                listfile(f,map);
            }
        }else{           
            String realName = file.getName().substring(file.getName().indexOf("_")+1);  
            map.put(file.getName(), realName);
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}