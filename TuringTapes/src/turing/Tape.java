package turing;

public class Tape {
	Cell currentC;
	
	public Tape() {	
		Cell newCell = new Cell();
		currentC=newCell;
	}
	
	public Tape(Cell cell) {
		currentC=cell;
	}
	
	/**
	 * returns the pointer that points to the current cell
	 * @return pointer to current cell
	 */
	public Cell getCurrentCell() {
		return this.currentC;
	}
	
	/**
	 * returns the char from the current cell
	 * @return char content of cell
	 */
	public char getContent() {
		return this.currentC.content;
	}
	
	/**
	 * changes the char in the current cell to the specified value
	 * @param ch the value to change the content to
	 */
	public void setContent(char ch) {
		this.currentC.content = ch;
	}
	
	/**
	 * moves the current cell one position to the left along the tape
	 * If the current cell is the leftmost cell that exists, then a new 
	 * cell is created and added to the tape at the left of the current 
	 * cell, and then the current cell pointer is moved to point to the
	 * new cell. The content of the new cell is a blank space.
	 */
	public void moveLeft() {
		if (this.currentC.prev == null) {
			Cell newCell = new Cell();
			newCell.content = ' ';
			newCell.next = currentC;
			currentC = newCell;
		}else{currentC = currentC.prev;}
	}
	
	/**
	 * moves the current cell one position to the right along the tape
	 * If the current cell is the rightmost cell that exists, then a new 
	 * cell is created and added to the tape at the right of the current 
	 * cell, and then the current cell pointer is moved to point to the
	 * new cell. The content of the new cell is a blank space.
	 */
	public void moveRight() {
		if (this.currentC.next == null) {
			Cell newCell = new Cell();
			newCell.content = ' ';
			newCell.prev = currentC;
			currentC = newCell;
		}else{currentC = currentC.next;}
	}
	
	/**
	 * returns a String consisting of the chars from all the cells on the 
	 * tape, read from left to right, except for leading or trailing blank
	 * characters.
	 * @return a String of all tape contents
	 */
	public String getTapeContents() {
		Cell runner = currentC;
		while (runner.prev != null){
			runner = runner.prev;
		}
		if (runner.content==' ')
			runner=runner.next;
		String tapeContent="";
		while (runner.next != null){
			tapeContent.concat(Character.toString(runner.content));
			runner=runner.next;
		}
		return tapeContent;
	}
}
