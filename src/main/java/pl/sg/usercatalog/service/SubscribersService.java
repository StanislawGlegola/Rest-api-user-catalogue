package pl.sg.usercatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pl.sg.usercatalog.exceptions.SubscriptionExceptions;
import pl.sg.usercatalog.model.Subscribers;
import pl.sg.usercatalog.repository.SubscribersRepository;

import java.util.List;

@Service
@EnableTransactionManagement
public class SubscribersService {
    private final SubscribersRepository subscribersRepository;

    @Autowired
    public SubscribersService(SubscribersRepository subscribersRepository) {
        this.subscribersRepository = subscribersRepository;
    }

    public List<Subscribers> getSubscribersListByUserId(long userId) {
        return subscribersRepository.getSubscribersListByUserId(userId);
    }

    public void addSubscription(Subscribers subscribers) {
        if (validateCorrectSubscription(subscribers)) {
            subscribersRepository.addSubscription(subscribers);
        }
    }

    private boolean validateCorrectSubscription(Subscribers subscribers) {
        boolean result = false;
        if (subscribers.getUserId() == subscribers.getSubscribesToId()) {
            throw new SubscriptionExceptions("User with id " + subscribers.getUserId() + " cannot subscribe to himself");
        } else if (subscribersRepository.isSubscribed(subscribers.getUserId(), subscribers.getSubscribesToId())) {
            throw new SubscriptionExceptions("User with id " + subscribers.getUserId() + " is already subscribed to user with id " + subscribers.getSubscribesToId());
        } else {
            result = true;
        }
        return result;
    }

    @Transactional
    public boolean addSubscribers(List<Subscribers> subscribersList) {
        for (Subscribers subscribers : subscribersList) {
            if (validateCorrectSubscription(subscribers)) {
                subscribersRepository.addSubscription(subscribers);
            } else {
                return false;
            }
        }
        return result;
    }

    public void deleteEverySubscriptionByUserId(Subscribers subscribers) {
        subscribersRepository.deleteEverySubscriptionByUserId(subscribers.getUserId());
    }

    public void deleteSubscription(Subscribers subscribers) {
        subscribersRepository.deleteSubscription(subscribers);
    }
}