package com.asynclabs.githubpersonalapplication.ui.main

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.os.Handler
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asynclabs.githubpersonalapplication.R
import com.asynclabs.githubpersonalapplication.data.remotemodels.RepoResponse
import com.asynclabs.githubpersonalapplication.utils.SimpleTimeUtils
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_repo_row.view.*

class MainAdapter(
    private val repoList: List<RepoResponse>,
    private val clickListener: ClickListener
) :
    RecyclerView.Adapter<MainAdapter.RepoViewHolder>() {

    interface ClickListener {
        fun onClick(repoResponse: RepoResponse)
    }

    class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun bindItems(item: RepoResponse) {
            Glide.with(itemView.imgUser.context)
                .load(item.owner?.avatarUrl ?: "err")
                .error(R.drawable.ic_git_logo_secondary)
                .into(itemView.imgUser)

            itemView.txtRepoName.text = item.name ?: ""
            itemView.txRepoDesc.text = item.description ?: "No description provided yet"
            itemView.txtLanguageName.text = item.language ?: "Unknown"
            itemView.txtOwner.text = "Created by " + (item.owner?.login ?: "Unknown")

            itemView.txtDate.text = item.createdAt?.let {
                SimpleTimeUtils().calculateTimeDifference(
                    it
                )
            }

            if (item.stargazersCount ?: 0 > 0) {
                itemView.txtStarCount.visibility = View.VISIBLE
                itemView.imgStarCount.visibility = View.VISIBLE
                itemView.txtStarCount.text = item.stargazersCount.toString()
            } else {
                itemView.txtStarCount.visibility = View.GONE
                itemView.imgStarCount.visibility = View.GONE
            }
            if (item.forksCount ?: 0 > 0) {
                itemView.txtForkCount.visibility = View.VISIBLE
                itemView.imgForkCount.visibility = View.VISIBLE
                itemView.txtForkCount.text = item.forksCount.toString()
            } else {
                itemView.txtForkCount.visibility = View.GONE
                itemView.imgForkCount.visibility = View.GONE
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_repo_row, parent, false)
        return RepoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bindItems(repoList[position])
        holder.itemView.setOnClickListener { clickListener.onClick(repoList[position]) }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}