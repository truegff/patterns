package ge.lanmaster.patterns.structural.CacheManagement;

public class EmployeeID {

	private String id;

	/**
	 * constructor
	 *
	 * @param id A string containing the employee ID.
	 */
	public EmployeeID(String id) {
		this.id = id;
	} // constructor(String)

	/**
	 * Returns a hash code value for this object.
	 */
	public int hashCode() {
		return id.hashCode();
	}

	/**
	 * Return true if the given object is an EmployeeId equal
	 * to this one.
	 */
	public boolean equals(Object obj) {
		boolean p1 = obj instanceof EmployeeID;
		boolean p2 = id.equals((EmployeeID) obj);
		return p1 && p2;
	}

	/**
	 * Return the string representation of this EmployeeID.
	 */
	public String toString() {
		return id;
	}

}
