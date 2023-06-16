package com.itwillbs.spring_mvc_board;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		// 디바이스 판별을 위한 Device 객체 얻어오기(HttpServletRequest 객체 필요)
		Device device = DeviceUtils.getCurrentDevice(request);
		
		// 디바이스 판별
		if(device != null) {
			if(device.isNormal()) { // 일반 디바이스 = PC
				logger.info("＠＠＠＠＠ PC 접속 ＠＠＠＠＠");
				System.out.println("＠＠＠＠＠ PC 접속 ＠＠＠＠＠");
				
				return "index";
			} else if(device.isMobile()) { // 모바일 디바이스
				logger.info("★★★★★★ 모바일 접속 ★★★★★★");
				System.out.println("★★★★★★ 모바일 접속 ★★★★★★");
				
				return "m_index";
			} else if(device.isTablet()) { // 태블릿 디바이스
				logger.info("○○○○○○ 태블릿 접속 ○○○○○○");
				System.out.println("○○○○○○ 태블릿 접속 ○○○○○○");
			}
				
		}
		
		System.out.println("HomeController222222");
		return "index";
	}
	
}











