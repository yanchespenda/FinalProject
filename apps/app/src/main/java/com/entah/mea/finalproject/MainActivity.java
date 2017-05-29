package com.entah.mea.finalproject;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

import static com.entah.mea.finalproject.R.id.container;

public class MainActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    static TextView TX_01,TX_02,TX_03,TX_04,TX_05,TX_06,TX_07,TX_08,TX_09,TX_10;
    final static Integer kopi_harga_satuan = 5000,
            kopi_max_pesan = 5,
            puding_harga_satuan=7500,
            puding_max_pesan = 10;
    static Integer kopi_jumlah = 0,
            kopi_total_harga = 0,
            kopi_stok = 50,
            puding_jumlah = 0,
            puding_total_harga = 0,
            puding_stok = 100;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        //View rootView=inflater.inflate(R.layout.activity_main_01, container, false);

    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
            //return true;
        //}

        //return super.onOptionsItemSelected(item);
        return false;
    }*/

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final Integer get_page=getArguments().getInt(ARG_SECTION_NUMBER);
            View rootView=inflater.inflate(R.layout.activity_main_01, container, false);

            if (get_page==1){
                rootView = inflater.inflate(R.layout.activity_main_01, container, false);
                TX_01 = (TextView)  rootView.findViewById(R.id.tv_kopi_harga);
                TX_02 = (TextView)  rootView.findViewById(R.id.tv_kopi_stok);
                TX_03 = (TextView)  rootView.findViewById(R.id.tv_kopi_max);
                TX_04 = (TextView)  rootView.findViewById(R.id.tv_kopi_total);
                TX_05 = (TextView)  rootView.findViewById(R.id.tv_kopi_jumlah);

                TX_01.setText("Harga Per Barang: " + kopi_harga_satuan);
                TX_02.setText("Stok Barang: " + kopi_stok);
                TX_03.setText("Maximal Pesanan: " + kopi_max_pesan);
                TX_04.setText("Harga Total: " + kopi_total_harga);
                TX_05.setText("Jumlah: " + kopi_jumlah);

               // TextView textView = (TextView) rootView.findViewById(R.id.section_label);
                //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            }else if (get_page==2){
                rootView = inflater.inflate(R.layout.activity_main_02, container, false);
                TX_06 = (TextView)  rootView.findViewById(R.id.tv_puding_harga);
                TX_07 = (TextView)  rootView.findViewById(R.id.tv_puding_stok);
                TX_08 = (TextView)  rootView.findViewById(R.id.tv_puding_max);
                TX_09 = (TextView)  rootView.findViewById(R.id.tv_puding_total);
                TX_10 = (TextView)  rootView.findViewById(R.id.tv_puding_jumlah);

                TX_06.setText("Harga Per Barang: " + puding_harga_satuan);
                TX_07.setText("Stok Barang: " + puding_stok);
                TX_08.setText("Maximal Pesanan: " + puding_max_pesan);
                TX_09.setText("Harga Total: " + puding_total_harga);
                TX_10.setText("Jumlah: " + puding_jumlah);

                //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
                //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            }else if (get_page==3){
                rootView = inflater.inflate(R.layout.activity_main_03, container, false);
                WebView myWebView = (WebView) rootView.findViewById(R.id.mywebview);
                myWebView.loadUrl("http://www.google.com");
                myWebView.setWebViewClient(new MyWebViewClient());
                WebSettings webSettings = myWebView.getSettings();
                webSettings.setJavaScriptEnabled(true);

                //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
                //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            }

            return rootView;
        }
    }

    //=======================================================================================================================

    public void btn_kopi_tambah(View v) {
        //TAMBAH
        if (kopi_jumlah < kopi_max_pesan) {
            if (kopi_jumlah < kopi_stok) {
                kopi_jumlah = kopi_jumlah + 1;
            } else {
                Toast.makeText(getApplicationContext(), "Barangnya dah abis Gan!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Gak bisa mesen banyak banyak Gan!", Toast.LENGTH_SHORT).show();
        }

        TX_05.setText("Jumlah: " + kopi_jumlah);
    }
    public void btn_kopi_kurang(View v) {
        //TAMBAH
        if (kopi_jumlah > 0) {
            kopi_jumlah = kopi_jumlah - 1;
        }

        TX_05.setText("Jumlah: " + kopi_jumlah);
    }

    public void btn_kopi(View v) {
        if (kopi_stok > 0) {
            if (kopi_stok >= kopi_jumlah) {
                kopi_stok = kopi_stok - kopi_jumlah;
                kopi_total_harga = kopi_harga_satuan * kopi_jumlah;
                TX_04.setText("Harga Total: " + kopi_total_harga);
                TX_02.setText("Stok Barang: " + kopi_stok);
                kopi_jumlah = 0;
                TX_05.setText("Jumlah: " + kopi_jumlah);
            } else {
                Toast.makeText(getApplicationContext(), "Gak bisa dipesen semua Gan!", Toast.LENGTH_SHORT).show();
            }

        }
        //Toast.makeText( getApplicationContext(), "Kopi Gan!", Toast.LENGTH_SHORT).show();
    }

    public void btn_puding_tambah(View v) {
        //TAMBAH
        if (puding_jumlah < puding_max_pesan) {
            if (puding_jumlah < puding_stok) {
                puding_jumlah = puding_jumlah + 1;
            } else {
                Toast.makeText(getApplicationContext(), "Barangnya dah abis Gan!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Gak bisa mesen banyak banyak Gan!", Toast.LENGTH_SHORT).show();
        }

        TX_10.setText("Jumlah: " + puding_jumlah);
    }
    public void btn_puding_kurang(View v) {
        //TAMBAH
        if (puding_jumlah > 0) {
            puding_jumlah = puding_jumlah - 1;
        }

        TX_10.setText("Jumlah: " + puding_jumlah);
    }
    public void btn_puding(View v) {
        if (puding_stok > 0) {
            if (puding_stok >= puding_jumlah) {
                puding_stok = puding_stok - puding_jumlah;
                puding_total_harga = puding_harga_satuan * puding_jumlah;
                TX_09.setText("Harga Total: " + puding_total_harga);
                TX_07.setText("Stok Barang: " + puding_stok);
                puding_jumlah = 0;
                TX_10.setText("Jumlah: " + puding_jumlah);
            } else {
                Toast.makeText(getApplicationContext(), "Gak bisa dipesen semua Gan!", Toast.LENGTH_SHORT).show();
            }

        }
        //Toast.makeText( getApplicationContext(), "Puding Gan!", Toast.LENGTH_SHORT).show();
    }


    private static class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    //=======================================================================================================================

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Kopi";
                case 1:
                    return "Puding";
                case 2:
                    return "Browser";
            }
            return null;
        }
    }
}
