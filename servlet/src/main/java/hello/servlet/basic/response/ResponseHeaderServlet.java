package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [HTTP 응답 코드 지정]
        response.setStatus(HttpServletResponse.SC_OK);

        // [헤더 조작]
        response.setHeader("Content-Type", "text/plain");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");

        // [바디 조작]
        response.getWriter().write("ok");

        // [Content-Type, Encoding, Length]
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        response.setContentLength(2);

        // [Cookie]
        Cookie cookie = new Cookie("cookieName", "cookieValue");
        cookie.setMaxAge(600);
        response.addCookie(cookie);

        // [Redirect]
        response.sendRedirect("/hello");
        response.setStatus(HttpServletResponse.SC_FOUND);
        response.setHeader("Location", "/hello");
    }

}
