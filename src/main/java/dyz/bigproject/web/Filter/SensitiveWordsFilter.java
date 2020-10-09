package dyz.bigproject.web.Filter;
/**
 * 从parameter中过滤敏感词
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        final ServletRequest req1=req;

        //1.创建代理对象来代替request增强getParameter方法
        //还没有加强getParameterMap方法
        ServletRequest proxy_req= (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(),req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("getParameter"))
                {
                    String value= (String) method.invoke(req1,args);
                    if(value!=null)
                    {
                        for(String str:list)
                        {
                            if(value.contains(str))
                            {
                                value=value.replaceAll(str,"***");
                            }
                        }
                    }
                    return value;
                }
                else if(method.getName().equals("getParameterMap"))
                {
                    Map<String,String[]> newMap =new HashMap<String,String[]>();
                    Map<String,String[]> map = (Map)method.invoke(req1, args);
                    Set<String> keySet= map.keySet();
                    for(String s:keySet)/*遍历关键字*/
                    {
                        int i=0;

                        String[] values=map.get(s);
                        if(values==null||values.length==0)
                        {
                            newMap.put(s,null);
                        }
                        else
                        {
                            for(String value:values)/*遍历关键字对应的键值数组*/ {

                                for (String str : list)/*搜索所有敏感词*/ {
                                    if (value.contains(str)) {
                                        value = value.replaceAll(str, "***");
                                        values[i] = value;
                                    }
                                }
                                i++;/*记录值在值数组的位置来方便更改*/
                            }
                            newMap.put(s,values);
                        }

                    }
                    return newMap;
                }
                else{

                    return method.invoke(req1,args);
                }

            }
        });


        //将代理对象用来换掉request
        chain.doFilter(proxy_req, resp);
    }

    private List<String> list=new ArrayList<String>();/*敏感词集合*/
    public void init(FilterConfig config) throws ServletException {
       try{
//        FilterConfig config于获取 Filter 程序在 web.xml 文件中的配置信息的接口,
        //1.获取文件真实路径
        ServletContext ser = config.getServletContext();
        /*单纯javaweb项目运行时文件路径差不多这样
        D:\IdeaProjects\day14_servlet\out\artifacts\day17_1_war_exploded\WEB-INF\classes\敏感词汇.txt
       String realPath = ser.getRealPath("/WEB-INF/classes/sensitiveWord.txt");
        */
        /*但maven是这样,一个是运行时候，一个是不运行时候
          /D:/maven-java/bigProject/target/classes/druid.properties
          D:\maven-java\bigProject\src\main\resources\sensitiveWord.txt*/
        //2.读取文件

        BufferedReader br = new BufferedReader(new FileReader("D:/maven-java/bigProject/target/classes/sensitiveWord.txt"));


        String line=null;

        while((line=br.readLine())!=null)
        {
            list.add(line);
        }
        br.close();
      /*     System.out.println(list);*/
        }catch(Exception e)
       {
           e.printStackTrace();
       }
    }

}
