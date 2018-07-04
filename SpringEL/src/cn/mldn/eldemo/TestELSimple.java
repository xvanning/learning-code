package cn.mldn.eldemo;
import java.util.HashMap;
import java.util.Map;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
public class TestELSimple {

	public static void main(String[] args) throws Exception {
		Map<String,String> all = new HashMap<String,String>();
		all.put("mldn","www.mldn.cn");
		all.put("mldnjava","www.mldnjava.cn");
		ExpressionParser parser = new SpelExpressionParser(); //定义解析器
		//处理完成之后改变的不是已有集合，已有的集合不会发生改变
		Expression exp = parser.parseExpression("#alldata.?[#this.key.contains('mldn')]");
		StandardEvaluationContext context = new StandardEvaluationContext();
		context.setVariable("alldata", all);
		System.out.println(exp.getValue(context));//这是一个新的集合
	}
}