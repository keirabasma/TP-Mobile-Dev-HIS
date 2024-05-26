public class FelicitationsActivity extends AppCompatActivity {
    private TextView tvMoyenne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_felicitations);

        tvMoyenne = findViewById(R.id.tvMoyenne);

        double moyenne = getIntent().getDoubleExtra("moyenne", 0);
        tvMoyenne.setText("Votre moyenne est : " + moyenne);
    }
}