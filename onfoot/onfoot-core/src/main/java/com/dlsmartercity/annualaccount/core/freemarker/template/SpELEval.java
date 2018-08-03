package com.dlsmartercity.annualaccount.core.freemarker.template;

import java.io.IOException;
import java.util.Map;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import freemarker.core.Environment;
import freemarker.core._DelayedFTLTypeDescription;
import freemarker.core._MiscTemplateException;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateScalarModel;

public class SpELEval implements TemplateDirectiveModel {
	
	private final ExpressionParser expressionParser = new SpelExpressionParser();

	@SuppressWarnings("rawtypes")
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
		TemplateModel expression = (TemplateModel) params.get("expression");
		if(expression == null) {
			throw new _MiscTemplateException(env, "Missing required parameter \"expression\"");
		}
		if(!(expression instanceof TemplateScalarModel)) {
			throw new _MiscTemplateException(env, new Object[] {"Expected a scalar model. \"expression\" is instead ", new _DelayedFTLTypeDescription(expression)});
		}
		
		String expressionString = ((TemplateScalarModel) expression).getAsString();
		Expression spexpression = expressionParser.parseExpression(expressionString);
		System.out.println(spexpression.getValue());
//		env.getOut();
	}

}
