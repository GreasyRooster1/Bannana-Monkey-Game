package System.Util.InvisibleVariables;

public class InvisibleVariables {
    static Variable[] variables = {};
    public static void defineVariable(String name,Object value){
        if(getVariable(name)==null) {
            Variable v = new Variable();
            v.setName(name);
            v.setValue(value);
        }
    }
    public static Object getVariable(String name){
        for (Variable v : variables) {
            if(v.getName()==name){
                return v.getValue();
            }
        }
        return null;
    }
    public static void setVariable(String name,Object val){
        for (Variable v : variables) {
            if(v.getName()==name){
                v.setValue(val);
            }
        }
    }
}
