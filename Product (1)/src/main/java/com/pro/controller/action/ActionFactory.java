package com.pro.controller.action;

import com.user.controller.actionuser.LogoutAction;
import com.user.controller.actionuser.MypageForm;
import com.user.controller.actionuser.RegisterAction;
import com.user.controller.actionuser.RegisterForm;
import com.user.controller.actionuser.UserDelete;
import com.user.controller.actionuser.UserListAction;
import com.user.controller.actionuser.UserLogin;
import com.user.controller.actionuser.UserLoginForm;
import com.user.controller.actionuser.UserUpdate;
import com.user.controller.actionuser.UserUpdateForm;
import com.user.controller.actionuser.UserView;


public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {}

	public static ActionFactory getInstance() {
		
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		
		//System.out.println("ActionFactory : " + command);
		
		if(command.equals("pro_list")) {
			action = new ProListAction();
		}else if(command.equals("pro_write_form")) {
			action = new ProWriteActionForm();
		}else if(command.equals("pro_write")) {
			action = new ProWriteAction();
		}else if(command.equals("pro_view")) {
			action = new ProViewAction();
		}else if(command.equals("pro_update_form")) {
			action = new ProUpdateFormAction();
		}else if(command.equals("pro_update")) {
			action = new ProUpdateAction();
		}else if(command.equals("pro_delete")) {
			action = new ProDeleteAction();
		}else if(command.equals("pro_check_delete_form")) {
			action = new ProCheckDeleteFormAction();
		}else if(command.equals("pro_check_delete")) {
			action = new ProCheckDeleteAction();
		}
		//회원
		else if(command.equals("user_list")) {
			action = new UserListAction();
		}else if(command.equals("register_form")) {
			action = new RegisterForm();
		}else if(command.equals("register")) {
			action = new RegisterAction();
		}else if(command.equals("user_view")) {
			action = new UserView();
		}else if(command.equals("user_update_form")) {
			action = new UserUpdateForm();
		}else if(command.equals("user_update")) {
			action = new UserUpdate();
		}else if(command.equals("user_delete")) {
			action = new UserDelete();
		}else if(command.equals("user_login")) {
			action = new UserLogin();
		}else if(command.equals("user_login_action")) {
			action = new UserLoginForm();
		}else if (command.equals("logout_action")) {
            action = new LogoutAction();
        }else if(command.equals("mypage")) {
        	action = new MypageForm();
        }else if(command.equals("order_list")) {
			action = new OrderListAction();
		} else if (command.equals("order_delete")) {
			action = (Action) new OrderDeleteAction();
		} else if (command.equals("order_pay1")) {
			action = (Action) new OrderPay1Action();
		}
		
		
		
		
		
		
		
		return action;
	};

}
