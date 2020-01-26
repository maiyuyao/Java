package com.essence.advanced.annotation.ex03;

public class ExecuteQuery {  
    public static void main(String[] args) {  
        User u1 = new User();  
        u1.setId(9);  //查询id为9的用户  
          
        User u2 = new User();  
        u2.setUserName("Randy");   //模糊查询用户名为JTZeng的用户  
        u2.setAge(21);  
          
        User u3 = new User();  
        u3.setEmail("xxx@163.com,xxx@qq.com");  //查询邮箱有任意一个的用户  
        
        DESADV u4 = new DESADV();  
        u4.setMESID_1(123456);   
        u4.setCOMPANY_2("A380");    
        u4.setINVOICE_3("88888888");   
          
        String sql1 = ReturnQuery.query(u1);    //查询id为9的用户  
        String sql2 = ReturnQuery.query(u2);    //查询用户名为Randy和年龄为21的用户  
        String sql3 = ReturnQuery.query(u3);    //查询邮箱中有任意一个的用户  
        String sql4 = ReturnQuery.query(u4);    //查询DN 
          
         System.out.println(sql1);  
         System.out.println(sql2);  
         System.out.println(sql3);  
         System.out.println(sql4);  
    }  
}  