package beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan({"beans"}) 
public class Runner {

	public static void main(String[] args) {
		//build the spring-core  container from spring-context 
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Runner.class);
		
		SingletonBean single1=ctx.getBean(SingletonBean.class);
		System.out.println("Single 1, x="+single1.x);
		SingletonBean single2=ctx.getBean(SingletonBean.class);
		System.out.println("Single 2, x="+single2.x);
		
		
		
		ProtoTypeBean proto1=ctx.getBean("proto",ProtoTypeBean.class);
		ProtoTypeBean proto2=ctx.getBean("proto",ProtoTypeBean.class);
		
		System.out.println("Proto 1, x="+proto1.x);
		System.out.println("Proto 2, x="+proto2.x);
		
		((AnnotationConfigApplicationContext)ctx).close();

	}

}
