package validator;

import org.springframework.beans.factory.annotation.Autowired;

public class Notes {

}


// 1 ) org.springframework.validation.Validator interfacesi implement ettik. @Component , @Service ..
// 2 ) ilgili senaryolara gore validation kurallarini yaziyoruz.

//required.productId= Invalid product id. It should be minimum 5 characters
//required.productId= Ürün kodu en az 5 karekter girilmelidir.
//errors.rejectValue("productId", "required.productId");
//
//productId  ==--> Product#productId
//
//required.productId --> properties dosyasindaki key karsiligi

// 3) formu submit ettigimiz metotta BindingResult binfingResult parametresini ekledik.

// 4) validate metodunu cagiryoruz.


//@Autowired
//private ProductValidator productValidator;

//productValidator.validate(productToBeAdded, br); //validator'i cagir

// 5) herhangi bir hata varsa ayni form sayfasini don.
//if(br.hasErrors()){
//	return "01.webstore.view/productAdd";
//}	

// 6) herhangi bir hata yoksa devam et
//productService.addProduct(productToBeAdded);
//return "redirect:/products";