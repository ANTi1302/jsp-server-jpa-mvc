/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.fit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "RemoveProductControl", urlPatterns = {"/remove"})
public class RemoveProductControl extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        Cookie arr[] = request.getCookies();
        String txt = "";
        for (Cookie o : arr) {
            if (o.getName().equals("productID")) {
                txt = txt + o.getValue();
                o.setMaxAge(0);
                response.addCookie(o);
            }
        }
        String ids[] = txt.split("/");
        String txtOutPut = "";
        int check = 0;
        for (int i = 0; i < ids.length; i++) {
            if (!ids[i].equals(id)) {
                if (txtOutPut.isEmpty()) {
                    txtOutPut = ids[i];
                } else {
                    txtOutPut = txtOutPut + "/" + ids[i];
                }
            }
        }
        if (!txtOutPut.isEmpty()) {
            Cookie c = new Cookie("productID", txtOutPut);
            c.setMaxAge(60 * 60 * 24);
            response.addCookie(c);
        }
        response.sendRedirect("print");
    }

   

}
