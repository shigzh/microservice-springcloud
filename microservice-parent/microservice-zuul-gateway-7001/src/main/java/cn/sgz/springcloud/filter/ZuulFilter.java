package cn.sgz.springcloud.filter;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义过虑器需要继承 ZuulFilter，ZuulFilter是一个抽象类，需要覆盖它的4个方法，如下：
 * filterType：返回字符串代表过滤器的类型，返回值有：
 *      pre：在请求路由之前执行
 *      route：在请求路由时调用
 *      post：请求路由之后调用， 也就是在route和errror过滤器之后调用
 *      error：处理请求发生错误时调用
 * filterOrder：此方法返回整型数值，通过此数值来定义过滤器的执行顺序，数字越小优先级越高。
 * shouldFilter：返回Boolean值，判断该过滤器是否执行。返回true表示要执行此过虑器，false不执行。
 * run：过滤器的业务逻辑。
 *
 * 自定义过滤器 LoginFilter
 * 继承 ZuulFilter
 * 在类上添加 @Component 注解 (一定不要少了)
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/9 16:54
 */
@Component
public class ZuulFilter extends com.netflix.zuul.ZuulFilter {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public String filterType() {
        return "pre"; //请求路由前调用
    }

    @Override
    public int filterOrder() {
        return 1; //int值来定义过滤器的执行顺序，数值越小优先级越高
    }

    @Override
    public boolean shouldFilter() {
        return true; //该过滤器是否执行，true执行，false不执行
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        //获取请求参数token的值
        String token = request.getParameter("token");
        if (token == null) {
            logger.warn("此操作需要先登录系统...");
            context.setSendZuulResponse(false);// 拒绝访问
            context.setResponseStatusCode(200);// 设置响应状态码
            try {
                //响应结果
                context.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        logger.info("ok");
        return null;
    }
}
