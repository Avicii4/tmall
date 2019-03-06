package tmall.filter;

import org.apache.commons.lang.StringUtils;
import tmall.bean.Category;
import tmall.bean.OrderItem;
import tmall.bean.User;
import tmall.dao.CategoryDAO;
import tmall.dao.OrderItemDAO;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Get the specific servlet from URI.
 * @author Harry Chou
 * @date 2019/3/6
 */
public class ForeServletFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        String contextPath=request.getServletContext().getContextPath();
        request.getServletContext().setAttribute("contextPath",contextPath);

        User user=(User) request.getSession().getAttribute("user");
        int cartTotalNumber=0;
        if(user!=null){
            List<OrderItem> ois=new OrderItemDAO().listByUser(user.getId());
            for(OrderItem oi:ois){
                cartTotalNumber+=oi.getNumber();
            }
        }
        request.setAttribute("cartTotalNumber",cartTotalNumber);

        List<Category> cs=(List<Category>) request.getAttribute("cs");
        if(cs==null){
            cs=new CategoryDAO().list();
            request.setAttribute("cs",cs);
        }

        String uri=request.getRequestURI();
        uri= StringUtils.remove(uri,contextPath);
        if(uri.startsWith("/fore") && !uri.startsWith("/foreServlet")){
            String method=StringUtils.substringAfterLast(uri,"/fore");
            request.setAttribute("method",method);
            servletRequest.getRequestDispatcher("/foreServlet").forward(request,response);
            return;
        }

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
    }
}
