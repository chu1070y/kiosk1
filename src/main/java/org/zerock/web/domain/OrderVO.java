package org.zerock.web.domain;

import lombok.Data;

@Data
public class OrderVO {

    private int mct,mprice,total;
    private String mname;

    int cno;


}
