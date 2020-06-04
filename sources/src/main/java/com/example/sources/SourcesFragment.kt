package com.example.sources

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.core.ui.BaseFragment
import com.example.core.ui.coreComponent
import com.example.core.ui.showWarningDialog
import com.example.sources.databinding.SourcesFragmentBinding
import com.example.sources.di.DaggerSourcesComponent
import com.example.sources.SourcesAdapter
import com.example.sources.di.SourcesModule
import javax.inject.Inject

class SourcesFragment : BaseFragment<SourcesViewModel>() {

    @Inject
    lateinit var factory: SourcesViewModel.Factory

    override val viewModel: SourcesViewModel by viewModels(factoryProducer = { factory })
    private lateinit var binding: SourcesFragmentBinding
    private val args: SourcesFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SourcesFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerSourcesComponent
            .builder()
            .sourcesModule(SourcesModule(args.category))
            .coreComponent(coreComponent())
            .build()
            .inject(this)

        binding.vm = viewModel
        val adapter = SourcesAdapter(viewModel)
        binding.sourcesRv.adapter = adapter

        viewModel.getSources()
        showLoadingDialog()

        viewModel.query.observe(viewLifecycleOwner, Observer {
            viewModel.filterSources(it)
        })

        viewModel.sourcesResponse.observe(viewLifecycleOwner, Observer {
            hideLoadingDialog()
            hideKeyboard()
            it.error?.let {err->
                showWarningDialog(getString(R.string.error), err.message.toString())
            }
        })
    }


}