package android.mobile.onbroading

import android.mobile.onbroading.model.Survey
import android.mobile.onbroading.screens.AdapterSurvey
import android.os.Bundle
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SurveyActivity : AppCompatActivity(), AdapterSurvey.OnItemClickListener {

    private lateinit var btnConfirm: AppCompatButton // Nút mà bạn muốn thay đổi màu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_survey)
        val surveyList = listOf(
            Survey(R.drawable.survey_01, "Samurai"),
            Survey(R.drawable.survey_02, "One Piece "),
            Survey(R.drawable.survey_03, "Spider"),
            Survey(R.drawable.survey_04, "Attach on titan"),
            Survey(R.drawable.survey_05, "Demon Slayer"),
            Survey(R.drawable.survey_06, "Naruto"),
            Survey(R.drawable.survey_07, "Dragon Ball"),
            Survey(R.drawable.survey_08, "Hunter x Hunter"),
            Survey(R.drawable.survey_01, "Jujutsu Kaisen"),
            Survey(R.drawable.survey_03, "Tokyo Revengers"),
            Survey(R.drawable.survey_02, "Fairy Tail"),
            Survey(R.drawable.survey_04, "My Hero Academia"),
            Survey(R.drawable.survey_05, "Chainsaw Man"),
            Survey(R.drawable.survey_06, "One Punch Man"),
            Survey(R.drawable.survey_08, "Sword Art Online"),
        )
        btnConfirm = findViewById(R.id.button_survey)
        btnConfirm.isEnabled = false
        val rcvSurvey = findViewById<RecyclerView>(R.id.rcv_survey)
        val adapterSurvey = AdapterSurvey(surveyList,this )
        rcvSurvey.adapter = adapterSurvey
        rcvSurvey.layoutManager = GridLayoutManager(this, 3)
    }

    override fun onItemSelected(selectedCount: Int) {
        // Thay đổi trạng thái nút dựa trên số lượng item được chọn
        if (selectedCount == 2) {
            btnConfirm.apply {
                isEnabled = true
                background = getDrawable(R.drawable.active_button)
//                setBackgroundColor(getColor(R.color.active_button)) // Màu khi nút hoạt động
            }
        } else {
            btnConfirm.apply {
                isEnabled = false
                background = getDrawable(R.drawable.inactive_button)
//                setBackgroundColor(getColor(R.color.inactive_button)) // Màu khi nút bị vô hiệu hóa
            }
        }
    }
}