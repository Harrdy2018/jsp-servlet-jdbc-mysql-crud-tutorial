package net.javaguides.usermanagement.web;

import net.javaguides.usermanagement.dao.UserDAO;
import net.javaguides.usermanagement.model.User;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="User", urlPatterns = "/")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private UserDAO userDAO;

    @Override
    public void init(){
        userDAO=new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post request "+request.getServletPath());
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getServletPath();
        System.out.println("get request "+action);
        switch (action){
            case "/new":
                showNewForm(request,response);
                break;
            case "/insert":
                insertUser(request,response);
                break;
            case "/update":
                updateUser(request,response);
                break;
                case "/delete":
                    deleteUser(request,response);
                break;
            case "/edit":
                showEditForm(request,response);
                break;
            default:
                listUser(request,response);
                break;
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("execute listUser function");
        List<User> users=new ArrayList<>();

        users=userDAO.selectAllUser();
        request.setAttribute("listUser", users);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/user-list.jsp");
        dispatcher.forward(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("execute showNewForm function");
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/user-form.jsp");
        dispatcher.forward(request,response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("execute insertUser function");
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String country=request.getParameter("country");

        userDAO.insertUser(new User(name,email,country));
        response.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("execute showEditForm function");
        int id=Integer.parseInt(request.getParameter("id"));

        User existingUser=userDAO.selectUser(id);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request,response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("execute updateUser function");
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String country=request.getParameter("country");

        userDAO.updateUser(new User(id,name,email,country));
        response.sendRedirect("list");
    }



    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("execute deleteUser function");
        int id=Integer.parseInt(request.getParameter("id"));

        userDAO.deleteUser(id);
        response.sendRedirect("list");
    }
}
