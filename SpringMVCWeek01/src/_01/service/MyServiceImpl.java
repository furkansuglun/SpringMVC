package _01.service;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService  {

	@Override
	public String printMessage() {
		return "MyServiceImplMessage...Hello MVC ";
	}

}
