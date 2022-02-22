package ay.artemis.myapplication.data

import androidx.databinding.BaseObservable
//Didn't use this no idea how without creating a database, found a tip calculator but way to confusing to follow along.
data class TipCalcData(
    val checkAmount: Double = 0.0,
    val tipPct: Int = 0,
    val perPerson: Int = 0,
    val grandTotal: Double = 0.0,
)

