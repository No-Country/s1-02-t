package consultation.by.video.call.auth.entity;

public enum ListRole {

    USER("USER"),
    ADMIN("ADMIN"),
    PROFESSIONAL("PROFESSIONAL");

    private static final String ROLE_PREFIX = "ROLE_";
    private final String name;

    ListRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFullRoleName() {
        return ROLE_PREFIX + name;
    }
}
