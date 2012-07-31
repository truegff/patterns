package ge.lanmaster.pattern.Facade;

import java.util.Hashtable;
import java.util.Vector;

/**
 * @author alexander
 */
public class MessageCreator {
    // Constants to indicate the type of message to create
    public final static int MIME = 1;
    public final static int MAPI = 2;

    private HashTable headerFields = new Hashtable();
    //private RichText messageBody;
    private Vector attachments = new Vector();
    private boolean signMessage;

    public MessageCreator(String to,
                          String from,
                          String subject) {
        this(to, from , subject, inferMessageType(to));
    } // Constructor(String, String, String)

    public MessageCreator(String to, String from,
                          String subject, int type) {
        headerFields.put("to", to);
        headerFields.put("from", from);
        headerFields.put("subject", subject);
        //...
    } // Constructor(String, String, String, int)

    /**
     * Set the contents of the message body.
     */
    public void setMessageBody(String messageBody) {
       // setMessageBody(new RichTextString(messageBody));
    }  // setMessageBody(String)

    /**
     * Add an attachment to the message
     */
    public void addAttachment(Object attachment) {
        attachments.addElement(attachment);
    }  // addAttachment(Object)

    /**
     * Set whether this message should be signed.  The default
     * is false.
     */
    public void setSignMessage(boolean signFlag) {
        signMessage = signFlag;
    } // setSignMessage(boolean)

    /**
     * Set the value of a header field.
     */
    public void setHeaderField(String name, String value) {
        headerFields.put(name.toLowerCase(), value);
    }  // setHeaderField(String, String)

    /**
     * Send the message.
     */
    public void send() {
        //...
    }  // send()

    /**
     * Infer a message type from a destination email address.
     */
    private static int inferMessageType(String address) {
        int type = 0;
    //...
        return type;
    }  // inferMessageType(String)

    /**
     * Create a Security object appropriate for signing this
     * message.
     */
//    private Security createSecurity() {
//        Security s = null;
//        ...
//        return s;
//    } // createSecurity()

    /**
     * Create a MessageSender object appropriate for the type
     * of message being sent.
     */
//    private void createMessageSender(Message msg) {
//        ...
//    }  // createMessageSender(Message)
//...
}  // class MessageCreator