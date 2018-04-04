package it.oggi012.skustore.custom;

import it.oggi012.skustore.bean.SkuStoreConstant;

public class CustomSkuStore {

	private boolean levelApp5;
	
	public CustomSkuStore() {
		super();
		
		initLevelApp5(SkuStoreConstant.LEVEL_APP);
	}
	
	private void initLevelApp5(int arg0) {
		this.levelApp5 = (arg0 == 5);
	}
	
	public boolean getLevelApp5() {
		return this.levelApp5;
	}
	
}
