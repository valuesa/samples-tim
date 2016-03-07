package redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LuoLiBing on 16/2/27.
 * 一个网站的投票功能
 */
public class Chapter01 {

    public final static int ONE_WEEK_IN_SECONDS = 7 * 86400;

    /**
     * 发表文章
     * 1/添加一个文章投票的一个集合
     *
     * @param conn
     * @param user
     * @param title
     * @param link
     * @return
     */
    public String postArticle(Jedis conn, String user, String title, String link) {
        String articleId = String.valueOf(conn.incr("article:"));

        // 新增一个投票SET,并且设置过期时间
        String voted = "voted:" + articleId;
        conn.sadd(voted, user);
        conn.expire(voted, ONE_WEEK_IN_SECONDS);

        // 添加一个文章的hash
        Map<String, String> articleData = new HashMap<String, String>();
        long now = System.currentTimeMillis() / 1000;
        String article = "article:" + articleId;
        articleData.put("now", String.valueOf(now));
        articleData.put("title", title);
        articleData.put("user", user);
        articleData.put("link", link);
        articleData.put("votes", "0");
        conn.hmset(article, articleData);

        // 添加时间列表
        conn.zadd("time:", now, article);
        // 添加一个得分列表,考虑时间加权
        conn.zadd("score:", now + 100, article);
        return articleId;
    }


    /**
     * 文章投票功能
     * @param conn
     * @param user
     * @param article
     */
    public void articleVote(Jedis conn, String user, String article) {
        // 一周前的不能再次投票
        long cutoff = (System.currentTimeMillis() / 1000) - ONE_WEEK_IN_SECONDS;
        if(conn.zscore("time:", article) < cutoff) {
            return;
        }

        // article:1001
        String articleId = article.substring(article.indexOf(":") + 1);

    }

}
