package com.fotos.fotos.cardHandling;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fotos.fotos.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewHolder> {

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView image;
        TextView name;
        TextView question;
        TextView option1;
        TextView option2;
        TextView sponsored;
        ImageView sponsorLogo;

        CardViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.card_view);
            image = (ImageView)itemView.findViewById(R.id.card_image);
            name = (TextView)itemView.findViewById(R.id.card_name);
            question  = (TextView)itemView.findViewById(R.id.card_question);
            option1  = (TextView)itemView.findViewById(R.id.card_option1);
            option2  = (TextView)itemView.findViewById(R.id.card_option2);
            sponsored = (TextView)itemView.findViewById(R.id.card_sponsored);
            sponsorLogo  = (ImageView)itemView.findViewById(R.id.card_sponsorLogo);
        }
    }

    List<Card> cards;

    public CardViewAdapter(List<Card> cards){
        this.cards = cards;
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
        CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder cardViewHolder, int i) {
        // set image
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap imageBitmap = BitmapFactory.decodeResource(cardViewHolder.cardView.getResources(),
                cards.get(i).imageDrawable, options);
        cardViewHolder.image.setImageBitmap(imageBitmap);
        // set name
        cardViewHolder.name.setText("By " + cards.get(i).name);
        Typeface type = Typeface.createFromAsset(cardViewHolder.cardView.getContext().getAssets(), "fonts/Roboto-Thin.ttf");
        cardViewHolder.name.setTypeface(type);
        // set question
        cardViewHolder.question.setText(cards.get(i).question);
        // set option1
        cardViewHolder.option1.setText(cards.get(i).option1);
        cardViewHolder.option1.setVisibility(!cards.get(i).sponsored ? View.VISIBLE : View.INVISIBLE);
        ((ImageView)cardViewHolder.cardView.findViewById(R.id.card_arrrow_left)).setVisibility(!cards.get(i).sponsored ? View.VISIBLE : View.INVISIBLE);
        // set option2
        cardViewHolder.option2.setText(cards.get(i).option2);
        // set sponsored
        cardViewHolder.sponsored.setVisibility(cards.get(i).sponsored ? View.VISIBLE : View.INVISIBLE);
        // set sponsor logo
        cardViewHolder.sponsorLogo.setVisibility(View.INVISIBLE);
        if (cards.get(i).sponsored) {
            BitmapFactory.Options sponsorOptions = new BitmapFactory.Options();
            options.inScaled = false;
            Bitmap sponsorImageBitmap = null;
            if (cards.get(i).sponsorLogo.equals("mcdonalds")){
                sponsorImageBitmap = BitmapFactory.decodeResource(cardViewHolder.cardView.getResources(),
                        R.drawable.logo_mcdonalds, sponsorOptions);
            } else if (cards.get(i).sponsorLogo.equals("starbucks")){
                sponsorImageBitmap = BitmapFactory.decodeResource(cardViewHolder.cardView.getResources(),
                        R.drawable.logo_starbucks, options);
            } else if (cards.get(i).sponsorLogo.equals("ticketmaster")){
                sponsorImageBitmap = BitmapFactory.decodeResource(cardViewHolder.cardView.getResources(),
                        R.drawable.logo_ticketmaster, options);
            }

            if (sponsorImageBitmap != null) {
                cardViewHolder.sponsorLogo.setImageBitmap(sponsorImageBitmap);
                cardViewHolder.sponsorLogo.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public void remove(int position) {
        cards.remove(position);
        notifyItemRemoved(position);
    }
}
