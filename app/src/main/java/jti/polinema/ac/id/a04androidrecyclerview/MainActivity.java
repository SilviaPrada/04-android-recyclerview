package jti.polinema.ac.id.a04androidrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Buku> dataList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setData(Data.dt());

        recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        Adapter adapter = new Adapter(dataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    public void setData(String data){
        try {
            JSONArray jsonArray = new JSONArray(data);
            dataList = new ArrayList<>();
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Buku buku = new Buku(jsonObject.getString("judul"),
                        jsonObject.getString("pengarang"));
                dataList.add(buku);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}