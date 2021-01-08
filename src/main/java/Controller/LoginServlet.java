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

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private AccountDAOImplement accountDAO;
    @Override
    public void init() throws ServletException {
        accountDAO = new AccountDAOImplement();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account)session.getAttribute("account");
        if (account == null){
            RequestDispatcher dispatcher = req.getRequestDispatcher("/login/login.jsp");
            dispatcher.forward(req,resp);
        }
        if (account.getRole().equals("member")){
            resp.sendRedirect("/app");
        }else{
            resp.sendRedirect("/admin");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = accountDAO.getAccount(username,password);
        if (account != null){
            HttpSession session = req.getSession();
            session.setAttribute("account",account);
            String role = account.getRole();
            if (role.equals("member")){
                resp.sendRedirect("/app");
            }else{
                resp.sendRedirect("/admin");
            }
        }else{
            req.setAttribute("message", "wrong username or password");
            RequestDispatcher dispatcher = req.getRequestDispatcher("login/login.jsp");
            dispatcher.forward(req,resp);
        }
    }
}
