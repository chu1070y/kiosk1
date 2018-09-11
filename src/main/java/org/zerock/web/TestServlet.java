package org.zerock.web;

import org.zerock.web.dao.OrderDAO;
import org.zerock.web.dao.QueryExecutor;
import org.zerock.web.domain.OrderVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //데이터베이스에 저장하기

        request.setCharacterEncoding("UTF-8");
        OrderDAO dao = new OrderDAO();
        int orderNum = dao.getOrderNum();


        String[] values = new String[9];

       Enumeration<String>  names =  request.getParameterNames();


       while(names.hasMoreElements()){
                    String name = names.nextElement();

                    values = request.getParameterValues(name);

                    System.out.println(Arrays.toString(values));
       }

        dao.add(values,orderNum);




        // 영수증 출력

        String sql = "select mname, mct, mprice, mct*mprice total\n" +
                "from tbl_customer cus, tbl_menu menu\n" +
                "where cus.mno = menu.mno and cus.cno="+ orderNum;

        List<OrderVO> list = new ArrayList<OrderVO>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println(".............next");
                OrderVO vo = new OrderVO(); //한 라인당 menuvo로 저장해준다.
                vo.setMname(rs.getString("mname"));
                vo.setMct(rs.getInt("mct"));
                vo.setMprice(rs.getInt("mprice"));
                vo.setTotal(rs.getInt("total"));
                list.add(vo); //리스트에 메뉴정보를 넣어준다.
            }

            }
        }.executeAll();



        System.out.println("----------------------------------------------------1");
        request.getServletContext().setAttribute("orderList",list);
        request.getServletContext().setAttribute("orderNum",orderNum);
        System.out.println("------------------------------------------------2");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/receipt.jsp"); //web-inf 폴더에 접근할 수 있게 된다.
        dispatcher.forward(request,response);// forward는 req와 resp를 전달하는 역할




    }

}
