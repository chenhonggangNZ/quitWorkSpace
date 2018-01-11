package com.xinyou.bookstore.book.service;

import com.xinyou.bookstore.book.domain.Book;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "AdminBaseServlet")
public class AdminBaseServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String methodName = null;
        try {
            methodName = request.getParameter("method");
        } catch (Exception e){e.printStackTrace();}
        if (methodName == null || methodName.equals("")) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            String realPath = request.getServletContext().getRealPath("/book_img/");
            try {
                FileItemIterator itemIterator = upload.getItemIterator(request);
                Map<String, String> form = BookService.ParsingForm(realPath, itemIterator);
                request.setAttribute("form", form);
                methodName = form.get("method");
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
        Method method = null;
        try {
            method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (Exception var10) {
            throw new RuntimeException("您要调用的方法：" + methodName + "它不存在！", var10);
        }

        try {
            String result = (String)method.invoke(this, request, response);
            if (result != null && !result.trim().isEmpty()) {
                int index = result.indexOf(":");
                if (index == -1) {
                    request.getRequestDispatcher(result).forward(request, response);
                } else {
                    String start = result.substring(0, index);
                    String path = result.substring(index + 1);
                    if (start.equals("f")) {
                        request.getRequestDispatcher(path).forward(request, response);
                    } else if (start.equals("r")) {
                        response.sendRedirect(request.getContextPath() + path);
                    }
                }
            }

        } catch (Exception var9) {
            throw new RuntimeException(var9);
        }
    }
}
