public class MainActivity extends AppCompatActivity {
    private EditText note1, note2, note3;
    private Button btnCalculer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note1 = findViewById(R.id.note1);
        note2 = findViewById(R.id.note2);
        note3 = findViewById(R.id.note3);
        btnCalculer = findViewById(R.id.btnCalculer);

        btnCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double moyenne = calculerMoyenne();
                if (moyenne >= 10) {
                    Intent intent = new Intent(MainActivity.this, FelicitationsActivity.class);
                    intent.putExtra("moyenne", moyenne);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, DommageActivity.class);
                    intent.putExtra("moyenne", moyenne);
                    startActivity(intent);
                }
            }
        });
    }

    private double calculerMoyenne() {
        double note1Value = Double.parseDouble(note1.getText().toString());
        double note2Value = Double.parseDouble(note2.getText().toString());
        double note3Value = Double.parseDouble(note3.getText().toString());
        return (note1Value + note2Value + note3Value) / 3;
    }
}