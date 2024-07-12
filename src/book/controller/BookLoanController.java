package book.controller;

import java.util.ArrayList;

import book.model.dto.Book;
import book.model.dto.Loan;
import book.service.BookLoanService;
import book.view.EndView;
import book.view.FailView;

public class BookLoanController {

	private static BookLoanController instance = new BookLoanController();

	private static BookLoanService service = BookLoanService.getInstance();

	private BookLoanController() {
	}

	public static BookLoanController getInstance() {
		return instance;
	}

	/**
	 * 브라우저의 입력창(form)에 입력없이 데이터 전송: ""(문자열 객체), 길이는 0 미존재하는 요청 = server애선 null로 인식
	 * 
	 * 모든 Project 검색
	 * 
	 * @return 모든 Project
	 */
	public void getBooksList() {
		EndView.BookListView(service.getBooksList());
	}

	public void insertBook(Book book) {
		String bookName = book.getTitle();

		if (bookName != null && bookName.length() != 0) {
			try {

				service.insertBook(book);
				EndView.successMessage("새로운 책 등록 성공했습니다.");

			} catch (Exception e) {
				FailView.failViewMessage(e.getMessage()); // 실패인 경우 예외로 end user 서비스
				e.printStackTrace();
			}
		} else {
			FailView.failViewMessage("입력 부족, 재 확인 하세요~~");
		}

	}

	public void getBookTitle(String BookTitle) {
		EndView.BookListView(service.getBook(BookTitle));
	}

	public void insertBookLoan(Loan loan) {
		String bookTitle = loan.getTitle();
		Book book = service.getBookTitle(bookTitle);

		if (bookTitle != null && bookTitle.length() != 0) {
			try {

				service.insertBookLoan(loan);
				EndView.successMessage("대출에 성공했습니다.");

			} catch (Exception e) {
				FailView.failViewMessage(e.getMessage()); // 실패인 경우 예외로 end user 서비스
				e.printStackTrace();
			}
		} else {
			FailView.failViewMessage("재고가 없습니다.");
		}

	}

	public void getUserHistory(String loanPerson) {

		ArrayList<Loan> loanList = service.getUserHistory(loanPerson);
		if (loanList != null) {
			EndView.bookLoanView(loanList);
		} else {
			FailView.failViewMessage("대출 내역이 없습니다.");
		}

	}
	
	public void updateBookLoan(int index, Loan loan) {
		int loanCount = loan.getNumb();
		
		if(loan != null && loanCount < 1) {
			try {
				service.updateBookLoan(index, loan);
				EndView.successMessage("연장에 성공했습니다.");
			}catch (Exception e) {
				FailView.failViewMessage(e.getMessage()); 
				e.printStackTrace();
			}
		} else {
			FailView.failViewMessage("더 이상 연장이 불가능 합니다.");
		
		}
		
		
		
	}
	
	public void deleteBookLoan(Loan loan) {
		boolean result = service.deleteBookLoan(loan);
		
		if(result) {
			EndView.successMessage("반납 성공");
		} else {
			FailView.failViewMessage("반납 실패");
		}
	}
}
