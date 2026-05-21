package com.example.contextactionbar;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if(actionMode != null) {
                    return false;
                }

                actionMode = startActionMode(actionModeCallback);

                v.setSelected(true);

                return true;
            }
        });
    }

    private ActionMode.Callback actionModeCallback =
            new ActionMode.Callback() {

                @Override
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {

                    mode.getMenuInflater()
                            .inflate(R.menu.action_menu, menu);

                    mode.setTitle("Select Action");

                    return true;
                }

                @Override
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false;
                }

                @Override
                public boolean onActionItemClicked(ActionMode mode,
                                                   MenuItem item) {

                    if(item.getItemId() == R.id.edit) {

                        Toast.makeText(MainActivity.this,
                                "Edit Selected",
                                Toast.LENGTH_SHORT).show();

                        mode.finish();

                        return true;
                    }

                    else if(item.getItemId() == R.id.delete) {

                        Toast.makeText(MainActivity.this,
                                "Delete Selected",
                                Toast.LENGTH_SHORT).show();

                        mode.finish();

                        return true;
                    }

                    return false;
                }

                @Override
                public void onDestroyActionMode(ActionMode mode) {

                    actionMode = null;
                }
            };
}