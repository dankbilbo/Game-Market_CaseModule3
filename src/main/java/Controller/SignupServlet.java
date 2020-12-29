package Controller;

import DAO.AccountDAOImplement;
import Model.Account;
import Service.AccountServiceImplement;

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
    private AccountServiceImplement accountService;
    @Override
    public void init() throws ServletException {
        accountService = new AccountServiceImplement();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        Account account = new Account(username,password,email,bankAccountID,country);
        if (new AccountDAOImplement().insertAccount(account) == 1){
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
            dispatcher.forward(request, response);
        }
    }
}
