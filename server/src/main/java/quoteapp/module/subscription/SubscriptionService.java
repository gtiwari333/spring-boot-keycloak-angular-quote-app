package quoteapp.module.subscription;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public void save(SubscriptionSaveDto d) {
        var s = new Subscription(d.getName(), d.getEmail());
        subscriptionRepository.save(s);
    }

}
