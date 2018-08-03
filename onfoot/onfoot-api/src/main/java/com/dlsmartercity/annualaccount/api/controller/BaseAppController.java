package com.dlsmartercity.annualaccount.api.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;
import com.dlsmartercity.annualaccount.api.response.BaseResponse;
import com.dlsmartercity.annualaccount.api.response.BodyResponse;
import com.dlsmartercity.annualaccount.core.controller.BaseController;
import com.dlsmartercity.annualaccount.core.helper.MessageSourceHolder;
import com.dlsmartercity.annualaccount.dto.single.SysError;
import com.dlsmartercity.annualaccount.service.ISysErrorService;
import com.dlsmartercity.annualaccount.util.StringUtils;
import com.dlsmartercity.annualaccount.util.URLUtils;

public abstract class BaseAppController extends BaseController {

	@Autowired
	private ISysErrorService sysErrorService;

	/**
	 * 
	 * @Title: sendMessage
	 * @Description: 返回相应体
	 * @param retcode
	 *            响应参数
	 * @param args
	 * @return 设定文件
	 * @return BaseResponse 返回类型
	 */
	public BaseResponse sendMessage(String retcode, Object... args) {
		BaseResponse response = new BaseResponse();
		response.setRetcode(retcode);
		response.setRetmessage(MessageSourceHolder.getMessage(retcode, args));
		return response;
	}

	/**
	 * 
	 * @Title: sendMessage
	 * @Description: 返回相应体
	 * @param retcode
	 *            响应参数
	 * @param args
	 * @return 设定文件
	 * @return BaseResponse 返回类型
	 */
	public BaseResponse sendExceptionMessage(String retcode, String message) {
		BaseResponse response = new BaseResponse();
		response.setRetcode(retcode);
		response.setRetmessage(MessageSourceHolder.getMessage(retcode) + StringUtils.getComma() + message);
		return response;
	}

	/**
	 * 
	 * @Title: sendBodyMessage
	 * @Description: 返回相应体
	 * @param retcode
	 *            响应参数
	 * @param data
	 *            响应数据
	 * @param args
	 * @return 设定文件
	 * @return BaseResponse 返回类型
	 */
	public BaseResponse sendBodyMessage(String retcode, Object data, Object... args) {
		BodyResponse response = new BodyResponse();
		response.setRetcode(retcode);
		response.setRetmessage(MessageSourceHolder.getMessage(retcode, args));
		response.setData(data);
		return response;
	}

	/**
	 * 
	 * @Title: getRootMap
	 * @Description: TODO(Map)
	 * @return 设定文件
	 * @return Map<String,Object> 返回类型
	 */
	public Map<String, Object> getRootMap() {
		Map<String, Object> rootMap = new HashMap<String, Object>();
		rootMap.put("msUrl", URLUtils.get("msUrl"));
		return rootMap;
	}

	/**
	 * 
	 * @Title: forword
	 * @Description: TODO(ModelAndView)
	 * @param viewName
	 * @param context
	 * @return 设定文件
	 * @return ModelAndView 返回类型
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ModelAndView forword(String viewName, Map context) {
		return new ModelAndView(viewName, context);
	}

	/**
	 * 
	 * @Title: saveSysError
	 * @Description: TODO(系统error)
	 * @param errorType
	 * @param errorCode
	 * @param errorMsg
	 *            设定文件
	 * @return void 返回类型
	 */
	public void saveSysError(String errorType, String errorCode, String errorMsg) {
		SysError t = new SysError();
		t.setErrorCode(errorCode);
		t.setErrorMsg(errorMsg);
		t.setErrorType(errorType);
		t.setCreateDate(new Date());
		sysErrorService.insertSysError(t);
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			public void setAsText(String value) {
				try {
					setValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value));
				} catch (ParseException e) {
					setValue(null);
				}
			}

			public String getAsText() {
				return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date) getValue());
			}
		});
	}
}
