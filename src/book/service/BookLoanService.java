
package book.service;

import java.util.ArrayList;

import book.model.dto.Book;
import book.model.dto.Loan;
import book.model.dto.User;

public class BookLoanService {

	// singleton design pattern
	private static BookLoanService instance = new BookLoanService();
	private BookLoanService() {}
	
	//보유하고 있는 Book 저장
	private ArrayList<Book> bookList = new ArrayList<Book>();
	private ArrayList<Loan> loanList = new ArrayList<Loan>();
	
	public static BookLoanService getInstance() {
		return instance;
	}

	/**
	 * 모든 Project 검색
	 * 
	 * @return 모든 Project
	 */
	public ArrayList<Book> getBooksList() {
		return bookList;
	}

	public Book getBook(String bookTitle) {
		for (Book book : bookList) {
			if (book != null && book.getTitle().equals(bookTitle)) {
				return book; // 메소드 자체의 종료
			}
		}

		return null;
	}
	
	public Book getBookTitle(String bookTitle) {
		for(Book book : bookList) {
			if(book != null && book.getTitle().equals(bookTitle)) {
				return book;
			}
		}
		return null;
	}
	
	public void insertBook(Book book) throws Exception {

		Book b = getBook(book.getTitle());

		if (b != null) {
			throw new Exception("해당 book명은 이미 존재합니다. 재 확인하세요");
		}

		bookList.add(book);

	}
	
	public void insertBookLoan(Loan loan) throws Exception {
		// 대출 내역 확인 생략
		loanList.add(loan);
	}


	public Book getDonationProject(String BookTitle) {
		for (Book project : bookList) {
			if (project != null && project.getTitle().equals(BookTitle)) {
				return project; // 메소드 자체의 종료
			}
		}

		return null;
	}
	
	public ArrayList<Loan> getUserHistory(String name) {
		
		ArrayList<Loan> loans = new ArrayList<Loan>();
		
		for (Loan loan : loanList) {
			if (loan != null && loan.getName().equals(name)) {
				loans.add(loan);
			}
		}
		return loans;
	}
	
	public void updateBookLoan(int index, Loan loan) throws Exception {
		int count = loan.getNumb();
		loan.setNumb(++count);
//		loanList.set(index-1, loan);
		loanList.get(index-1).setNumb(++index);
	}
	
	public boolean deleteBookLoan(Loan loan) {
		
		for(Loan l : loanList) {
			if (l != null && l.getTitle().equals(loan.getTitle())) {
				loanList.remove(loan);
				return true;
			}
		}
		return false;
	}

}











