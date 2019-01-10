
public enum ListOrder {
	
	Ascending,
	Descending,
	Random;
	
	public static final String[] ORDER_NAMES = {"��������", "��������", "������"};
	
	public String orderName(){
		return ListOrder.ORDER_NAMES[this.ordinal()];
	}
}