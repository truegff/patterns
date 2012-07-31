package ge.lanmaster.pattern.TemplateMethod;

/**
 * @author alexander
 */
public class Logon extends AbstractLogon {

    protected Object authenticate(String userID, String password) throws Exception {
        if (userID.equals("abc") && password.equals("123")) return userID;
        throw new Exception("bad user ID");
    } // authenticate

    protected void notifyAuthentication(Object authToken) {
        throw new UnsupportedOperationException("Not supported yet.");
    } // notify(Object)
} // class Logon
