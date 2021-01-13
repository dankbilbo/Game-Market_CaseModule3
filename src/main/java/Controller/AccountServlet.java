package Controller;

import DAO.AccountDAOImplement;
import Model.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/account")
public class AccountServlet extends HttpServlet {
    private AccountDAOImplement accountDAO;
    @Override
    public void init() throws ServletException {
        accountDAO = new AccountDAOImplement();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String action = req.getParameter("action");
            if (action == null){
                action = "";
            }
            switch (action){
                case "updatepass":
                    viewUpdate(req,resp);
                    break;
                default:
                    viewProfile(req,resp);
            }
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("account/changepass.jsp");
        dispatcher.forward(req,resp);
    }

    private void viewProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("account/profile.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        update(req,resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        String bankAccount = req.getParameter("bankaccount");
        Account accountSS = (Account)session.getAttribute("account");
        int id = accountSS.getId();
        String role = accountSS.getRole();
        Account account = new Account(id,username,password,email,country,bankAccount,role);
        if(accountDAO.updateAccount(account) == 1){
            req.setAttribute("message", "update successfully");
            RequestDispatcher dispatcher = req.getRequestDispatcher("account/changepass.jsp");
            dispatcher.forward(req,resp);
            session.setAttribute("account",account);
        }else {
            req.setAttribute("message", "update unsuccessfully");
            RequestDispatcher dispatcher = req.getRequestDispatcher("account/changepass.jsp");
            dispatcher.forward(req,resp);
        }
    }
}
