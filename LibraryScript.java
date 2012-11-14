public class LibraryScript {
	public static void main(String[] args) {
		LibraryScript script = new LibraryScript();
		script.launch();
	}
	
	public void launch() {
		System.out.println("LibraryScript tests out the functionality of a Library in the following situations\n");
		Library lib = new Library("British Library");
		situation1(lib);
		//situation2(lib);
		//situation3(lib);
		//situation4(lib);
	}
	
	public void situation1(Library lib) {
		System.out.println("Situation 1: A user borrows one book and then returns it...\n");
		
		User john = new User("John Smith");
		Book bk = new Book("William Shakespeare","The Tempest");
		
		System.out.println(john.getName() + " is registering with the library");
		john.register(lib);
		System.out.println("John's ID: " + john.getID() + " and in the library's records: " + lib.getID(john));
	
		System.out.println("Adding " + bk.getTitle() + " to the library");
		lib.addBook(bk);
		
		System.out.println("John decides to borrow " + bk.getTitle());
		Book borrowedBook = lib.takeBook("The Tempest", john);
		System.out.println("John is reading " + john.getBooksBorrowed().peek().getTitle());
		
		System.out.println("John's finished reading The Tempest (he got bored), so he's returning it");
		lib.returnBook(borrowedBook);

		System.out.println("John's now reading " + john.getBooksBorrowed().size() + " books.");
	}
}