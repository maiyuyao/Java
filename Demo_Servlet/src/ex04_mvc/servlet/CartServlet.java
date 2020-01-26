﻿package ex04_mvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex04_mvc.dao.ItemsDAO;
import ex04_mvc.entity.Cart;
import ex04_mvc.entity.Items;

public class CartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String action; // 表示购物车的动作 ,add,show,delete
	// 商品业务逻辑类的对象
	private ItemsDAO idao = new ItemsDAO();

	public CartServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (request.getParameter("action") != null) {
			this.action = request.getParameter("action");
			if (action.equals("add")) // 如果是添加商品进购物车
			{
				if (addToCart(request, response)) {
					request.getRequestDispatcher("/ex04/success.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/ex04/failure.jsp").forward(request, response);
				}
			}
			if (action.equals("show"))// 如果是显示购物车
			{
				request.getRequestDispatcher("/ex04/cart.jsp").forward(request, response);
			}
			if (action.equals("delete")) // 如果是执行删除购物车中的商品
			{
				if (deleteFromCart(request, response)) {
					request.getRequestDispatcher("/ex04/cart.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/ex04/cart.jsp").forward(request, response);
				}
			}
		}

	}

	// 添加商品进购物车的方法
	private boolean addToCart(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String number = request.getParameter("num");
		Items item = idao.getItemsById(Integer.parseInt(id));

		// 是否是第一次给购物车添加商品,需要给session中创建一个新的购物车对象
		if (request.getSession().getAttribute("cart") == null) {
			Cart cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart.addGoodsInCart(item, Integer.parseInt(number))) {
			return true;
		} else {
			return false;
		}

	}

	// 从购物车中删除商品
	private boolean deleteFromCart(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		Items item = idao.getItemsById(Integer.parseInt(id));
		if (cart.removeGoodsFromCart(item)) {
			return true;
		} else {
			return false;
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
