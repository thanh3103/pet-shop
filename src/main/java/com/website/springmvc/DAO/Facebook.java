package com.website.springmvc.DAO;

import org.springframework.social.ApiBinding;
import org.springframework.social.facebook.api.AchievementOperations;
import org.springframework.social.facebook.api.CommentOperations;
import org.springframework.social.facebook.api.EventOperations;
import org.springframework.social.facebook.api.FeedOperations;
import org.springframework.social.facebook.api.FriendOperations;
import org.springframework.social.facebook.api.GraphApi;
import org.springframework.social.facebook.api.GroupOperations;
import org.springframework.social.facebook.api.LikeOperations;
import org.springframework.social.facebook.api.MediaOperations;
import org.springframework.social.facebook.api.OpenGraphOperations;
import org.springframework.social.facebook.api.PageOperations;
import org.springframework.social.facebook.api.SocialContextOperations;
import org.springframework.social.facebook.api.TestUserOperations;
import org.springframework.social.facebook.api.UserOperations;
import org.springframework.web.client.RestOperations;

public interface Facebook extends GraphApi, ApiBinding {
	AchievementOperations achievementOperations();

	CommentOperations commentOperations();

	EventOperations eventOperations();

	FeedOperations feedOperations();

	FriendOperations friendOperations();

	GroupOperations groupOperations();

	LikeOperations likeOperations();

	MediaOperations mediaOperations();

	OpenGraphOperations openGraphOperations();

	PageOperations pageOperations();

	SocialContextOperations socialContextOperations();

	TestUserOperations testUserOperations();

	UserOperations userOperations();

	RestOperations restOperations();

	String getApplicationNamespace();
}
