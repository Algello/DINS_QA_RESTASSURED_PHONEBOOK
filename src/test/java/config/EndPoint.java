package config;

public interface EndPoint {
    String USERS = "/users";
    Integer USER_ID = 2;
    Integer CONTACT_ID = 66;
    Integer INVALID_USER_NAME = 666;
    String CONTACT_NOT_FOUND_ERROR_TEXT = String.format("Contact with id:%d not found", CONTACT_ID);
    String USER_WITH_THIS_NAME_NOT_FOUND_ERROR_TEXT = String.format("Users with this name: %d is not present",
                                                                    INVALID_USER_NAME);
}
