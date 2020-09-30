package smartcardDemo.model.dao;

public class OrderDAO {

	private long orderId;
	private String productName; // smartcard name
	private int qty;
	private float subtotal;
	private float shipping;
	private float tax;
	private float total;

	public OrderDAO() {
	}

	public OrderDAO(String productName, String subtotal, String shipping, String tax, String total) {
		this.productName = productName;
		this.subtotal = Float.parseFloat(subtotal);
		this.shipping = Float.parseFloat(shipping);
		this.tax = Float.parseFloat(tax);
		this.total = Float.parseFloat(total);
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public String getSubtotal() {
		return String.format("%.2f", subtotal);
	}

	public String getShipping() {
		return String.format("%.2f", shipping);
	}

	public String getTax() {
		return String.format("%.2f", tax);
	}

	public String getTotal() {
		return String.format("%.2f", tax + shipping + subtotal);
	}

}
