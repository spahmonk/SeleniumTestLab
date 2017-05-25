import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by ilitvinov on 2/1/2017.
 */
public class TestJavaScript {
    public static void main(String[] args) throws ScriptException, FileNotFoundException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("nashorn");
        Object result=engine.eval(new FileReader("src/js/coverlist.js"));
        System.out.println(result.toString());
        HashSet set=new HashSet();
/*        set.add("dsfds");
        set.toArray();
        System.out.println(Arrays.toString(set.toArray()));*/
    }

}
