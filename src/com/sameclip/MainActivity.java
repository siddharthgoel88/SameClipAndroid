package com.sameclip;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private ClipboardManager clip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        clip = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        final ClipData cd = clip.getPrimaryClip();
        
        Button copy = (Button) findViewById(R.id.copy_button);
        final TextView tv = (TextView) findViewById(R.id.copiedText);
        copy.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (cd == null) {
					tv.setText("Clipboard Oops moment!!!");
					return;
				}
				CharSequence temp = cd.getItemAt(0).getText();
				if (temp == null)
					tv.setText("Clipboard is empty buddy!!!");
				else
					tv.setText(temp);
			}
		});
    }
}
