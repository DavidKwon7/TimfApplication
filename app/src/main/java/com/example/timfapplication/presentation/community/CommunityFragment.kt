package com.example.timfapplication.presentation.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timfapplication.R
import com.example.timfapplication.databinding.FragmentCommunityBinding
import com.example.timfapplication.domain.entity.community.RequestModel
import com.example.timfapplication.domain.entity.community.SearchObj
import com.example.timfapplication.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CommunityFragment : BaseFragment<FragmentCommunityBinding>() {

    val vm: CommunityViewModel by viewModels()

    var isLoading: Boolean = false
    private val dataItems = mutableListOf<String?>()

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCommunityBinding {
        return FragmentCommunityBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for (i in 1 until 20) {
            dataItems.add("item $i")
        }

        binding.rvBoard.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = binding.rvBoard.layoutManager as LinearLayoutManager
                if (!isLoading) {
                    if (layoutManager != null && layoutManager.findLastCompletelyVisibleItemPosition() == dataItems.size -1) {
                        isLoading = true
                        getMoreData()
                    }
                }
                if (!isLoading) {
                    if (!binding.rvBoard.canScrollVertically(1)) {
                        isLoading = true
                        getMoreData()
                    }
                }
            }
        })

        binding.rvBoard.adapter = CommunityAdapter()

        val requestModel = RequestModel(
            length = 1,
            searchObj = (
                    SearchObj(
                        "string",
                        "string",
                        "string",
                        "2022-06-28T08:48:15.289Z",
                        "2022-06-28T08:48:15.289Z",
                        "string",
                        "string"
                    )
                    ),
            start = 0
        )

        binding.btnNew.setOnClickListener {
            Toast.makeText(requireContext(), "버튼을 눌렀습니다", Toast.LENGTH_SHORT).show()
            vm.postData(requestModel)
        }

        observing()
    }

    private fun getMoreData() {
        dataItems.add(null)
        binding.rvBoard.adapter?.notifyItemInserted(dataItems.size -1)
        dataItems.removeAt(dataItems.size -1)
        val currentSize = dataItems.size
        for (i in currentSize +1 until currentSize + 10) {
            dataItems.add("item $i")
        }
        binding.rvBoard.adapter?.notifyDataSetChanged()
        isLoading = false
    }


    private fun observing() {
        vm.boardLiveData.observe(viewLifecycleOwner) {
            (binding.rvBoard.adapter as CommunityAdapter).setItems(it)

        }
    }
}