package Controller;

import DAO.AccountDAOImplement;
import Model.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.channels.AcceptPendingException;

@WebServlet(urlPatterns = "/signup")
public class SignupServlet extends HttpServlet {
    AccountDAOImplement accountDAO;
    @Override
    public void init() throws ServletException {
        accountDAO = new AccountDAOImplement();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("signup.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        signup(request,response);
    }

    private void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String bankAccountID = request.getParameter("bankAccountID");
        String country = request.getParameter("country");
        String role = request.getParameter("role");
        Account account = new Account(username,password,email,bankAccountID,country,role);
        if (new AccountDAOImplement().insertAccount(account) == 1){
            request.setAttribute("message", "Done");
            RequestDispatcher dispatcher = request.getRequestDispatcher("signup/signup.jsp");
            dispatcher.forward(request,response);
        }else {
            request.setAttribute("message", "Wrong input try again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("signup/signup.jsp");
            dispatcher.forward(request,response);
        }
    }
}
