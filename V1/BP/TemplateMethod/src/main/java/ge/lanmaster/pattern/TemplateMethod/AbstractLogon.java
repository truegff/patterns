package ge.lanmaster.pattern.TemplateMethod;

/**
 * @author alexander
 */

public abstract class AbstractLogon {

    /**
     * This method authenticates a user.
     * @param frame
     *  The parent frame of dialogs this method pops up.
     * @param programName
     *  The name of the program.
     */

    public void logon(Frame frame, String programName) {
        Object authenticationToken;
        LogonDialog logonDialog;
        logonDialog = new LogonDialog(frame, "Log on to "+programName );
        JDialog waitDialog = createWaitDialog(frame);

        while (true) {
            waitDialog.setVisible(false);
            logonDialog.setVisible(true);
            waitDialog.setVisisble(true);
            try {
                String userID = logonDialog.getUserID();
                String password = logonDialog.getPassword();
                authenticationToken = authenticate(userID, password);
                break;
            } catch (Exception e) {
                // Tell user that authentication failed
                JOptionPane.showMessageDialog(frame, e.getMessage(),
                        "Authentication Failure", JOptionPane.ERROR_MESSAGE);
            } // try
        }
        // Authentication successful
        waitDialog.setVisible(false);
        logonDialog.setVisible(false);
        notifyAuthentication(authenticationToken);
    } // logon()


    /**
     * Authenticate user based on the supplied user id and password.
     * @param userID
     *  the supplied user id
     * @param password
     *  the supplied password
     * @return
     *  object encapsulating proof of authentication
     * @throws Exception
     */
    abstract protected Object authenticate(String userID, String password)
        throws Exception;

    /**
     * Notify the rest of program that user is authenticated.
     * @param authToken
     *  What the authenticate method returned.
     */
    abstract protected void notifyAuthentication(Object authToken);
} // class AbstractLogon
