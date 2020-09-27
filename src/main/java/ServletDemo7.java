import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
    ServletContext的域对象的演示
 */
@WebServlet(name = "ServletDemo7")
public class ServletDemo7 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        //当ServletDemo7被创建,初始化一个值
        this.getServletContext().setAttribute("name","James");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (String) this.getServletContext().getAttribute("name");
        System.out.println("姓名：" + name);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
