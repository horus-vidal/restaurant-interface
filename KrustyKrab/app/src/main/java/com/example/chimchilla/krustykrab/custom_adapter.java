//package com.example.chimchilla.krustykrab;//package com.example.chimchilla.krustykrab;//package com.example.chimchilla.krustykrab;
//
//
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
///**
// * Created by ChimChilla on 3/29/2018.
// */
//
////class custom_adapter extends ArrayAdapter<String> {
////    public custom_adapter(@NonNull Context context, String [] foods) {
////        super(context, R.layout.custom_row,foods);
////
////    }
////
////    @NonNull
////    @Override
////    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
////        LayoutInflater stuffInflator = LayoutInflater.from(getContext());
////        View customView = stuffInflator.inflate(R.layout.custom_row, parent, false);
////        String singleFoodItem = getItem (position);
////       String singlePriceItem = getItem(position);
////        TextView stuffText = (TextView) customView.findViewById(R.id.Name);
////        ImageView FoodImage = (ImageView) customView.findViewById(R.id.Krabby);
////        TextView priceText = (TextView) customView.findViewById(R.id.Price);
////        stuffText.setText(singleFoodItem);
////        priceText.setText(singlePriceItem);
////      //we will do this when we have an array of prices and names...  moreText.setText();
////        FoodImage.setImageResource(R.mipmap.krabby);
////    return customView;
////    }
////}
//
//
//public class custom_adapter extends BaseAdapter {
//    @Override
//    public int getCount () {
//        return IMAGES.length;
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup)
//
//    {
//        view = getLayoutInflater().inflate(R.layout.custom_row,null);
//        ImageView imageView = (ImageView)view.findViewById(R.id.Krabby);
//        TextView textView = (TextView) view.findViewById(R.id.Name);
//        TextView textView1 = (TextView) view.findViewById(R.id.Price);
//
//        imageView.setImageResource(IMAGES[i]);
//        textView.setText(Name[i]);
//        textView1.setText(Description[i]);
//
//
//        return view;
//    }
//}
//
//}