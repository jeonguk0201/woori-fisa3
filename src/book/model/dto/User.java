package book.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter  
@Setter
public class User {
	
	/** 수혜자 번호 : pk*/
	private String name;

	/** 수혜자 이름 */
	private int age;  

	/** 수혜자 연락처 */
	private String gender;


}
