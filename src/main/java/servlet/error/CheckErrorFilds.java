package servlet.error;


public class CheckErrorFilds {
    private String name;
    private String password;
    private String txms;
    private String email;
    private String nickname;

    public CheckErrorFilds(){

    }

    public CheckErrorFilds(String name, String password, String txms, String email, String nickname) {
        this.name = name;
        this.password = password;
        this.txms = txms;
        this.email = email;
        this.nickname = nickname;
    }

    private boolean veryPassword(String p){

        if(p == null || p.equals("")){
            return false;
        }

        p = p.trim();

        if(p.length() < 5){
            return false;
        }

        if(!p.matches("(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}")){
            System.out.println(" M : veryPassword OUT ");
            return false;
        }
        return true;
    }

    private boolean veryEmail(String email){

        if(email == null || email.equals("")){
            return false;
        }

        email = email.trim();

        if(email.length() < 2){
            return false;
        }
        if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,6}$")){
            System.out.println(" M : veryEmail OUT ");
            return false;
        }
        return true;
    }

    private boolean veryTxms(String Txms){

        if(Txms == null || Txms.equals("")){
            return false;
        }

        Txms = Txms.trim();

        if(Txms.length() < 14){
            return false;
        }
        if(!Txms.matches("[a-zA-Z]*")){
            System.out.println(" M : veryTxms OUT ");
            return false;
        }
        return true;
    }

    private boolean veryName(String name){

        if(name == null || name.equals("")){
            return false;
        }

        name = name.trim();

        if(name.length() < 3){
            return false;
        }
        if(!name.matches("[a-zA-Z]*")){
            System.out.println(" M : veryName OUT ");
            return false;
        }
        return true;
    }

    private boolean veryNickName(String NickName){

        if(NickName == null || NickName.equals("")){
            return false;
        }

        NickName = NickName.trim();

        if(NickName.length() < 3){
            return false;
        }
        if(!NickName.matches("(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}")){
            System.out.println("M : veryNickName OUT ");
            return false;
        }
        return true;
    }

    public boolean validAuth(String l, String ln, String f,String p,String pt,String e){
        if(veryNickName(l) && veryName(ln) && veryName(f) && veryPassword(p)
                && veryPassword(pt) && veryEmail(e)){
            return true;
        }
        return false;
    }

    public boolean validAunt(String l, String p){
        if(veryNickName(l) && veryPassword(p)){
            return true;
        }
        return false;
    }

    public boolean validHelp(String l, String tx, String e){
        if(veryNickName(l) && veryTxms(tx) && veryEmail(e)){
            return true;
        }
        return false;
    }
}
