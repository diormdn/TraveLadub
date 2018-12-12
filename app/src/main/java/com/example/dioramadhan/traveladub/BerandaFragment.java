package com.example.dioramadhan.traveladub;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link BerandaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BerandaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView rv;
    private TextView namaTempat;
    private TextView valWeekdays;
    private TextView valWeekend;
    private ImageView gambarTempat;
    ArrayList<TempatWisata> tw;

    TempatWisataAdapter mAdapter;


    public BerandaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BerandaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BerandaFragment newInstance(String param1, String param2) {
        BerandaFragment fragment = new BerandaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_beranda, container, false);
//        initView(rootView);

        TempatWisata a = new TempatWisata();
        a.setNamaTempat("Museum Angkut");
        a.setJamBukaWeekdays("12.00 – 20.00");
        a.setJamBukaWeekends("12.00 – 20.00");
        a.setLocation("Jl. Sultan Agung No. 2, Ngaglik, Kecamatan Batu, Kota Batu");
        a.setHargaWeekdays("Rp. 70.000");
        a.setHargaWeekdends("Rp. 100.000");
        a.setLat(7.8787960);
        a.setLongt(112.52025790);
        a.setDetail("Terletak di kawasan Kota Wisata Batu. Museum ini mempunyai beberapa macam koleksi transportasi mulai dari kenadaraan tradisional, clasik hingga kendaraan modern. Pada museum ini terdapat banyak lokasi foto. Jangan sampai lupa membawa kamera");
        int urla1= R.drawable.museumangkut2;
        int urla2= R.drawable.museumangkut3;
        int urla3= R.drawable.museumangkut4;

        int[] gambara = new int[]{urla1,urla2,urla3};
        a.setUrlGambar(gambara);

        TempatWisata b = new TempatWisata();
        b.setNamaTempat("Jatim Park 2");
        b.setJamBukaWeekdays("10.00 – 18.00");
        b.setJamBukaWeekends("10.00 – 18.00");
        b.setLocation("Jl. Jalan Oro Oro Ombo No.9, Temas, Kecamatan Batu, Kota Batu");
        b.setHargaWeekdays("Rp. 84.000");
        b.setHargaWeekdends("Rp. 120.000");
        b.setLat(-7.8883293);
        b.setLongt(112.5299283);
        b.setDetail("Terdiri dari 3 area utama termasuk Batu Secret Zoo dan Museum Satwa. Mempunyai 200 spesies dan acara yang mendidik di Batu Secret Zoo. Sedangkan Museum satwa mempunyai patung dari hewan hewan buas yang besar. " +
                "Museum ini menampilkan patung hewan " +
                "tersebut di dalam habitat buatan.");
        int urlb1= R.drawable.jatimpark1;
        int urlb2= R.drawable.jatimpark2;
        int urlb3= R.drawable.jatimpark3;

        int[] gambarb = new int[]{urlb1,urlb2,urlb3};
        b.setUrlGambar(gambarb);

        TempatWisata c = new TempatWisata();
        c.setNamaTempat("Jatim Park 3");
        c.setJamBukaWeekdays("11.00 – 18.00");
        c.setJamBukaWeekends("11.00 – 18.00");
        c.setLocation("Jl. Ir. Soekarno No.112, Beji, Junrejo");
        c.setHargaWeekdays("Rp. 75.000");
        c.setHargaWeekdends("Rp. 100.000");
        c.setLat(-7.896671);
        c.setLongt(112.5510033);
        c.setDetail("Ayo belajar mengenai bagaimana dinosaurus yang sudah punah hidup dan juga mengendarai atraksi yang bertema dinosaurus di Dino Park. Merupakan satu satunya taman rekreasi yang bertema Dinosaurus di Indonesia. Jangan lupa menikmati berabagai fasilitas seperti aquarium 3 dimensi dan Active Fun House");
        int urlc1= R.drawable.jatimpark33;
        int urlc2= R.drawable.jatimpark32;
        int urlc3= R.drawable.jatimpark34;

        int[] gambarc = new int[]{urlc1,urlc2,urlc3};
        c.setUrlGambar(gambarc);

        TempatWisata d = new TempatWisata();
        d.setNamaTempat("Museum Tubuh");
        d.setJamBukaWeekdays("08.30 – 16.30");
        d.setJamBukaWeekends("08.30 – 16.30");
        d.setLocation("Jl. Kartika No. 2, Sisir, Kecamatan Batu");
        d.setHargaWeekdays("Rp. 49.000");
        d.setHargaWeekdends("Rp. 70.000");
        d.setLat(-7.883830);
        d.setLongt(112.523898);
        d.setDetail("Ayo datang ke Bagong Adventure Museum Tubuh. Museum pertama di Indonesi yang menampilkan anatomi tubuh manusia. Jelajahi area bertema seperti gigi, otak, dan cara bagaimana tubuh berfungsi. Untuk mendapatkan pengalaman yang bermafaat anda dapat melihat bagaimana bagian tubuh manusia bekerja di dalam kemasan film 3 dimensi.");
        int urld1= R.drawable.museumtubuh3;
        int urld2= R.drawable.museumtubuh1;
        int urld3= R.drawable.museumangkut2;

        int[] gambard = new int[]{urld1,urld2,urld3};
        d.setUrlGambar(gambard);

        TempatWisata e = new TempatWisata();
        e.setNamaTempat("The Onsen Genki");
        e.setJamBukaWeekdays("14.00 – 17.00");
        e.setJamBukaWeekends("14.00 – 17.00");
        e.setLocation("Jl. Arumdalu, Songgokerto, Kecamatan Batu");
        e.setHargaWeekdays("Rp. 200.000");
        e.setHargaWeekdends("Rp. 200.000");
        e.setLat(7.8635744);
        e.setLongt(112.4997146);
        e.setDetail("Pernahkah anda membayangkan bagaimana rasanya berendam di pemandian air panas Jepang. The Onsen Genki menawarkan pemandian ari panas yang bertemakan Jepang. Anda bisa mengunjungi The Onsen Resort Batu Malang untuk mendapatkan pengalaman yang unik. Resort ini adalah satu satunhya pemandian air panas yang memiliki restoran bertema Jepang di ");
        int urle1= R.drawable.onsen3;
        int urle2= R.drawable.onsen1;
        int urle3= R.drawable.onsen2;

        int[] gambare = new int[]{urle1,urle2,urle3};
        e.setUrlGambar(gambare);

        TempatWisata f = new TempatWisata();
        f.setNamaTempat("Coban Rais");
        f.setJamBukaWeekdays("07.30 – 16.00");
        f.setJamBukaWeekends("07.30 – 16.00");
        f.setLocation("Jalur Lkr. Barat No. 8 Oro Oro Ombo. Kecamatan Batu");
        f.setHargaWeekdays("Rp. 10.000");
        f.setHargaWeekdends("Rp. 10.000");
        f.setLat(-7.9116249);
        f.setLongt(112.5206806);
        f.setDetail("Nikmati pengalaman dan jelajahi banyak tujuan di Coban Rais dan Batu Flower Garden ini. Menyajikan keindahan wilayah asri di sekitar air terjun dan taman bunga di kawasan pegunungan batu. Anda dapat menjelajahi area hutan yang merupakan jalur menuju kawasan air terjun.");
        int urlf1= R.drawable.coban1;
        int urlf2= R.drawable.coban1;
        int urlf3= R.drawable.coban1;

        int[] gambarf = new int[]{urlf1,urlf2,urlf3};
        f.setUrlGambar(gambarf);


        TempatWisata g = new TempatWisata();
        g.setNamaTempat("Batu Night Spectacular");
        g.setJamBukaWeekdays("15.00 – 23.00");
        g.setJamBukaWeekends("15.00 – 23.00");
        g.setLocation("Jl. Oro Oro Ombo No. 3, Kecamatan Batu");
        g.setHargaWeekdays("Rp. 30.000");
        g.setHargaWeekdends("Rp. 40.000");
        g.setLat(-7.8965265);
        g.setLongt(112.534532);
        g.setDetail("Nikmati pengalaman pasar malam di Batu Night Spectacular. Taman ini menyediakan berbagai macam hiburan untuk semua orang. Nikmati berbagai macam atraksi yang menantang seperti Flying Swinger, Rumah Hantu. hingga Virtual Reality. ");
        int urlg1= R.drawable.bns1;
        int urlg2= R.drawable.bns2;
        int urlg3= R.drawable.bns3;

        int[] gambarg = new int[]{urlg1,urlg2,urlg3};
        g.setUrlGambar(gambarg);

        tw = new ArrayList<>();
        tw.add(a);
        tw.add(b);
        tw.add(c);
        tw.add(d);
        tw.add(e);
        tw.add(f);
        tw.add(g);


        this.rv = (RecyclerView) rootView.findViewById(R.id.recycleView);
        mAdapter = new TempatWisataAdapter(tw,getActivity().getApplicationContext() );
        this.rv.setAdapter(mAdapter);
        this.rv.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));



        return rootView;


        //
    }

    private void initView(View rootView) {

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }



    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
