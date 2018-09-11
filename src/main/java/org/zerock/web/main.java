package org.zerock.web;

import org.zerock.web.dao.MenuDAO;
import org.zerock.web.domain.MenuVO;

import java.util.List;

public class main {
    public static void main(String[] args) throws Exception {
        MenuDAO dao = new MenuDAO();
        List<MenuVO> menuVOList = dao.getList();
        System.out.println(menuVOList);
        new MenuDAO().getList().stream().forEach(s-> System.out.println(s));
    }
}
