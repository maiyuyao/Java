package com.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.MaintainService;

@SuppressWarnings("serial")
public class deleteBatchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置编码
		req.setCharacterEncoding("UTF-8");
		//接受页面的值
		String[] ids = req.getParameterValues("id");
		MaintainService maintainService =new MaintainService();
		maintainService.deleteBatch(ids);
		//跳转
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}




	
}
