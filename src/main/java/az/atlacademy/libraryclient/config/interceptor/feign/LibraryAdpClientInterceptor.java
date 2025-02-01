package az.atlacademy.libraryclient.config.interceptor.feign;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LibraryAdpClientInterceptor implements RequestInterceptor
{
    @Override
    public void apply(RequestTemplate requestTemplate)
    {
        String url = requestTemplate.url(); 
        String method = requestTemplate.method();

        if (requiresAuthentication(url, method)) 
        {
            HttpSession session = getCurrentHttpRequest().getSession();
            String token = (String) session.getAttribute("token");
            if (token != null) 
            {
                requestTemplate.header("Authorization", "Bearer " + token);
            }
        }
    }

    private boolean requiresAuthentication(String url, String method)
    {
        if (
            method == "GET" && 
            !url.startsWith("/auth/is-authenticated") && 
            !url.startsWith("/api/v1/order") &&
            !url.startsWith("/api/v1/student")
        ){
            return false; 
        }
        return true;
    }

    private HttpServletRequest getCurrentHttpRequest() 
    {
        ServletRequestAttributes attributes = 
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        return attributes != null ? attributes.getRequest() : null;
    }
}
