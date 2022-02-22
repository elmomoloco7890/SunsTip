package ay.artemis.myapplication.models


import androidx.lifecycle.*
import ay.artemis.myapplication.data.TipCalcData
import java.text.NumberFormat
import java.util.logging.Handler
import kotlin.math.roundToInt
import kotlin.math.roundToLong

//tax rate common for calculation


/*private const val given_TaxRate = 0.091
private const val OneHundred = 100*/



private const val taxRate = 0.091
class TipViewModel : ViewModel() {


    // this is my attempt to handle the tip calculations a little better than last time.
    private val _subTotalOnInput = MutableLiveData<Double>()
    val subTotalOnInput: LiveData<String> = Transformations.map(_subTotalOnInput){
        NumberFormat.getCurrencyInstance().format(it)
    }

    fun subTotalCalculated(cost: Double){
        _subTotalOnInput.value = cost.plus(taxRate)
    }

    fun subTotalEditTextDisplay(): LiveData<Double>{
        return Transformations.switchMap(subTotalOnInput){
            val subLiveData = MutableLiveData<Double>()
                try {
                    subLiveData.value = it.toString().toDouble() .plus(taxRate)
                } catch (e: NumberFormatException){
                    subLiveData.value = 0.0
                }
                subLiveData
            }
        }

    val percentProgressLiveData = MutableLiveData("0.0")
    //val tipPercent = percentProgressLiveData.value?.toIntOrNull()

    fun progressValues(percentage: Int){
        percentProgressLiveData.value = percentage.toFloat().roundToInt().toString()
    }

    fun onEditTextTyped(): LiveData<Int> {
        return Transformations.switchMap(percentProgressLiveData) {
            val liveData = MutableLiveData<Int>()
            try {
                liveData.value = it.toString().toFloat().roundToInt()
            } catch (e: NumberFormatException) {
                // reset the progress bar if the progress text is invalid
                liveData.value = 0
            }
            liveData
        }
    }

}


