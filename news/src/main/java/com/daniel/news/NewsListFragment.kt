package com.daniel.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daniel.news.databinding.FragmentNewsListBinding
import com.daniel.news.di.ArticleAdapter
import com.daniel.news.di.DaggerNewsComponent
import com.daniel.news.di.NewsListModule
import com.example.core.ui.BaseFragment
import com.example.core.ui.coreComponent
import com.example.core.ui.showWarningDialog
import com.example.core.utils.EndlessRVListener
import com.example.sources.SourcesFragmentArgs
import javax.inject.Inject

class NewsListFragment : BaseFragment<NewsListViewModel>() {

    @Inject
    lateinit var factory: NewsListViewModel.Factory

    override val viewModel: NewsListViewModel by viewModels(factoryProducer = { factory })
    private lateinit var binding: FragmentNewsListBinding
    private val args: NewsListFragmentArgs by navArgs()

    private lateinit var scrollListener: EndlessRVListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerNewsComponent
            .builder()
            .newsListModule(NewsListModule(args.sources))
            .coreComponent(coreComponent())
            .build()
            .inject(this)

        viewModel.getArticles()
        binding.vm = viewModel
        showLoadingDialog()

        setupView()
        observe()
    }

    private fun observe(){
        viewModel.articleResponse.observe(viewLifecycleOwner, Observer {
            hideLoadingDialog()
            hideKeyboard()
            it.error?.let {err->
                showWarningDialog(getString(R.string.error), err.message.toString())
            }
        })

        viewModel.query.observe(viewLifecycleOwner, Observer {
            viewModel.getArticles()
        })
    }



    private fun setupView() {
        val lm = binding.newsArticleRv.layoutManager as LinearLayoutManager
        val adapter = ArticleAdapter(viewModel)
        binding.newsArticleRv.adapter = adapter
        scrollListener = object : EndlessRVListener(lm) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                viewModel.getNewArticle(page)
            }
        }
        binding.newsArticleRv.addOnScrollListener(scrollListener)
    }
}