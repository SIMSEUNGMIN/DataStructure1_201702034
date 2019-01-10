
public enum ListOrder {
	Ascending,
	Descending,
	Random;
	
	public static final String[] STRINGS_IN_KOREAN = new String[]{"��������", "��������", "������"};
	
	public String toStringInKorean(){
		return ListOrder.STRINGS_IN_KOREAN[this.ordinal()];
	}
}
