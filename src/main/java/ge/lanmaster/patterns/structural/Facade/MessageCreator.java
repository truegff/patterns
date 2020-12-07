package ge.lanmaster.patterns.structural.Facade;

import java.security.Security;
import java.util.Hashtable;
import java.util.Vector;

public class MessageCreator {
    // Constants to indicate the type of message to create
    public final static int MIME = 1;
    public final static int MAPI = 2;

    private Hashtable headerFields = new Hashtable();
    //private RichText messageBody;
    private Vector attachments = new Vector();
    private boolean signMessage;

    public MessageCreator(String to,
                          String from,
                          String subject) {
        this(to, from , subject, inferMessageType(to));
    }

    public MessageCreator(String to, String from,
                          String subject, int type) {
        headerFields.put("to", to);
        headerFields.put("from", from);
        headerFields.put("subject", subject);
        //...
    }

    /**
     * Set the contents of the message body.
     */
    public void setMessageBody(String messageBody) {
       // setMessageBody(new RichTextString(messageBody));
    }

    /**
     * Add an attachment to the message
     */
    public void addAttachment(Object attachment) {
        attachments.addElement(attachment);
    }

    /**
     * Set whether this message should be signed.  The default
     * is false.
     */
    public void setSignMessage(boolean signFlag) {
        signMessage = signFlag;
    }


    /**
     * Set the value of a header field.
     */
    public void setHeaderField(String name, String value) {
        headerFields.put(name.toLowerCase(), value);
    }

    /**
     * Send the message.
     */
    public void send() {
        //...
    }

    /**
     * Infer a message type from a destination email address.
     */
    private static int inferMessageType(String address) {
        int type = 0;
        //...
        return type;
    }

    /**
     * Create a Security object appropriate for signing this
     * message.
     */
    private Security createSecurity() {
        Security s = null;
        //...
        return s;
    }

    /**
     * Create a MessageSender object appropriate for the type
     * of message being sent.
     */
//    private void createMessageSender(Message msg) {
//        ...
//    }  // createMessageSender(Message)
//...
}