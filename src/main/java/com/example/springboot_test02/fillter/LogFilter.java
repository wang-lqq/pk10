package com.example.springboot_test02.fillter;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.AddDefaultCharsetFilter.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.springboot_test02.util.IpUtil;

public class LogFilter implements Filter{
	private Logger logger= LoggerFactory.getLogger(getClass());
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		ResponseWrapper wrapper = new ResponseWrapper((HttpServletResponse)response, null);
		
		StringBuffer requestUrl=req.getRequestURL();
		logger.info("requestUrl:"+requestUrl.toString());
		logger.info("requesetMethod:"+req.getMethod());
		logger.info("Status:"+wrapper.getStatus());
		logger.info("ip:"+IpUtil.getIpAddr(req));
		getDate(req.getParameterMap());
		Map<String,String[]> map=req.getParameterMap();
		
		chain.doFilter(request,response);
		System.out.println("response");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	public void getDate(Map<String,String[]> map) {
		Set set=map.keySet();
		for (Object object : set) {
			System.out.println("ParametersName:"+object.toString());
			String[] str=map.get(object);
			for (String s : str) {
				System.out.print("ParametersValue:"+s+"---");
			}
			System.out.println();
		}
	}
}
