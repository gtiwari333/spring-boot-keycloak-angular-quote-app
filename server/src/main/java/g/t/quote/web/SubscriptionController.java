package g.t.quote.web;

import g.t.quote.module.subscription.SubscriptionSaveDto;
import g.t.quote.module.subscription.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/subscribe")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;


    @PostMapping
    @CrossOrigin
    public void save(@RequestBody SubscriptionSaveDto d) {

        log.info("Got request to subscribe ");

        subscriptionService.save(d);
    }

}
