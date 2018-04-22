package util.pon.al;

public final class SystemMessage {
    private static final String SEND_MESSAGE = "Message sent";
    private static final String CONFIRM_ACCOUNT = " you need to confirm your account.";
    private static final String USER_BLOCK = "User is locked";
    private static final String USER_DELETE = "User is deleted";
    private static final String USER_EXIST = "Ooops User with nickname already exist";
    private static final String INCORRECT = "Ooopss... Incorrect login or password";


    public static String getSendMessage() {
        return SEND_MESSAGE;
    }

    public static String getConfirmAccount() {
        return CONFIRM_ACCOUNT;
    }

    public static String getUserBlock() {
        return USER_BLOCK;
    }

    public static String getUserDelete() {
        return USER_DELETE;
    }

    public static String getUserExist() {
        return USER_EXIST;
    }

    public static String getIncorrect() {
        return INCORRECT;
    }
}
