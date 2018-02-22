package com.lvhong.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lvhong.util.VerificationCode;

@Controller
@RequestMapping("/blogs")
public class VerificationCodeController {
	@RequestMapping("/verificationCode")
	public void verificationCode(HttpServletResponse response,HttpSession session) {
		VerificationCode verificationCode = new VerificationCode();
		try {
			verificationCode.drawImage(response.getOutputStream());
			session.setAttribute("verificationCode", verificationCode.getCode());
		} catch (IOException e) {
			
		}
	}
}
