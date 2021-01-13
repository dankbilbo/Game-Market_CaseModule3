package Controller;

import Model.Account;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/login/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/login");
            dispatcher.forward(request,response);
        } else if (account.getRole().equals("member")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/app");
            dispatcher.forward(request,response);
        } else if (account.getRole().equals("admin") ) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/admin");
            dispatcher.forward(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
