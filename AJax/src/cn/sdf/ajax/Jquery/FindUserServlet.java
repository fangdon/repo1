package cn.sdf.ajax.Jquery;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编吗格式
        response.setContentType("text/html;charset=utf-8");
        //获取参数
        String username = request.getParameter("username");
        //查询数据库调取service层
        Map<String,Object> map=new HashMap<String,Object>();
        if("jia".equals(username)){
            //存在
            map.put("userExsit",true);
            map.put("msg","用户名重复，请换一个！");
        }else{
            //不存在
            map.put("userExsit",false);
            map.put("msg","用户名正确！");
        }
        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
