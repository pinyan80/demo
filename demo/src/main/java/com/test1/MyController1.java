package com.test1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller  //ch2-p65, ch3-p77, ch8-p139
public class MyController1 {
	
	@GetMapping("/")  //ch2-p65, ch3-p77, ch8-p139
	public String myMethod() {
		return "index"; // --> src/main/resources/templates/index.html --> ch8-p137(p265) ;p264	
	}
	@GetMapping("form1")  //ch2-p65, ch3-p77, ch8-p139
	public String myMethod1() {
		return "form1"; // --> src/main/resources/templates/form.html --> ch8-p137(p265) ;p264	
	}
	@GetMapping("form2")  //ch2-p65, ch3-p77, ch8-p139
	@ResponseBody
	public String myMethod2() {
		return "<b><font color=red>form2</font></b>";
	}

}
