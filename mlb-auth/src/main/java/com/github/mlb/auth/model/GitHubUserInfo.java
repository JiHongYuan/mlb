package com.github.mlb.auth.model;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * GitHub 用户信息
 * @author JiHongYuan
 * @date 2022/3/7 10:45
 *
 * Example:
 * {
 *  "login":"JiHongYuan",
 *  "id":26153585,
 *  "node_id":"MDQ6VXNlcjI2MTUzNTg1",
 *  "avatar_url":"https://avatars.githubusercontent.com/u/26153585?v=4",
 *  "gravatar_id":"","url":"https://api.github.com/users/JiHongYuan",
 *  "html_url":"https://github.com/JiHongYuan",
 *  "followers_url":"https://api.github.com/users/JiHongYuan/followers",
 *  "following_url":"https://api.github.com/users/JiHongYuan/following{/other_user}",
 *  "gists_url":"https://api.github.com/users/JiHongYuan/gists{/gist_id}",
 *  "starred_url":"https://api.github.com/users/JiHongYuan/starred{/owner}{/repo}",
 *  "subscriptions_url":"https://api.github.com/users/JiHongYuan/subscriptions",
 *  "organizations_url":"https://api.github.com/users/JiHongYuan/orgs",
 *  "repos_url":"https://api.github.com/users/JiHongYuan/repos",
 *  "events_url":"https://api.github.com/users/JiHongYuan/events{/privacy}",
 *  "received_events_url":"https://api.github.com/users/JiHongYuan/received_events",
 *  "type":"User",
 *  "site_admin":false,
 *  "name":"JiHongYuan",
 *  "company":null,
 *  "blog":"",
 *  "location":null,
 *  "email":"1206429202@qq.com",
 *  "hireable":null,
 *  "bio":null,
 *  "twitter_username":null,
 *  "public_repos":10,
 *  "public_gists":0,
 *  "followers":7,
 *  "following":12,
 *  "created_at":"2017-03-03T00:51:39Z",
 *  "updated_at":"2022-01-21T03:07:19Z"
 * }
 */
@Getter
@Setter
public class GitHubUserInfo {

    /** ID */
    private Long id;

    /** 头像 */
    private String avatarUrl;

    /** 用户名 */
    private String login;

    /** 邮箱 */
    private String email;

}
