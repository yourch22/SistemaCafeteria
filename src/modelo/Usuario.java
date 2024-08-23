package modelo;
/**
 * @author Jorge Flores
 */
public class Usuario {
    private String username;
    private String password_hash;

    public Usuario(String username, String password_hash) {
        this.username = username;
        this.password_hash = password_hash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }
    
    
}
