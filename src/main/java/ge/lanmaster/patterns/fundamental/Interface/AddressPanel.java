package ge.lanmaster.patterns.fundamental.Interface;

public class AddressPanel {

	private Address data;

	public void setData(Address data) {
		this.data = data;
	}

	public Address getData() {
		return data;
	}

	public void save() {
		if (data != null) {
			data.setAddress1("address1text");
			data.setPostalCode("postalCodetext");
		}
	}

	public static void main(String[] args) {
		AddressPanel ap = new AddressPanel();
		ap.setData(new ReceivingLocation());
		ap.save();


		System.out.println("Hello world!");
		System.out.println(ap.getData().getAddress1());
		System.out.println(ap.getData().getPostalCode());
	}
}




