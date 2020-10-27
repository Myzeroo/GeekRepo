package HomeWork_08;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ParseExpression {
    public static String getResult(String input) {

        try {
            ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
            ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
            String str = String.valueOf(scriptEngine.eval(input));
            return str;
        }catch (Exception e){
            return "Error";
        }
    }
}
