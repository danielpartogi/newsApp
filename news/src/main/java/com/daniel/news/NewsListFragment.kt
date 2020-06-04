package com.daniel.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.daniel.news.databinding.FragmentNewsListBinding
import com.daniel.news.di.DaggerNewsComponent
import com.daniel.news.di.NewsListModule
import com.example.core.ui.BaseFragment
import com.example.core.ui.coreComponent
import com.example.sources.SourcesFragmentArgs
import javax.inject.Inject

class NewsListFragment : BaseFragment<NewsListViewModel>() {

    @Inject
    lateinit var factory: NewsListViewModel.Factory

    override val viewModel: NewsListViewModel by viewModels(factoryProducer = { factory })
    private lateinit var binding: FragmentNewsListBinding
    private val args: NewsListFragmentArgs by navArgs()

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
    }
}