package com.sreeharan.labreportingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.sreeharan.labreportingsystem.adapters.TimeSlotAdapter;
import com.sreeharan.labreportingsystem.pojo.Appointment;
import com.sreeharan.labreportingsystem.pojo.TimeSlot;

public class AppointmentActivity extends AppCompatActivity {

    TimeSlot[] timeList = {new TimeSlot(0), new TimeSlot(0),
            new TimeSlot(0), new TimeSlot(0),
            new TimeSlot(0), new TimeSlot(0) };

    private static final int CHANGE_TIME = 1;
    private static final int CHANGE_DATE = 2;
    private static final int GET_APPOINTMENT = 3;
    CheckBox sugar, blood, urine;
    Appointment appointment;
    TextView changeTime, changeDate;
    Dialog dialog;
    Button appointmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        dialog = new Dialog(this);

        appointment = new Appointment();
        sugar = findViewById(R.id.sugar_checkbox);
        blood = findViewById(R.id.blood_checkbox);
        urine = findViewById(R.id.urine_test_checkbox);
        appointmentButton = findViewById(R.id.get_appointment_button);

        appointment.setBloodTest(blood.isChecked());
        appointment.setSugarTest(sugar.isChecked());
        appointment.setUrineTest(urine.isChecked());

        changeDate = findViewById(R.id.change_date);
        changeDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(CHANGE_DATE);
            }
        });

        changeTime = findViewById(R.id.change_time);
        changeTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(CHANGE_TIME);
            }
        });

        appointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(GET_APPOINTMENT);
            }
        });
    }

    private void openDialog(int id) {
        RecyclerView rvTimeSlot;
        TextView time;
        Button timeOk, DateOk;
        TimeSlotAdapter slotAdapter;
        if(id == CHANGE_TIME){
            //TODO: open the change time dialog
            dialog.setContentView(R.layout.dialog_time);

            slotAdapter = new TimeSlotAdapter(this, timeList);
            rvTimeSlot = dialog.findViewById(R.id.rv_time);
            rvTimeSlot.setAdapter(slotAdapter);
            rvTimeSlot.setLayoutManager(new LinearLayoutManager(this));


            timeOk = dialog.findViewById(R.id.time_ok_button);
            timeOk.setOnClickListener(v -> dialog.dismiss());

        }else if(id == CHANGE_DATE){
            //TODO: open the change date dialog
            dialog.setContentView(R.layout.dialog_date);


            DateOk = dialog.findViewById(R.id.date_ok_button);
            DateOk.setOnClickListener(v -> dialog.dismiss());

        }
        dialog.show();
    }
}