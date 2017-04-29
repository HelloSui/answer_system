package com.suixue.dicussaggoropp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suixue.common.BaseController;
import com.suixue.dicussaggoropp.domain.DiscussAggOrOpp;
import com.suixue.dicussaggoropp.service.DiscussAggOrOppService;

@Controller
@RequestMapping("/dicussaggoropp")
public class DiscussAggOrOppController extends BaseController  {
	
	@Autowired
	private DiscussAggOrOppService discussAggOrOppService;
	
	
	/**
	 * 根据参数查询是否有此记录，有则返回true,否则返回false
	 * @param discussAggOrOpp
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/query/param", method = RequestMethod.GET)
	@ResponseBody
	public Boolean queryDiscussAggOrOppByParam(DiscussAggOrOpp discussAggOrOpp, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		DiscussAggOrOpp discussAggOrOppList = discussAggOrOppService.get(discussAggOrOpp);
		if(discussAggOrOppList == null){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 插入一条新的记录
	 * @param type
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	@ResponseBody
	public void insert(DiscussAggOrOpp discussAggOrOpp, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		discussAggOrOppService.insert(discussAggOrOpp);		
	}
	
	/**
	 * 更新记录
	 * @param type
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	public void update(DiscussAggOrOpp discussAggOrOpp, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		discussAggOrOppService.update(discussAggOrOpp);		
	}
	
	/**
	 * 删除一个记录
	 * @param type
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public void delete(DiscussAggOrOpp discussAggOrOpp, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		discussAggOrOppService.delete(discussAggOrOpp);	
	}
}
