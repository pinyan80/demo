//package com.tabletype.controller;
//
//import java.io.*;
//import java.util.*;
//
//
//import javax.servlet.*;
//
//import javax.servlet.http.*;
//import com.tabletype.model.*;
//
//
//public class TableTypeServlet extends HttpServlet{
//	public void doGet(HttpServletRequest req, HttpServletResponse res)
//			throws ServletException, IOException {
//		doPost(req, res);
//	}
//
//	public void doPost(HttpServletRequest req, HttpServletResponse res)
//			throws ServletException, IOException {
//
////		req.setCharacterEncoding("UTF-8");
//		String action = req.getParameter("action");
//		
//		
//		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
//				String str = req.getParameter("tableId");
//				if (str == null || (str.trim()).length() == 0) {
//					errorMsgs.add("�п�J�૬�s��");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/tabletype/select_page.jsp");
//					failureView.forward(req, res);
//					return;//�{�����_
//				}
//				
//				Integer tableId = null;
//				try {
//					tableId = Integer.valueOf(str);
//				} catch (Exception e) {
//					errorMsgs.add("�૬�s���榡�����T");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/tabletype/select_page.jsp");
//					failureView.forward(req, res);
//					return;//�{�����_
//				}
//				
//				/***************************2.�}�l�d�߸��*****************************************/
//				TableTypeService tableSvc = new TableTypeService();
//				TableTypeVO tableTypeVO = tableSvc.getOneTableType(tableId);
//				if (tableTypeVO == null) {
//					errorMsgs.add("�d�L���");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/tabletype/select_page.jsp");
//					failureView.forward(req, res);
//					return;//�{�����_
//				}
//				
//				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
//				req.setAttribute("tableTypeVO", tableTypeVO); // ��Ʈw���X��empVO����,�s�Jreq
//				String url = "/tabletype/listOneTableType.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
//				successView.forward(req, res);
//		}
//		
//		
//		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllEmp.jsp���ШD
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//			
//				/***************************1.�����ШD�Ѽ�****************************************/
//				Integer tableId = Integer.valueOf(req.getParameter("tableId"));
//				
//				/***************************2.�}�l�d�߸��****************************************/
//				TableTypeService tableSvc = new TableTypeService();
//				TableTypeVO tableVO = tableSvc.getOneTableType(tableId);
//								
//				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
//				req.setAttribute("tableVO", tableVO);         // ��Ʈw���X��empVO����,�s�Jreq
//				String url = "/tabletype/update_table_type_input.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_emp_input.jsp
//				successView.forward(req, res);
//		}
//		
//		
//		if ("update".equals(action)) { // �Ӧ�update_emp_input.jsp���ШD
//			
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//		
//				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
//				Integer tableId = Integer.valueOf(req.getParameter("tableId").trim());
//				Integer tableType = null;
//				try {
//					tableType = Integer.valueOf(req.getParameter("tabletype").trim());
//				}catch (NumberFormatException e) {
//					tableType=0;
//					errorMsgs.add("�п�J�૬�H��");
//				}
//				
//				Integer tableTypeNumber = null;
//				try {
//				tableTypeNumber =Integer.valueOf(req.getParameter("tabletypenumber").trim());
//				}catch (NumberFormatException e) {
//					tableTypeNumber=0;
//					errorMsgs.add("�п�J��l�i��");
//				}
//				
//				
//					
//
//				TableTypeVO tableVO = new TableTypeVO();
//				tableVO.setTableId(tableId);
//				tableVO.setTableType(tableType);
//				tableVO.setTableTypeNumber(tableTypeNumber);
//				
//
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//req.setAttribute("tableVO", tableVO); // �t����J�榡���~��empVO����,�]�s�Jreq
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/tabletype/update_table_type_input.jsp");
//					failureView.forward(req, res);
//					return; //�{�����_
//				}
//				
//				/***************************2.�}�l�ק���*****************************************/
//				TableTypeService tableSvc = new TableTypeService();
//				tableVO = tableSvc.updateTableType(tableId,tableType,tableTypeNumber);
//				
//				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/
//				req.setAttribute("tableTypeVO", tableVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
//				String url = "/tabletype/listOneTableType.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneEmp.jsp
//				successView.forward(req, res);
//		}
//
//        if ("insert".equals(action)) { // �Ӧ�addEmp.jsp���ШD  
//			
//        	List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//			
//				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
//		
//				// Send the use back to the form, if there were errors
//				Integer tableType = null;
//				
//				try {
//					tableType = Integer.valueOf(req.getParameter("tabletype").trim());
//				} catch (NumberFormatException e) {
//					
//					errorMsgs.add("�H�ƽж�Ʀr.");
//				}
//				Integer tableTypeNumber =null;
//				try {
//					tableTypeNumber = Integer.valueOf(req.getParameter("tabletypenumber").trim());
//				} catch (NumberFormatException e) {
//					
//					errorMsgs.add("�ƶq�ж�Ʀr.");
//				}
//				
//				
//				
//				
//				
//			
//			
//				
//			
//
//				TableTypeVO tableVO = new TableTypeVO();
//				
//				tableVO.setTableType(tableType);
//				tableVO.setTableTypeNumber(tableTypeNumber);
//
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//req.setAttribute("tableTypeVO", tableVO); // �t����J�榡���~��empVO����,�]�s�Jreq �I��G��
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/tabletype/addTable.jsp");
//					failureView.forward(req, res);
//					return;
//				}
//				
//				/***************************2.�}�l�s�W���***************************************/
//				TableTypeService tableSvc = new TableTypeService();
//				tableVO = tableSvc.addTableType(tableType,tableTypeNumber);
//				
//				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
//				String url = "/tabletype/listAllTableType.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
//				successView.forward(req, res);				
//		}
//		
//		
//		if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//	
//				/***************************1.�����ШD�Ѽ�***************************************/
//				Integer tableId = Integer.valueOf(req.getParameter("tableId"));
//				
//				/***************************2.�}�l�R�����***************************************/
//				TableTypeService tableSvc = new TableTypeService();
//				tableSvc.deleteTableType(tableId);
//				
//				/***************************3.�R������,�ǳ����(Send the Success view)***********/								
//				String url = "/tabletype/listAllTableType.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
//				successView.forward(req, res);
//		}
//	}
//}
