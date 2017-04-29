package com.suixue.discuss.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suixue.common.BaseController;
import com.suixue.common.BaseResponse;
import com.suixue.dicussaggoropp.domain.DiscussAggOrOpp;
import com.suixue.dicussaggoropp.service.DiscussAggOrOppService;
import com.suixue.discuss.domain.AnswerList;
import com.suixue.discuss.domain.AnswerVO;
import com.suixue.discuss.domain.Discuss;
import com.suixue.discuss.service.DiscussService;
import com.suixue.question.domain.Question;
import com.suixue.question.domain.Type;
import com.suixue.question.service.QuestionService;
import com.suixue.question.service.TypeService;
import com.suixue.user.service.UserService;

@Controller
@RequestMapping("/discuss")
public class DiscussController extends BaseController  {
	
	@Autowired
	private DiscussService discussService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private UserService userService;
	@Autowired
	private TypeService typeService;
	@Autowired
	private DiscussAggOrOppService discussAggOrOppService;
	
	
	/**
	 * 查询所有讨论列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/query/all", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse queryAllDiscuss() throws Exception{
		List<Discuss> allDiscussList = discussService.getList();
        return success(allDiscussList);
	}
	
	/**
	 * 根据相应参数查询相应的讨论列表
	 * @param discuss
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/query/param", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse queryDiscusssByParam(Discuss discuss, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		List<Discuss> discussList = discussService.queryDiscussesByParam(discuss);
        return success(discussList);
	}
	
	/**
	 * 插入一条新的讨论记录
	 * @param discuss
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse insert(Discuss discuss, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		discussService.insert(discuss);		
		return success(discuss);
	}
	
	/**
	 * 更新一条讨论记录
	 * @param discuss
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse update(Discuss discuss, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		discussService.update(discuss);		
		return success(discuss);
	}
	
	/**
	 * 根据讨论id删除一条讨论记录
	 * @param discuss
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse delete(Discuss discuss, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		discussService.delete(discuss);		
		return success(discuss);
	}
	
	/**
	 * 删除某一个问题的所有讨论，请求参数为问题ID
	 * @param questionId
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/deleteByQuestionId", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse deleteByQuestionId(String questionId, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		discussService.deleteByQuestionId(questionId);		
		return success("删除成功");
	}
	
	@RequestMapping(value="/discussList",method=RequestMethod.GET)
	public String getAnswerList(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		//将问题标签写入到jsp
		List<Type> allQuestionTypeList = typeService.getList();
		model.addAttribute("allQuestionType",allQuestionTypeList);
		return "discussList";
	}
	
	@RequestMapping(value="/discussList",method=RequestMethod.POST)
	@ResponseBody
	public String getAnswerListData() {
		
		
		return "discussList";
	}
	
	@RequestMapping(value="/answer",method=RequestMethod.GET)
	public String getAnswerPage() {
		
		return "answerList";
	}
	
	@RequestMapping(value = "/answerQuestion", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse answerQuestion(String questionId, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		//questionId = "1";
		AnswerVO answerVO = new AnswerVO();
		Question question = new Question();	
		question  = questionService.queryQuestionsById(questionId);
		String name = userService.getUserNameById(question.getCreateUserId()).getName();
		question.setCreateUserName(name);
		answerVO.setQuestion(question);
		int answerNum = discussService.queryAnswerNum(questionId);
		answerVO.setAnswerNum(answerNum);
		//该问题的直接回答列表，其中包括这些回答的所有回复
		List<AnswerList> answerList = new ArrayList();
		Discuss param = new Discuss();
		param.setLastLevel("0");
		param.setQuestionId(questionId);
		List<Discuss> derectAnswer = new ArrayList();
		//该问题的所有直接回答
		derectAnswer = discussService.queryDiscussesByParam(param);
		if(derectAnswer!=null){
			for(Discuss da:derectAnswer){
				AnswerList anList = new AnswerList();
				anList.setAnswerUserId(da.getSpeakerId());
				anList.setAgreeTimes(da.getAgreeTimes());
				anList.setAnswerContent(da.getContent());
				anList.setOpposeTimes(da.getOpposeTimes());
				String answerUserName =  userService.getUserNameById(da.getSpeakerId()).getName();
				anList.setAnswerUserName(answerUserName);
				anList.setCreateTime(da.getCreateTime());
				anList.setUpdateTime(da.getUpdateTime());
				anList.setLastLevel(da.getLastLevel());
				Discuss disParam = new Discuss();
				disParam.setQuestionId(questionId);
				disParam.setLastLevel(da.getId());
				disParam.setListnerId(da.getSpeakerId());
				disParam.setLastLevel(da.getId());
				List<Discuss> answerSimpleList = new ArrayList();
				answerSimpleList = discussService.queryDiscussesByParam(disParam);
				if(answerSimpleList!=null){
					anList.setAnswerNum(answerSimpleList.size());
					for(Discuss p:answerSimpleList){
						String aun =  userService.getUserNameById(p.getSpeakerId()).getName();
						p.setSpeakerName(aun);
					}
					
				}else{
					anList.setAnswerNum(0);
				}
				anList.setDiscussList(answerSimpleList);
				answerList.add(anList);
			}
		}
		answerVO.setAnswerList(answerList);
		return success(answerVO);
	}
	
	/**
	 * 点击赞同时
	 * @param discuss
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/agree", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse agree(String discussId,String userId, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		DiscussAggOrOpp discussAggOrOpp = new DiscussAggOrOpp();
		discussAggOrOpp.setUserId(userId);
		discussAggOrOpp.setDiscussId(discussId);
		Discuss param = new Discuss();
		param.setId(discussId);
		Discuss discuss = discussService.get(param);
		int num = discussAggOrOppService.agree(discussAggOrOpp);
		if(num == 0){
			//该用户对于这个回答本来就有赞同票
		}else if(num == 1){//该用户对于这个回答没有赞同票或者反对票
			int times = Integer.valueOf(discuss.getAgreeTimes());
			times++;
			String finalTimes = String.valueOf(times);	
			discuss.setAgreeTimes(finalTimes);
			discussService.update(discuss);		
		}else{//该用户对于这个回答有反对票
			int timesOne = Integer.valueOf(discuss.getAgreeTimes());
			timesOne++;
			String finalTimes = String.valueOf(timesOne);
			discuss.setAgreeTimes(finalTimes);
			int timesTwo = Integer.valueOf(discuss.getOpposeTimes());
			timesTwo--;
			String finalTimesTwo = String.valueOf(timesOne);
			discuss.setOpposeTimes(finalTimesTwo);
			discussService.update(discuss);		
		}		
		return success(discuss);
	}
	
	/**
	 * 点击反对时
	 * @param discussId
	 * @param userId
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/oppose", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse oppose(String discussId,String userId, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		DiscussAggOrOpp discussAggOrOpp = new DiscussAggOrOpp();
		discussAggOrOpp.setUserId(userId);
		discussAggOrOpp.setDiscussId(discussId);
		Discuss param = new Discuss();
		param.setId(discussId);
		Discuss discuss = discussService.get(param);
		int num = discussAggOrOppService.agree(discussAggOrOpp);
		if(num == 0){
			//该用户对于这个回答本来就有反对
		}else if(num == 1){//该用户对于这个回答没有赞同票或者反对票
			int times = Integer.valueOf(discuss.getOpposeTimes());
			times++;
			String finalTimes = String.valueOf(times);	
			discuss.setOpposeTimes(finalTimes);
			discussService.update(discuss);		
		}else{//该用户对于这个回答有赞同票没有反对票
			int timesOne = Integer.valueOf(discuss.getOpposeTimes());
			timesOne++;
			String finalTimes = String.valueOf(timesOne);	
			discuss.setOpposeTimes(finalTimes);
			int timesTwo = Integer.valueOf(discuss.getAgreeTimes());
			timesTwo--;
			String finalTimesTwo = String.valueOf(timesOne);
			discuss.setAgreeTimes(finalTimesTwo);
			discussService.update(discuss);		
		}		
		return success(discuss);
	}
}
