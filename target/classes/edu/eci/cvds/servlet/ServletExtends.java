/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.servlet;
import edu.eci.cvds.servlet.model.Todo;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Optional;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author 2118887
 */
@WebServlet(
        urlPatterns = "/elServletPleno"
)
public class ServletExtends extends HttpServlet{
    @Override    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Writer responseWriter = resp.getWriter();
       try{
       Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
       String id = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";
       int ide = Integer.parseInt(id);
       Todo all = Service.getTodo(ide);
       ArrayList<Todo> todos = new ArrayList<Todo>();
       todos.add(all);
       responseWriter.write(Service.todosToHTMLTable(todos));
       }catch(java.lang.NumberFormatException e){
        responseWriter.write("requerimiento inválido");
       }catch(java.net.MalformedURLException e){
        responseWriter.write("error interno en el servidor");
       }catch(Exception e ){
        responseWriter.write("requerimiento inválido");
       }
       
       resp.setStatus(HttpServletResponse.SC_OK);
       
       responseWriter.flush();
    }
    @Override    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Writer responseWriter = resp.getWriter();
       try{
       Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
       String id = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";
       int ide = Integer.parseInt(id);
       Todo all = Service.getTodo(ide);
       ArrayList<Todo> todos = new ArrayList<Todo>();
       todos.add(all);
       responseWriter.write(Service.todosToHTMLTable(todos));
       }catch(java.lang.NumberFormatException e){
        responseWriter.write("requerimiento inválido");
       }catch(java.net.MalformedURLException e){
        responseWriter.write("error interno en el servidor");
       }catch(Exception e ){
        responseWriter.write("requerimiento inválido");
       }
       
       resp.setStatus(HttpServletResponse.SC_OK);
       
       responseWriter.flush();
    }
    
}
