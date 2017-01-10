package com.yotadevices.example;

/*
 * Copyright (C) 2016 Yota Devices LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.yotadevices.viscera.di.Container;
import com.yotadevices.viscera.di.Module;

/**
 * @author Vitalii Dmitriev
 * @since 17.12.2016
 */
public class MainActivity extends AppCompatActivity implements ExampleScreen {

    private Module mModule;
    private TextView mTextView;
    private View mRoot;
    private Button mButton;
    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRoot = findViewById(R.id.main_root);
        mButton = (Button) findViewById(R.id.main_button);
        mTextView = (TextView) findViewById(R.id.main_text);
        mCheckBox = (CheckBox) findViewById(R.id.main_check_box);
        mModule = Container.getInstance().get(ExampleModule.class).attach(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mModule.update(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mModule.detach(this);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public boolean isToastEnabled() {
        return mCheckBox.isChecked();
    }

    @Override
    public void setupText(int textResource, int colorResource) {
        mTextView.setText(textResource);
        mTextView.setTextColor(getResources().getColor(colorResource));
    }

    @Override
    public void setBackground(int colorResource) {
        mRoot.setBackgroundResource(colorResource);
    }

    @Override
    public void showToast(CharSequence text, boolean durationLong) {
        Toast.makeText(this, text, durationLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setButtonClickListener(View.OnClickListener listener) {
        mButton.setOnClickListener(listener);
    }

    @Override
    public void setupButton(int textResource, int colorResource) {
        mButton.setText(textResource);
        mButton.setTextColor(getResources().getColor(colorResource));
    }
}
