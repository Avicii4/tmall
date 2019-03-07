package tmall.filter;

import org.apache.commons.lang.StringUtils;
import tmall.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Check if users have logged in.
 * @author Harry Chou
 * @date 2019/3/6
 */
public class ForeAuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        String contextPath=request.getServletContext().getContextPath();

        // pages that don't need to login
        String[] noNeedAuthPage=new String[]{
                "homepage","checkLogin","register",
                "loginAjax","login","product",
                "category","search"};
        String uri=request.getRequestURI();
        uri= StringUtils.remove(uri,contextPath);
        if(uri.startsWith("/fore") && !uri.startsWith("/foreServlet")){
            String method=StringUtils.substringAfterLast(uri,"/fore");
            // users need to log in
            if(!Arrays.asList(noNeedAuthPage).contains(method)){
                User user=(User) request.getSession().getAttribute("user");
                if(user==null){
                    response.sendRedirect("login.jsp");
                    return;
                }
            }
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
    }
}
