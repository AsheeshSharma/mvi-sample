package com.animelabs.mvi_sample.data.models

import com.google.gson.annotations.SerializedName

data class UserResponse(
      @SerializedName("login")
      private var login: String?,
      @SerializedName("id")
      private var id: Int?,
      @SerializedName("avatar_url")
      private var avatarUrl: String?,
      @SerializedName("gravatar_id")
      private var gravatarId: String?,
      @SerializedName("url")
      private var url: String?,
      @SerializedName("html_url")
      private var htmlUrl: String?,
      @SerializedName("followers_url")
      private var followersUrl: String?,
      @SerializedName("following_url")
      private var followingUrl: String?,
      @SerializedName("gists_url")
      private var gistsUrl: String?,
      @SerializedName("starred_url")
      private var starredUrl: String?,
      @SerializedName("subscriptions_url")
      private var subscriptionsUrl: String?,
      @SerializedName("organizations_url")
      private var organizationsUrl: String?,
      @SerializedName("repos_url")
      private var reposUrl: String?,
      @SerializedName("events_url")
      private var eventsUrl: String?,
      @SerializedName("received_events_url")
      private var receivedEventsUrl: String?,
      @SerializedName("type")
      private var type: String?,
      @SerializedName("site_admin")
      private var siteAdmin: Boolean?,
      @SerializedName("score")
      private var score: Double?
)

data class UserItemModel(
      @SerializedName("total_count")
      val total_count : Int?,
      @SerializedName("items")
      val users : List<UserResponse>
)