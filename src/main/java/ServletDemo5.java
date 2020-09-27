import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
/*
    ServletContext
        作用以：获取web项目的信息
 */

@WebServlet(name = "ServletDemo5")
public class ServletDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取文件的MIME类型
        ServletContext servletContext = this.getServletContext();
        String mimeType = servletContext.getMimeType("aa.txt");
        System.out.println(mimeType);
        /*
            text/plain
         */

        //2.获得请求路径的工程名
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
        /*
            /Test3_war
         */

        //3.获得全局的初始化参数
        String username = servletContext.getInitParameter("username");
        String password = servletContext.getInitParameter("password");
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();

        while (initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String pwd = servletContext.getInitParameter(name);
            System.out.println(name + "\t" + pwd);
        }
        System.out.println(username + "\t" + password);
        /*
            password	123
            username	root
            root	123
         */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
