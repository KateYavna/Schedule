package com.example.schedule

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_schedule.view.*

class ScheduleAdapter( val context:Context, val schedule: List<Schedule>) :RecyclerView.Adapter<ViewHolder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_schedule,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (schedule[position].importance.equals(true)) holder.importance.visibility = View.VISIBLE
        holder.task.text = schedule[position].task
        holder.description.text = schedule[position].description
        holder.time.text = schedule[position].time
        if (schedule[position] == schedule[schedule.lastIndex]) {
            holder.importance.visibility = View.INVISIBLE
            holder.task.visibility = View.INVISIBLE
            holder.description.visibility = View.INVISIBLE
            holder.time.visibility = View.INVISIBLE
            holder.ivDelete.visibility = View.INVISIBLE
            holder.fab.visibility = View.VISIBLE
        }
        holder.fab.setOnClickListener {
            holder.fab.visibility = View.INVISIBLE
            holder.clEt.visibility = View.VISIBLE
            // val newSchedule = Schedule("","","",false)
            // Thread{ App.instance.database.scheduleDao().insert(newSchedule)}.start()
            holder.etTask.afterTextChanged {
                holder.tvAdd.setOnClickListener { holder.etDescription.requestFocus() }
            }
            holder.etDescription.afterTextChanged {
                holder.tvAddDescription.setOnClickListener { holder.etTime.requestFocus() }
            }
            holder.etTime.afterTextChanged {
                holder.tvAddTime.setOnClickListener { holder.etImportance.requestFocus() }
            }
            holder.etImportance.afterTextChanged {
                holder.tvAddImportance.setOnClickListener {
                    if (holder.etImportance.text.toString().equals("0")) {
                        val newSchedule = Schedule(
                            holder.etTask.text.toString(),
                            holder.etDescription.text.toString(), holder.etTime.text.toString(),
                            false
                        )
                        Thread { App.instance.database.scheduleDao().insert(newSchedule) }.start()
                    } else {
                        val newSchedule = Schedule(
                            holder.etTask.text.toString(),
                            holder.etDescription.text.toString(), holder.etTime.text.toString(),
                            true
                        )
                        Thread { App.instance.database.scheduleDao().insert(newSchedule) }.start()


                    }
                    holder.clMain.visibility = View.INVISIBLE

                }
            }
        }
            holder.ivDelete.setOnClickListener {
                val newSchedule = Schedule(
                    schedule[position].task,
                    schedule[position].description,
                    schedule[position].time,
                    schedule[position].importance
                )
                Thread{ App.instance.database.scheduleDao().delete(newSchedule)}.start()
                holder.clMain.visibility = View.INVISIBLE

            }
            if (schedule[position].importance.equals(true)) holder.importance.visibility =
                View.VISIBLE
            holder.task.text = schedule[position].task
            holder.description.text = schedule[position].description
            holder.time.text = schedule[position].time
        }

    override fun getItemCount(): Int {
        return schedule.size
    }

    }

    class ViewHolder(Itemview: View) :RecyclerView.ViewHolder(Itemview){
    val importance = itemView.ivImportance
    val task = itemView.tvTask
    val description = itemView.tvDescription
    val time = itemView.tvTime
    val clEt = itemView.clEt
    val fab = itemView.floatingActionButton
        val ivDelete = itemView.ivDelete
        val tvAdd = itemView.tvAdd
        val tvAddDescription = itemView.tvAddDescription
        val tvAddTime = itemView.tvAddTime
        val tvAddImportance = itemView.tvAddImportance
        val etTask = itemView.etTask
        val etDescription = itemView.etDescripsion
        val etTime = itemView.etTime
        val etImportance = itemView.etImportance
        val clMain = itemView.clMain

    }

    fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
     })
    }