package abika.sinau.core.utils.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding


abstract class BaseViewModelActivity<VM : ViewModel, VB : ViewBinding> : AppCompatActivity() {
    protected lateinit var viewModel: VM
    protected abstract val viewModelClass: Class<VM>
    protected lateinit var binding: VB
    protected abstract fun setupObservers(lifecycleOwner: LifecycleOwner, viewModel: VM)
    protected abstract fun setupViews()
    abstract fun inflateLayout(layoutInflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[viewModelClass]
        binding = inflateLayout(layoutInflater)
        setContentView(binding.root)
        setupObservers(this, viewModel)
        setupViews()
    }
}