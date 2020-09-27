import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebServlet(name = "ServletDemo6")
public class ServletDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //tradition();//传统方式(Error)
//        SC();//使用ServletContext对象获取
        SCsj();
    }

    public void SCsj() throws IOException {
        Properties properties = new Properties();
        String realPath = this.getServletContext().getRealPath("F:\\JAVA_WorkStation\\Java-Web\\Test3\\src\\main\\java\\db.properties");
        System.out.println(realPath);
        InputStream inputStream = new FileInputStream(realPath);
        properties.load(inputStream);
        //获取数据
        String driveClassName = properties.getProperty("driveClassName");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        //输出数据
        System.out.println(driveClassName);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
    }

    public void SC() throws IOException {
        //读取web项目下的文件,使用ServletContest读取
        Properties properties = new Properties();
        InputStream resourceAsStream = this.getServletContext().getResourceAsStream("src/main/java/db.properties");
        properties.load(resourceAsStream);
        //获取数据
        String driveClassName = properties.getProperty("driveClassName");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        //输出数据
        System.out.println(driveClassName);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
    }

    public void tradition() throws IOException {
        //传统方式读取文件(失败)
        Properties properties = new Properties();
        //创建一个文件输入流
        InputStream inputStream = new FileInputStream("db.properties");
        properties.load(inputStream);
        //获取数据
        String driveClassName = properties.getProperty("driveClassName");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        //输出数据
        System.out.println(driveClassName);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
