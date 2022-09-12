package web.configuration;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {PersistenceConfiguraion.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {MvcConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    public void onStartup(ServletContext servContext) throws ServletException {
        super.onStartup(servContext);
        registerHiddenFieldFilter(servContext);
    }

    private void registerHiddenFieldFilter(ServletContext sContext){
        sContext.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null, true, "/*");

    }
}
