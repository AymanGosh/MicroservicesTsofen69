package nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptExample {

	public static void main(String[] args) {
	
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName( "JavaScript" );
		System.out.println( engine.getClass().getName() );
		
		try {
			System.out.println( "Result:" + engine.eval( 
					"function f(name) { return 'hello '+name; }; f('david');"		
					) );
		} catch (ScriptException e) {
			e.printStackTrace();
		}

	}

}
