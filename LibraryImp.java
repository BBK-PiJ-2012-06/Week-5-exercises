public class LibraryImp implements Library {
	private final String NAME;
	private static final int DEFAULT_MAX_BPU = 10;
	private int maxBooksPerUser;
	
	public LibraryImp(String name) {
		this.NAME = name;
		this.maxBooksPerUser = DEFAULT_MAX_BPU;
	}
	
	@Override
	public String getName() {
		return NAME;
	}
	
	//int getID(String username);
	
	@Override
	public int getMaxBooksPerUser() {
		return maxBooksPerUser;
	}
	
	@Override
	public void setMaxBooksPerUser(int new_max_bpu) {
		if( new_max_bpu > 0 )
			maxBooksPerUser = new_max_bpu;
	}
	
	@Override
	public int getID(String username) {
		return 13;
	}
}