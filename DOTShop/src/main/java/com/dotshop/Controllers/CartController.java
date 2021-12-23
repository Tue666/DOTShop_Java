package com.dotshop.Controllers;

import java.io.IOException;
import java.util.List;

import com.dotshop.Models.CartItem;
import com.dotshop.Service.ICartService;
import com.dotshop.Service.Implement.CartService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICartService cartService;

	public CartController() {
		cartService = new CartService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int userID = session.getAttribute("id") == null ? 0 : Integer.parseInt(session.getAttribute("id").toString());
		
		List<CartItem> cart = cartService.findCartByUserID(userID);
		
		Boolean isCheckedAll = cart.stream().reduce(0, (sum, item) -> {
			if (item.getCartChecked()) {
				return sum + 1;
			}
			return sum;
		}, Integer::sum) == cart.size();
		int guess = cart.stream().reduce(0, (sum, item) -> {
			if (item.getCartChecked()) {
				return sum + (item.getCartQuantity()
						* (item.getProductPrice() - item.getProductPrice() * item.getProductDiscount() / 100));
			}
			return sum;
		}, Integer::sum);
		int coupon = 0;
		int shipFee = cart.stream().reduce(0, (sum, item) -> {
			if (item.getCartChecked()) {
				return sum + item.getVATFee();
			}
			return sum;
		}, Integer::sum);
		int freeShip = 0;
		int total = guess - coupon + (shipFee - freeShip > 0 ? shipFee - freeShip : 0);
		request.setAttribute("isCheckedAll", isCheckedAll);
		request.setAttribute("cart", cart);
		request.setAttribute("guess", guess);
		request.setAttribute("coupon", coupon);
		request.setAttribute("shipFee", shipFee);
		request.setAttribute("freeShip", freeShip);
		request.setAttribute("total", total);
		RequestDispatcher rd = request.getRequestDispatcher("/pages/Cart.jsp");
		rd.forward(request, response);
	}
}
