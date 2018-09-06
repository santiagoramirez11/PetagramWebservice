package com.coursera.santiago.petagram.restApi.adapter;

import com.coursera.santiago.petagram.restApi.ConstantesRestApi;
import com.coursera.santiago.petagram.restApi.EndpointApi;
import com.coursera.santiago.petagram.restApi.deserializador.MascostaDeserializador;
import com.coursera.santiago.petagram.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public EndpointApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascostaDeserializador());
        return gsonBuilder.create();
    }
}
