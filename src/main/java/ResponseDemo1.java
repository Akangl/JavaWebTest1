import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
    设置响应的状态码
    使用状态码和location头完成重定向
 */
@WebServlet(name = "ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的状态码
//        response.setStatus(404);
        //完成重定向
//        response.setStatus(302);
        //设置响应头
//        response.setHeader("Location","/Test3_war/ResponseDemo2");
        //定时刷新
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("五秒以后页面跳转");
        response.setHeader("Refresh","5;url=/Test3_war/ResponseDemo2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
