
package book.view;

import java.util.ArrayList;

import book.model.dto.Book;
import book.model.dto.Loan;

public class EndView {
	
	//진행중인 특정 프로젝트 출력 
	public static void projectView(Book book){
		if(book != null) {
			System.out.println(book);	//project.toString()	
		}else {
			System.out.println("해당 프로젝트는 존재하지 않습니다.");
		}
	}
	
	//진행중인 모든 프로젝트 출력
	public static void BookListView(ArrayList<Book> allBook){
		
		int index = 1;
		for(Book book : allBook) {
			
			if(book != null){
				System.out.println("[제목 : " + (index++) + "] " + book.getTitle());
			}
			
		}
	}
	
	public static void BookListView(Book book){
		if(book != null) {
			System.out.println("제목: "+book.getTitle()+ ", "+ "저자: "+book.getAuthor() + ", " +"재고: "+ book.getNum());	//project.toString()	
		}else {
			System.out.println("해당 프로젝트는 존재하지 않습니다.");
		}
	}

	public static void successMessage(String message) {
		System.out.println(message);
	}
	
	public static void bookLoanView(ArrayList<Loan> loanList) {

		for(Loan l : loanList) {
			if(l != null) {
				System.out.println(l.toString());
			}
		}
	}
	
}






