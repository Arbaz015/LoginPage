package com.example.loginpage;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.loginpage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    StringBuilder result=new StringBuilder();
    String name="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        InputFilter letterFilter=new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

                String filtered="";

                for (int i=start;i<end;i++)
                {
                    char character=source.charAt(i);
                    if (!Character.isWhitespace(character)&& Character.isLetter(character))
                    {
                        filtered+=character;
                    }
                }
                return filtered;
            }
        };
        binding.editTextTextName.setFilters(new InputFilter[]{letterFilter});

        binding.submitBtn.setOnClickListener(v->{




                   boolean check= isEmpty(binding.editTextText);

                    if (check)
                    {
                        binding.editTextTextName.setError("Name Required");


                    }else {
                        name=binding.editTextTextName.getText().toString();

                    }

        });
            binding.finalResult.setText(name);
        Log.d("Check",""+name);
    }

    private  boolean isEmpty(EditText editText)
    {
       return binding.editTextTextName.getText().toString().trim().isEmpty();

    }
}