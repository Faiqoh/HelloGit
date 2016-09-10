package id.sch.smktelkom_mlg.tugas01.xirpl1012.project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

      EditText etNama;
      EditText etAlamat;
      /*RadioButton rbP, rbL;*/
      RadioGroup rgJenis;
      CheckBox cbV, cbB, cbF, cbPS;
      Button bOk;
      TextView tvHasil;
      TextView tvHasil1;
      TextView tvHasil2;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            etNama = (EditText) findViewById(R.id.editTextNama);
            etAlamat = (EditText) findViewById(R.id.editTextAlamat);
            /*rbP = (RadioButton) findViewById(R.id.radioButtonP);
            rbL = (RadioButton) findViewById(R.id.radioButtonL);*/
            rgJenis = (RadioGroup) findViewById(R.id.radioGroupJenis);
            cbV = (CheckBox) findViewById(R.id.checkBoxVoli);
            cbB = (CheckBox) findViewById(R.id.checkBoxBasket);
            cbF = (CheckBox) findViewById(R.id.checkBoxFutsal);
            cbPS = (CheckBox) findViewById(R.id.checkBoxPaduanSuara);
            bOk = (Button) findViewById(R.id.buttonOK);
            tvHasil = (TextView) findViewById(R.id.textViewHasil);
            tvHasil1 = (TextView) findViewById(R.id.textViewHasil1);
            tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);

            bOk.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                        doProcess();
                  }
            });
      }

      private void doProcess() {
            if (isValid()) {
                  String nama = etNama.getText().toString();
                  String alamat = etAlamat.getText().toString();
                  tvHasil.setText("Nama Anda " + nama + " asal " + alamat);
            }
            String hasil = null;

            if (rgJenis.getCheckedRadioButtonId() != -1) {
                  RadioButton rb = (RadioButton)
                          findViewById(rgJenis.getCheckedRadioButtonId());
                  hasil = rb.getText().toString();
            }

            if (hasil == null) {
                  tvHasil1.setText("Belum memilih jenis Kelamin");
            } else {
                  tvHasil1.setText("Jenis Kelamin Anda " + hasil);
            }

            String hasil3 = "Ekskul yang Anda pilih:\n";
            int startlen = hasil.length();
            if (cbV.isChecked()) hasil3 += cbV.getText() + "\n";
            if (cbB.isChecked()) hasil3 += cbB.getText() + "\n";
            if (cbF.isChecked()) hasil3 += cbF.getText() + "\n";
            if (cbPS.isChecked()) hasil3 += cbPS.getText() + "\n";

            if (hasil3.length() == startlen) hasil3 += "Tidak ada pada pilihan";
            tvHasil2.setText(hasil3);
      }

      private boolean isValid() {
            boolean valid = true;

            String nama = etNama.getText().toString();
            String alamat = etAlamat.getText().toString();

            if (nama.isEmpty()) {
                  etNama.setError("Nama belum diisi");
                  valid = false;
            } else if (nama.length() < 3) {
                  etNama.setError("Nama minimal 3 error");
                  valid = false;
            } else {
                  etNama.setError(null);
            }

            if (alamat.isEmpty()) {
                  etAlamat.setError("Alamat belum diisi");
                  valid = false;
            } else {
                  etAlamat.setError(null);
            }
            return valid;
      }

}
