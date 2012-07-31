
class AddressPanel {

	private AddressIF data;

	public void setData(AddressIF data) {
		this.data = data;
	}
	
	public AddressIF getData() {
		return data;
	}
		
	public void save() {
		if (data!=null) {
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

interface AddressIF {
	public String getAddress1();
	public void setAddress1(String address1);
	public String getPostalCode();
	public void setPostalCode(String postalCode);
}


class ReceivingLocation implements AddressIF{
	private String address1;
	private String postalCode;
	
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
