package com.techmania.newsapp


import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.techmania.newsapp.R
import com.techmania.newsapp.db.Article
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class FragmentBreakingNewsDirections private constructor() {
    private data class ActionFragmentBreakingNewsToFragmentArticle(
        public val article: Article,
    ) : NavDirections {
        public override val actionId: Int = R.id.action_fragmentBreakingNews_to_fragmentArticle

        public override val arguments: Bundle
            @Suppress("CAST_NEVER_SUCCEEDS")
            get() {
                val result = Bundle()
                if (Parcelable::class.java.isAssignableFrom(Article::class.java)) {
                    result.putParcelable("article", this.article as Parcelable)
                } else if (Serializable::class.java.isAssignableFrom(Article::class.java)) {
                    result.putSerializable("article", this.article as Serializable)
                } else {
                    throw UnsupportedOperationException(Article::class.java.name +
                            " must implement Parcelable or Serializable or must be an Enum.")
                }
                return result
            }
    }

    public companion object {
        public fun actionFragmentBreakingNewsToFragmentArticle(article: Article): NavDirections =
            ActionFragmentBreakingNewsToFragmentArticle(article)

        public fun actionFragmentBreakingNewsToFragmentSavedNews(): NavDirections =
            ActionOnlyNavDirections(R.id.action_fragmentBreakingNews_to_fragmentSavedNews)
    }
}
