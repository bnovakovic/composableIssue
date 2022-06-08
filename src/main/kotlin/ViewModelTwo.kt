import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelTwo(val stringList: List<String>) {
    private val viewModelScope = CoroutineScope(Dispatchers.IO)
    private val _currentListItem = MutableStateFlow(0)
    val currentListItem = _currentListItem.asStateFlow()

    fun changeIndex() {
        viewModelScope.launch {
            _currentListItem.emit(2)
        }
    }
}