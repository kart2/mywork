package com.yomdom.ydu;

import android.app.Activity;
import android.os.Bundle;


import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class YduActivity extends Activity {
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
  }

  public void onPopupButtonClick(View button) {
    PopupMenu popup = new PopupMenu(this, button);
    popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());

    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
      public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(YduActivity.this, "Clicked popup menu item " + item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
      }
    });

    popup.show();
  }
}
