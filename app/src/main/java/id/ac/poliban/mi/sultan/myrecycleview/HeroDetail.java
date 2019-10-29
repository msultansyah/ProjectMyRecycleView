package id.ac.poliban.mi.sultan.myrecycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class HeroDetail extends AppCompatActivity {
    private TextView tvNameDetail;
    private TextView tvDetailDetail;
    private ImageView imgPhotoDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_detail);

        tvNameDetail = findViewById(R.id.tv_detail_name);
        tvDetailDetail = findViewById(R.id.tv_detail_detail);
        imgPhotoDetail = findViewById(R.id.img_detail_photo);

        if (getIntent().getExtras() !=null)
            showHeroDetail();
    }

    private void showHeroDetail() {
        Hero hero = (Hero) getIntent().getSerializableExtra("hero");
//untuk menampilkan photo secara asynchonous
//dari URL yang diberikan
        Glide.with(this)
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(220, 220))
                .into(imgPhotoDetail);
        tvNameDetail.setText(hero.getName());
        tvDetailDetail.setText(hero.getDetail());
/*
//jika photo tidak ingin berbentuk bulat
imgPhotoDetail.setImageResource(hero.getPhoto());
*/
    }
}
