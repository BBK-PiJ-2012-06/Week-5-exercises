public class Person {
	private String name;
	private int age;
	private Person nextPerson;
	private Person previousPerson;
	private static Person lastPerson;
	private static Person firstPerson;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		this.nextPerson = null;
		this.previousPerson = null;
	}	
	
	public Person() {
		this.nextPerson = null;
		this.previousPerson = null;		
	}
	
	public String name() {
		return this.name;
	}
	
	public int age() {
		return this.age;
	}
		
	public Person next() {
		return this.nextPerson;
	}
	
	public Person previous() {
		return this.previousPerson;
	}
	
	public Person last() {
		return lastPerson;
	}
	
	public Person first() {
		return firstPerson;
	}
	
	public String getInitials(String fullName) {
		String result = "";
		String[] words = fullName.split(" ");
		for (int i = 0; i < words.length; i++) {
			if( words[i].length() != 0 ) {
				String nextInitial = "" + words[i].charAt(0);
				result = result + nextInitial.toUpperCase();
			}
		}
		return result;
	}
	
	public void addPerson(Person newPerson) {
		if(this.nextPerson == null) {
			// last patient in the list
			this.nextPerson = newPerson;
			newPerson.previousPerson = this;
			lastPerson = this.nextPerson;
			if(this.previousPerson == null) {
				// must be first patient
				firstPerson = this;
			}
		} else {
			this.nextPerson.addPerson(newPerson);
		}
	}
	
	public boolean deletePerson(Person patient) {
		if(this.nextPerson == null) {
			// patient to remove was not found
			return false;
		} else if (this.name.equals(patient.name)) {
			// patient to delete is first patient
			this.nextPerson.previousPerson = null;
			firstPerson = this.nextPerson;
			return true;
		} else if (this.nextPerson.name.equals(patient.name)) {
			// Found it! Need to delete next one -
			// so link this patient to the one after next...
			this.nextPerson = nextPerson.nextPerson;
			// and one after next (now next) to this one as long as this isn't last
			if(this.nextPerson !=null) {
				this.nextPerson.previousPerson = this;
			}
			// if deleted the lastPerson, make sure this is the new lastPerson
			else {
				lastPerson = this;
			}
			return true;
		} else {
			return this.nextPerson.deletePerson(patient);
		}
	}
}