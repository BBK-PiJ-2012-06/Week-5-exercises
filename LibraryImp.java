import java.util.Map;
import java.util.HashMap;

public class LibraryImp implements Library {
	private final String NAME;
	private static final int DEFAULT_MAX_BPU = 10;
	private int maxBooksPerUser;
	private Map<String, Integer> user_map = new HashMap<String, Integer>();
	private int nextID = 0;
	
	public LibraryImp(String name) {
		this.NAME = name;
		this.maxBooksPerUser = DEFAULT_MAX_BPU;
	}
	
	@Override
	public String getName() {
		return NAME;
	}
	
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
		if( user_map.containsKey(username) )
			return user_map.get(username);
		user_map.put(username, nextID);
		return nextID++;
	}
}