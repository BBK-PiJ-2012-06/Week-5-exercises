public class MockLibraryImp implements Library {
	private Book book;
	private int MBPU = 10;
	private boolean taken = false;
	private String name;
	
	public MockLibraryImp(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public int getID(String str) {
		return 13;
	}
	@Override
	public int getMaxBooksPerUser() {
		return MBPU;
	}
	@Override
	public void setMaxBooksPerUser(int new_MBPU) {
		MBPU =  new_MBPU;
	}
	@Override
	public void addBook(String author, String title) {
		book = new Book(author, title);
	}
	@Override
	public Book takeBook(String title) {
		if(!taken) {
			taken = true;
			return book;
		}
		else
			return null;
	}
	@Override 
	public void returnBook(Book book) {
		taken = false;
	}
	@Override
	public int getReaderCount() {
		return 1;
	}
	@Override
	public int getBookCount() {
		return 2;
	}
	@Override
	public int getBookBorrowedCount() {
		return 3;
	}
}