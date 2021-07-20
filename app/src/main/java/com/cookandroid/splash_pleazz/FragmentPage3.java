package com.cookandroid.splash_pleazz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentPage3 extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_page_3, container, false);

        Button btn_faq = view.findViewById(R.id.btn_faq);
        Button btn_faq_test = view.findViewById(R.id.btn_faq_test);
        Button btn_login = view.findViewById(R.id.btn_login);
        Button btn_search_test = view.findViewById(R.id.btn_search_test);
        Button btn_112 = view.findViewById(R.id.btn_112);

        btn_faq.setOnClickListener(this);
        btn_faq_test.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        btn_search_test.setOnClickListener(this);
        btn_112.setOnClickListener(this);

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_faq:
                Intent intent = new Intent(getActivity(), Faq.class);
                startActivity(intent);
                break;
            case R.id.btn_faq_test:
                intent = new Intent(getActivity(), Faq_test.class);
                startActivity(intent);
                break;
            case R.id.btn_login:
                intent = new Intent(getActivity(), com.cookandroid.myapplication.MainActivity.class); // import 한 모듈의 class 로 페이지 넘길때
                startActivity(intent);
                break;
            case R.id.btn_search_test:
                intent = new Intent(getActivity(), Search_test.class);
                startActivity(intent);
                break;
            case R.id.btn_112:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/112"));
                startActivity(intent);
        }
    }
}
