package com.example.baitap6;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap6.adapter.AdapterTinNhan;
import com.example.baitap6.model.Tinnhan;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Doctinnhan extends AppCompatActivity {
    private  static final  int REQUEST_CONTACTS_ASK_PERMISSION = 1001;

    ArrayList<Tinnhan> dsTinNhan;
    ArrayAdapter adapterTinnhan;
    ListView lvDocTinNhan;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctinnhan);
        addConTrol();
        docToanBoTinNhan();

    }

    private void docToanBoTinNhan() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Uri uri = Uri.parse("content://sms//inbox");
        Cursor cursor = getContentResolver().query(uri,null, null, null, null);
        dsTinNhan.clear();
        while (cursor.moveToNext()){
            int indexPhoneNumber = cursor.getColumnIndex("address");
            int indexTimeStamp = cursor.getColumnIndex("date");
            int indexBody = cursor.getColumnIndex("body");
            String phoneNumber = cursor.getString(indexPhoneNumber);
            String timeStamp = cursor.getString(indexTimeStamp);
            String body = cursor.getString(indexBody);
            dsTinNhan.add(new Tinnhan(phoneNumber,sdf.format(Long.parseLong(timeStamp)),body));
            adapterTinnhan.notifyDataSetChanged();
        }
    }

    private void addConTrol() {
        lvDocTinNhan = findViewById(R.id.lvDocTinNhan);
        dsTinNhan = new ArrayList<>();
        adapterTinnhan = new AdapterTinNhan(
                Doctinnhan.this,R.layout.item_tinnhan, dsTinNhan
        );
        lvDocTinNhan.setAdapter(adapterTinnhan);

    }
}