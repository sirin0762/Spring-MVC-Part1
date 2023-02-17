package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회 - START]");

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");             // 단일파라미터 조회
        System.out.println("username = " + username);

        System.out.println("[모든 파라미터 조회]");
        Enumeration<String> parameterNames = request.getParameterNames();     // 파라미터 이름들 조회
        parameterNames.asIterator()
            .forEachRemaining(parameterName -> System.out.println(parameterName + " = " + request.getParameter(parameterName)));

        System.out.println("[이름이 같은 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");     // 복수 파라미터 조회
        Arrays.stream(usernames).forEach(System.out::println);
        response.getWriter().write("ok");
    }

}
