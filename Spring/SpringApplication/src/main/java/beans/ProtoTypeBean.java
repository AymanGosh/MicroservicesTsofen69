package beans;



import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("proto")
@Scope("prototype")
public class ProtoTypeBean {
	public int x=(int)(Math.random()*100);
	
	//@PostConstruct
	public void init() {
		System.out.println("Inside init method "+x );
	}
}
