import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

import java.util.Map;

@WebListener
public class RegistrationServletContextListener implements ServletContextListener {
    private static ServletContext servletContext;
    private static ServletRegistration.Dynamic servletRegistrationDynamic;
    @Override
    public void contextInitialized(ServletContextEvent event) {
        servletContext = event.getServletContext();

        String servletName = "defaultuserservlet";
        Class userAppControllerClass = AdminServlet.class;
        String urlPatterns = "/admin/";

        toRegistrServlet(servletName,userAppControllerClass,urlPatterns);

        String servletNameNew = "user1";
        Class userAppControllerClassNew = UserServlet.class;
        String urlPatternsNew = "/user1/";
        toRegistrServlet(servletNameNew,userAppControllerClassNew,urlPatternsNew);
        addMappringToServlet("/user2/");

        servletRegistrationDynamic.setInitParameter("user1","AdminServlet");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
    public static void toRegistrServlet(String servletName, Class servletClass, String urlPatterns) {
        servletRegistrationDynamic = servletContext.addServlet(servletName,servletClass);
        servletRegistrationDynamic.addMapping(urlPatterns);
    }

    public static void addMappringToServlet (String urlPattern) {
        System.out.println(servletRegistrationDynamic.getMappings());
        servletRegistrationDynamic.addMapping(urlPattern);
        System.out.println(servletRegistrationDynamic.getMappings());
    }

    public static ServletContext getServletContext() {
        return servletContext;
    }
}