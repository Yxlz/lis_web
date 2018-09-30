package com.cdxt.lisweb.controller.mdro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cdxt.lisweb.controller.BaseController;
import com.cdxt.lisweb.entity.mdro.LisWebMdrosSuggestion;
import com.cdxt.lisweb.service.mdro.LisWebMdrosSuggestionService;

/**
 * @author : Tangxiaohui
 * @date 创建时间：2018年9月11日 下午1:40:55
 * @version 1.0
 * @company :成都信通网易医疗科技发展有限公司
 * @description: 耐药菌控制器
 */
@Controller
@RequestMapping("/mdro")
public class LisWebMdrosSuggestionController extends BaseController {

	@Autowired
	private LisWebMdrosSuggestionService mdroService;

	/**
	 * 根据耐药菌代码获取耐药菌信息
	 */
	@RequestMapping(value = "getMdro.do", produces = "application/json;charset=utf8")
	public ModelAndView getMdroSuggestionDetail(String mdroCode) {
		LisWebMdrosSuggestion mdro = mdroService
				.getLisWebMdrosSuggestionByMdroCode(mdroCode);
		ModelAndView view = new ModelAndView();
		view.setViewName("mdro/mdroDetail");
		view.addObject("mdroDetail", splitStr(mdro.getMdroSuggestion()));
		view.addObject("mdroName", mdro.getMdroName());
		return view;
	}
	
	/**
	 * 将耐药菌治疗指导意见文本分割成段落，不然在页面会显示成一段
	 */
	private String[] splitStr(String suggestion){
		/*正则表达式：句子结束符  还有空格*/  
		String regEx="：|。|！|；|\\s+";   
		Pattern p =Pattern.compile(regEx);  
		Matcher m = p.matcher(suggestion);  
		  
		/*按照句子结束符分割句子*/  
		String[] words = p.split(suggestion);  
		  
		/*将句子结束符连接到相应的句子后*/  
		if(words.length > 0)  
		{  
		    int count = 0;  
		    while(count < words.length)  
		    {  
		        if(m.find())  
		        {  
		            words[count] += m.group();  
		        }  
		        count++;  
		    }  
		}  
		
		return words;
	}
	

	/**
	 * 获取所有耐药菌信息，也可根据耐药菌代码筛选
	 */
	@RequestMapping(value = "getMdros.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String, Object> getMdros(int start, int limit, String mdroCode) {
		Map<String, Object> query = new HashMap<String, Object>();
		if (StringUtils.hasText(mdroCode)) {
			query.put("mdroCode", mdroCode);
		}

		Map<String, Object> users = mdroService.queryAllByPage(start, limit,
				query);
		return users;
	}

	@RequestMapping(value = "saveMdro.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public void saveMdro(@RequestBody LisWebMdrosSuggestion mdro,
			HttpServletResponse response) {
		mdroService.saveClob(mdro);
		this.resJsonMessage(response, "保存成功");
	}

	@RequestMapping(value = "delMdro.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String delMdro(@RequestBody List<LisWebMdrosSuggestion> mdro) {
		mdroService.deleteAll(mdro);
		return "{success:true}";
	}

	@RequestMapping(value = "updateMdro.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String updateMdro(@RequestBody LisWebMdrosSuggestion mdro,
			HttpServletResponse response) {
		mdroService.updateClob(mdro);
		return "{success:true}";
	}
}
