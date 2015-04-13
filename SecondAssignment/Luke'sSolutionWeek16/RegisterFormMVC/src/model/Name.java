package model;
import java.io.Serializable;

public class Name implements Serializable {

	//Fields
	private String title;
	private String firstName;
	private String familyName;

	
	//Constructors
	public Name() {
		title = "";
		firstName = "";
		familyName = "";
	}
	
	public Name(String title, String firstName, String familyName) {
		this.title = title;
		this.firstName = firstName;
		this.familyName = familyName;
	}

	
	//Methods
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getTitle() {
		return title;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public String getFullName() {
		return title + " " + firstName + " " + familyName;
	}
	

	@Override
	public String toString() {
		//non-conventional toString as this is used to output names in JList
		//ideally you would create a CustomCellRenderer, but this is a simpler fix
		return this.getFullName();
	}
	
	@Override
	public boolean equals(Object obj) {
		if ((this.getClass() != obj.getClass()) || (obj == null) )
			return false;
		
			Name other = (Name) obj;
			
			return this.title.equals(other.title) && this.firstName.equals(other.firstName) && this.familyName.equals(other.familyName);
	}
	
	@Override
	public int hashCode() {
			final int HASH_MULTIPLIER = 29; 
			int h = HASH_MULTIPLIER * title.hashCode() + firstName.hashCode();
			h = HASH_MULTIPLIER * h + familyName.hashCode();
			return h;
	}
	
}
