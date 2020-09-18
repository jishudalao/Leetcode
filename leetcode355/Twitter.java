package leetcode355;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {

    /**
     * �û� id �����ģ��������Ķ�Ӧ��ϵ
     */
    private Map<Integer, Tweet> twitter;

    /**
     * �û� id ������ע���û��б�Ķ�Ӧ��ϵ
     */
    private Map<Integer, Set<Integer>> followings;

    /**
     * ȫ��ʹ�õ�ʱ����ֶΣ��û�ÿ����һ������֮ǰ + 1
     */
    private static int timestamp = 0;

    /**
     * �ϲ� k ������ʹ�õ����ݽṹ�������ڷ����ﴴ��ʹ�ã���������ȫ�ֱ����Ǳ��裬�Ӹ������ʹ��
     */
    private static PriorityQueue<Tweet> maxHeap;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followings = new HashMap<>();
        twitter = new HashMap<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> -o1.timestamp + o2.timestamp);
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        if (twitter.containsKey(userId)) {
            Tweet oldHead = twitter.get(userId);
            Tweet newHead = new Tweet(tweetId, timestamp);
            newHead.next = oldHead;
            twitter.put(userId, newHead);
        } else {
            twitter.put(userId, new Tweet(tweetId, timestamp));
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        // ������ȫ��ʹ�õģ�ʹ��֮ǰ��Ҫ���
        maxHeap.clear();

        // ����Լ���������ҲҪ����
        if (twitter.containsKey(userId)) {
            maxHeap.offer(twitter.get(userId));
        }

        Set<Integer> followingList = followings.get(userId);
        if (followingList != null && followingList.size() > 0) {
            for (Integer followingId : followingList) {
                Tweet tweet = twitter.get(followingId);
                if (tweet != null) {
                    maxHeap.offer(tweet);
                }
            }
        }

        List<Integer> res = new ArrayList<>(10);
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Tweet head = maxHeap.poll();
            res.add(head.id);

            // ������õĲ���Ӧ���� replace������ Java û���ṩ
            if (head.next != null) {
                maxHeap.offer(head.next);
            }
            count++;
        }
        return res;
    }


    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     *
     * @param followerId �����ע�� id
     * @param followeeId ����ע�� id
     */
    public void follow(int followerId, int followeeId) {
        // ����ע�˲������Լ�
        if (followeeId == followerId) {
            return;
        }

        // ��ȡ���Լ��Ĺ�ע�б�
        Set<Integer> followingList = followings.get(followerId);
        if (followingList == null) {
            Set<Integer> init = new HashSet<>();
            init.add(followeeId);
            followings.put(followerId, init);
        } else {
            if (followingList.contains(followeeId)) {
                return;
            }
            followingList.add(followeeId);
        }
    }


    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     *
     * @param followerId ����ȡ����ע���˵� id
     * @param followeeId ��ȡ����ע���˵� id
     */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }

        // ��ȡ���Լ��Ĺ�ע�б�
        Set<Integer> followingList = followings.get(followerId);

        if (followingList == null) {
            return;
        }
        // ����ɾ��֮ǰ�������жϣ���Ϊ�����Ƿ�����Ժ󣬾Ϳ���ɾ��������ɾ��֮ǰ��Ҫ����
        followingList.remove(followeeId);
    }

    /**
     * �����࣬��һ������������ӽǣ�
     */
    private class Tweet {
        /**
         * ���� id
         */
        private int id;

        /**
         * �����ĵ�ʱ���
         */
        private int timestamp;
        private Tweet next;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    public static void main(String[] args) {

        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        List<Integer> res1 = twitter.getNewsFeed(1);
        System.out.println(res1);

        twitter.follow(2, 1);

        List<Integer> res2 = twitter.getNewsFeed(2);
        System.out.println(res2);

        twitter.unfollow(2, 1);

        List<Integer> res3 = twitter.getNewsFeed(2);
        System.out.println(res3);
    }
}