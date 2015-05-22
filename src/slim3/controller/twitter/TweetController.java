package slim3.controller.twitter;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import slim3.service.TwitterService;

public class TweetController extends Controller {

    private TwitterService service = new TwitterService();
    
    @Override
    public Navigation run() throws Exception {
        service.tweet(new RequestMap(request));
        return redirect(basePath);
    }
}
