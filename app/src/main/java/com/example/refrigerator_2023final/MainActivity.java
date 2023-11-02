package com.example.refrigerator_2023final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.refrigerator_2023final.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.example.refrigerator_2023final.R;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private TextView userEmailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());


        // Firebase Authentication에서 현재 사용자 가져오기
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        if (user != null) {
            // 사용자가 로그인한 경우 사용자 이메일 가져오기
            String userEmail = user.getEmail();

            // 이메일 주소를 "@"를 기준으로 분할
            String[] parts = userEmail.split("@");

            // "@" 이전의 이메일 주소 부분을 가져오기
            if (parts.length > 0) {
                String username = parts[0];
                userEmailTextView.setText(username+" 님");
            }
        }
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            if (menuItem.getItemId() == R.id.tab_mypage) {
                Intent intent = new Intent(MainActivity.this, MyPageJava.class);
                startActivity(intent);
            } else if (menuItem.getItemId() == R.id.tab_home) {

            } else if (menuItem.getItemId() == R.id.tab_search) {
                Intent intent = new Intent(MainActivity.this, SearchFragment.class);
                startActivity(intent);
            } else if (menuItem.getItemId() == R.id.tab_list) {
                Intent intent = new Intent(MainActivity.this, FoodListPage.class);
                startActivity(intent);
            }
//asdfj
            transaction.commitAllowingStateLoss(); // 여기서 commit 호출
            return true;
        }
    }

    public void GoToFoodList(View view) {
        Intent intent = new Intent(this, FoodListPage.class);
        startActivity(intent);
    }
}
