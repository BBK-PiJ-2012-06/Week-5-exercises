public class MockLibraryImp implements Library {
	@Override
	public String getName() {
		return "Mock library";
	}
	
	@Override
	public int getID(String str) {
		return 13;
	}
}