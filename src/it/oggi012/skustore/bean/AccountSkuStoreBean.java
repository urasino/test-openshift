package it.oggi012.skustore.bean;

public class AccountSkuStoreBean {

	private String dataUltimaModifica;
	
	private boolean levelApp5;
	private String userNameValue;
	private String passwordValue;
	
	public AccountSkuStoreBean() {
		super();
		
		dataUltimaModifica = "20180317.2340";
		setLevelApp5(SkuStoreConstant.LEVEL_APP);
	}
	
	public void actionLogin() {
		return;
	}
	
	public String outcomeLogin() {
		return null;
	}
	
	public String outcomeInfoDB() {
		return SkuStoreConstant.PAGE_ELENCOINFODB;
	}
	
	public String getUserNameActive() {
		return null;
	}
	
	public void setUserNameActive(String arg0) {
		return;
	}
	
	public String getUsrRuoloSkuStoreDescrizione() {
		return null;
	}
	
	public void setUsrRuoloSkuStoreDescrizione(String arg0) {
		return;
	}
	
	public String getAccountSkuStoreActive() {
		return null;
	}
	
	public void setAccountSkuStoreActive(String arg0) {
		return;
	}
	
	public void setLevelApp5(int arg0) {
		this.levelApp5 = (arg0 == 5);
	}
	
	public boolean isLevelApp5() {
		return levelApp5;
	}
	
	public String getDataUltimaModifica() {
		return this.dataUltimaModifica;
	}

	public String getUserNameValue() {
		return userNameValue;
	}

	public void setUserNameValue(String userNameValue) {
		this.userNameValue = userNameValue;
	}

	public boolean getFlagBranches() {
		return SkuStoreConstant.FLAG_BRANCHES;
	}

	public String getPasswordValue() {
		return passwordValue;
	}

	public void setPasswordValue(String passwordValue) {
		this.passwordValue = passwordValue;
	}
}
