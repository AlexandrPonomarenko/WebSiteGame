package servlet.error;


import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CheckErrorFilds {
    private JSONObject object;
    private Map<String, String> error;
    private boolean valid;

    public CheckErrorFilds(){
        error = new HashMap<>();
        object = new JSONObject();
        valid = true;
    }

    private boolean veryPassword(String p){

        if(!validNotNullAndEmpty(p)){
            error.put("password", "empty string");
            object.put("password","empty string");
            return false;
        }

        p = p.trim();

        if(p.length() < 5){
            error.put("password", "to be > 5");
            object.put("password","to be > 5");
            return false;
        }

        if(!p.matches("^.*(?=.{8,})(?=.*\\d)(?=.*[a-zA-Z])|(?=.{8,})(?=.*\\d)(?=.*[!@#$%^&])|(?=.{8,})(?=.*[a-zA-Z])(?=.*[!@#$%^&]).*$")){
            error.put("password", "wrong schema");
            object.put("password","wrong schema");
            System.out.println(" M : veryPassword OUT ");
            return false;
        }
        return true;
    }

    private boolean veryEmail(String email){

        if(!validNotNullAndEmpty(email)){
            error.put("email", "empty string");
            object.put("email","empty string");
            return false;
        }

        email = email.trim();

        if(email.length() < 2){
            error.put("email", "to be > 3 char");
            object.put("email","to be > 3 char");
            return false;
        }
        if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
            error.put("email", "wrong schema");
            object.put("email", "wrong schema");
            System.out.println(" M : veryEmail OUT ");
            return false;
        }
        return true;
    }

    private boolean veryTxms(String txms){

        if(!validNotNullAndEmpty(txms)){
            error.put("txms", "empty string");
            object.put("txms", "empty string");
            return false;
        }

        txms = txms.trim();

        if(txms.length() < 14){
            error.put("txms", "to be > 14 char");
            object.put("txms", "to be > 14 char");
            return false;
        }
        return true;
    }

    private boolean veryName(String name){

        if(!validNotNullAndEmpty(name)){
            error.put("name", "empty string");
            object.put("name", "empty string");
            return false;
        }

        name = name.trim();

        if(name.length() < 3){
            error.put("name", "to be > 3");
            object.put("name", "to be > 3");
            return false;
        }
        if(!name.matches("[a-zA-Z]*")){
            System.out.println(" M : veryName OUT ");
            error.put("name", "wrong schema");
            object.put("name", "wrong schema");
            return false;
        }
        return true;
    }

    private boolean veryNickName(String nickName){

        if(!validNotNullAndEmpty(nickName)){
            error.put("nickName", "empty string");
            object.put("nickName", "empty string");
            return false;
        }

        nickName = nickName.trim();

        if(nickName.length() < 3){
            error.put("nickName", "to be > 3 char");
            object.put("nickName", "to be > 3 char");
            return false;
        }
        if(!nickName.matches("[a-zA-Z]*")){
            System.out.println("M : veryNickName OUT ");
            error.put("nickName", "wrong schema");
            object.put("nickName", "wrong schema");
            return false;
        }
        return true;
    }

    private boolean verEquPasswords(String p, String p2){
        if(p == null || p2 == null || p.equals("") || p2.equals("")){
            return false;
        }

        if(!p.equals(p2)){
            error.put("pas", "to be equals");
            object.put("pas", "to be equals");
            return false;
        }
        return true;
    }

    public boolean validAuth(String l, String ln, String f,String p,String pt,String e){
        if(!veryNickName(l)){
            valid = false;
        }
        if(!veryName(ln)){
            valid = false;
        }
        if(!veryName(f)){
            valid = false;
        }
        if(!veryPassword(p)){
            valid = false;
        }
        if(!veryPassword(pt)){
            valid = false;
        }
        if(!veryEmail(e)){
            valid = false;
        }
        if(!verEquPasswords(p, pt)){
            valid = false;
        }

        return valid;
    }

    public boolean validAunt(String l, String p){
        if(!veryNickName(l)){
            valid = false;
        }
        if(!veryPassword(p)){
            valid = false;
        }
        return valid;
    }


    public boolean validHelp2(String l, String tx, String e){
        if(veryNickName(l) && veryTxms(tx) && veryEmail(e)){
            return true;
        }
        return false;
    }

    public boolean validHelp(String l, String tx, String e){
        if(!veryNickName(l)){
            valid = false;
        }
        if(!veryTxms(tx)){
            valid = false;
        }
        if(!veryEmail(e)){
            valid = false;
        }
        return valid;
    }


    private boolean validNotNullAndEmpty(String str){
        if(str == null || str.equals("")){
            return false;
        }
        return true;
    }

    private String getTrim(String str){
        return str.trim();
    }

    public Map<String, String> getError(){
        return error;
    }

    public String getJsonObj(){
        System.out.println("SJON STRING OUT" + object.toJSONString());
        return object.toJSONString();
    }
}
