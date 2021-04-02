package edu.jsu.mcis.cs408.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView output;
    private EditText newMemo;
    private EditText memoToDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (TextView)findViewById(R.id.memos);
        newMemo = (EditText)findViewById(R.id.newMemo);
        memoToDelete = (EditText)findViewById(R.id.memoToDelete);

        DatabaseHandler db = new DatabaseHandler(this, null, null, 1);
        String memos = db.getAllMemos();
        output.setText(memos);
    }

    public void addMemo(View v) {
        String memoToAdd = newMemo.getText().toString();
        Memo newMemoToAdd = new Memo(memoToAdd);

        DatabaseHandler db = new DatabaseHandler(this, null, null, 1);
        db.addMemo(newMemoToAdd);

        String memos = db.getAllMemos();
        output.setText(memos);
    }

    public void deleteMemo(View v) {
        int memoIdToDelete = Integer.parseInt(memoToDelete.getText().toString());

        DatabaseHandler db = new DatabaseHandler(this, null, null, 1);
        db.deleteMemo(memoIdToDelete);

        String memos = db.getAllMemos();
        output.setText(memos);
    }
}