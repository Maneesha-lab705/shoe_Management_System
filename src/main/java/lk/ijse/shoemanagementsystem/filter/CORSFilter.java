package lk.ijse.shoemanagementsystem.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class CORSFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException, ServletException {
       String origin = req.getHeader("Origin");
        System.out.println(origin);
       if (origin.contains(getServletContext().getInitParameter("origin"))){
           res.setHeader("Access-Control-Allow-Origin",origin);
           res.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE,HEADER");
           res.setHeader("Access-Control-Allow-Headers","Content-Type,Authorization");
           res.setHeader("Access-Control-Expose-Headers","Content-Type,Authorization");
           res.setHeader("Access-Control-Allow-Credentials", "true");
           res.setHeader("Access-Control-Max-Age", "3600");
       }
       chain.doFilter(req,res);
    }
}