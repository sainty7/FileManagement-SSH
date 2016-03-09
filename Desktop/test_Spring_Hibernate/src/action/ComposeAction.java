package action;

import com.opensymphony.xwork2.ActionSupport;

public class ComposeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String execute()
	{	
		LoginAction la = new LoginAction();
		this.setUsername(la.username);
		return SUCCESS;
		
	}
	
}
