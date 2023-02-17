package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Locale;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
    }

    private static void printStartLine(HttpServletRequest request) {
        System.out.println("------------------- Request Method Start -------------------" );
        String method = request.getMethod();
        System.out.println("method = " + method);

        String protocol = request.getProtocol();
        System.out.println("protocol = " + protocol);

        String scheme = request.getScheme();
        System.out.println("scheme = " + scheme);

        String requestUrl = request.getRequestURL().toString();
        System.out.println("requestUrl = " + requestUrl);

        String requestUri = request.getRequestURI();
        System.out.println("requestUri = " + requestUri);

        String queryString = request.getQueryString();
        System.out.println("queryString = " + queryString);

        String isSecure = String.valueOf(request.isSecure());
        System.out.println("isSecure = " + isSecure);
        System.out.println("------------------- Request Method End -------------------" );
    }

    private void printHeaders(HttpServletRequest request) {
        System.out.println("------------------- Request Header Start -------------------" );
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println("headerName = " + headerName));
        System.out.println("------------------- Request Header End -------------------" );
    }

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("------------------- Request HeaderUtils Start -------------------" );

        System.out.println("[HOST 편의 조회]");
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        System.out.println("serverName = " + serverName);
        System.out.println("serverPort = " + serverPort);
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        Locale locale = request.getLocale();
        System.out.println("locale = " + locale);
        System.out.println();

        System.out.println("[Cookie 편의 조회]");
        if (request.getCookies() != null) {
            Arrays.stream(request.getCookies()).forEach(cookie ->
                    System.out.println("cookieName = " + cookie.getName() + "," + " cookieValue = " + cookie.getValue()));
        }
        System.out.println();

        System.out.println("[Content 편의 조회]");
        String contentType = request.getContentType();
        System.out.println("contentType = " + contentType);
        int contentLength = request.getContentLength();
        System.out.println("contentLength = " + contentLength);
        String characterEncoding = request.getCharacterEncoding();
        System.out.println("characterEncoding = " + characterEncoding);

        System.out.println("------------------- Request HeaderUtils End -------------------" );
    }

}
