package com.example.webservlet.webservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = false, value = {"/not-async"})
public class WebServletNotAsyncSupported extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        
        writer.println("Entry doget() ==> thread name: " + Thread.currentThread().getName());
        writer.println("<progress> id='progress' max='100'></progress>");
        int i = 0;
        while (i <= 100) {
            writer.println("<script>document.getElementById('progress').value = \"" + i++ + "\"</script>");
            writer.flush();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }

        writer.println("<script>document.getElementById('progress').style.display = 'none'</script>");
        writer.println("Exit doget() ==> thread name: " + Thread.currentThread().getName());
        writer.flush();
        writer.close();
    }    
    
}
