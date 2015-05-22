package slim3.service;

import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import slim3.meta.TweetMeta;
import slim3.model.Tweet;

import com.google.appengine.api.datastore.Transaction;

public class TwitterService {
    public Tweet tweet(Map<String, Object> input) {
        Tweet tweet = new Tweet();
        BeanUtil.copy(input, tweet);
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(tweet);
        tx.commit();
        return tweet;
    }
    private TweetMeta t = new TweetMeta();

    public List<Tweet> getTweetList() {
        return Datastore.query(t).sort(t.createdDate.desc).asList();
    }
}
