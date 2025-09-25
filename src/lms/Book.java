package lms;

public class Book {
	private int id;
	private String title;
	private String author;
	private boolean isIssued;
	public Book(int id, String title, String author) {
		
		this.id = id;
		this.title = title;
		this.author = author;
		this.isIssued = false;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isIssued() {
		return isIssued;
	}
	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}
	 public void issue() { isIssued = true; }
	    public void returnBook() { isIssued = false; }
	
	@Override
	public String toString() {
		return id +" - " + title + " by " + author + (isIssued ? " [Issued]" : " [Available]"); 	}
	

}
