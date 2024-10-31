package com.example.apphitung;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegitigaActivity extends AppCompatActivity {

    private EditText nilaia, nilait; // EditText untuk alas dan tinggi
    private TextView hasil; // TextView untuk menampilkan hasil

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segitiga); // Pastikan setContentView dipanggil sebelum inisialisasi

        // Mengambil referensi untuk EditText dan TextView setelah setContentView
        nilaia = findViewById(R.id.nilaia);
        nilait = findViewById(R.id.nilait);
        hasil = findViewById(R.id.hasil);

        // Set padding untuk insets sistem
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Hitung(View view) {
        // Ambil nilai alas dan tinggi
        String alasStr = nilaia.getText().toString();
        String tinggiStr = nilait.getText().toString();

        // Validasi input
        if (alasStr.isEmpty() || tinggiStr.isEmpty()) {
            Toast.makeText(this, "Alas dan Tinggi harus diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        // Menghitung luas segitiga
        double alas = Double.parseDouble(alasStr);
        double tinggi = Double.parseDouble(tinggiStr);
        double luas = 0.5 * alas * tinggi;

        // Menampilkan hasil
        hasil.setText("Hasil: " + luas);
    }
}
