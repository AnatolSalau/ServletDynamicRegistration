import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.annotation.WebListener;

import java.util.Map;

//Registration by ServletRegistration
@WebListener
public class TestServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        // Register Servlet (NameServlet like in XML, Full name Java class servlet like AdminServlet.java)
        // if folder java have packages you have to insert in the fullpath like com.tms.AdminServlet.java
        ServletRegistration servletRegistration = sc.addServlet("AdminServlet",
                "AdminServlet");
        servletRegistration.addMapping("/d");
       ServletRegistration servletRegistration2 = sc.addServlet("UserServlet",
                "UserServlet");
        servletRegistration2.addMapping("/d2");
    }
}