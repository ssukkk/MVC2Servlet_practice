package kr.swdl.servlet;

public class ActionFactory {

	public static Action getAction(String cmd) {
		if (cmd == null)
			cmd = "";
		Action a = null;
		// 메뉴를 규칙이 없지만 값을 비교
		switch (cmd) {
		case "addCustomerUI":
			a = new addCustomerUIAction();
			break;
		case "addCustomerAction":
			a = new addCustomerAction();
			break;
		case "loginUI":
			a = new LoginUIAction2();
			break;
		case "loginAction":
			a = new LoginAction();
			break;
		case "":
		default:
			a = new MainUIAction();
		}
		return a;
	}

}
