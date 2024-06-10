package com.example.loginpage;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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
    String name="",pass="",add="",mob="";
//    long mob
    private RadioGroup radioGroup;
    private RadioButton radioButton;

//    RadioButton radioButton;
;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup );

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





            if (binding.editTextTextName.getText().toString().length()==0)
            {
                binding.editTextTextName.setError("Name Required");

            }
            else {
                name=binding.editTextTextName.getText().toString();
                result.append("Name is \n");

            }
            if (binding.editTextTextPass.getText().toString().length()==0)
            {
                binding.editTextTextPass.setError("Password  Requird");
            }
            else {
                pass=binding.editTextTextName.getText().toString();
                result.append("Pass is \n");


            }

            int radioId=binding.radioGroup.getCheckedRadioButtonId();
                if (radioId>0)
                {
                     radioButton=findViewById(radioId);
                    result.append("Gender is \n");

                }
                else {
                    binding.radioButtonMale.setError("Required");
                    binding.radioButtonFemale.setError("Required");


                }if (binding.editTextText.getText().toString().length()==0)
            {
                binding.editTextText.setError("Password  Requird");

            }
                else {
                    add=binding.editTextText.getText().toString();
                result.append("Add is \n");

            }
                if (binding.editTextPhone.getText().toString().length()==0)
                {
                    binding.editTextPhone.setError("Password  Requird");

                }
                else
                {
                    mob= binding.editTextPhone.getText().toString().toString();
                    result.append("Phone is \n");


                }

        });

        binding.finalResult.setText(result);

    }


}