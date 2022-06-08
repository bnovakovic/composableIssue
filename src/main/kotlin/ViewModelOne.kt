import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelOne {
    private val viewModelScope = CoroutineScope(Dispatchers.IO)
    private val _stateOne = MutableStateFlow(0)
    val stateOne = _stateOne.asStateFlow()

    fun changeState() {
        viewModelScope.launch {
            val currentValue = stateOne.value + 1
            _stateOne.emit(currentValue)
        }
    }
}