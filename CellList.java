import java.util.NoSuchElementException;

public class CellList {

	private CellNode head;
	private int size;
	

	public CellList() {
		head = null;
		size = 0;
	}

	public CellList(CellList c) {
		CellNode t1,t2,t3;
		t1=c.head;
		while (t1!=null) {
			t3=new CellNode(t1.cell.clone(),null);
			if (head == null) {
				head=t2=t3;
			}
			t1=t1.nxt;
			t2=t3;
		}
		t2=t3=null;
	}

	public void addToStart(CellPhone cell) {
		head = new CellNode(cell, head);
		size++;
	}

	public void verify(int x) {
		try {
			if (x > (size - 1) || x < 0)
				throw new NoSuchElementException();

		} catch (NoSuchElementException e) {
			System.out.println("Wrong index, program will terminate!!");
			System.exit(0);
		}
	}

	public boolean insertAtIndex(CellPhone cell, int x) {
		verify(x);

		if (head == null) {
			System.out.println("List is empty!");
			return false;
		} else {
			CellNode t = head;
			int counter = 0;

			while (t.nxt != null) {
				if (x > counter) {
					t = t.nxt;
					counter++;
				} else if (x == counter) {
					t = new CellNode(cell, t);
					size++;
					return true;
				}
			}
		}
		return false;

	}

	public boolean deleteFromIndex(int x) {

		verify(x);
		if (head == null) {
			System.out.println("List is empty!");
			return false;
		}
		if (x == 0)
			return deleteFromStart();
		else {
			CellNode t = head;
			int counter = 0;
			while (t != null) {
				if (x - 1 > counter) {
					t = t.nxt;
					counter++;
				} else if (x - 1 == counter) {
					t = t.nxt.nxt;
					size--;
					return true;
				}
			}
			return false;
		}

	}

	private boolean deleteFromStart() {

		head = head.nxt;
		size--;
		return true;

	}

	public boolean replaceAtIndex(CellPhone cell, int x) {
		verify(x);

		if (head == null) {
			System.out.println("List is empty!");
			return false;
		} else {
			CellNode t = head;
			int counter = 0;

			while (t != null) {
				if (x > counter) {
					t = t.nxt;
					counter++;
				} else if (x == counter) {
					t = new CellNode(cell, t.nxt);
					return true;
				}
			}
		}
		return false;

	}

	public CellNode find(long sn) {
		int counter = 0;
		CellNode t = head;

		while (t != null) {
			counter++;
			if (t.cell.getSerialNum() == sn) {
				System.out.println(counter + " iterations have been done.");
				return t;
			} else
				t = t.nxt;

		}
		return null;

	}

	public boolean contains(long sn) {

		if (find(sn) == null)
			return false;
		else
			return true;

	}

	public void showContents() {
		CellNode t = head;
		System.out.println("The current size of the list is " + size + ".Here are the content of the list.");
		System.out.println("==============================================================================");
		while (t != null) {
			System.out.println(t.cell.toString() + " ---> ");
			t = t.nxt;
		}

		System.out.print("X");
	}

	public boolean equals(CellList c) {
		CellNode t=c.head;
		int count = 0;
		CellNode n = this.head;
		if (c.size != this.size)
			return false;
		while (c.size != count) {

			if (!t.cell.equals(n.cell)) {
				t=t.nxt;
				n=n.nxt;
				count++;
				continue;
			} else
				return false;
		}
		return true;

	}

	// ********************Beginning of CellNode class***************************
	private class CellNode {
		private CellPhone cell;
		private CellNode nxt;

		public CellNode() {
			cell = null;
			nxt = null;
		}

		public CellNode(CellPhone cell, CellNode nxt) {
			this.cell = cell;
			this.nxt = nxt;
		}

		// **********************NOT SURE***********************************
		public CellNode(CellNode c) {
			cell = c.cell.clone();
			nxt = c.nxt;
		}

		public CellNode clone() {
			return new CellNode(this);
		}

		public CellPhone getCell() {
			return cell;
		}

		public CellNode getNxt() {
			return nxt;
		}

		public void setCell(CellPhone cell) {
			this.cell = cell;
		}

		public void setNxt(CellNode nxt) {
			this.nxt = nxt;
		}

	}

}
