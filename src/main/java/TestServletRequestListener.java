import jakarta.servlet.ServletRegistration;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

//Добавление мапинга к сервлету если нам передали нужный параметр new : admin
// листенер обрабатывает параметры в любом типе запроса, не только GET (POST, PUT, итд)
@WebListener
public class TestServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) sre.getServletRequest();
        String aNew = null;
        if (aNew == null) {
            aNew = httpServletRequest.getParameter("new");
            System.out.println(aNew);
        }
        //Проверка чтобы небыло ошибки что aNew is NULL
        if (aNew != null && aNew.equals("admin")) {
            //Указываем "AdminServlet" - полное название класса внутри папки Java (AdminServlet.java)
            ServletRegistration servletRegistration = sre.getServletContext().getServletRegistration("AdminServlet");
            servletRegistration.addMapping("/newadmin");
        }
    }
}
