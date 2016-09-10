package id.sch.smktelkom_mlg.tugas01.xirpl1012.project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

      EditText etNama;
      EditText etAlamat;
      RadioButton rbP, rbL;
      Button bOk;
      TextView tvHasil;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            etNama = (EditText) findViewById(R.id.editTextNama);
            etAlamat = (EditText) findViewById(R.id.editTextAlamat);
            rbP = (RadioButton) findViewById(R.id.radioButtonP);
            rbL = (RadioButton) findViewById(R.id.radioButtonL);
            bOk = (Button) findViewById(R.id.buttonOK);
            tvHasil = (TextView) findViewById(R.id.textViewHasil);

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
                  String hasil = rbP.getText().toString();
                  tvHasil.setText(nama + " asal " + alamat + "Jenis Kelamin Anda " + hasil);
            }
            String hasil = null;

            if (rbP.isChecked()) {
                  hasil = rbP.getText().toString();
            } else if (rbL.isChecked()) {
                  hasil = rbL.getText().toString();
            }

            if (hasil == null) {

            } else {

            }
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
