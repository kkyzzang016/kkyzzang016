package com.shoppingmall.controller;

import com.shoppingmall.controller.action.Action;
import com.shoppingmall.controller.action.CartDeleteAction;
import com.shoppingmall.controller.action.CartInsertAction;
import com.shoppingmall.controller.action.CartListAction;
import com.shoppingmall.controller.action.ContractAction;
import com.shoppingmall.controller.action.FindZipNumAction;
import com.shoppingmall.controller.action.IdCheckFormAction;
import com.shoppingmall.controller.action.IndexAction;
import com.shoppingmall.controller.action.JoinAction;
import com.shoppingmall.controller.action.JoinFormAction;
import com.shoppingmall.controller.action.LoginAction;
import com.shoppingmall.controller.action.LoginFormAction;
import com.shoppingmall.controller.action.LogoutAction;
import com.shoppingmall.controller.action.ProductDetailAction;
import com.shoppingmall.controller.action.ProductKindAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	public ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory :" + command);
		if (command.equals("main")) {
			action = new IndexAction();
		} else if (command.equals("product_detail")) {
			action = new ProductDetailAction();
		} else if (command.equals("catagory")) {
			action = new ProductKindAction();
		} else if (command.equals("contract")) {
			action = new ContractAction();
		} else if (command.equals("join_form")) {
			action = new JoinFormAction();
		} else if (command.equals("id_check_form")) {
			action = new IdCheckFormAction();
		} else if (command.equals("find_zip_num")) {
			action = new FindZipNumAction();
		} else if (command.equals("join")) {
			action = new JoinAction();
		} else if (command.equals("login_form")) {
			action = new LoginFormAction();
		} else if (command.equals("login")) {
			action = new LoginAction();
		} else if (command.equals("logout")) {
			action = new LogoutAction();
		} else if (command.equals("cart_insert")) {
			action = new CartInsertAction();
		} else if (command.equals("cart_list")) {
			action = new CartListAction();
		} else if (command.equals("cart_delete")) {
			action = new CartDeleteAction();
		}

		return action;
	}
}