package controller.action;

public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		System.out.println("ActionFactory : " + command);
		// 조건식 나열 --> action 구현 클래스

		if (command.equals("order_list")) {
			action = new OrderListAction();
		} else if (command.equals("order_pay")) {
			action = (Action) new OrderPayAction();
		}

		return action;
	}
}