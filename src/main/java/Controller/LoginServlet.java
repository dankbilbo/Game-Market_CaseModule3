package Controller;

import Model.Account;
import DAO.AccountDAOImplement;
import Service.AccountServiceImplement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/app")
public class LoginServlet extends HttpServlet {
    private AccountServiceImplement accountService;
    private AccountDAOImplement accountDAO;
    @Override
    public void init() throws ServletException {
        accountService = new AccountServiceImplement();
        accountDAO = new AccountDAOImplement();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        boolean isadmin = username.equals("admin") && password.equals("admin") ;
        boolean isUser = accountService.validateLogin(username,password);
        if (isadmin){
            response.sendRedirect("app/adminController.jsp");
        }else if(isUser){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            RequestDispatcher dispatcher = request.getRequestDispatcher("app/homepage.jsp");
//            response.sendRedirect("app/homepage.jsp");
            dispatcher.forward(request,response);
        }else{
            request.setAttribute("message", "Wrong username or password !!!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("http://localhost:8080/");
            dispatcher.forward(request,response);
        }

    }
}
