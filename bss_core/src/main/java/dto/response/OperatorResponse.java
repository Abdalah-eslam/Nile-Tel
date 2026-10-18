package dto.response;

public class OperatorResponse {
    private String username;
    private String full_name;
    private String role;
    private String SessionId;

    public OperatorResponse(String username, String full_name, String role, String sessionId) {
        this.username = username;
        this.full_name = full_name;
        this.role = role;
        SessionId = sessionId;
    }

    public OperatorResponse() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSessionId(String sessionId) {
        SessionId = sessionId;
    }

    public String getUsername() {
        return username;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getRole() {
        return role;
    }

    public String getSessionId() {
        return SessionId;
    }
}
