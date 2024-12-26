package android.mobile.onbroading.screens

import android.annotation.SuppressLint
import android.mobile.onbroading.R
import android.mobile.onbroading.model.Survey
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView

class AdapterSurvey(
    private val listSurvey: List<Survey>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<AdapterSurvey.ViewHolder>() {

    private val selectedPositions = mutableSetOf<Int>() // Lưu trữ các vị trí đã chọn

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterSurvey.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_survey, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: AdapterSurvey.ViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val survey = listSurvey[position]
        holder.bind(survey, selectedPositions.contains(position))

        holder.itemView.setOnClickListener() {

            if (selectedPositions.contains(position)) {
                selectedPositions.remove(position) // da chon roi thi bo
            } else {
                selectedPositions.add(position) // chua chon thi them vao
            }
            notifyItemChanged(position) // cap nhat lai trang thai
            listener.onItemSelected(selectedPositions.size) // gui so luong ma khi nguoi dung click
        }

    }

    override fun getItemCount(): Int = listSurvey.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btn_picSurvey = itemView.findViewById<AppCompatButton>(R.id.pic_survey)
        val txt_nameSurvey = itemView.findViewById<TextView>(R.id.txt_titleSuver)

        fun bind(survey: Survey, isSelected: Boolean) {
            btn_picSurvey.setBackgroundResource(survey.pic)
            txt_nameSurvey.text = survey.name
            updateSelection(isSelected)
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        fun updateSelection(isSelected: Boolean) {
            if (isSelected) {
                // Khi được chọn
                btn_picSurvey.foreground = itemView.context.getDrawable(R.drawable.select_boder)
                txt_nameSurvey.background = itemView.context.getDrawable(R.drawable.select_text)
//                txt_nameSurvey.setBackgroundColor(itemView.context.getDrawable(R.drawable.select_text))
                txt_nameSurvey.setTextColor(itemView.context.getColor(R.color.white))
            } else {
                // Khi không được chọn
                btn_picSurvey.foreground = null // loai bo vien
                txt_nameSurvey.background = null
                txt_nameSurvey.setTextColor(itemView.context.getColor(R.color.white))
            }
        }
    }

    interface OnItemClickListener {
        fun onItemSelected(selectedCount: Int)
    }
}