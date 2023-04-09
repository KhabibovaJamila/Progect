package com.example.mysmartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mysmartlab.Adapter.ImageAdapter;
import com.example.mysmartlab.Adapter.ProgectAdapter;
import com.example.mysmartlab.CartManager;
import com.example.mysmartlab.DataClass.ImageAnalyzes;
import com.example.mysmartlab.DataClass.Product;
import com.example.mysmartlab.R;
import com.example.mysmartlab.RequestInteface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnalyzeActivity extends AppCompatActivity {
    private RecyclerView recyclerView2, res;
    private ArrayList<Product> products;
    private CartManager cartManager;
    public ArrayList<ImageAnalyzes> courses = new ArrayList<>() ;
    private ImageAdapter adapter;//carsAdapter

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze);

        res = findViewById(R.id.recyclerView2) ;
        res.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false) ;
        res.setLayoutManager(layoutManager);

        getCarsResponse() ;






        recyclerView2 = findViewById(R.id.res);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        products = generateTestData();
        cartManager = CartManager.getInstance();
        recyclerView2.setAdapter(new ProgectAdapter(products, this, cartManager));
    }
    private ArrayList<Product> generateTestData() {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(1, "ПЦР-тест на определение РНК коронавирусв стандартный", "Клинический анализ крови – это самое важное комплексное лабораторное исследование при обследовании человека с любым заболеванием. Изменение исследуемых показателей, как правило, происходит задолго до появления видимых симптомов болезни.", 1800,  "Популярные" , "2 дня", "Кровь следует сдавать утром натощак, днем или вечером – через 4-5 часов после последнего приема пищи. За 1–2 дня до исследования необходимо исключить из рациона продукты с высоким содержанием жиров и алкоголь.","Слизистая"));
        products.add(new Product(2, "Экспресс-тест, ПЦР, РНК вируса SARS-CoV-2, мазок (PCR Rapid test, SARS-CoV-2, RNA, nasopharyngeal and oropharyngeal smear", "Тест проводят с целью определения наличия РНК коронавируса SARS-CoV-2 в мазке со слизистой носа, носоглотки и ротоглотки методом ПЦР с детекцией в режиме реального времени (RT-PCR).", 4085, "Популярные", "1 день", "Взятие биологического материала рекомендуется проводить до начала приема лекарственных препаратов.   При подготовке пациента к взятию биоматериала следует учесть: за шесть часов до исследования не рекомендуется использовать лекарственные средства для орошения ротоглотки и препараты для рассасывания; перед взятием биологического материала, за 3-4 часа не рекомендуется использовать жевательную резинку/пастилки для освежения дыхания, принимать  пищу, чистить зубы, курить; если полость носа заполнена слизью, перед процедурой рекомендуется провести высмаркивание.", "Мазок со слизистой носа, носоглотки и/или ротоглотки"));
        products.add(new Product(3, "Гликированный гемоглобин (HbA1С, Glycated Hemoglobin)", "Оценку содержания гликированного гемолобина в цельной крови используют для долгосрочного контроля уровня глюкозы в крови, при диагностике сахарного диабета, выявлении риска развития диабета.", 1070,  "Популярные" , "1 день", "Взятие крови предпочтительно проводить натощак. Исследование нецелесообразно проводить после кровотечений, гемотрансфузий.", "Цельная кровь (с ЭДТА)"));
        products.add(new Product(4, "Тироксин общий (Т4 общий, тетрайодтиронин общий, Total Thyroxine, TT4))", "Описание телефона 5", 925,  "Популярные", "2 дня", "Взятие крови предпочтительно проводить утром натощак, после 8-14-часового периода ночного голодания (воду пить можно), допустимо в дневное время, выдержав 4 часа от последнего приема пищи.", "Сыворотка крови"));
        products.add(new Product(5, "ПЦР-тест на коронавирус SARS-CoV-2, мазок (PCR, Coronavirus SARS-CoV-2, nasopharyngeal and oropharyngeal smear)", "Описание телефона 5", 2540,  "COVID", "1 день", "Взятие биологического материала рекомендуется проводить до начала приема лекарственных препаратов.   При подготовке пациента к взятию биоматериала следует учесть:   за шесть часов до исследования не рекомендуется использовать лекарственные средства для орошения ротоглотки и препараты для рассасывания;  перед взятием биологического материала, за 3-4 часа не рекомендуется использовать жевательную резинку/пастилки для освежения дыхания, принимать пищу, чистить зубы, курить; если полость носа заполнена слизью, перед процедурой рекомендуется провести высмаркивание.", "Мазок со слизистой носоглотки и/или ротоглотки"));
        products.add(new Product(6, "ПЦР-тест на РНК коронавируса SARS-CoV-2, включая определение штаммов Омикрон и Дельта, в мазке со слизистой носоглотки и ротоглотки", "SARS-CoV-2 относится к большому семейству РНК-содержащих вирусов – коронавирусов (лат. Coronaviridae), вызывающих респираторные заболевания. В настоящее время известно о циркуляции среди населения четырех видов коронавирусов (HCoV-229E, -OC43, -NL63 и -HKU1), которые круглогодично присутствуют в структуре ОРВИ и, как правило, вызывают поражение верхних дыхательных путей легкой и средней тяжести. К семейству коронавирусов также относятся опасные вирусы SARS-CoV и MERS-CoV, вызывающие тяжелый острый респираторный синдром и ближневосточный респираторный синдром, соответственно.", 2640, "COVID","1 день","Взятие биологического материала рекомендуется проводить до начала приема лекарственных препаратов.  При подготовке пациента к взятию биоматериала следует учесть: за час до исследования не рекомендуется использовать лекарственные средства для орошения ротоглотки и препараты для рассасывания; непосредственно перед взятием биологического материала не рекомендуется использовать жевательную резинку/пастилки для освежения дыхания; если полость носа заполнена слизью, перед процедурой рекомендуется провести высмаркивание. Желательно соблюдать все описанные условия, если лечащим врачом не рекомендовано иное.","Мазок со слизистой носоглотки и/или ротоглотки"));
        products.add(new Product(7, "Антитела, количественные, к спайковому (S) белку (RBD) SARS-CoV-2, IgG (Anti-SARS-CoV-2, spike (S) protein (RBD), IgG, quantitative", "Присутствие специфических антител к вирусу SARS-CoV-2 класса G указывает на факт недавнего или прошлого взаимодействия с вирусом. Поэтому такие тесты используют в комплексной диагностике при наличии подозрений на инфекцию новым коронавирусом или ее осложнения. Основной метод лабораторного подтверждения острой инфекции COVID-19 – выявление методами полимеразной цепной реакции (ПЦР) РНК вируса в биоматериале, взятом из дыхательных путей, обычно в мазке из носоглотки и ротоглотки.", 1740,  "COVID","2 дня","Специальной подготовки не требуется.","Сыворотка крови"));
        products.add(new Product(8, "Поствакцинальные (ЭпиВакКорона, Вектор) антитела к SARS-CoV-2 (N-, S-белки), SARS-CoV-2-IgG-Вектор", "Качественное определение поствакцинальных (ЭпиВакКорона, Вектор) антител к SARS-CoV-2 в сыворотке крови позволяет оценить наличие иммунного ответа на вакцину ЭпиВакКорона (Вектор).", 2540, "COVID","1 день","Взятие крови предпочтительно проводить утром натощак, после 8-14 часов ночного периода голодания (воду пить можно), допустимо днем через 4 часа после легкого приема пищи. Исследование целесообразно проводить не ранее чем через две недели после второй вакцинации.","Сыворотка крови"));
        products.add(new Product(9, "Анализ перестроек гена BCL- 6 (der(3)(q27)) (FISH, колич.) Analysis of BCL- 6 gene rearrangements (der(3)(q27) (FISH, quantitative)", "Согласно современным представлениям, опирающимся на результаты исследования профиля экспрессии генов, существует несколько подтипов диффузной B-крупноклеточной лимфомы (ДBКЛ): из В-клеток герминативного центра и из активированных В-клеток. Ген BCL6 (находиться в длинном плече 3 хромосомы в районе 27) является одним из ключевых регуляторов развития В-лимфоцитов на уровне герминальной (фолликулярной) дифференцировки.", 11195, "Онкогенетические","7 рабочих дней","Специальной подготовки не требуется.","Цельная кровь")) ;
        products.add(new Product(10, "Профиль Гиперэозинофильный синдром", "Цитогенетическое исследование клеток костного мозга (кариотипирование) – это микроскопический анализ хромосом, который проводится для определения кариотипа, выявления численных и структурных нарушений в структуре хромосом, а также подтверждения онкологического заболевания.", 34250, "Онкогенетические","7 рабочих дней","",""));
        return products;
    }
    private void getCarsResponse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://medic.madskill.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInteface requestInteface = retrofit.create(RequestInteface.class);
        Call<List<ImageAnalyzes>> call = requestInteface.getCarsJcon();
        call.enqueue(new Callback<List<ImageAnalyzes>>() {
            @Override
            public void onResponse(Call<List<ImageAnalyzes>> call, Response<List<ImageAnalyzes>> response) {
                courses = new ArrayList<>(response.body());
                adapter = new ImageAdapter( AnalyzeActivity.this, courses);
                res.setAdapter(adapter);

                Toast.makeText(AnalyzeActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ImageAnalyzes>> call, Throwable t) {
                Toast.makeText(AnalyzeActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }


        });
    }
}