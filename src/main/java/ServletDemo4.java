import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/*
    ServletConfig对象的API的演示
 */
@WebServlet(name = "ServletDemo4")
public class ServletDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得初始化参数的API
        //获得ServletConfig对象;
        ServletConfig servletConfig = this.getServletConfig();
        String username = servletConfig.getInitParameter("username");
        String password = servletConfig.getInitParameter("password");
        System.out.println(username + "\t" + password);
        /*
            root	123
         */
        //获得所有初始化参数的名称
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            String initParameter = servletConfig.getInitParameter(s);
            System.out.println(s + "\t" + initParameter);
        }
        /*
            password	123
            username	root
         */
        //获得Servlet的名称
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);
        /*
            ServletDemo4
         */
    }
}
