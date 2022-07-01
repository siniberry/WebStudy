/*============================================
   MVCTest02.java
   - Controller 역할을 수행할 서블릿 클래스
============================================ */

package com.svt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.MVCTest02Model;

public class MVCTest02 extends HttpServlet
{

	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGetPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGetPost(request, response);
	}
	
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 서블릿 관련 코딩
		
		// 모델 객체 생성 및 모델이 처리한 결과 수신(View 정보 획득)
		MVCTest02Model model = new MVCTest02Model();
		String view = model.actionCount(request, response);
		
		
		// 이 부분이 MVCTest01과 다름 
		// 컨트롤러가 등장함으로써, 모델과 뷰가 직접 만나지 않음
		// MVCTest01에서는 컨트롤러가 직접 업무처리를 했는데 여기서 컨트롤러는 실질적으로 하는 게 없음
		// 컨트롤러는 오케이 ~ 최종 컨펌 도장만 찍음
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);


	
	}
	
}
