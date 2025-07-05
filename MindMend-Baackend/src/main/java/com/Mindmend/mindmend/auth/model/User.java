package com.Mindmend.mindmend.auth.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password; // guardado hasheado

    // Constructor vacío requerido por JPA
    public User() {}

    // Constructor de conveniencia
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters / Setters

    public Long getId() {
        return id;
    }

    // No expongas setId si no quieres que se modifique desde fuera
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Recuerda que aquí debes pasar la contraseña ya hasheada,
     * nunca guardes la raw password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    // equals & hashCode basados en 'username' (o en 'id' si lo prefieres)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User other = (User) o;
        return Objects.equals(username, other.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    // toString (sin exponer la password)

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
