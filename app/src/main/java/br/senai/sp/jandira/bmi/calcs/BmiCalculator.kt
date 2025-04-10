import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.model.Bmi
import br.senai.sp.jandira.bmi.model.BmiStatus
import kotlin.math.pow

@Composable
fun bmiCalculate (weight: Int, height: Double): Bmi {
    var bmi = weight.div(height.pow(2))

    when{
        bmi < 18.5 ->
            return Bmi(
                color = colorResource(R.color.Ligth_blue),
                status = BmiStatus.UNDER_WEIGHT,
                bmi = Pair(stringResource(R.string.under_weight), bmi)
            )


        bmi >= 18.5 && bmi < 25.0 ->
            return Bmi(
                color = colorResource(R.color.Ligth_green),
                status = BmiStatus.NORMAL,
                bmi = Pair(stringResource(R.string.normal_weight), bmi)
            )


        bmi >= 25.0 && bmi < 30.0 ->
            return Bmi(
                color = colorResource(R.color.yellow),
                status = BmiStatus.OVER_HEIGHT,
                bmi = Pair(stringResource(R.string.over_weigth), bmi)
            )

        bmi >= 30.0 && bmi < 35.0 ->
            return Bmi(
                color = colorResource(R.color.Ligth_orange),
                status = BmiStatus.OBESITY_1,
                bmi = Pair(stringResource(R.string.class1_weigth), bmi)
            )


        bmi >= 35.0 && bmi < 40.0 ->
            return Bmi(
                color = colorResource(R.color.Dark_orange),
                status = BmiStatus.OBESITY_2,
                bmi = Pair(stringResource(R.string.class2_weigth), bmi)
            )


        else ->
            return Bmi(
                color = colorResource(R.color.Ligth_red),
                status = BmiStatus.OBESITY_3,
                bmi = Pair(stringResource(R.string.normal_weight), bmi)
            )
    }
}