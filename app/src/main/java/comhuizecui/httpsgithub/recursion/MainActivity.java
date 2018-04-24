/**
 * Name:Huize Cui
 * Course:CS40S
 * Teacher:Mr.Hardman
 * Lab #3,Program.1
 * Date Last Modified: 4/24/2018
 */
package comhuizecui.httpsgithub.recursion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mUserInput;
    private TextView mRuselt;
    private TextView mErrorNessage;

    @Override
    /**
     * onCreate is the method that is run when the Activity is created
     *
     * @param savedInstanoeState is a Bundle of data that can be used to restore
     *                           a previous instance of this Activity
     * @return ""Nothing is returned
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserInput = (EditText) findViewById(R.id.et_user_input);
        mErrorNessage = (TextView) findViewById(R.id.tv_error_message);
        mRuselt = (TextView) findViewById(R.id.tv_result);

        mUserInput.addTextChangedListener(numberinputWatcher);
    }

    private final TextWatcher numberinputWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        /**
         * afterTextChanged is the method that is called once the text has chaged
         * in an Editable object
         *
         * @param editable is the object that has text changed within it
         * @return ""Nothing is returned
         */
        @Override
        public void afterTextChanged(Editable editable) {
            String userInput;
            boolean reusltPalindromeCheck;

            if (editable.length() == 0) {
                mRuselt.setText("");
                mErrorNessage.setText("You must enter a word");
            }
            else
            {
                userInput = mUserInput .getText().toString().toUpperCase();

                mRuselt.setText("");
                mErrorNessage.setText("");

                reusltPalindromeCheck = checkPalindrome(userInput, 0);
                
                if (reusltPalindromeCheck=true)
                {
                    mRuselt.append("\n\nThat is a paindrome.");
                }
                else
                {
                    mRuselt.append("\n\nThat is not a paindrome.");
            }


            }
        }


    };
    //This is where the TextWatcher has closed

    /**
     * checkPalindrome check the word this is or not a palindrome
     *
     * @param indexFromEnd is the current number of the checkpalindrome
     * @return an integer thatstores the checkpalindrome result
     */
    private boolean checkPalindrome(String userWord, int currentIndex)
    {
        boolean result;

        int indexFromEnd = userWord.length() - currentIndex - 1;

        if (userWord.charAt(currentIndex) == userWord.charAt(indexFromEnd ) )
        {
            if(currentIndex == indexFromEnd || currentIndex == indexFromEnd - 1)
            {
                result = true;
            }
            else
            {
                result = checkPalindrome(userWord, currentIndex + 1 );
            }

        }else
        {
            result = false;
        }
        return result;

    }


}
