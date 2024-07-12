package book.view;
/*
 * 실행 프로세스
 * StartView -> Controller -> Service -> DAO -> DB
 * -> DAO -> Service -> Controller -> 정상 view
 * 									-> 실패 view
 *
 * Controller : 정상/비정상 구분
 * 		조건문 또는 예외처리
 */
import book.controller.BookLoanController;
import book.model.dto.Book;
import book.model.dto.Loan;
import book.model.dto.User;
public class StartView {
	
	public static void main(String[] args) {
		
		User user1 = new User("이연희", 22, "여");
		User user2 = new User("이정민", 23, "여");
		User user3 = new User("이정욱", 17, "남");
		User user4 = new User("이유나", 20, "여");
		
		Book book1 = new Book("어린 왕자", "생텍쥐페리", 1);
		Book book2 = new Book("노인과 바다", "헤밍웨이", 2);
		Book book3 = new Book("누가 내 머리에 똥 쌌어", "홀츠바르트", 2);
		
		Loan loan1 = new Loan(0, "누가 내 머리에 똥 쌌어", "이정욱");
		Loan loan2 = new Loan(1, "노인과 바다", "이연희");
		BookLoanController controller = BookLoanController.getInstance();
		
		System.out.println("*** 01. 책 정보 추가 ***");
		controller.insertBook(book1);
		controller.insertBook(book2);
		controller.insertBook(book3);
		
		System.out.println("\n*** 02. 모든 책 검색 ***");
		controller.getBooksList();
		
		System.out.println("\n*** 03. 책 이름 '어린 왕자' Book 검색");
		controller.getBookTitle("어린 왕자");
		
		System.out.println("\n*** 04. 대출 내역 추가");
		controller.insertBookLoan(loan1);
		controller.insertBookLoan(loan2);
		
		System.out.println("\n*** 05. '이정욱' 이름으로 도서 대출 내역 조회");
		controller.getUserHistory("이정욱");
		
		System.out.println("\n*** 06. 책 대출 연장");
		controller.updateBookLoan(1, loan1); // 연장 성공
		controller.updateBookLoan(2, loan2); // 연장 실패2
		
		System.out.println("\n*** 07. 책 대출 반납");
		controller.deleteBookLoan(loan1); 
	}
}