public class MockLibraryImp implements Library {
	@Override
	String getName() {
		return "Mock library";
	}
	
	@Override
	int getID(String str) {
		return 13;
	}
}