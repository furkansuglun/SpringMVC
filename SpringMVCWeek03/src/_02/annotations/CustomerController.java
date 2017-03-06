package _02.annotations;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	/* her bir customer id ye karsýlýk býr metot tanýmlayamayýz
	 * customer/1
	 * customer/2
	 * 
	 * customer/100
	 * 
	 * Bu gibi sorunlarý çözmek için @PathVariable kullaýcaz
	 */
	
	@RequestMapping("/pathVariable/{customerId}")
	/*// burada onemli nokta @RequestMapping annotationdaki {pathVariablename} ile
	// @PathVariable annotationdaki {pathVariablename} ismi ayni olmalidir.
	 * 
	 * 
	 * http://localhost:8080/SpringMVCWeek03/customer/pathVariable/1
	 * http://localhost:8080/SpringMVCWeek03/customer/pathVariable/2
	 * http://localhost:8080/SpringMVCWeek03/customer/pathVariable/100
	 * 
	 */
	public String getCustomerById(@PathVariable("customerId") String id , Model model) {
		model.addAttribute("message" , "getCustomerById#customer id : " + id);
		return "02.annotations.view/customerPage";
	}
	
	/*Bunlar ayný anlama gelir.Erðer pathvariable annotation unda bilgi yoksa deðþiken ismiyle ayný olacaktýr.
	 * 
	 * @PathVariable() String id 
	 * @PathVariable("id") String id 
	 */
	
	
	
	
	@RequestMapping("/pathVariable2/{day}/{month}/{year}")
	//http://localhost:8080/SpringMVCWeek03/customer/pathVariable2/22/02/2017
	public String getCustomerByBirthDay(@PathVariable("day") int day , @PathVariable("month") int month , 
			@PathVariable("year") int year , Model model) {
		
		LocalDate date = LocalDate.of(year, month, day);
		model.addAttribute("message" , "getCustomerByBirthDay# : " + date);
		return "02.annotations.view/customerPage";
	}
	
	
	//QUERY PARAM GENEL FORMAT / REQUEST PARAM GENEL FORMAT
	//path?queryParam=value1&queryParam2=value2
	
	@RequestMapping("/requestParam")
	//http://localhost:8080/SpringMVCWeek03/customer/requestParam?customerName=Furkan
	public String getCustomerByName(@RequestParam("customerName") String name , Model model) {
		
		model.addAttribute("message" , "getCustomerByName# : " + name);
		return "02.annotations.view/customerPage";
	}
	
	@RequestMapping("/requestParam2")
	//http://localhost:8080/SpringMVCWeek03/customer/requestParam2?customerName=Furkan&customerSurname=Süðlün
	public String getCustomerByNameAndSurname(@RequestParam("customerName") String name, 
			@RequestParam("customerSurname") String surname, Model model) {
		
		model.addAttribute("message" , "getCustomerByNameAndSurname# : " + name + " " + surname);
		return "02.annotations.view/customerPage";
	}
	
	
	// Matrix variable , Spring 3.2 versiyonuyla geldi.
		// matrixvariable complex ve fazla sayidaki URI parametrelerini yonetmek
		// icin kolaylik saglamaktadir.

		// GENEL FORMAT ;
		// path/matrixVariable1=value1,value2,value3...valueT;matrixVariable2=value1,value2..
		// valuex;

		// varsayilan olarak bu ozellik kapalidir.
	
	@RequestMapping("/matrixVariable/{filter}")
	//http://localhost:8080/SpringMVCWeek03/customer/matrixVariable/phoneNumber=05435234
	public String getCustomerByFilter1(@MatrixVariable(pathVar="filter") String phoneNumber , Model model) {
		model.addAttribute("message" , "getCustomerByFilter1# :" + phoneNumber);
		return "02.annotations.view/customerPage";
	}
	
	@RequestMapping("/matrixVariable2/{filter}")
	//http://localhost:8080/SpringMVCWeek03/customer/matrixVariable2/gender=erkek;cities=Istanbul,Ankara,Izmir
	public String getCustomerByFilter2(@MatrixVariable(pathVar="filter") String gender ,
			@MatrixVariable(pathVar="filter") List<String> cities, Model model) {
		
		model.addAttribute("message" , "getCustomerByFilter2# :" + gender + " " + cities);
		return "02.annotations.view/customerPage";
	}
	
	
	
}
