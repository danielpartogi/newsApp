package com.example.sources

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.core.ui.BaseFragment
import com.example.core.ui.coreComponent
import com.example.sources.di.DaggerSourcesComponent
import com.example.sources.di.SourcesModule
import javax.inject.Inject

class SourcesFragment : BaseFragment<SourcesViewModel>() {

    @Inject
    lateinit var factory: SourcesViewModel.Factory

    override val viewModel: SourcesViewModel by viewModels(factoryProducer = { factory })

    private val args: SourcesFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sources_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerSourcesComponent
            .builder()
            .sourcesModule(SourcesModule(args.category))
            .coreComponent(coreComponent())
            .build()
            .inject(this)

        viewModel.getSources()
    }


}