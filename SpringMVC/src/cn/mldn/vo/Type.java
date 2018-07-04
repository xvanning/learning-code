package cn.mldn.vo;

public class Type {
	private String typeTitle;
	public void setTypeTitle(String typeTitle) {
		this.typeTitle = typeTitle;
	}
	public String getTypeTitle() {
		return typeTitle;
	}
	
	@Override
	public String toString() {
		return this.typeTitle;
	}
}
