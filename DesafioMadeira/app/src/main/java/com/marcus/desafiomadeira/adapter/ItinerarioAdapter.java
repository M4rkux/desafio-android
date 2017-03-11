package com.marcus.desafiomadeira.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.marcus.desafiomadeira.R;
import com.marcus.desafiomadeira.model.Itinerario;

import java.util.List;

/**
 * Created by Marcus on 10/03/2017.
 */

public class ItinerarioAdapter extends BaseAdapter {

    List<Itinerario> lista;
    Context context;

    public ItinerarioAdapter (final Context context, final List<Itinerario> lista) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            final LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_itinerario, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_titulo = (TextView) convertView.findViewById(R.id.tv_titulo);
            viewHolder.tv_texto = (TextView) convertView.findViewById(R.id.tv_texto);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Itinerario itinerario = lista.get(position);
        viewHolder.tv_titulo.setText(itinerario.getTipo()+":");
        viewHolder.tv_texto.setText(itinerario.getNome() + ", " + itinerario.getEndereco().getRua() +
                ", nº" + itinerario.getEndereco().getNumero() + ", " + itinerario.getEndereco().getBairro() +
                ", " + itinerario.getEndereco().getCidade() + " - " + itinerario.getEndereco().getEstado());
        return convertView;
    }

    static class ViewHolder {
        ViewGroup.LayoutParams layout;
        TextView tv_titulo;
        TextView tv_texto;
    }
}
