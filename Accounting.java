/**
* A program for simple personal accounting.
*
* Asks the users about their bills, and then
* says how many bills there are, and what is the
* total debt.
*/
public class Accounting {
	/**
	* The first element of the list of bills
	*/
	private Bill firstBill = null;
	public static void main(String[] args) {
		Accounting acc = new Accounting();
		acc.launch(args);
	}

	public int billCount() {
		Bill b1 = new Bill("one", 1);
		Bill b2 = new Bill("two", 2);
		addBillToList(b1);
		addBillToList(b2);
		int count = 0;
		int totalDebt = 0;
		for (Bill current = firstBill; current != null; current = current.getNextBill()) {
			count++;
			totalDebt += current.getAmount();
		}
		return count;
	}
	
	public int totalDebt() {
		String concept = "";
		int amount = 0;
		do {
			System.out.println("What’s your next bill (type \"END\" to finish)?");
			System.out.print(" Concept: ");
			concept = System.console().readLine();
			if (!concept.equals("END")) {
				System.out.print(" Amount: ");
				String strAmount = System.console().readLine();
				amount = Integer.parseInt(strAmount);
				Bill newBill = new Bill(concept, amount);
				addBillToList(newBill);
			}
		} while (!concept.equals("END"));
		int totalDebt = 0;
		for( Bill current = firstBill; current != null; current = current.getNextBill() ) {
			totalDebt += current.getAmount();
		}
		return totalDebt;
	}
	
	public int listLength() {
		String concept = "";
		int amount = 0;
		do {
			System.out.println("What’s your next bill (type \"END\" to finish)?");
			System.out.print(" Concept: ");
			concept = System.console().readLine();
			if (!concept.equals("END")) {
				System.out.print(" Amount: ");
				String strAmount = System.console().readLine();
				amount = Integer.parseInt(strAmount);
				Bill newBill = new Bill(concept, amount);
				addBillToList(newBill);
			}
		} while (!concept.equals("END"));
		int listLength = 0;
		for( Bill current = firstBill; current != null; current = current.getNextBill() ) {
			listLength++;
		}
		return listLength;
	}
	
	private void launch(String[] args) {
		String concept = "";
		int amount = 0;
		do {
			System.out.println("What’s your next bill (type \"END\" to finish)?");
			System.out.print(" Concept: ");
			concept = System.console().readLine();
			if (!concept.equals("END")) {
				System.out.print(" Amount: ");
				String strAmount = System.console().readLine();
				amount = Integer.parseInt(strAmount);
				Bill newBill = new Bill(concept, amount);
				addBillToList(newBill);
			}
		} while (!concept.equals("END"));
		int count = 0;
		int totalDebt = 0;
		for (Bill current = firstBill; current != null; current = current.getNextBill()) {
			count++;
			totalDebt += current.getAmount();
		}
		System.out.println("You have " + count + " bills unpaid (total debt: " + totalDebt + ")");
	}

	private void addBillToList(Bill bill) {
		if (firstBill == null) {
			firstBill = bill;
			return;
		}
		Bill current = firstBill;
		while (current != null) {
			if (current.getNextBill() == null) {
				current.setNextBill(bill);
				return;
			}
			current = current.getNextBill();
		}
		return;
	}
}