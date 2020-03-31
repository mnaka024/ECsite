package com.internousdev.ecsite.dto;

public class SearchItemDTO {

	//テーブルカラムに対応したフィールド変数を宣言する
	private int productId;
	private String productName;
	private String productKanaName;

	//get.set

	//フィールド変数に対応したGetter、Setterを定義する
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductKanaName() {
		return productKanaName;
	}
	public void setProductKanaName(String productKanaName) {
		this.productKanaName = productKanaName;
	}

}
