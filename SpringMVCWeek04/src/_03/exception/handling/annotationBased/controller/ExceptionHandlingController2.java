package _03.exception.handling.annotationBased.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionHandlingController2 {

	@RequestMapping("/sqlException2")
	//http://localhost:8080/SpringMVCWeek04/sqlException2
	String throwSQLException() throws SQLException {
		System.out.println("SQLException 2....");
		throw new SQLException();
	}

	@RequestMapping("/indexOutOfBoundsException2")
	//http://localhost:8080/SpringMVCWeek04/indexOutOfBoundsException2
	String throwIndexOutOfBoundsException() {
		System.out.println("IndexOutOfBoundsException 2....");
		throw new IndexOutOfBoundsException();
	}

	
	//burada @Exception Handler tanýmlamadýgýmýz ýcýn Generiðe düþecektir hata
}