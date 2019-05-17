package com.yazan98.river.core.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.yazan98.river.android.common.ui.ImageLoaders
import com.yazan98.river.android.screen.RiverNetworkScreen
import com.yazan98.river.base.presenter.PresenterStatus
import com.yazan98.river.core.R
import com.yazan98.river.core.domain.GithubUser
import com.yazan98.river.core.logic.GithubPresenter
import com.yazan98.river.core.logic.GithubView
import kotlinx.android.synthetic.main.screen_github.*

/**
 *    Copyright [2019] [Yazan Tarifi]
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

class GithubScreen : RiverNetworkScreen<GithubView, GithubPresenter>(), GithubView {

    private var presenter: GithubPresenter = GithubPresenter()
    private lateinit var viewModel: GithubViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initScreen()
    }

    override fun getPresenter(): GithubPresenter {
        return presenter
    }

    override fun initScreen() {
        presenter.attachView(this)
        viewModel = ViewModelProviders.of(this).get(GithubViewModel::class.java)
        if (viewModel.data.value == null) {
            presenter.getUser()
        }

        viewModel.data.observe(this, Observer {
            onGithubSuccess(it)
        })

    }

    override fun acceptPresenterStatus(status: PresenterStatus) {
        if (status == PresenterStatus.LOADING) {
            imageView.visibility = View.INVISIBLE
            textView.visibility = View.INVISIBLE
            textView2.visibility = View.INVISIBLE
            Progress.visibility = View.VISIBLE
        } else if (status == PresenterStatus.FINISHED) {
            imageView.visibility = View.VISIBLE
            textView.visibility = View.VISIBLE
            textView2.visibility = View.VISIBLE
            Progress.visibility = View.GONE
        }
    }

    override fun onError(error: Throwable) {
        Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
    }

    override fun getLayoutRes(): Int {
        return R.layout.screen_github
    }

    override fun onGithubSuccess(data: GithubUser) {
        ImageLoaders.loadImageWithPicasso(data.avatar_url, imageView)
        textView.text = data.name
        textView2.text = data.bio
        viewModel.data.postValue(data)
    }

}
