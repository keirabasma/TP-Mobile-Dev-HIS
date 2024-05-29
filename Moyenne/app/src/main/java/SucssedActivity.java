import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp2.R;

public class FelicitationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);

        float moyenne = getIntent().getFloatExtra("moyenne", 0);

        TextView textViewMoyenne = findViewById(R.id.textViewMoyenne);
        textViewMoyenne.setText("Votre moyenne : " + moyenne);
    }
}
