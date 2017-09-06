package com.imooc.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imooc.util.VerificationCode;

public class VerificationCodeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Pragma", "no-cache");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/jpeg");
		//生成随机验证码
		String verifyCode=VerificationCode.generateVerifyCode(4);
		//存入Session
		HttpSession session=req.getSession(true);
		//删除之前的
		session.removeAttribute("verifyCode");
		session.setAttribute("verifyCode", verifyCode);
		//生成图片
		int width=100;
		int height=30;
    //调用VerificationCode类中的静态方法outputImage用ImageIO.write()方法
		VerificationCode.outputImage(width, height, resp.getOutputStream(), verifyCode);
	}
}
