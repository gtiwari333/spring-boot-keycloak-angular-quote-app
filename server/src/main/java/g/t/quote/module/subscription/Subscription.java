package g.t.quote.module.subscription;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
public class Subscription implements Serializable {

    private static final long serialVersionUID = 744281458877843466L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    private Instant addedOn;

    private boolean active = true;

    public Subscription(String name, String email) {
        this.name = name;
        this.email = email;
        this.addedOn = Instant.now();
    }
}
