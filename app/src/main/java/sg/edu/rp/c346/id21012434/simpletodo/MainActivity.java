package sg.edu.rp.c346.id21012434.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText etElement;
    Button btnAdd;
    Button btnClear;
    ListView listView;
    ArrayList<String> alToDo;
    ArrayAdapter<String> aaToDo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etElement=findViewById(R.id.editText);
        btnAdd=findViewById(R.id.btnAdd);
        btnClear=findViewById(R.id.btnClear);
        listView=findViewById(R.id.listView);

        alToDo=new ArrayList<>();
        aaToDo=new ArrayAdapter<>(this
                , android.R.layout.simple_list_item_1,alToDo);
        listView.setAdapter(aaToDo);

        btnAdd.setOnClickListener((view) ->{
            String newTodo=etElement.getText().toString();
            alToDo.add(newTodo);
            aaToDo.notifyDataSetChanged();
            etElement.setText(null);
        });
        btnClear.setOnClickListener((view) ->{
            alToDo.clear();
            aaToDo.notifyDataSetChanged();
        });
    }
}