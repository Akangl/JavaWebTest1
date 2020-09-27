import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得请求方式
        System.out.println("请求方式：" + request.getMethod());
        /*
            请求方式：GET
         */

        //获取客户机的IP地址
        System.out.println("客户机的地址："+ request.getRemoteAddr());
        /*
            客户机的地址：10.84.198.73
         */

        //获得请求参数的字符串
        System.out.println("请求参数的字符串:" + request.getQueryString());
        /*
            http://10.84.198.73:8080/Test3_war/RequestDemo1?id=1&name=kobe
            请求参数的字符串:id=1&name=kobe
         */

        //获得请求路径的URL和URI
        System.out.println("请求路径URL:" + request.getRequestURL());
        System.out.println("请求路径的URI:" + request.getRequestURI());
        /*
            请求路径URL:http://10.84.198.73:8080/Test3_war/RequestDemo1
            请求路径的URI:/Test3_war/RequestDemo1
         */

        //获取请求头的信息
        System.out.println("获取客户机浏览器的类型:" + request.getHeader("User-Agent"));
        /*
            获取客户机浏览器的类型:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36

         */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
//        System.out.println("请求方式：" + request.getMethod());
    }
}
