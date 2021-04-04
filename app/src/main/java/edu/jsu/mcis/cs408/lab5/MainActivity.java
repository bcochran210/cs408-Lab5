package edu.jsu.mcis.cs408.lab5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private RecyclerView output;
    private EditText newMemo;
    private EditText memoToDelete;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (RecyclerView)findViewById(R.id.memos);
        newMemo = (EditText)findViewById(R.id.newMemo);
        memoToDelete = (EditText)findViewById(R.id.memoToDelete);

        db = new DatabaseHandler(this, null, null, 1);
        updateRecyclerView();
    }

    public void addMemo(View v) {
        String memoToAdd = newMemo.getText().toString();
        Memo newMemoToAdd = new Memo(memoToAdd);

        DatabaseHandler db = new DatabaseHandler(this, null, null, 1);
        db.addMemo(newMemoToAdd);

        updateRecyclerView();
    }

    public void deleteMemo(View v) {
        int memoIdToDelete = Integer.parseInt(memoToDelete.getText().toString());

        DatabaseHandler db = new DatabaseHandler(this, null, null, 1);
        db.deleteMemo(memoIdToDelete);

        updateRecyclerView();
    }

    private void updateRecyclerView() {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(db.getAllMemosAsList());
        output.setHasFixedSize(true);
        output.setLayoutManager(new LinearLayoutManager(this));
        output.setAdapter(adapter);
    }
}