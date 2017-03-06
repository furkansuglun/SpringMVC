package _01.notes;

public class Notes {

}

//MVC -> Model View Controller bir design pattern'dir.

//1970 yilina dayanmaktadir.

//MVC yaklasiminin en onemli noktasi "separation of concern"
//separation of concern -> islerin/etkilerin/iliskilerin ayristirilmasi olarak dusunebiliriz.
//bu da bizim icin temiz bir mimari/temiz code (clean code) ve bakimi kolay kod ozelligi saglayacaktir.


//Model 
//model siniflarimiz -> pojo'ariiz -> plain old java object dedigimiz java siniflarmiz olacaktir.
//bir kutuphane sisetmi dusunursek ;

//Book.java Author.java Publisher.java  gibi siniflari/modelleri/domainleri dusunebiliriz.
//bir ders programi sistemi ;
//Student.java ClassRoom.java Teacher.java gibi siniflari/modelleri/ dusunebiliriz.
//
//View
//View , sunumdan/presentation dan sorumludur.
//Controlller, datayi/modeli View'e yonlendirir. View de bu datayi/modeli gosterecektir.

//JSP , Facelets (xhtml) , PDF , XML , JSON , FreeMarker , Apache Velocity, thymeleaf vs

//Controller
//Controller , istegin karsilanmasindan sorumludur. (handle request)


//MVC design patterni ;

//separation of concern' prensibini uygulariz.
//loose coupling
//+ olarak cohesion saglar.
//spring mvc ogrenme maliyeti (-)
//uygulamanin complexity artmaktadir(-)

//Spring MVC , MVC model2 yaklasimini kullanir.
//Bu yaklasimda onde bir Front Controller yer almaktadir. 
//Projeye istek geldigince bu Front controller calismaktadir.

//#### Application Layering

//en basic  katmanlý mimamri;

//Presentation Layer
//Service Layer
//Data Layer

//-----

//Spring MVC Application Layer

//Domain Layer(cross cutting bir layerdýr. her katman bu katmaný kullanabilir.)(person student etc. 
															//classlarýmýz bu katmaný olusturur)
//User Interface Layer
//Web Layer
//Service Layer
//Data Access Layer

//------
//### Domain Layer
//Domain'e ozgu siniflarimiz/modellerimiz.
//Transaction.java Order.java  Account.java Customer.java vs gibi siniflar/modeller olacaktir.

//### User Interface Layer
//User Interface Layer --> View 
//Uygulamayi son kullaniciya gosterdigimiz katman/layer
//JSP , XML , JSON , FreeMarker vs

//### Web Layer
//Controller kismidir!
//Kullanicinin yaptigi isteklere karsilik olarak istegi karsilamak/ URL mapping'i yapmak.
//Gelen HTTP istegini karsilar , Service Layer'i cagirir.
//Asil isi Service Layer'i yapar. Business Logic'i Controllerda uygulamak uygun degildir.
//Web Layer katmaindan cookie, session, header vs gibi isler yapilabilir.


//2 tip Web Layer yaklasimi vardir.
//Component Based (JSF, Tapestry)
//Request/Response Based (Spring MVC)

//Spring MVCde controller tanimlamak icin 2 temel yaklasim vardir.

//1) @Controller annotationini kullanmak.
//(org.springframework.stereotype.Controller)

//2) Controller arabirimini implement etmek.
//(org.springframework.web.servlet.mvc.Controller)

//### Service Layer
//Uygulamamizin asil kismi burasi olacaktir. Service Layer , business logic'in yer aldigi katmandir.
//Service Layer --> Data Access layer'a erisirek ve Domain Layerdan yararlanarak IS yapar.
//bu katmanda bizim kendi yazdigimiz uygulama kodlari olacak.
//bu noktada transaction yonetimi gibi isler icin Spring'ten destek almaktayiz.

//### Data Access Layer
//Veritabani ile iliskili/ilgili layer.
//Spring ile JDBC, JPA , Hibernate gibi urunlere/frameworkleri kullanabiliriz.
//Spring bu yapilarla son derece uyumlu sekilde calismaktadir. Kendi bunyesinde abstraction classlar saglamaktadir.