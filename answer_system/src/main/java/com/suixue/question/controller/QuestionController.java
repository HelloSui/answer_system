package com.suixue.question.controller;

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

import com.github.pagehelper.PageHelper;
import com.suixue.common.BaseController;
import com.suixue.common.BaseResponse;
import com.suixue.common.Page;
import com.suixue.discuss.domain.Discuss;
import com.suixue.discuss.service.DiscussService;
import com.suixue.question.domain.Question;
import com.suixue.question.domain.QuestionParam;
import com.suixue.question.domain.Type;
import com.suixue.question.service.QuestionService;
import com.suixue.question.service.TypeService;
import com.suixue.user.domain.User;
import com.suixue.user.domain.UserRole;
import com.suixue.user.service.UserRoleService;
import com.suixue.user.service.UserService;

@Controller
@RequestMapping("/question")
public class QuestionController extends BaseController  {
	
	@Autowired
	private QuestionService questionService;
	@Autowired
	private DiscussService discussService;
	@Autowired
	private TypeService typeService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	/**
	 * 查询所有的问题列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/query/all", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse queryAllQuestion() throws Exception{
		List<Question> allQuestionList = questionService.getList();
        return success(allQuestionList);
	}
	
	/**
	 * 根据参数查询问题列表
	 * @param question
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/query/param", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse queryQuestionsByParam(QuestionParam question, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		PageHelper.startPage(question.getPageNo(), question.getPageSize());
		List<Question> questionList = questionService.queryQuestionsByParam(question);
		
		Page<Question> page = new Page<>();
		page.setPageData(questionList);
        return success(page);
	}
	
	/**
	 * 插入一条新问题
	 * @param question
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse insert(Question question, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		questionService.insert(question);		
		return success(question);
	}
	
	/**
	 * 更新一个问题记录
	 * @param question
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse update(Question question, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		questionService.update(question);		
		return success(question);
	}
	
	/**
	 * 删除一个问题记录，同时删除该问题的所有讨论列表
	 * @param question
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse delete(Question question, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		questionService.delete(question);
		discussService.deleteByQuestionId(question.getId());
		return success(question);
	}
	
	@RequestMapping(value = "/ask", method = RequestMethod.GET)
	public String askQuestion(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		if(currentUser == null) {
			currentUser = new User();
			currentUser.setId("123");
			currentUser.setName("suixue");
		}
		model.addAttribute("currentUser",currentUser);
		
		//将问题标签写入到jsp
		List<Type> allQuestionTypeList = typeService.getList();
		model.addAttribute("allQuestionType",allQuestionTypeList);
		
		return "ask";
	}
	
	/**
	 * 查询附带最佳回答的问题列表
	 * @param question
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getQuestionListData", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse getQuestionList(QuestionParam question, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		List<Question> questionList = new ArrayList<>();
		
		if(question == null){
			PageHelper.startPage(question.getPageNo(), question.getPageSize());
			questionList = questionService.getList();
		}else{
			PageHelper.startPage(question.getPageNo(), question.getPageSize());
			questionList = questionService.queryQuestionsByParam(question);
		}
		for(Question q : questionList){
			String id = q.getCreateUserId();
			User user = userService.getUserNameById(id);
			q.setCreateUserName(user.getName());
			Discuss discuss = new Discuss();
			discuss.setListnerId(q.getCreateUserId());
			discuss.setQuestionId(q.getId());
			Discuss bestDiscuss = discussService.querybestDiscusssByParam(discuss);
			if(bestDiscuss != null){
				String speakerId = bestDiscuss.getSpeakerId();
				UserRole ur = userRoleService.getUserRole(speakerId);
				if(ur.getRoleId().equals("1")){//回答者是老师
					q.setSpeakerName(userService.getUserNameById(speakerId).getName().concat("  教师"));
				}else if(ur.getRoleId().equals("2")){//回答者是学生
					q.setSpeakerName(userService.getUserNameById(speakerId).getName().concat("  学生"));
				}
			}			
			q.setBestDiscuss(bestDiscuss);
		}
		
		Page<Question> page = new Page<>();
		page.setPageData(questionList);
        return success(page);
	}
}

